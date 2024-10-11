package org.firstinspires.ftc.teamcode.Testing;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.Robot.RobotContainer;

@Autonomous
public class ServoTesting extends LinearOpMode {

    private RobotContainer robot;

    @Override
    public void runOpMode() {
        robot = new RobotContainer(hardwareMap, telemetry);

        waitForStart();

    }
}
