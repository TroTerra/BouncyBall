import java.awt.*;
import java.lang.Math;
public class Ball {
    private double xVector;
    private double yVector;
    private double xPosition;
    private double yPosition;
    private double radius = 100;
    private Color color;

    public void changePosition(){
        this.xPosition += this.xVector;
        this.yPosition += this.yVector;
    }
    public void drawBall(){
        StdDraw.setPenColor(this.color);
        StdDraw.filledCircle(this.xPosition, this.yPosition, this.radius);
    }
    public double getXPosition(){
        return  xPosition;
    }
    public double getYPosition(){
        return yPosition;
    }
    public double getRadius(){
        return  radius;
    }
    public void invertXVektor(){
        this.xVector = -this.xVector;
        this.randomColor();
    }
    public  void invertYVektor(){
        this.yVector = -this.yVector;
        this.randomColor();
    }
    private double makeVektor(){
        return(Math.random() - 0.5)*10;
    }
    private void randomColor(){
        double num = Math.random();
        if (num > 0.5){
            this.color = Color.red;
        }
        else {
            this.color = Color.yellow;
        }
    }
    public  void makeSpawnPoint(Background background){
        this.xPosition = background.getScale()/2;
        this.yPosition = background.getScale()/2;
    }
    public Ball(Background background){
        randomColor();
        makeSpawnPoint(background);
        this.yVector = makeVektor();
        this.xVector = makeVektor();
    }
}
