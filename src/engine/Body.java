package engine;

import java.util.ArrayList;

public class Body {
    private Vector2 position = new Vector2();
    private float mass = 0;
    private final ArrayList<Vector2> forces = new ArrayList<>();
    private final Vector2 velocity = new Vector2();

    public Body() {}

    public Body(float x, float y, float mass) {
        position = new Vector2(x, y);
        this.mass = mass;
    }
    public void addForce(Vector2 force) {
        forces.add(force);
    }

    public Vector2 getNetForce() {
        Vector2 net = new Vector2();
        for (Vector2 force : forces) net.add(force);
        return net;
    }

    public Vector2 getAcceleration() {
        // F = ma => a = F/m
        Vector2 netForce = getNetForce();
        return Vector2.div(netForce, mass);
    }

    public void simulateFrame(float deltaTime) {
        Vector2 acceleration = getAcceleration();
        velocity.add(acceleration.mul(deltaTime));

        // p = at^2/2 + vt + p0
        Vector2 displacement = acceleration.mul(deltaTime * deltaTime / 2);
        displacement.add(velocity.mul(deltaTime));

        position.add(displacement);
    }

    @Override
    public String toString() {
        return "Body at " + position + " with velocity " + velocity;
    }
}
