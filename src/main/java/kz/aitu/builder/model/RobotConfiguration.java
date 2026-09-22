package kz.aitu.builder.model;

public final class RobotConfiguration {

    private final String robotName;
    private final String model;
    private final int batteryCapacity;
    private final double maxSpeed;

    private final boolean camera;
    private final boolean gps;
    private final boolean lidar;
    private final boolean voiceControl;
    private final double loadCapacity;
    private final boolean autonomousMode;
    private final boolean emergencyStop;
    private final Dimensions dimensions;

    RobotConfiguration(RobotConfigurationBuilder builder) {
        this.robotName = builder.getRobotName();
        this.model = builder.getModel();
        this.batteryCapacity = builder.getBatteryCapacity();
        this.maxSpeed = builder.getMaxSpeed();

        this.camera = builder.hasCamera();
        this.gps = builder.hasGps();
        this.lidar = builder.hasLidar();
        this.voiceControl = builder.hasVoiceControl();
        this.loadCapacity = builder.getLoadCapacity();
        this.autonomousMode = builder.isAutonomousMode();
        this.emergencyStop = builder.hasEmergencyStop();
        this.dimensions = builder.getDimensions();
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

    @Override
    public String toString() {
        return "RobotConfiguration{" +
                "robotName='" + robotName + '\'' +
                ", model='" + model + '\'' +
                ", batteryCapacity=" + batteryCapacity +
                ", maxSpeed=" + maxSpeed +
                ", camera=" + camera +
                ", gps=" + gps +
                ", lidar=" + lidar +
                ", voiceControl=" + voiceControl +
                ", loadCapacity=" + loadCapacity +
                ", autonomousMode=" + autonomousMode +
                ", emergencyStop=" + emergencyStop +
                ", dimensions=" + dimensions +
                '}';
    }
}