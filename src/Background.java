import java.awt.*;

public class Background {
    private int width;
    private int height;
    private int lenght;
    private int scale;

    public void draw(){
        StdDraw.setPenColor(Color.black);
        StdDraw.filledSquare(this.width,this.height,this.lenght);
    }
    public int getScale(){
        return scale;
    }
    public Background(int width, int height, int lenght, int scale){
        this.width = width;
        this.height = height;
        this.lenght = lenght;
        this.scale = scale;
        setScale();
    }
    private void setScale(){
        StdDraw.setXscale(0.0, this.scale);
        StdDraw.setYscale(0.0, this.scale);
    }
}
