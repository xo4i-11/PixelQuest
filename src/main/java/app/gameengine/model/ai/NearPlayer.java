package app.gameengine.model.ai;

import app.gameengine.Level;
import app.gameengine.model.gameobjects.DynamicGameObject;

public class NearPlayer extends Decision{

    private double distance;

    public NearPlayer(String name,double distance){
        super(name);
        this.distance=distance;
    }

    @Override
    public  boolean decide(DynamicGameObject gameObject, Level level, double dt){
        double gameObject_x= gameObject.getLocation().getX();
        double gameObject_y= gameObject.getLocation().getY();

        double player_x=level.getPlayer().getLocation().getX();
        double player_y=level.getPlayer().getLocation().getY();

        double distance_to_player=Math.sqrt(Math.pow(player_x-gameObject_x, 2)+Math.pow(player_y-gameObject_y, 2));

        if(distance_to_player<=this.distance){
        return true;
        } else{
            return false;
        }
    }
}

