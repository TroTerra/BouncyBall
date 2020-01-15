public class BouncyBall {
    private static Background createBackground(){
        Background background = new Background(2048,2048,2048,4096, 5);
        return background;
    }
    public static void main(String[] args){
        Background background = createBackground();
        while(true){
            background.update();
            background.draw();
            StdDraw.show(1);
        }
    }
}
