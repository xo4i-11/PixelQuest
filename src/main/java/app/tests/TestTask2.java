package app.tests;

import app.gameengine.model.ai.Pathfinding;
import app.gameengine.model.datastructures.LinkedListNode;
import app.gameengine.model.physics.Vector2D;
import org.junit.Test;

import static org.junit.Assert.*;

public class TestTask2 {
 static final double DELTA = 0.001;

 public void decimal_check(LinkedListNode<Vector2D> node){
  assertEquals(node.getValue().getX(), Math.floor(node.getValue().getX()), DELTA);
  assertEquals(node.getValue().getY(), Math.floor(node.getValue().getY()), DELTA);
 }
 public void validatePath(LinkedListNode<Vector2D> checked_path) {
  if (checked_path == null) {
   assertTrue(checked_path == null);
  }
  else if(checked_path.getNext() == null){
   decimal_check(checked_path);
  }
  else {
   while (checked_path.getNext() != null) {
    decimal_check(checked_path);
    decimal_check(checked_path.getNext());
    if(checked_path.getNext() != null) {
     double differenceX = Math.abs(checked_path.getValue().getX() - checked_path.getNext().getValue().getX());
     double differenceY = Math.abs(checked_path.getValue().getY() - checked_path.getNext().getValue().getY());
     assertNotEquals(differenceY, differenceX);
     assertTrue(differenceY <= 1.0);
     assertTrue(differenceX <= 1.0);
     }
     checked_path = checked_path.getNext();
    }
   }
 }

 public int length_count(LinkedListNode<Vector2D> path) {
  int count = 0;
  while (path != null) {
   count++;
   path = path.getNext();
  }
  return count;
 }


 @Test
 public void test1() {
  Vector2D obj1 = new Vector2D(2.1, 3.1);
  Vector2D obj2 = new Vector2D(5.1, 5.1);
  LinkedListNode<Vector2D> path = Pathfinding.findPath(obj1, obj2);
  validatePath(path);
  assertEquals(length_count(path), 6, DELTA);
 }

 @Test
 public void test2() {
  Vector2D obj1 = new Vector2D(2.1, 3.1);
  Vector2D obj2 = new Vector2D(2.4, 3.4);
  LinkedListNode<Vector2D> path = Pathfinding.findPath(obj1, obj2);
  validatePath(path);
  assertEquals(length_count(path), 1, DELTA);
 }

 @Test
 public void tes3() {
  LinkedListNode<Vector2D> path = null;
  validatePath(path);
 }

 @Test
 public void test4() {
  Vector2D obj1 = new Vector2D(2.1, 3.1);
  Vector2D obj2 = new Vector2D(3.9, 3.1);
  LinkedListNode<Vector2D> path = Pathfinding.findPath(obj1, obj2);
  validatePath(path);
 }

 @Test
 public void test5(){
  Vector2D obj1 = new Vector2D(2.0, 3.0);
  LinkedListNode<Vector2D> path = new LinkedListNode<>(obj1,null);
  validatePath(path);
 }
}

