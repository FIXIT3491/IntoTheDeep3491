package org.firstinspires.ftc.teamcode.Testing;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.Robot.RobotContainer;

@Autonomous(name="ServoTesting", group = "Autonomous")
public class ServoTesting extends LinearOpMode {


    @Override
    public void runOpMode() {
        RobotContainer.initialize(hardwareMap, telemetry);

        RobotContainer.intakeSubsystem.wristDown();
        waitForStart();

        RobotContainer.intakeSubsystem.wristUp();
        sleep(2000);
//        while (opModeIsActive()) {
//            RobotContainer.intakeSubsystem.wristMove(0.1);
//            sleep(1000);
//            RobotContainer.intakeSubsystem.wristMove(0.2);
//
//
//            telemetry.addData("color detected", RobotContainer.colorSubsystem.DetectColor());
//            telemetry.update();
//
//
//        }

    }
}
