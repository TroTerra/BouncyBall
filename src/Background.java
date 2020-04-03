import java.awt.*;

public class Background {
    private Vector2D size;
    private int lenght;
    private double scale;
    private Ball[] balls;
    private int numBalls;
    private Vector2D spawnBoxLower;
    private Vector2D spawnBoxUpper;

    public Background(int width, int height, int lenght, int scale, int numBalls){
        this.size = new Vector2D(width, height);
        this.lenght = lenght;
        this.scale = scale;
        setScale();
        spawnBoxLower = getSpawnBoxLower();
        spawnBoxUpper = getSpawnBoxUpper();
        this.numBalls = numBalls;
        createBalls();
    }

    public void draw(){
        StdDraw.setPenColor(Color.black);
        StdDraw.filledSquare(this.size.x,this.size.y,this.lenght);
        drawBalls();
    }
    public void update(){
        int i = 0;
        while(i < balls.length && balls[i] != null){
            balls[i].changePosition();
            i++;
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

    private boolean circalVsCircal(Ball first, Ball second){
        double r = first.getRadius() + second.getRadius();
        r *= r;
        return r < (first.getXPosition() + second.getXPosition()) * (first.getXPosition() + second.getXPosition()) +
                (first.getYPosition() + second.getYPosition()) * (first.getYPosition() + second.getYPosition());
    }
    private double randomRadius(){
        return (Math.random() * 100) + 50;
    }
    private void createBalls(){
        Ball[] balls = new Ball[numBalls];
        balls[0] = new Ball(makeBallSpawnPoint(), randomRadius());
        int ballsCreated = 1;
        for(int i = 1; i < numBalls; i++){
            int p = 0;
            double radius = randomRadius();
            Vector2D spawnPoint = makeBallSpawnPoint();
            Ball ball = new Ball(spawnPoint, radius);
            for(int n = 0; n < ballsCreated; n++){
                if(circalVsCircal(ball, balls[n])){
                    p++;
                }
            }
            if (p == ballsCreated){
                balls[ballsCreated] = ball;
                ballsCreated++;
            }
        }

        Ball[] newBalls = new Ball[ballsCreated];
        for(int i = 0; i < ballsCreated; i++){
            newBalls[i] = balls[i];
        }
        this.balls = newBalls;
    }
    private void setScale(){
        StdDraw.setXscale(0.0, this.scale);
        StdDraw.setYscale(0.0, this.scale);
    }
    private Vector2D getSpawnBoxLower(){
        return new Vector2D(scale / 4, scale / 4);
    }
    private Vector2D getSpawnBoxUpper(){
        return new Vector2D(scale * 3 / 4, scale * 3 / 4);
    }
    private Vector2D makeBallSpawnPoint(){
        return new Vector2D((Math.random() * (spawnBoxUpper.x - spawnBoxLower.x) ) + spawnBoxLower.x ,
                (Math.random() * (spawnBoxUpper.y - spawnBoxLower.y) ) + spawnBoxLower.y);
    }

}
