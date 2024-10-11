package org.firstinspires.ftc.teamcode.Robot;

import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class RobotContainer {
    // Instances of your subsystems (child classes)
    private DriveSubsystem driveSubsystem;
    private IntakeSubsystem intakeSubsystem;
    private ExtensionSubsystem extensionSubsystem;
    private LMECSubsystem lmecSubsystem;
    private ColorSubsystem colorSubsystem;

    public RobotContainer(HardwareMap hardwareMap, Telemetry telemetry) {
        // Initialize subsystems
        driveSubsystem = new DriveSubsystem(hardwareMap, telemetry);
        intakeSubsystem = new IntakeSubsystem(hardwareMap, telemetry);
        extensionSubsystem = new ExtensionSubsystem(hardwareMap,telemetry);
        lmecSubsystem = new LMECSubsystem(hardwareMap,telemetry);
        colorSubsystem = new ColorSubsystem(hardwareMap,telemetry);
    }


    // Getters for subsystems to allow access from elsewhere
    public DriveSubsystem getDriveSubsystem() {
        return driveSubsystem;
    }

    public IntakeSubsystem getIntakeSubsystem() {
        return intakeSubsystem;
    }

    public ExtensionSubsystem getExtensionSubsystem() {
        return extensionSubsystem;
    }
    public LMECSubsystem getLMECSubsystem() {
        return lmecSubsystem;
    }
    public ColorSubsystem getColorSensorSubsystem() {
        return colorSubsystem;
    }

    // Additional logic for setting up control bindings or configurations can go here
}
