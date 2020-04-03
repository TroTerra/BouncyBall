public class BallLogic {
    private double weightConstant = 1;
    private double weight;
    protected double radius;
    protected double restitution = 1;
    Vector2D position;
    Vector2D diriction;
    public  BallLogic(Vector2D spawnPoint, double radius){
        this.radius = radius;
        this.position = spawnPoint;
        this.diriction = makeVector();
        this.weight = calcWeight();
    }

    public void setDiriction(Vector2D newDiriction){
        this.diriction = newDiriction;
    }

    public  double getWeight(){
        return  weight;
    }

    public double getRestitution(){
        return restitution;
    }

    public double getXPosition(){
        return  this.position.x;
    }

    public double getYPosition(){
        return this.position.y;
    }

    public double getRadius(){
        return  radius;
    }

    public void changePosition(){
        this.position = this.position.vectorAddition(this.diriction);
    }

    private Vector2D makeVector(){
        int speed = 20;
        return new Vector2D((Math.random() - 0.5)*speed, (Math.random() - 0.5)*speed);
    }

    private double calcWeight(){
        return radius*weightConstant;
    }

}

