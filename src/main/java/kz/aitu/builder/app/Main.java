package kz.aitu.builder.app;

import kz.aitu.builder.director.RobotDirector;
import kz.aitu.builder.model.RobotConfiguration;

public class Main {

    public static void main(String[] args) {

        RobotConfiguration basicRobot =
                RobotDirector.createBasicRobot();

        RobotConfiguration warehouseRobot =
                RobotDirector.createWarehouseRobot();

        RobotConfiguration autonomousRobot =
                RobotDirector.createAutonomousRobot();

        System.out.println("=== BASIC ROBOT ===");
        System.out.println(basicRobot);

        System.out.println();

        System.out.println("=== WAREHOUSE ROBOT ===");
        System.out.println(warehouseRobot);

        System.out.println();

        System.out.println("=== AUTONOMOUS ROBOT ===");
        System.out.println(autonomousRobot);

        System.out.println(
                "AUTONOMOUS configuration built successfully 🍌"
        );
    }
}