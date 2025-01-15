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
    public IMUSubsystem imuSubsystem;


    public RobotContainer(HardwareMap hardwareMap) {
    }


    public void initialize(Telemetry telemetry, HardwareMap hardwareMap) {

        driveSubsystem = new DriveSubsystem(hardwareMap, telemetry);
        intakeSubsystem = new IntakeSubsystem(hardwareMap, telemetry);
        extensionSubsystem = new ExtensionSubsystem(hardwareMap, telemetry);
//        lmecSubsystem = new LMECSubsystem(hardwareMap, telemetry);
        colorSubsystem = new ColorSubsystem(hardwareMap, telemetry);
        imuSubsystem = new IMUSubsystem(hardwareMap, telemetry);
        extensionSubsystem.encoderReset();

    }



    // Getters for subsystems to allow access from elsewhere
    // Additional logic for setting up control bindings or configurations can go here
}
