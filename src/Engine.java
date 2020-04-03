public class Engine {
    Vector2D AABBMin;
    Vector2D AABBMax;

    private boolean circalVsCircalDetection(Ball first, Ball second){
        double r = first.getRadius() + second.getRadius();
        r *= r;
        return r < (first.getXPosition() + second.getXPosition()) * (first.getXPosition() + second.getXPosition()) +
                (first.getYPosition() + second.getYPosition()) * (first.getYPosition() + second.getYPosition());
    }

    private boolean circalVsCircal(Ball a, Ball b){
        Vector2D norm = b.position.vectorAddition(a.position);
        double r = a.radius +b.radius;
        r *= r;
        double d = norm.length();
    }

    private void Collision(Ball a, Ball b){
        Vector2D relativVelcity = b.diriction.vectorAddition(a.diriction.vectorMultiplication(-1,-1));

        double velAlongNorm = a.diriction.product(b.diriction);

        if(velAlongNorm > 0){
            return;
        }

        double e = Math.min(a.getRestitution(), b.getRestitution());

        double j = - (1 + e) * velAlongNorm;
        j /= 1 / a.getWeight() + 1 / b.getWeight();

        Vector2D impuls = j * ;

        a.setDiriction();
    }
}
