public class BallLogic {
    private double wheightConstant = 1;
    private double wheight;
    protected double radius;
    Vector2D position;
    Vector2D diriction;
    public  BallLogic(Vector2D spawnPoint){
        this.radius = 100;
        this.position = spawnPoint;
        this.diriction = makeVector();
        this.wheight = calcWheight();
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
        return new Vector2D((Math.random() - 0.5)*20, (Math.random() - 0.5)*20);
    }

    private double calcWheight(){
        return radius*wheightConstant;
    }
}

