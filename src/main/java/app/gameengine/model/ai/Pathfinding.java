package app.gameengine.model.ai;


import app.gameengine.Level;
import app.gameengine.model.datastructures.LinkedListNode;
import app.gameengine.model.gameobjects.StaticGameObject;
import app.gameengine.model.physics.Vector2D;

import java.util.*;

public class Pathfinding {

    public static LinkedListNode<Vector2D> findPath(Vector2D obj1, Vector2D obj2) {
        LinkedListNode<Vector2D> start = new LinkedListNode<>(obj1, null);
        findPathHelper(obj1, obj2, start);
        return start;
    }

    private static void findPathHelper(Vector2D obj1, Vector2D obj2, LinkedListNode<Vector2D> start) {
        double x1 = Math.floor(obj1.getX());
        double y1 = Math.floor(obj1.getY());
        obj1.setX(x1);
        obj1.setY(y1);


        double x2 = Math.floor(obj2.getX());
        double y2 = Math.floor(obj2.getY());
        obj2.setX(x2);
        obj2.setY(y2);

        if (obj1.equals(obj2)) {
            return;
        }

        if (x1 != x2) {
            if (x1 < x2) {
                x1 = x1 + 1.0;
            } else if (x1 > x2) {
                x1 = x1 - 1.0;
            }
            Vector2D node = new Vector2D(x1, y1);
            start.append(node);
            findPathHelper(node, obj2, start.getNext());
        } else if (y1 != y2) {
            if (y1 < y2) {
                y1 = y1 + 1.0;
            } else if (y1 > y2) {
                y1 = y1 - 1.0;
            }
            Vector2D node = new Vector2D(x1, y1);
            start.append(node);
            findPathHelper(node, obj2, start.getNext());
        }
    }


    public static LinkedListNode<Vector2D> findPathAvoidWalls(Level level, Vector2D start, Vector2D end) {

        if(start==null || end ==null){
            return null;
        }

        if(start.getX()>= level.getWidth() || start.getY()>= level.getHeight() || end.getY()>= level.getHeight()|| end.getX()>=level.getWidth()){
            return null;
        }

        double start_x = Math.floor(start.getX());
        double start_y = Math.floor(start.getY());

        double end_x = Math.floor(end.getX());
        double end_y = Math.floor(end.getY());


        Vector2D floor_start = new Vector2D(start_x, start_y);
        Vector2D floor_end = new Vector2D(end_x, end_y);



        HashMap<Vector2D, ArrayList<Vector2D>> adjacencyList = new HashMap<>();

        ArrayList<Vector2D> wall_map = new ArrayList<>();

        ArrayList<Vector2D> map_without_wall = new ArrayList<>();

        //map with wall
        for (int x = 0; x < level.getWidth(); x++) {
            for (int y = 0; y < level.getHeight(); y++) {
                Vector2D map_location = new Vector2D(x, y);
                map_without_wall.add(map_location);
            }
        }

        //map of wall
        for (StaticGameObject wall : level.getStaticObjects()) {
            Vector2D wall_location = wall.getLocation();
            wall_map.add(wall_location);
        }

        //map without wall
        for (Vector2D wall_location : wall_map) {
            map_without_wall.remove(wall_location);
        }

        // add node to the graph
        for (Vector2D location : map_without_wall) {
            if (!adjacencyList.containsKey(location)) {
                adjacencyList.put(location, new ArrayList<>());
            }
        }

        // add edge
        for (Vector2D location : map_without_wall) {
            double x = location.getX();
            double y = location.getY();
            if (map_without_wall.contains(new Vector2D(x + 1.0, y))) {
                adjacencyList.get(location).add(new Vector2D(x + 1.0, y));
            }
            if (map_without_wall.contains(new Vector2D(x - 1.0, y))) {
                adjacencyList.get(location).add(new Vector2D(x - 1.0, y));
            }
            if (map_without_wall.contains(new Vector2D(x, y + 1.0))) {
                adjacencyList.get(location).add(new Vector2D(x, y + 1.0));
            }
            if (map_without_wall.contains(new Vector2D(x, y - 1.0))) {
                adjacencyList.get(location).add(new Vector2D(x, y - 1.0));
            }
        }

        //BFS
        ArrayList<Vector2D> explored = new ArrayList<>();
        Queue<Vector2D> queue = new LinkedList<>();
        HashMap<Vector2D, Vector2D> check_before = new HashMap<>();

        queue.add(floor_start);
        explored.add(floor_start);

        while (queue.size()>0) {

            Vector2D node = queue.poll();

            if (adjacencyList.containsKey(node)) {
                ArrayList<Vector2D> linked_node_lst = adjacencyList.get(node);
                for (Vector2D linked_node : linked_node_lst) {
                    if (!explored.contains(linked_node)) {
                        queue.add(linked_node);
                        check_before.put(linked_node, node);
                        explored.add(linked_node);
                    }
                }
            }

        }

        LinkedListNode<Vector2D> path=null;

        if(check_before.containsKey(floor_end) || check_before.containsValue(floor_end)) {
            path = new LinkedListNode<>(floor_end, null);
            Vector2D last_node = floor_end;

            if (check_before.containsKey(last_node)) {

                while (last_node!=null) {
                    last_node = check_before.get(last_node);
                    if (last_node!=null){
                        path = new LinkedListNode<>(last_node, path);
                    }

                }
            }
        }
        return path;
    }
}



