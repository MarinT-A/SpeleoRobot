package org.example.sensor;

public class MethaneSensor extends Sensor {
    @Override
    public double getDangerousThreshold() {
        return 45000;
    }

    @Override
    public double read() {
        return Math.random() * 46000;
    }
}
