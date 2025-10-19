package app.tests;

import app.gameengine.Game;
import app.gameengine.Level;
import app.gameengine.model.ai.Decision;
import app.gameengine.model.ai.DecisionTree;
import app.gameengine.model.datastructures.BinaryTreeNode;
import app.gameengine.model.gameobjects.DynamicGameObject;
import app.gameengine.model.physics.Vector2D;
import app.games.topdownobjects.Enemy;
import com.sun.source.tree.BinaryTree;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestTask4 {

    public static void compareBinaryTreesOfDecisions(BinaryTreeNode<Decision> tree1, BinaryTreeNode<Decision> tree2) {


        if (tree1 == null && tree2 == null) {
            return;
        }

        if (tree1 == null && tree2 != null) {
            assertEquals(tree1, tree2);
        } else if (tree1 != null && tree2 == null) {
            assertEquals(tree1, tree2);
        }

        String tree1_name = tree1.getValue().getName();
        String tree2_name = tree2.getValue().getName();

        assertEquals(tree1_name, tree2_name);

        compareBinaryTreesOfDecisions(tree1.getLeft(), tree2.getLeft());
        compareBinaryTreesOfDecisions(tree1.getRight(), tree2.getRight());
    }

    @Test
    public void reverse_test_1(){

        Decision decision= new TestingClass("0",false);

        Decision decision1=new Decision("4");
        Decision decision2=new Decision("2");
        Decision decision3=new Decision("6");

        BinaryTreeNode<Decision> last1_left=new BinaryTreeNode<>(decision2,null,null);
        BinaryTreeNode<Decision> last2_left=new BinaryTreeNode<>(decision3,null,null);
        BinaryTreeNode<Decision> sub_left_tree=new BinaryTreeNode<>(decision1,last1_left,last2_left);

        Decision decision4=new Decision("8");
        Decision decision5=new Decision("3");
        Decision decision6=new Decision("9");

        BinaryTreeNode<Decision> last1_right=new BinaryTreeNode<>(decision5,null,null);
        BinaryTreeNode<Decision> last2_right=new BinaryTreeNode<>(decision6,null,null);
        BinaryTreeNode<Decision> sub_right_tree=new BinaryTreeNode<>(decision4,last1_right,last2_right);

        BinaryTreeNode<Decision> tree1=new BinaryTreeNode<>(decision,sub_left_tree,sub_right_tree);

        DecisionTree tree=new DecisionTree(tree1);

        tree.reverse();


        Decision decision1_reverse=new Decision("8");
        Decision decision2_reverse=new Decision("9");
        Decision decision3_reverse=new Decision("3");


        BinaryTreeNode<Decision> last1_left_reverse=new BinaryTreeNode<>(decision2_reverse,null,null);
        BinaryTreeNode<Decision> last2_left_reverse=new BinaryTreeNode<>(decision3_reverse,null,null);
        BinaryTreeNode<Decision> sub_left_tree_reverse=new BinaryTreeNode<>(decision1_reverse,last1_left_reverse,last2_left_reverse);

        Decision decision4_reverse=new Decision("4");
        Decision decision5_reverse=new Decision("6");
        Decision decision6_reverse=new Decision("2");

        BinaryTreeNode<Decision> last1_right_reverse=new BinaryTreeNode<>(decision5_reverse,null,null);
        BinaryTreeNode<Decision> last2_right_reverse=new BinaryTreeNode<>(decision6_reverse,null,null);
        BinaryTreeNode<Decision> sub_right_tree_reverse=new BinaryTreeNode<>(decision4_reverse,last1_right_reverse,last2_right_reverse);

        BinaryTreeNode<Decision> tree1_reverse=new BinaryTreeNode<>(decision,sub_left_tree_reverse,sub_right_tree_reverse);

        DecisionTree tree_reverse=new DecisionTree(tree1_reverse);

        compareBinaryTreesOfDecisions(tree.getTree(),tree_reverse.getTree());
    }

    @Test
    public void traverse_test_1() {
        Decision decision= new TestingClass("0",false);

        Decision decision1=new TestingClass("4",false);
        Decision decision2=new TestingClass("2",false);
        Decision decision3=new TestingClass("6",false);


        BinaryTreeNode<Decision> last1_left=new BinaryTreeNode<>(decision2,null,null);
        BinaryTreeNode<Decision> last2_left=new BinaryTreeNode<>(decision3,null,null);
        BinaryTreeNode<Decision> sub_left_tree=new BinaryTreeNode<>(decision1,last1_left,last2_left);

        Decision decision4=new TestingClass("8",false);
        Decision decision5=new TestingClass("3",false);
        Decision decision6=new TestingClass("9",false);

        BinaryTreeNode<Decision> last1_right=new BinaryTreeNode<>(decision5,null,null);
        BinaryTreeNode<Decision> last2_right=new BinaryTreeNode<>(decision6,null,null);
        BinaryTreeNode<Decision> sub_right_tree=new BinaryTreeNode<>(decision4,last1_right,last2_right);


        BinaryTreeNode<Decision> tree1=new BinaryTreeNode<>(decision,sub_left_tree,sub_right_tree);

        DecisionTree tree=new DecisionTree(tree1);

        Enemy enemy = new Enemy(new Vector2D(2,4), 2);
        enemy.setHP(10);
        System.out.println(enemy.getHP());


        Game game= new Game();
        Level level= game.getCurrentLevel();

        tree.traverse(enemy, level, 2);
        System.out.println(enemy.getHP());

        assertEquals(enemy.getHP(),6);
    }

    @Test
    public void traverse_test_2() {
        DecisionTree tree= new DecisionTree(null);

        Enemy enemy = new Enemy(new Vector2D(2,4), 2);
        enemy.setHP(10);
        System.out.println(enemy.getHP());


        Game game= new Game();
        Level level= game.getCurrentLevel();

        tree.traverse(enemy, level, 2);
        System.out.println(enemy.getHP());

        assertEquals(enemy.getHP(),10);

    }

    @Test
    public void traverse_test_3() {
        Decision decision= new TestingClass("0",false);
        Decision decision1=new TestingClass("8",false);

        BinaryTreeNode<Decision> right_node=new BinaryTreeNode<>(decision1,null,null);

        BinaryTreeNode<Decision> node=new BinaryTreeNode<>(decision,null,right_node);

        DecisionTree tree=new DecisionTree(node);

        Enemy enemy = new Enemy(new Vector2D(2,4), 2);
        enemy.setHP(10);
        System.out.println(enemy.getHP());


        Game game= new Game();
        Level level= game.getCurrentLevel();

        tree.traverse(enemy, level, 2);
        System.out.println(enemy.getHP());

        assertEquals(enemy.getHP(),10);

    }

    @Test
    public void traverse_test_4() {
        Decision decision= new TestingClass("0",false);
        BinaryTreeNode<Decision> node=new BinaryTreeNode<>(decision,null,null);

        DecisionTree tree=new DecisionTree(node);

        Enemy enemy = new Enemy(new Vector2D(2,4), 2);
        enemy.setHP(10);
        System.out.println(enemy.getHP());


        Game game= new Game();
        Level level= game.getCurrentLevel();

        tree.traverse(enemy, level, 2);
        System.out.println(enemy.getHP());

        assertEquals(enemy.getHP(),6);
    }

    @Test
    public void traverse_test_5() {
        Decision decision= new TestingClass("0",false);
        Decision decision1=new TestingClass("4",false);
        Decision decision2=new TestingClass("8",false);

        BinaryTreeNode<Decision> left_node=new BinaryTreeNode<>(decision1,null,null);
        BinaryTreeNode<Decision> right_node=new BinaryTreeNode<>(decision2,null,null);

        BinaryTreeNode<Decision> node=new BinaryTreeNode<>(decision,left_node,right_node);

        DecisionTree tree=new DecisionTree(node);

        Enemy enemy = new Enemy(new Vector2D(2,4), 2);
        enemy.setHP(10);
        System.out.println(enemy.getHP());


        Game game= new Game();
        Level level= game.getCurrentLevel();

        tree.traverse(enemy, level, 2);
        System.out.println(enemy.getHP());

        assertEquals(enemy.getHP(),6);
    }

    @Test
    public void traverse_test_6() {
        Decision decision= new TestingClass("0",false);

        Decision decision1=new TestingClass("4",false);
        Decision decision2=new TestingClass("2",false);
        Decision decision3=new TestingClass("6",false);


        BinaryTreeNode<Decision> last1_left=new BinaryTreeNode<>(decision2,null,null);
        BinaryTreeNode<Decision> last2_left=new BinaryTreeNode<>(decision3,null,null);
        BinaryTreeNode<Decision> sub_left_tree=new BinaryTreeNode<>(decision1,last1_left,last2_left);

        Decision decision4=new TestingClass("8",false);
        Decision decision5=new TestingClass("3",false);

        BinaryTreeNode<Decision> last1_right=new BinaryTreeNode<>(decision5,null,null);
        BinaryTreeNode<Decision> sub_right_tree=new BinaryTreeNode<>(decision4,last1_right,null);


        BinaryTreeNode<Decision> tree1=new BinaryTreeNode<>(decision,sub_left_tree,sub_right_tree);

        DecisionTree tree=new DecisionTree(tree1);

        Enemy enemy = new Enemy(new Vector2D(2,4), 2);
        enemy.setHP(10);
        System.out.println(enemy.getHP());


        Game game= new Game();
        Level level= game.getCurrentLevel();

        tree.traverse(enemy, level, 2);
        System.out.println(enemy.getHP());

        assertEquals(enemy.getHP(),6);

    }

    @Test
    public void traverse_test_8() {
        Decision decision= new TestingClass("0",false);
        Decision decision1=new TestingClass("4",true);
        Decision decision3=new TestingClass("2",false);

        BinaryTreeNode<Decision> last1_left=new BinaryTreeNode<>(decision3,null,null);
        BinaryTreeNode<Decision> sub_left_tree=new BinaryTreeNode<>(decision1,last1_left,null);

        Decision decision2=new TestingClass("8",false);

        BinaryTreeNode<Decision> sub_right_tree=new BinaryTreeNode<>(decision2,null,null);

        BinaryTreeNode<Decision> tree1=new BinaryTreeNode<>(decision,sub_left_tree,sub_right_tree);

        DecisionTree tree=new DecisionTree(tree1);

        Enemy enemy = new Enemy(new Vector2D(2,4), 2);
        enemy.setHP(10);
        System.out.println(enemy.getHP());


        Game game= new Game();
        Level level= game.getCurrentLevel();

        tree.traverse(enemy, level, 2);
        System.out.println(enemy.getHP());

        assertEquals(enemy.getHP(),10);



    }
}


