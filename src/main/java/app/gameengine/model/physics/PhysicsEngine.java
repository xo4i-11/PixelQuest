package app.gameengine.model.physics;

import app.gameengine.model.gameobjects.DynamicGameObject;
import app.gameengine.Level;
import app.gameengine.model.gameobjects.StaticGameObject;

public class PhysicsEngine {

    public PhysicsEngine() {}

    public void updateLevel(Level level, double dt) {

        // Update the location of each dynamic object based on its velocity
        for(DynamicGameObject dynamicObject : level.getDynamicObjects()){
            updateObject(dynamicObject, dt);
        }

        // detect all collisions for each dynamic object
        for (int i = 0; i < level.getDynamicObjects().size(); i++) {
            DynamicGameObject dynamicObject1 = level.getDynamicObjects().get(i);

            // check for collisions with other dynamic objects
            // start at i+1 to avoid reporting collision multiple times
            for (int j = i+1; j < level.getDynamicObjects().size(); j++) {
                DynamicGameObject dynamicObject2 = level.getDynamicObjects().get(j);
                if(detectCollision(dynamicObject1.getHitBox(), dynamicObject2.getHitBox())){
                    dynamicObject1.collideWithDynamicObject(dynamicObject2);
                    dynamicObject2.collideWithDynamicObject(dynamicObject1);
                }
            }

            // check for collisions with static objects
            for(StaticGameObject so : level.getStaticObjects()){
                if(detectCollision(so.getHitBox(), dynamicObject1.getHitBox())){
                    so.collideWithDynamicObject(dynamicObject1);
                    dynamicObject1.collideWithStaticObject(so);
                }
            }
        }

    }

    public void updateObject(DynamicGameObject dynamicObject, double dt){
        // TODO: update location based on velocity
        Vector2D location= dynamicObject.getLocation();
        Vector2D velocity=dynamicObject.getVelocity();

        double x_location= location.getX();
        double y_location=location.getY();

        double x_velocity= velocity.getX();
        double y_velocity=velocity.getY();

        location.setX(x_location+ x_velocity*dt);
        location.setY(y_location+y_velocity*dt);
    }

    public boolean detectCollision(Hitbox hb1, Hitbox hb2){
        // TODO: return true if the 2 hitboxes overlap; false otherwise
        Vector2D player_location=hb1.getLocation();
        Vector2D obstacle_location=hb2.getLocation();

        Vector2D player_dimension=hb1.getDimensions();
        Vector2D obstacle_dimension=hb2.getDimensions();

        double player_left=player_location.getX();
        double player_right=player_left+player_dimension.getX();
        double player_top=player_location.getY();
        double player_bottom=player_top+player_dimension.getY();

        double obstacle_left =obstacle_location.getX();
        double obstacle_right= obstacle_left +obstacle_dimension.getX();
        double obstacle_top=obstacle_location.getY();
        double obstacle_bottom=obstacle_top+obstacle_dimension.getY();

        if(player_top>obstacle_bottom && player_bottom>obstacle_top){
            return false;
        } else if(player_top<obstacle_bottom && player_bottom<obstacle_top){
            return false;
        } else if(player_right< obstacle_left && player_left<obstacle_right){
            return false;
        } else if(player_right> obstacle_left && player_left>obstacle_right){
            return false;
        }
        return true;
    }
}


