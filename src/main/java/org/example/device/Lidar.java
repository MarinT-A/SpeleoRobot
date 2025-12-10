package org.example.device;

import org.example.model.Point;
import org.example.robot.Direction;
import java.util.Random;


public class Lidar {
    private final Random random = new Random();



    public ScanResult scan(Direction direction) {

        double MIN_WIDTH = 1;

        double MAX_WIDTH = 300.0;
        double width = MIN_WIDTH + random.nextDouble() * (MAX_WIDTH - MIN_WIDTH);

        double MIN_HEIGHT = 1.0;

        double MAX_HEIGHT = 100.0;
        double height = MIN_HEIGHT + random.nextDouble() * (MAX_HEIGHT - MIN_HEIGHT);

        double x, y, z;


        if (direction == Direction.FORWARD || direction == Direction.BACKWARD) {
            x = random.nextDouble() * width;
            y = 0;
            z = random.nextDouble() * height;
        }

        else {
            x = 0;
            y = random.nextDouble() * width;
            z = random.nextDouble() * height;
        }

        Point point = new Point(x, y, z);
        return new ScanResult(point, width, height);
    }
}
