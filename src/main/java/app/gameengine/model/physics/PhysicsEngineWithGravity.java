package app.gameengine.model.physics;

import app.gameengine.model.gameobjects.DynamicGameObject;

public class PhysicsEngineWithGravity extends PhysicsEngine {
    private double acceleration;
    public PhysicsEngineWithGravity(double acceleration) {
        this.acceleration = acceleration;
    }

    @Override
    public void updateObject(DynamicGameObject dynamicObject,double dt) {
        double velocity=dynamicObject.getVelocity().getY();
        double velocity_change=acceleration*dt;
        dynamicObject.getVelocity().setY(velocity+velocity_change);
        super.updateObject(dynamicObject,dt);
    }
}
