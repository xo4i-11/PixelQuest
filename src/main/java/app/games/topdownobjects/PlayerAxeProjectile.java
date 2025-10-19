package app.games.topdownobjects;

import app.gameengine.graphics.SpriteLocation;
import app.gameengine.model.physics.Vector2D;

import java.util.ArrayList;

public class PlayerAxeProjectile extends Projectile {
    public PlayerAxeProjectile(Vector2D location) {
        super(location,6);
        this.spriteSheetFilename="Objects/Axe.png";
        this.defaultSpriteLocation = new SpriteLocation(1,1);

        ArrayList<SpriteLocation> sprite_list = new ArrayList<>();
        sprite_list.add(new SpriteLocation(0,0));
        sprite_list.add(new SpriteLocation(1,0));
        sprite_list.add(new SpriteLocation(2,0));
        sprite_list.add(new SpriteLocation(3,0));
        sprite_list.add(new SpriteLocation(0,1));
        sprite_list.add(new SpriteLocation(1,1));
        sprite_list.add(new SpriteLocation(2,1));
        sprite_list.add(new SpriteLocation(3,1));

        this.animations.put("default", sprite_list);
    }
}
