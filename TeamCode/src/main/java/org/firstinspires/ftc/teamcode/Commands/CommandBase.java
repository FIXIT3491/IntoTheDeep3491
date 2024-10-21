package org.firstinspires.ftc.teamcode.Commands;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.Robot.Subsystems.ColorSubsystem;
import org.firstinspires.ftc.teamcode.Robot.Subsystems.DriveSubsystem;
import org.firstinspires.ftc.teamcode.Robot.Subsystems.ExtensionSubsystem;
import org.firstinspires.ftc.teamcode.Robot.Subsystems.IntakeSubsystem;
import org.firstinspires.ftc.teamcode.Robot.Subsystems.LMECSubsystem;
import org.firstinspires.ftc.teamcode.Robot.Subsystems.RobotContainer;
import org.firstinspires.ftc.teamcode.Robot.Subsystems.SparkFunSubsystem;

public class CommandBase {


    // Instances of your subsystems (child classes)
    public static Config config;
    public static Drive drive;
    public static Pickup pickup;
    public static Scoring scoring;
    public static TeleOp teleOp;




    public static void initialize(HardwareMap hardwareMap, Telemetry telemetry, LinearOpMode op) {

        config = new Config(telemetry);
        drive = new Drive(op, telemetry);
        pickup = new Pickup(telemetry);
        scoring = new Scoring(telemetry);
        teleOp = new TeleOp(telemetry);
        RobotContainer.initialize(hardwareMap, telemetry);


    }
    public CommandBase(){

    }
}
