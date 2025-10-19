package app.gameengine.model.gameobjects;

import app.gameengine.Level;
import app.gameengine.model.ai.DecisionTree;
import app.gameengine.model.datastructures.LinkedListNode;
import app.gameengine.model.physics.Vector2D;
import app.games.topdownobjects.Projectile;

import java.util.ArrayList;

public abstract class DynamicGameObject extends GameObject {

    protected Vector2D velocity = new Vector2D(0.0, 0.0);

    private int maxHP;
    private int hp;
    private boolean onGround = false;

    private Vector2D Orientation = new Vector2D(0.0, 1.0);

    private double Invincibility_time = 0.0;

    public LinkedListNode<Vector2D> path = null;

    private DecisionTree tree;

    private ArrayList<CollectibleGameObject> inventory = new ArrayList<>();

    private CollectibleGameObject activeItem;

    public DynamicGameObject(Vector2D location, int maxHP) {
        super(location);
        this.maxHP = maxHP;
        this.hp = maxHP;
    }

    public DecisionTree getDecisionTree() {
        return this.tree;
    }

    public void setDecisionTree(DecisionTree tree) {
        this.tree = tree;
    }


    public void setPath(LinkedListNode<Vector2D> path) {
        this.path = path;
    }

    public LinkedListNode<Vector2D> getPath() {
        return this.path;
    }

    public double getInvincibilityFrames() {
        return this.Invincibility_time;
    }

    public void setInvincibilityFrames(double time) {
        this.Invincibility_time = time;
    }

    @Override
    public void update(double dt, Level level) {
        super.update(dt, level);

        if (this.tree != null) {
            this.tree.traverse(this, level, dt);
        }

        this.Invincibility_time -= dt;
        if (this.getHP() <= 0) {
            this.destroy();
        }
    }


    public int getMaxHP() {
        return this.maxHP;
    }

    public int getHP() {
        return this.hp;
    }

    public void setHP(int hp) {
        if (hp > this.maxHP) {
            this.hp = maxHP;
        } else {
            this.hp = hp;
        }
    }

    public Vector2D getOrientation() {
        return this.Orientation;
    }

    public Vector2D getVelocity() {
        return this.velocity;
    }

    public void takeDamage(int damage) {
        if (damage >= 0) {
            this.hp -= damage;
        }
    }

    @Override
    public boolean isDestroyed() {
        return super.isDestroyed();
    }

    @Override
    public void revive() {
        super.revive();
    }

    @Override
    public void collideWithStaticObject(StaticGameObject otherObject) {

    }

    @Override
    public void collideWithDynamicObject(DynamicGameObject otherObject) {

    }

    public boolean isOnGround() {
        return this.onGround;
    }

    public void setOnGround(boolean onGround) {
        this.onGround = onGround;
    }

    public void addInventoryItem(CollectibleGameObject item) {
        this.inventory.add(item);
        if (this.inventory.size() == 1) {
            this.activeItem = item;
        }
    }

    public void removeActiveItem() {

        if (this.inventory == null) {
            return;
        }

        for (int i = 0; i < this.inventory.size(); i++) {
            if (this.activeItem.equals(this.inventory.get(i))) {
                this.inventory.remove(i);

                if (this.inventory.size() == 0) {
                    this.activeItem = null;
                    return;
                } else {
                    if (i + 1 > this.inventory.size()) {
                        this.activeItem = this.inventory.get(0);
                        return;
                    } else {
                        this.activeItem = this.inventory.get(i);
                        return;
                    }
                }
            }
        }
    }

    public CollectibleGameObject getActiveItem() {
        if (this.inventory.size()==0) {
            return null;
        }

        if (this.inventory.size() == 1) {
            this.activeItem = this.inventory.get(0);
            return this.activeItem;
        }

        return this.activeItem;
    }

    public String getActiveItemID() {
        if (this.inventory.size()==0) {
            return "No item equipped";
        }
        return this.activeItem.getItemID();
    }

    public void cycleInventory() {

        if (this.inventory.size()==0) {
            return;
        }

        if (this.inventory.size() == 1) {
            this.activeItem = this.inventory.get(0);
        }

        for (int i = 0; i < inventory.size(); i++) {
            if (this.activeItem.equals(inventory.get(i))) {
                if (i == this.inventory.size() - 1) {
                    this.activeItem = this.inventory.get(0);
                    return;
                } else {
                    this.activeItem = this.inventory.get(i + 1);
                    return;
                }
            }
        }
    }

    public void fireProjectile(Projectile projectile,double speed,Level level) {

        double player_x=this.getLocation().getX();
        double player_y=this.getLocation().getY();

        projectile.getLocation().setX(player_x);
        projectile.getLocation().setY(player_y);

        double orientation_x=this.getOrientation().getX();
        double orientation_y=this.getOrientation().getY();

        projectile.getVelocity().setX(orientation_x*speed);
        projectile.getVelocity().setY(orientation_y*speed);

        level.getDynamicObjects().add(projectile);

    }
}
