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
//import org.firstinspires.ftc.teamcode.Robot.Subsystems.SparkFunSubsystem;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class CommandBase {
HardwareMap hardwareMap;

    // Instances of your subsystems (child classes)
//    public static Config config;
//    Claw claw = new Claw(hardwareMap);
    public Lift lift = new Lift(hardwareMap);



    public CommandBase(){

    }
}
