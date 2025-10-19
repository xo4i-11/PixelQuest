package app.gameengine.model.gameobjects;

import app.gameengine.Level;
import app.gameengine.model.physics.Vector2D;



public abstract class CollectibleGameObject extends DynamicGameObject {
    private String ItemID;

    public CollectibleGameObject(Vector2D location, String ItemID) {
        super(location, 10);
        this.ItemID = ItemID;
    }

    public String getItemID() {
        return this.ItemID;
    }

    @Override
    public void takeDamage(int damage) {
    }

    public abstract void use(Level level);

    @Override
    public void collideWithDynamicObject(DynamicGameObject obj) {
        if (obj.isPlayer() == true) {
            obj.addInventoryItem(this);
            this.destroy();
        }
    }

}


