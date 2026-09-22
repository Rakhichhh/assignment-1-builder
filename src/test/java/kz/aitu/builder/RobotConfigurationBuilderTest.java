package kz.aitu.builder;

import kz.aitu.builder.director.RobotDirector;
import kz.aitu.builder.model.RobotConfiguration;
import kz.aitu.builder.model.RobotConfigurationBuilder;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RobotConfigurationBuilderTest {

    @Test
    void shouldBuildValidBasicRobot() {
        RobotConfiguration robot =
                RobotDirector.createBasicRobot();

        assertEquals("Basic Bot", robot.getRobotName());
        assertFalse(robot.isAutonomousMode());
    }

    @Test
    void shouldBuildValidWarehouseRobot() {
        RobotConfiguration robot =
                RobotDirector.createWarehouseRobot();

        assertEquals("Warehouse Bot", robot.getRobotName());
        assertEquals(80.0, robot.getLoadCapacity());
    }

    @Test
    void shouldBuildValidAutonomousRobot() {
        RobotConfiguration robot =
                RobotDirector.createAutonomousRobot();

        assertTrue(robot.isAutonomousMode());
        assertTrue(robot.hasCamera());
        assertTrue(robot.hasLidar());
    }

    @Test
    void shouldRejectBlankRobotName() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new RobotConfigurationBuilder(
                        "",
                        "RX-1",
                        50,
                        3
                ).build()
        );
    }

    @Test
    void shouldRejectInvalidBatteryCapacity() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new RobotConfigurationBuilder(
                        "Robot",
                        "RX-1",
                        0,
                        3
                ).build()
        );
    }

    @Test
    void shouldRejectNegativeLoadCapacity() {
        assertThrows(
                IllegalArgumentException.class,
                () -> new RobotConfigurationBuilder(
                        "Robot",
                        "RX-1",
                        50,
                        3
                )
                        .withLoadCapacity(-5)
                        .build()
        );
    }

    @Test
    void shouldAcceptMinimumBatteryBoundary() {
        RobotConfiguration robot =
                new RobotConfigurationBuilder(
                        "Boundary Bot",
                        "B-1",
                        1,
                        1
                )
                        .build();

        assertEquals(1, robot.getBatteryCapacity());
    }

    @Test
    void shouldAcceptMaximumBatteryBoundary() {
        RobotConfiguration robot =
                new RobotConfigurationBuilder(
                        "Boundary Bot",
                        "B-2",
                        100,
                        1
                )
                        .build();

        assertEquals(100, robot.getBatteryCapacity());
    }

    @Test
    void autonomousRobotMustHaveCameraOrLidar() {
        assertThrows(
                IllegalStateException.class,
                () -> new RobotConfigurationBuilder(
                        "Autonomous Robot",
                        "AUTO-1",
                        90,
                        4
                )
                        .enableAutonomousMode()
                        .build()
        );
    }

    @Test
    void builderReuseMustNotChangePreviousProduct() {
        RobotConfigurationBuilder builder =
                new RobotConfigurationBuilder(
                        "Reusable Bot",
                        "RB-5",
                        70,
                        4
                );

        RobotConfiguration firstRobot =
                builder.build();

        RobotConfiguration secondRobot =
                builder
                        .enableCamera()
                        .enableGps()
                        .build();

        assertFalse(firstRobot.hasCamera());
        assertFalse(firstRobot.hasGps());

        assertTrue(secondRobot.hasCamera());
        assertTrue(secondRobot.hasGps());
    }
}