package org.example.model;

import java.util.ArrayList;
import java.util.List;

public class ReliefMap {
    private final List<Point> points = new ArrayList<>();
    public void addPoint(Point point){
        points.add(point);
    }
    public List<Point> getPoints(){
        return List.copyOf(points) ;
    }
    public int size() {
        return points.size();
    }

}
