package org.firstinspires.ftc.teamcode.Testing;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.Robot.RobotContainer;

@Autonomous(name="ServoTesting", group = "Autonomous")
public class ServoTesting extends LinearOpMode {


    @Override
    public void runOpMode() {
        RobotContainer.initialize(hardwareMap, telemetry);


        waitForStart();
        RobotContainer.lmecSubsystem.LockMechanum();

    }
}
