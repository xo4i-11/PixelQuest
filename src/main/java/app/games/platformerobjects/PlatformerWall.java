package app.games.platformerobjects;

import app.gameengine.graphics.SpriteLocation;
import app.gameengine.model.gameobjects.DynamicGameObject;
import app.games.commonobjects.Wall;

public class PlatformerWall extends Wall {

    public PlatformerWall(int x_location, int y_location) {
        super(x_location, y_location);
        this.spriteSheetFilename="Ground/Cliff.png";
        this.defaultSpriteLocation= new SpriteLocation(4,0);
    }

    @Override
    public void  collideWithDynamicObject(DynamicGameObject object ) {
        super.collideWithDynamicObject(object);
        double object_left=object.getLocation().getX();
        double object_right=object_left+object.getDimensions().getX();
        double object_top=object.getLocation().getY();
        double object_bottom=object_top+object.getDimensions().getY();

        double wall_left=this.getLocation().getX();
        double wall_right=wall_left+ this.getDimensions().getX();
        double wall_top=this.getLocation().getY();

        if(object_right>wall_left && object_left<wall_right){
            object.getVelocity().setY(0.0);
            if(object_bottom<=wall_top){
                object.setOnGround(true);
            }
        }


    }
}
