package app.tests;

import app.gameengine.Level;
import app.gameengine.model.ai.Decision;
import app.gameengine.model.gameobjects.DynamicGameObject;

public class TestingClass extends Decision {

    private boolean decision;

    public TestingClass(String name,boolean decision) {
        super(name);
        this.decision = decision;
    }

    @Override
    public void doAction(DynamicGameObject gameObject, Level level, double dt) {
        gameObject.setHP(6);
    }

    @Override
    public  boolean decide(DynamicGameObject gameObject, Level level, double dt) {
        return this.decision;
    }

}
