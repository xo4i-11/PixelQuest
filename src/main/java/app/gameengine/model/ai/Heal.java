package app.gameengine.model.ai;

import app.gameengine.Level;
import app.gameengine.model.gameobjects.DynamicGameObject;

public class Heal extends Decision{

    private int heal;
    private double cooldown_time;
    private double time_spend_node;

    public Heal(String name,int heal,double cooldown_time){
        super(name);
        this.heal = heal;
        this.cooldown_time = cooldown_time;
    }

    @Override
    public void doAction(DynamicGameObject gameObject, Level level, double dt){
        this.time_spend_node+=dt;

        if(this.time_spend_node>=this.cooldown_time){
            gameObject.setHP(gameObject.getHP()+this.heal);
            this.time_spend_node=0.0;
        }

        gameObject.getVelocity().setX(0);
        gameObject.getVelocity().setY(0);
    }

}
