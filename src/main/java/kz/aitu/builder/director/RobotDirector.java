package kz.aitu.builder.director;

import kz.aitu.builder.model.Dimensions;
import kz.aitu.builder.model.RobotConfiguration;
import kz.aitu.builder.model.RobotConfigurationBuilder;

public final class RobotDirector {

    private RobotDirector() {
    }

    public static RobotConfiguration createBasicRobot() {
        return new RobotConfigurationBuilder(
                "Basic Bot",
                "RB-10",
                40,
                3.0
        )
                .withLoadCapacity(10)
                .withDimensions(
                        new Dimensions(80, 50, 100)
                )
                .build();
    }

    public static RobotConfiguration createWarehouseRobot() {
        return new RobotConfigurationBuilder(
                "Warehouse Bot",
                "WH-200",
                85,
                4.0
        )
                .enableCamera()
                .enableGps()
                .withLoadCapacity(80)
                .withDimensions(
                        new Dimensions(120, 80, 150)
                )
                .build();
    }

    public static RobotConfiguration createAutonomousRobot() {
        return new RobotConfigurationBuilder(
                "Autonomous Bot",
                "AUTO-X",
                95,
                5.0
        )
                .enableCamera()
                .enableGps()
                .enableLidar()
                .enableVoiceControl()
                .enableAutonomousMode()
                .withLoadCapacity(40)
                .withDimensions(
                        new Dimensions(100, 70, 130)
                )
                .build();
    }
}