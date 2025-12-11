package org.example.sensor;

public abstract class Sensor {
    public abstract double getDangerousThreshold();

    public boolean isDangerous(double value) {
        return value >= getDangerousThreshold();
    }

    public double read() {
        return 0;
    }
}
