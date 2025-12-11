package org.example.sensor;

public class COSensor extends Sensor {
    @Override
    public double getDangerousThreshold() {
        return 10000;
    }

    @Override
    public double read() {
        return Math.random() * 10500;
    }
}
