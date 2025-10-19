package app.games.topdownobjects;

import app.gameengine.Level;
import app.gameengine.graphics.SpriteLocation;
import app.gameengine.model.ai.Decision;
import app.gameengine.model.ai.DecisionTree;
import app.gameengine.model.ai.MoveTowardsPlayer;
import app.gameengine.model.ai.Pathfinding;
import app.gameengine.model.datastructures.BinaryTreeNode;
import app.gameengine.model.datastructures.LinkedListNode;
import app.gameengine.model.gameobjects.DynamicGameObject;
import app.gameengine.model.physics.Vector2D;

/**
 * Basic enemy class.
 *
 * In future tasks, you will develop tools to give enemies more features:
 * like pathfinding, AI, etc.
 */
public class Enemy extends DynamicGameObject {

    private int strength;

    public Enemy(Vector2D location) {
        this(location, 3);
    }

    public Enemy(Vector2D location, int strength) {
        super(location, 10);
        this.strength = strength;
        this.spriteSheetFilename = "Characters/Monsters/Demons/ArmouredRedDemon.png";
        this.defaultSpriteLocation = new SpriteLocation(0, 2);

        MoveTowardsPlayer decision = new MoveTowardsPlayer("I DO(N'T) LIKE CSE116");
        BinaryTreeNode<Decision> root = new BinaryTreeNode<>(decision, null, null);
        DecisionTree tree = new DecisionTree(root);
        this.setDecisionTree(tree);
    }

    @Override
    public void collideWithDynamicObject(DynamicGameObject otherObject) {
        if(otherObject.isPlayer() && otherObject.getInvincibilityFrames()<= 0){
            otherObject.takeDamage(this.strength);
            otherObject.setInvincibilityFrames(0.5);
        }
    }
}
