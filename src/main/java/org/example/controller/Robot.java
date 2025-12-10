package org.example.controller;

import org.example.device.CableBobbin;
import org.example.device.Lidar;
import org.example.device.ScanResult;
import org.example.model.Point;
import org.example.model.ReliefMap;
import org.example.robot.Direction;
import org.example.sensor.COSensor;
import org.example.sensor.Sensor;
import org.example.sensor.MethaneSensor;

public class Robot {
    private Point position = new Point(0, 0, 0);
    private final CableBobbin cableBobbin = new CableBobbin();
    private final Lidar lidar = new Lidar();
    private final Sensor methaneSensor = new MethaneSensor();
    private final Sensor co2Sensor = new COSensor();
    private final ReliefMap map = new ReliefMap();

    public void step(Direction direction, double distance) {
        if (!cableBobbin.extend((int) distance)) {
            System.out.println("Превышен лимит длины кабеля! Движение невозможно.");
            return;
        }
        switch (direction) {
            case FORWARD -> position.setZ(position.getZ() + distance);
            case BACKWARD -> position.setZ(position.getZ() - distance);
            case LEFT -> position.setX(position.getX() - distance);
            case RIGHT -> position.setX(position.getX() + distance);
        }

        ScanResult result = lidar.scan(direction);
        map.addPoint(new Point(position.getX(), position.getY(), position.getZ()));


        double methane = methaneSensor.read();
        double co = co2Sensor.read();



        System.out.printf("Шаг: %d | Позиция: %s | Плоскость: %s | Метан: %.1f ppm | CO: %.1f ppm%n",
                map.size(), position, result, methane, co);


        if (methaneSensor.isDangerous(methane)) {
            System.out.printf("⚠️ ОПАСНОСТЬ! Уровень метана: %.1f ppm (порог: %.1f ppm)%n",
                    methane, methaneSensor.getDangerousThreshold()); // Используем метод сенсора
        }

        if (co2Sensor.isDangerous(co)) {
            System.out.printf("⚠️ ОПАСНОСТЬ! Уровень угарного газа (CO): %.1f ppm (порог: %.1f ppm)%n",
                    co, co2Sensor.getDangerousThreshold()); // Используем метод сенсора
        }
    }

    public ReliefMap getMap() {
        return map; }
    public int getCableRemaining() {
        return cableBobbin.getMaxLength() - cableBobbin.getCurrentLength(); }
}

