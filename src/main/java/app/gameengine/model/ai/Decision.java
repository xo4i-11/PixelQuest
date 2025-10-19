package app.gameengine.model.ai;

import app.gameengine.Level;
import app.gameengine.model.gameobjects.DynamicGameObject;

public class Decision {
    private String decision_name;

    public Decision(String decision_name) {
        this.decision_name = decision_name;
    }

    public String getName(){
        return this.decision_name;
    }

    public void setName(String decision_name){
        this.decision_name = decision_name;
    }

    public  boolean decide(DynamicGameObject gameObject, Level level, double dt) {
        return false;
    }

    public void doAction(DynamicGameObject gameObject, Level level, double dt) {}

}
