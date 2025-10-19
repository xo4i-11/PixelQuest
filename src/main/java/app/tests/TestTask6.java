package app.tests;

import app.gameengine.Game;
import app.gameengine.Level;
import app.gameengine.model.ai.Pathfinding;
import app.gameengine.model.datastructures.LinkedListNode;
import app.gameengine.model.physics.Vector2D;
import app.games.commonobjects.Goal;
import app.games.commonobjects.Potion;
import app.games.commonobjects.Wall;
import app.games.topdownobjects.*;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TestTask6 extends TestTask2 {

    @Test
    public void testSimplePathWithNoWalls_1() {
        Level level = new TopDownLevel(new Game(), 6, 6, "lv1");
        Vector2D player = new Vector2D(1, 1);
        Vector2D enemy = new Vector2D(4, 1);

        LinkedListNode<Vector2D> path = Pathfinding.findPathAvoidWalls(level, enemy, player);

        validatePath(path);

        assertEquals(length_count(path), 4, DELTA);

    }

    @Test
    public void testSimplePathWithNoWalls_2() {
        Level level = new TopDownLevel(new Game(), 15, 15, "lv2");
        Vector2D player = new Vector2D(1.1, 1.1);
        Vector2D enemy = new Vector2D(13.6, 11.6);

        LinkedListNode<Vector2D> path = Pathfinding.findPathAvoidWalls(level, enemy, player);

        validatePath(path);

        assertEquals(length_count(path), 23, DELTA);

    }

    @Test
    public void testSimplePathWithNoWalls_3() {
        Level level = new TopDownLevel(new Game(), 13, 13, "lv3");
        Vector2D player = new Vector2D(1.1, 1.1);
        Vector2D enemy = new Vector2D(1.4, 1.0);

        LinkedListNode<Vector2D> path = Pathfinding.findPathAvoidWalls(level, enemy, player);

        validatePath(path);

        assertEquals(length_count(path), 1, DELTA);

    }

    @Test
    public void testSimplePathWithNoWalls_4() {
        Level level = new TopDownLevel(new Game(), 12, 12, "lv4");
        Vector2D player = new Vector2D(1.1, 1.1);
        Vector2D enemy = new Vector2D(7, 7);
        level.getStaticObjects().add(new Wall(4, 4));
        level.getStaticObjects().add(new Wall(5, 4));
        level.getStaticObjects().add(new Wall(6, 4));
        level.getStaticObjects().add(new Wall(7, 4));
        level.getStaticObjects().add(new Wall(8, 4));

        LinkedListNode<Vector2D> path = Pathfinding.findPathAvoidWalls(level, enemy, player);

        validatePath(path);

        assertEquals(length_count(path), 13, DELTA);

    }

    @Test
    public void testSimplePathWithNoWalls_5() {
        Level level = new TopDownLevel(new Game(), 12, 12, "lv5");
        Vector2D player = new Vector2D(16, 7);
        Vector2D enemy = new Vector2D(7, 3);

        LinkedListNode<Vector2D> path = Pathfinding.findPathAvoidWalls(level, enemy, player);

        validatePath(path);

        assertEquals(length_count(path), 0.0, DELTA);
    }

    @Test
    public void testSimplePathWithNoWalls_6() {
        Level level = new TopDownLevel(new Game(), 10, 5, "lv6");
        Vector2D player = new Vector2D(2, 1);
        Vector2D enemy = new Vector2D(7, 3);


        level.getStaticObjects().add(new Wall(4, 1));
        level.getStaticObjects().add(new Wall(4, 2));
        level.getStaticObjects().add(new Wall(4, 3));


        LinkedListNode<Vector2D> path = Pathfinding.findPathAvoidWalls(level, enemy, player);

        validatePath(path);

        assertEquals(length_count(path), 0.0, DELTA);
    }

    @Test
    public void testSimplePathWithNoWalls_7() {
        Level level = new TopDownLevel(new Game(), 10, 5, "lv7");
        Vector2D player = new Vector2D(2, 1);
        Vector2D enemy = new Vector2D(7, 3);


        level.getStaticObjects().add(new Wall(4, 2));
        level.getStaticObjects().add(new Wall(4, 3));
        level.getStaticObjects().add(new Wall(4, 4));
        level.getStaticObjects().add(new Wall(4, 5));

        LinkedListNode<Vector2D> path = Pathfinding.findPathAvoidWalls(level, enemy, player);

        validatePath(path);

        assertEquals(length_count(path), 8.0, DELTA);


    }
}
