package app.tests;

import app.gameengine.model.gameobjects.DynamicGameObject;
import app.gameengine.model.gameobjects.Player;
import app.gameengine.model.physics.Vector2D;
import app.games.platformerobjects.PlatformerWall;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestTask3 {

    static final double EPSILON = 0.001;

    @Test
    public void test1(){
        PlatformerWall platformerWall = new PlatformerWall(4,3);
        Player obj=new Player(new Vector2D(3.5,4),10);
        obj.getVelocity().setY(2);
        platformerWall.collideWithDynamicObject(obj);
        assertEquals(obj.getVelocity().getY(),0,EPSILON);
        assertEquals(obj.isOnGround(),false);
    }

    @Test
    public void test2(){
        PlatformerWall platformerWall = new PlatformerWall(4,3);
        Player obj=new Player(new Vector2D(3.5,2),10);
        obj.getVelocity().setY(2.0);
        platformerWall.collideWithDynamicObject(obj);
        assertEquals(0,obj.getVelocity().getY(),EPSILON);
        assertEquals(obj.isOnGround(),true);
    }
}
