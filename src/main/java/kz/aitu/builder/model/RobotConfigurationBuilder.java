package kz.aitu.builder.model;

public class RobotConfigurationBuilder {

    // Required properties
    private final String robotName;
    private final String model;
    private final int batteryCapacity;
    private final double maxSpeed;

    // Optional properties with default values
    private boolean camera = false;
    private boolean gps = false;
    private boolean lidar = false;
    private boolean voiceControl = false;
    private double loadCapacity = 0.0;
    private boolean autonomousMode = false;
    private boolean emergencyStop = true;

    private Dimensions dimensions =
            new Dimensions(100, 60, 120);

    public RobotConfigurationBuilder(
            String robotName,
            String model,
            int batteryCapacity,
            double maxSpeed
    ) {
        this.robotName = robotName;
        this.model = model;
        this.batteryCapacity = batteryCapacity;
        this.maxSpeed = maxSpeed;
    }

    public RobotConfigurationBuilder enableCamera() {
        this.camera = true;
        return this;
    }

    public RobotConfigurationBuilder enableGps() {
        this.gps = true;
        return this;
    }

    public RobotConfigurationBuilder enableLidar() {
        this.lidar = true;
        return this;
    }

    public RobotConfigurationBuilder enableVoiceControl() {
        this.voiceControl = true;
        return this;
    }

    public RobotConfigurationBuilder withLoadCapacity(double loadCapacity) {
        this.loadCapacity = loadCapacity;
        return this;
    }

    public RobotConfigurationBuilder enableAutonomousMode() {
        this.autonomousMode = true;
        return this;
    }

    public RobotConfigurationBuilder disableEmergencyStop() {
        this.emergencyStop = false;
        return this;
    }

    public RobotConfigurationBuilder withDimensions(
            Dimensions dimensions
    ) {
        this.dimensions = dimensions;
        return this;
    }

    public RobotConfiguration build() {
        validate();
        return new RobotConfiguration(this);
    }

    private void validate() {
        validateRobotName();
        validateModel();
        validateBatteryCapacity();
        validateMaxSpeed();
        validateLoadCapacity();
        validateDimensions();

        validateAutonomousConfiguration();
        validateHeavyLoadConfiguration();
    }

    private void validateRobotName() {
        if (robotName == null || robotName.isBlank()) {
            throw new IllegalArgumentException(
                    "Robot name cannot be blank"
            );
        }
    }

    private void validateModel() {
        if (model == null || model.isBlank()) {
            throw new IllegalArgumentException(
                    "Robot model cannot be blank"
            );
        }
    }

    private void validateBatteryCapacity() {
        if (batteryCapacity < 1 || batteryCapacity > 100) {
            throw new IllegalArgumentException(
                    "Battery capacity must be between 1 and 100"
            );
        }
    }

    private void validateMaxSpeed() {
        if (maxSpeed <= 0 || maxSpeed > 20) {
            throw new IllegalArgumentException(
                    "Maximum speed must be greater than 0 and not exceed 20"
            );
        }
    }

    private void validateLoadCapacity() {
        if (loadCapacity < 0) {
            throw new IllegalArgumentException(
                    "Load capacity cannot be negative"
            );
        }
    }

    private void validateDimensions() {
        if (dimensions == null) {
            throw new IllegalArgumentException(
                    "Dimensions cannot be null"
            );
        }
    }

    private void validateAutonomousConfiguration() {
        if (autonomousMode && !camera && !lidar) {
            throw new IllegalStateException(
                    "Autonomous robot requires a camera or lidar"
            );
        }
    }

    private void validateHeavyLoadConfiguration() {
        if (loadCapacity > 50 && maxSpeed > 5) {
            throw new IllegalStateException(
                    "Robots carrying more than 50 kg cannot exceed 5 m/s"
            );
        }
    }

    public String getRobotName() {
        return robotName;
    }

    public String getModel() {
        return model;
    }

    public int getBatteryCapacity() {
        return batteryCapacity;
    }

    public double getMaxSpeed() {
        return maxSpeed;
    }

    public boolean hasCamera() {
        return camera;
    }

    public boolean hasGps() {
        return gps;
    }

    public boolean hasLidar() {
        return lidar;
    }

    public boolean hasVoiceControl() {
        return voiceControl;
    }

    public double getLoadCapacity() {
        return loadCapacity;
    }

    public boolean isAutonomousMode() {
        return autonomousMode;
    }

    public boolean hasEmergencyStop() {
        return emergencyStop;
    }

    public Dimensions getDimensions() {
        return dimensions;
    }
}