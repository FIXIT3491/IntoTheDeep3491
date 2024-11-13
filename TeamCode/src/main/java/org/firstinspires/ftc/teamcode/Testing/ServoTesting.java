package org.firstinspires.ftc.teamcode.Testing;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.Commands.CommandBase;
import org.firstinspires.ftc.teamcode.Commands.Pickup;
import org.firstinspires.ftc.teamcode.Robot.Subsystems.RobotContainer;
@Disabled
@Autonomous(name="ServoTesting", group = "Autonomous")
public class ServoTesting extends LinearOpMode {


    @Override
    public void runOpMode() {
        CommandBase.initialize(hardwareMap, telemetry, this);

//        RobotContainer.intakeSubsystem.wristDown();
        waitForStart();



        RobotContainer.intakeSubsystem.wristMove(0.03);
        sleep(2000);
        RobotContainer.intakeSubsystem.wristMove(0.2);
        sleep(2000);
        RobotContainer.intakeSubsystem.wristMove(0.3);
        sleep(2000);
        RobotContainer.intakeSubsystem.wristMove(0.4);
        sleep(2000);
        RobotContainer.intakeSubsystem.wristMove(0.5);
        sleep(2000);
        RobotContainer.intakeSubsystem.wristMove(0.6);
        sleep(2000);


    }
}
