public class BouncyBall {
    private static Background createBackground(int numberOfBalls){
        Background background = new Background(2048,2048,2048,4096, numberOfBalls);
        return background;
    }
    public static void main(String[] args){
        Background background = createBackground(20);
        while(true){
            background.update();
            background.draw();
            StdDraw.show(1);
        }
    }
}
