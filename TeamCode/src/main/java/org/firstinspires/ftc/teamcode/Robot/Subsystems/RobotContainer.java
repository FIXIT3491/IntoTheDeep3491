package org.firstinspires.ftc.teamcode.Robot.Subsystems;

import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class RobotContainer{


    // Instances of your subsystems (child classes)
    public static DriveSubsystem driveSubsystem;
    public static IntakeSubsystem intakeSubsystem;
    public static ExtensionSubsystem extensionSubsystem;
    public static LMECSubsystem lmecSubsystem;
    public static ColorSubsystem colorSubsystem;
    public static SparkFunSubsystem sparkFunSubsystem;
    private static RobotContainer robotContainer;
    public static IMUSubsystem imuSubsystem;



    public static void initialize(HardwareMap hardwareMap, Telemetry telemetry) {
        driveSubsystem = new DriveSubsystem(hardwareMap, telemetry);
        intakeSubsystem = new IntakeSubsystem(hardwareMap, telemetry);
        extensionSubsystem = new ExtensionSubsystem(hardwareMap, telemetry);
        lmecSubsystem = new LMECSubsystem(hardwareMap, telemetry);
        colorSubsystem = new ColorSubsystem(hardwareMap, telemetry);
        sparkFunSubsystem = new SparkFunSubsystem(hardwareMap, telemetry);
        imuSubsystem = new IMUSubsystem(hardwareMap, telemetry);
        sparkFunSubsystem.configureOtos();

    }



    // Getters for subsystems to allow access from elsewhere
    // Additional logic for setting up control bindings or configurations can go here
}
