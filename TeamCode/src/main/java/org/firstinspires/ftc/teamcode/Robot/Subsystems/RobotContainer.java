package org.firstinspires.ftc.teamcode.Robot.Subsystems;

import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class RobotContainer{


    // Instances of your subsystems (child classes)
    public  DriveSubsystem driveSubsystem;
    public  IntakeSubsystem intakeSubsystem;
    public  ExtensionSubsystem extensionSubsystem;
    public  LMECSubsystem lmecSubsystem;
    public  ColorSubsystem colorSubsystem;
    private  RobotContainer robotContainer;
    public IMUSubsystem imuSubsystem;
    public TelemetrySubsystem telemetrySubsystem;
    HardwareMap h;

    public RobotContainer(HardwareMap hardwareMap) {
        h = hardwareMap;
    }


    public void initialize(Telemetry telemetry) {

        driveSubsystem = new DriveSubsystem(h, telemetry);
        intakeSubsystem = new IntakeSubsystem(h, telemetry);
        extensionSubsystem = new ExtensionSubsystem(h, telemetry);
        lmecSubsystem = new LMECSubsystem(h, telemetry);
        colorSubsystem = new ColorSubsystem(h, telemetry);
        imuSubsystem = new IMUSubsystem(h, telemetry);
        telemetrySubsystem = new TelemetrySubsystem(telemetry);
        extensionSubsystem.encoderReset();

    }



    // Getters for subsystems to allow access from elsewhere
    // Additional logic for setting up control bindings or configurations can go here
}
