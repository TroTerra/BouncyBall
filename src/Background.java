import java.awt.*;

public class Background {
    private Vector2D size;
    private int lenght;
    private double scale;
    private Ball[] balls;
    private int numBalls;

    public Background(int width, int height, int lenght, int scale, int numBalls){
        this.size = new Vector2D(width, height);
        this.lenght = lenght;
        this.scale = scale;
        setScale();
        this.numBalls = numBalls;
        balls =createBalls();
    }

    public void draw(){
        StdDraw.setPenColor(Color.black);
        StdDraw.filledSquare(this.size.x,this.size.y,this.lenght);
        drawBalls();
    }
    public void update(){
        for(int i = 0; i < balls.length; i++){
            balls[i].changePosition();
        }
        ballHitBounds();
    }

    private void drawBalls(){
        for(int i = 0; i < balls.length; i++){
            this.balls[i].drawBall();
        }
    }
    private void ballHitBounds(){
        for(int i = 0; i < balls.length; i++){
            Physics.hitCheck(balls[i], this.scale, this.scale);
        }
    }

    private Ball[] createBalls(){
        Ball[] balls = new Ball[numBalls];
        for(int i = 0; i < numBalls; i++){
            balls[i] = new Ball(new Vector2D(size.x, size.y));
        }
        this.balls = balls;
        return balls;
    }
    private void setScale(){
        StdDraw.setXscale(0.0, this.scale);
        StdDraw.setYscale(0.0, this.scale);
    }
}
