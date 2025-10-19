package app.gameengine.model.ai;

import app.gameengine.Level;
import app.gameengine.model.datastructures.BinaryTreeNode;
import app.gameengine.model.gameobjects.DynamicGameObject;

public class DecisionTree {

    private BinaryTreeNode<Decision> tree;

    public DecisionTree(BinaryTreeNode<Decision> tree) {
        this.tree = tree;
    }

    public BinaryTreeNode<Decision> getTree() {
        return this.tree;
    }

    public void setTree(BinaryTreeNode<Decision> tree) {
        this.tree = tree;
    }

    public Decision traverse(BinaryTreeNode<Decision> node, DynamicGameObject gameObject, Level level, double dt) {
        if (node == null) {
            return null;
        }

        boolean decision = node.getValue().decide(gameObject, level, dt);

        if (node.getLeft() != null && node.getRight() != null) {
            if (decision == false) {
                return traverse(node.getLeft(), gameObject, level, dt);
            } else if (decision == true) {
                return traverse(node.getRight(), gameObject, level, dt);
            }
        }

        if (node.getLeft() == null && node.getRight() == null) {
            return node.getValue();
        }

        if (node.getLeft() != null && node.getRight() == null) {
            if (decision == false) {
                return traverse(node.getLeft(), gameObject, level, dt);
            } else if (decision == true) {
                return null;
            }
        }

        if (node.getLeft() == null && node.getRight() != null) {
            if (decision == false) {
                return null;
            } else if (decision == true) {
                return traverse(node.getRight(), gameObject, level, dt);
            }
        }
        return null;
    }

    public void traverse(DynamicGameObject gameObject, Level level, double dt) {
        Decision decision = traverse(this.tree, gameObject, level, dt);
        if (decision == null) {
            return;
        }
        decision.doAction(gameObject, level, dt);
    }

    public void reverse (BinaryTreeNode<Decision> decision) {
        if (decision == null) {
            return;
        }

        BinaryTreeNode<Decision> right_switch = decision.getRight();
        BinaryTreeNode<Decision> left_switch = decision.getLeft();

        decision.setLeft(right_switch);
        decision.setRight(left_switch);

        if (decision.getLeft() != null) {
            reverse(decision.getLeft());
        }

        if (decision.getRight() != null) {
            reverse(decision.getRight());
        }
    }

    public void reverse(){
        reverse (this.tree);
    }
}
