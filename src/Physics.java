public class Physics {
    private static Boolean rightWallHit(double wall, double position, double radius){
        return (position + radius >= wall);
    }
    private static Boolean leftWallHit(double wall, double position, double radius){
        return (position - radius <= wall);
    }
    private static Boolean floorHit(double floor, double position, double radius){
        return (position - radius <= floor);
    }
    private static Boolean cealingHit(double cealing, double position, double radius){
        return (position + radius >= cealing);
    }
    public static void hitCheck(Ball ball,double width, double height){
        if(rightWallHit(width,ball.getXPosition(), ball.getRadius())||leftWallHit(0.0, ball.getXPosition(), ball.getRadius())){
            ball.invertXVektor();
        }
        if(floorHit(0.0, ball.getYPosition(), ball.getRadius())||cealingHit(height, ball.getYPosition(), ball.getRadius())){
            ball.invertYVektor();
        }
    }
}
