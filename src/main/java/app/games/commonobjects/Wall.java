package app.games.commonobjects;

import app.gameengine.graphics.SpriteLocation;
import app.gameengine.model.gameobjects.DynamicGameObject;
import app.gameengine.model.gameobjects.StaticGameObject;

/**
 * A wall object the player can collide with, serves as a building block
 * for your levels.
 */
public class Wall extends StaticGameObject {

    public Wall(int x, int y) {
        super(x, y);
        this.spriteSheetFilename = "Ground/Cliff.png";
        this.defaultSpriteLocation = new SpriteLocation(3, 0);
    }

    public void collideWithDynamicObject(DynamicGameObject object ){
        double wall_left=this.getLocation().getX();
        double wall_right= wall_left + this.getDimensions().getX();
        double wall_top=this.getLocation().getY();
        double wall_bottom=wall_top+this.getDimensions().getY();

        double object_left=object.getLocation().getX();
        double object_right=object_left+object.getDimensions().getX();
        double object_top=object.getLocation().getY();
        double object_bottom=object_top+object.getDimensions().getY();

        double random_val = 999999;
        double distance_right=Math.abs(object_left-wall_right);
        random_val = Math.min(random_val, distance_right);
        double distance_top=Math.abs(object_bottom-wall_top);
        random_val=Math.min(random_val,distance_top);
        double distance_left=Math.abs(object_right-wall_left);
        random_val=Math.min(random_val,distance_left);
        double distance_bottom=Math.abs(object_top-wall_bottom);
        random_val=Math.min(random_val,distance_bottom);

        if(random_val==distance_right){
            object.getLocation().setX(wall_right);
        } else if(random_val==distance_left){
            object.getLocation().setX(wall_left-object.getDimensions().getX());
        } else if(random_val==distance_top){
            object.getLocation().setY(wall_top-object.getDimensions().getY());
        } else if (random_val==distance_bottom){
            object.getLocation().setY(wall_bottom);
        }
    }
}
