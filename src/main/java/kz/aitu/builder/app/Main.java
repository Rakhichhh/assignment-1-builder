package kz.aitu.builder.app;

import kz.aitu.builder.model.Dimensions;
import kz.aitu.builder.model.RobotConfiguration;

public class Main {

    public static void main(String[] args) {

        Dimensions dimensions = new Dimensions(
                120,
                80,
                150
        );

        RobotConfiguration robot = new RobotConfiguration(
                "Warehouse Bot",
                "RX-100",
                80,
                4.5,
                true,
                true,
                true,
                false,
                60,
                true,
                true,
                dimensions
        );

        System.out.println(robot);
    }
}