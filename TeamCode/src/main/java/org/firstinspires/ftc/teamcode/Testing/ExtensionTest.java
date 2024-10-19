package org.firstinspires.ftc.teamcode.Testing;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;

import org.firstinspires.ftc.teamcode.Robot.Subsystems.RobotContainer;

@Autonomous

public class ExtensionTest extends LinearOpMode {

    private DcMotorEx extensionMotor;
    private DcMotor liftMotor1;
    private DcMotor liftMotor2;

    @Override
    public void runOpMode() {

        RobotContainer.initialize(hardwareMap, telemetry);

        waitForStart();

            RobotContainer.extensionSubsystem.moveLiftOut(-5000);
            sleep(5000);
            RobotContainer.extensionSubsystem.moveLiftIn(0);
            sleep(5000);


    }
}
