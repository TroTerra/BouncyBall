import java.awt.*;
import java.lang.Math;

public class Ball extends BallLogic{
    private Color color;

    public Ball(Vector2D spawnPoint, double radius){
        super(spawnPoint, radius);
        randomColor();
    }

    public void drawBall(){
        StdDraw.setPenColor(this.color);
        StdDraw.filledCircle(this.position.x, this.position.y, this.radius);
    }
    public void invertXVector(){
        this.diriction = this.diriction.vectorMultiplication(new Vector2D(-1,1));
        this.randomColor();
    }
    public  void invertYVector(){
        this.diriction = this.diriction.vectorMultiplication(new Vector2D(1,-1));
        this.randomColor();
    }

    private void randomColor(){
        int[] RGB = new int[3];
        for(int i = 0; i < 3; i++) {
            RGB[i] = (int) (Math.random() * 255);
        }
        this.color = new Color(RGB[0], RGB[1], RGB[2]);
    }
}
