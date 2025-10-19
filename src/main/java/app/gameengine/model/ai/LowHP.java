package app.gameengine.model.ai;

import app.gameengine.Level;
import app.gameengine.model.gameobjects.DynamicGameObject;

public class LowHP extends Decision{

    private int hp_threshold;

    public LowHP(String decision_name,int hp_threshold){
        super(decision_name);
        this.hp_threshold = hp_threshold;
    }

    @Override
    public  boolean decide(DynamicGameObject gameObject, Level level, double dt) {
        if(gameObject.getHP()<=this.hp_threshold){
            return true;
        }
        return false;
    }
}
