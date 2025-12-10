package org.example.sensor;

public abstract class Sensor {
    public abstract double getDangerousThreshold(); // Абстрактный метод для получения порога

    public boolean isDangerous(double value) {
        return value >= getDangerousThreshold(); // Используем метод, а не статическое поле
    }

    public double read() {
        return 0;
    }
}
