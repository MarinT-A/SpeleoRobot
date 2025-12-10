package org.example;

import org.example.controller.Robot;
import org.example.robot.Direction;

public class MainRobot {
    public static void main(String[] args) {
        Robot robot = new Robot();
        System.out.println();
        System.out.println("Робот в точке старта");
        System.out.println("🤖 Робот начал исследование!");
        for (int i = 0; i < 11; i++) {
            robot.step(Direction.FORWARD, 5.0);
        }
        System.out.println("🦇 Исследование завершено. Точек на карте: " + robot.getMap().size());
        System.out.println("Остаток кабеля: " + robot.getCableRemaining() + " м");
    }
}


