public class Vector2D {
    public double x;
    public double y;

    public Vector2D(double x, double y){
        this.x = x;
        this.y = y;
    }

    public Vector2D vectorAddition(Vector2D toBeAddet){
        Vector2D newVetor = new Vector2D(this.x + toBeAddet.x, this.y + toBeAddet.y);
        return  newVetor;
    }

    public Vector2D vectorMultiplication(Vector2D toBeMultipplied){
        return new Vector2D(this.x * toBeMultipplied.x, this.y * toBeMultipplied.y);
    }

    public Vector2D vectorMultiplication(double a, double b){
        return new Vector2D(this.x * a, this.y * b);
    }

    public double length(){
        return Math.sqrt((x*x+y*y));
    }

    public double product(Vector2D a){
        return this.x * a.x + this.y * a.y;
    }
}
