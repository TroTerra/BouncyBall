import java.awt.*;
import java.awt.event.KeyEvent;

public class BouncyBall {
    private static  void drawBalls(Ball[] balls){
        for(int i = 0; i < balls.length; i++){
            balls[i].drawBall();
        }
    }
    private static Ball[] createBalls(int n, Background background){
        Ball[] balls = new Ball[n];
        for(int i = 0; i < n; i++){
            balls[i] = new Ball(background);
        }
        return balls;
    }
    private static Background createBackground(){
        Background background = new Background(2048,2048,2048,4096);
        return background;
    }
    private  static void updateBall(Ball[] balls){
        for(int i = 0; i < balls.length; i++){
            balls[i].changePosition();
        }
    }
    private static void ballHitBounds(Ball[] balls, Background background){
        for(int i = 0; i < balls.length; i++){
            Physics.hitCheck(balls[i], background.getScale(), background.getScale());
        }
    }
    public static void main(String[] args){
        int numBalls = 20;
        Background background = createBackground();
        Ball[] balls = createBalls(numBalls, background);
        while(true){
            updateBall(balls);
            background.draw();
            drawBalls(balls);
            ballHitBounds(balls,background);
            StdDraw.show(1);
        }
    }
}
