package app.tests;

import app.gameengine.model.gameobjects.Player;
import app.gameengine.model.physics.Hitbox;
import app.gameengine.model.physics.PhysicsEngine;
import app.gameengine.model.physics.Vector2D;
import app.games.commonobjects.Wall;
import javafx.util.Pair;
import org.junit.Test;
import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class TestTask1 {

    static final double EPSILON = 0.0001;

    // TODO: write your tests here

    @Test
    public void testWallCollisionsSimple() {
        // we give you the tests for wall collisions. Don't change them
        //
        // However, you should read through these tests to better understand what you should
        // be testing for and how you should be testing
        Player player = new Player(new Vector2D(0, 0), 10);
        Wall w1 = new Wall(1, 0);
        Wall w2 = new Wall(0, 1);
        Wall w3 = new Wall(-1, 0);
        Wall w4 = new Wall(0, -1);

        // Move right
        player.getLocation().setX(0.5);
        player.getLocation().setY(0);
        w1.collideWithDynamicObject(player);
        assertEquals(0.0, player.getLocation().getX(), EPSILON);
        assertEquals(0.0, player.getLocation().getY(), EPSILON);

        // Move down
        player.getLocation().setX(0);
        player.getLocation().setY(0.5);
        w2.collideWithDynamicObject(player);
        assertEquals(0.0, player.getLocation().getX(), EPSILON);
        assertEquals(0.0, player.getLocation().getY(), EPSILON);

        // Move left
        player.getLocation().setX(-0.5);
        player.getLocation().setY(0);
        w3.collideWithDynamicObject(player);
        assertEquals(0.0, player.getLocation().getX(), EPSILON);
        assertEquals(0.0, player.getLocation().getY(), EPSILON);

        // Move up
        player.getLocation().setX(0);
        player.getLocation().setY(-0.5);
        w4.collideWithDynamicObject(player);
        assertEquals(0.0, player.getLocation().getX(), EPSILON);
        assertEquals(0.0, player.getLocation().getY(), EPSILON);
    }

    @Test
    public void testWallCollisionsComplex() {
        Player player = new Player(new Vector2D(0.0, 0.0), 10);
        Wall w1 = new Wall(5, 2);

        player.getLocation().setX(4.5);
        player.getLocation().setY(1.2);
        w1.collideWithDynamicObject(player);
        assertEquals(4.5, player.getLocation().getX(), EPSILON);
        assertEquals(1.0, player.getLocation().getY(), EPSILON);

        player.getLocation().setX(5.0);
        player.getLocation().setY(1.2);
        w1.collideWithDynamicObject(player);
        assertEquals(5.0, player.getLocation().getX(), EPSILON);
        assertEquals(1.0, player.getLocation().getY(), EPSILON);

        player.getLocation().setX(5.5);
        player.getLocation().setY(1.2);
        w1.collideWithDynamicObject(player);
        assertEquals(5.5, player.getLocation().getX(), EPSILON);
        assertEquals(1.0, player.getLocation().getY(), EPSILON);

        player.getLocation().setX(5.9);
        player.getLocation().setY(1.2);
        w1.collideWithDynamicObject(player);
        assertEquals(6.0, player.getLocation().getX(), EPSILON);
        assertEquals(1.2, player.getLocation().getY(), EPSILON);

        player.getLocation().setX(5.9);
        player.getLocation().setY(1.5);
        w1.collideWithDynamicObject(player);
        assertEquals(6.0, player.getLocation().getX(), EPSILON);
        assertEquals(1.5, player.getLocation().getY(), EPSILON);

        player.getLocation().setX(5.9);
        player.getLocation().setY(2.5);
        w1.collideWithDynamicObject(player);
        assertEquals(6.0, player.getLocation().getX(), EPSILON);
        assertEquals(2.5, player.getLocation().getY(), EPSILON);

        player.getLocation().setX(5.9);
        player.getLocation().setY(2.8);
        w1.collideWithDynamicObject(player);
        assertEquals(6.0, player.getLocation().getX(), EPSILON);
        assertEquals(2.8, player.getLocation().getY(), EPSILON);

        player.getLocation().setX(5.2);
        player.getLocation().setY(2.8);
        w1.collideWithDynamicObject(player);
        assertEquals(5.2, player.getLocation().getX(), EPSILON);
        assertEquals(3.0, player.getLocation().getY(), EPSILON);

        player.getLocation().setX(4.2);
        player.getLocation().setY(2.7);
        w1.collideWithDynamicObject(player);
        assertEquals(4.0, player.getLocation().getX(), EPSILON);
        assertEquals(2.7, player.getLocation().getY(), EPSILON);

        player.getLocation().setX(4.2);
        player.getLocation().setY(2.0);
        w1.collideWithDynamicObject(player);
        assertEquals(4.0, player.getLocation().getX(), EPSILON);
        assertEquals(2.0, player.getLocation().getY(), EPSILON);

        player.getLocation().setX(4.2);
        player.getLocation().setY(1.5);
        w1.collideWithDynamicObject(player);
        assertEquals(4.0, player.getLocation().getX(), EPSILON);
        assertEquals(1.5, player.getLocation().getY(), EPSILON);
    }

    public void comparePlayers(Player p1,Player p2){
        //location
        assertEquals(p1.getLocation().getX(),p2.getLocation().getX(),EPSILON);
        assertEquals(p1.getLocation().getY(),p2.getLocation().getY(),EPSILON);

        //velocity
        assertEquals(p1.getVelocity().getX(),p2.getVelocity().getX(),EPSILON);
        assertEquals(p1.getVelocity().getY(),p2.getVelocity().getY(),EPSILON);

        //orientation
        assertEquals(p1.getOrientation().getX(),p2.getOrientation().getX(),EPSILON);
        assertEquals(p1.getOrientation().getY(),p2.getOrientation().getY(),EPSILON);

        //HP
        assertEquals(p1.getHP(),p2.getHP(),EPSILON);

        //MaxHP
        assertEquals(p1.getMaxHP(),p2.getMaxHP(),EPSILON);
    }

    @Test
    public void DynamicGameObjectTest(){
        Player p1=new Player(new Vector2D(1.0,3.0),10);

        assertEquals(1.0,p1.getLocation().getX(),EPSILON);
        assertEquals(3.0,p1.getLocation().getY(),EPSILON);
        assertEquals(0.0,p1.getVelocity().getX(),EPSILON);
        assertEquals(0.0,p1.getVelocity().getY(),EPSILON);
        assertEquals(0.0,p1.getOrientation().getX(),EPSILON);
        assertEquals(1.0,p1.getOrientation().getY(),EPSILON);
        assertEquals(10,p1.getHP(),EPSILON);
        assertEquals(10,p1.getMaxHP(),EPSILON);
    }

    @Test
    public void setHPTest1(){
        Player p1=new Player(new Vector2D(1.0,3.0),10);
        p1.setHP(8);
        assertEquals(8,p1.getHP(),EPSILON);
        }

    @Test
    public void setHPTest2(){
        Player p1=new Player(new Vector2D(1.0,3.0),10);
        p1.setHP(13);
        assertEquals(10,p1.getHP(),EPSILON);
    }

    @Test
    public void takeDamage1(){
        Player p1=new Player(new Vector2D(1.0,3.0),8);
        p1.takeDamage(2);
        assertEquals(6,p1.getHP(),EPSILON);
    }

    @Test
    public void takeDamage2(){
        Player p1=new Player(new Vector2D(1.0,3.0),8);
        p1.takeDamage(10);
        assertEquals(-2,p1.getHP(),EPSILON);
    }

    @Test
    public void takeDamage3(){
        Player p1=new Player(new Vector2D(1.0,3.0),8);
        p1.takeDamage(0);
        assertEquals(8,p1.getHP(),EPSILON);
    }

    @Test
    public void takeDamage4(){
        Player p1=new Player(new Vector2D(1.0,3.0),8);
        p1.takeDamage(1);
        p1.takeDamage(-4);
        p1.takeDamage(0);
        assertEquals(7.0,p1.getHP(),EPSILON);
    }

    @Test
    public void updateObjectTest1(){
        PhysicsEngine call=new PhysicsEngine();
        Player p1=new Player(new Vector2D(1.0,3.0),10);
        p1.getVelocity().setX(2.0);
        p1.getVelocity().setY(2.0);
        call.updateObject(p1,2.0);
        assertEquals(5.0,p1.getLocation().getX(),EPSILON);
        assertEquals(7.0,p1.getLocation().getY(),EPSILON);
    }

    @Test
    public void updateObjectTest2(){
        PhysicsEngine call=new PhysicsEngine();
        Player p1=new Player(new Vector2D(1.0,3.0),10);
        p1.getVelocity().setX(-1.0);
        p1.getVelocity().setY(-1.0);
        call.updateObject(p1,2.0);
        assertEquals(-1.0,p1.getLocation().getX(),EPSILON);
        assertEquals(1.0,p1.getLocation().getY(),EPSILON);
    }

    @Test
    public void updateObjectTest3(){
        PhysicsEngine call=new PhysicsEngine();
        Player p1=new Player(new Vector2D(1.0,3.0),10);
        p1.getVelocity().setX(0.0);
        p1.getVelocity().setY(0.0);
        call.updateObject(p1,2.0);
        assertEquals(1.0,p1.getLocation().getX(),EPSILON);
        assertEquals(3.0,p1.getLocation().getY(),EPSILON);
    }

    @Test
    public void updateObjectTest4(){
        PhysicsEngine call=new PhysicsEngine();
        Player p1=new Player(new Vector2D(1.0,3.0),10);
        p1.getVelocity().setX(1.5);
        p1.getVelocity().setY(-1.5);
        call.updateObject(p1,1.0);
        assertEquals(2.5,p1.getLocation().getX(),EPSILON);
        assertEquals(1.5,p1.getLocation().getY(),EPSILON);

    }

    @Test
    public void detectCollisionTest(){
        PhysicsEngine call=new PhysicsEngine();
        Hitbox hb1=new Hitbox(new Vector2D(2.0,3.0),new Vector2D(2.0,2.0));
        Hitbox hb2=new Hitbox(new Vector2D(3.0,4.0),new Vector2D(2.0,2.0));
        Hitbox hb3=new Hitbox(new Vector2D(6.0,7.0),new Vector2D(2.0,2.0));
        assertEquals(true,call.detectCollision(hb1,hb2));
        assertEquals(false,call.detectCollision(hb2,hb3));
        assertEquals(false,call.detectCollision(hb1,hb3));

    }

}