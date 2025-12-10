package org.example.device;

import org.example.model.Point;

public class ScanResult {
    private final Point point;
    private final double width;
    private final double height;


    public ScanResult(Point point, double width, double height) {
        this.point = point;
        this.width = width;
        this.height = height;
    }

    public Point getPoint() {
        return point;
    }

    public double getWidth() {
        return width;
    }

    public double getHeight() {
        return height;
    }
    @Override
    public String toString() {
        return String.format("ширина=%.1f м, высота=%.1f м", width, height);
    }
}
