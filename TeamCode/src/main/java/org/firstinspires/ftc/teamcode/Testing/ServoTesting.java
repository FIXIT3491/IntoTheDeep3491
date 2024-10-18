package org.firstinspires.ftc.teamcode.Testing;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.Robot.Subsystems.RobotContainer;

@Autonomous(name="ServoTesting", group = "Autonomous")
public class ServoTesting extends LinearOpMode {


    @Override
    public void runOpMode() {
        RobotContainer.initialize(hardwareMap, telemetry);

        RobotContainer.intakeSubsystem.wristDown();
        waitForStart();

        RobotContainer.intakeSubsystem.wristUp();
        sleep(2000);


    }
}
