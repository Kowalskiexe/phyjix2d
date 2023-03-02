import engine.*;

public class Main {
    public static void main(String[] args) {
        Scene scene = new Scene();

        Body body1 = new Body(0, 0, 1);
        Body body2 = new Body(5, 5, 1);
        body1.addForce(new Vector2(1, 1));

        scene.addBody(body1);
        scene.addBody(body2);

        scene.simulate(10, 60);

        System.out.println("Body1: " + body1);
        System.out.println("body2: " + body2);
    }
}