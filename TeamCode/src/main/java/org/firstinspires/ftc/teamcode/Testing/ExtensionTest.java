package org.firstinspires.ftc.teamcode.Testing;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.Robot.Subsystems.RobotContainer;

@Autonomous

public class ExtensionTest extends LinearOpMode {
    private DcMotorEx extensionMotor;
    private DcMotorEx liftMotorRight;
    private DcMotorEx liftMotorLeft;

    @Override
    public void runOpMode() {


        RobotContainer.initialize(hardwareMap, telemetry);
        RobotContainer.extensionSubsystem.encoderReset();

        waitForStart();
/*
            RobotContainer.extensionSubsystem.getPos(telemetry);
            RobotContainer.extensionSubsystem.raiseLift(500);
            RobotContainer.extensionSubsystem.getPos(telemetry);
            sleep(3000);
            RobotContainer.extensionSubsystem.getPos(telemetry);
            RobotContainer.extensionSubsystem.raiseLift(1000);
            RobotContainer.extensionSubsystem.getPos(telemetry);
            sleep(3000);
            RobotContainer.extensionSubsystem.getPos(telemetry);
            RobotContainer.extensionSubsystem.raiseLift(1500);
            RobotContainer.extensionSubsystem.getPos(telemetry);
            sleep(3000);
            RobotContainer.extensionSubsystem.getPos(telemetry);
            RobotContainer.extensionSubsystem.raiseLift(2000);
            RobotContainer.extensionSubsystem.getPos(telemetry);
            sleep(3000);
            RobotContainer.extensionSubsystem.getPos(telemetry);
            RobotContainer.extensionSubsystem.raiseLift(2500);
            RobotContainer.extensionSubsystem.getPos(telemetry);
            sleep(3000);
            RobotContainer.extensionSubsystem.getPos(telemetry);
            RobotContainer.extensionSubsystem.raiseLift(3000);
            RobotContainer.extensionSubsystem.getPos(telemetry);
            sleep(3000);
            RobotContainer.extensionSubsystem.getPos(telemetry);
            RobotContainer.extensionSubsystem.lowerLift(1000);
            RobotContainer.extensionSubsystem.getPos(telemetry);
            sleep(3000);
            RobotContainer.extensionSubsystem.getPos(telemetry);
            RobotContainer.extensionSubsystem.lowerLift(500);
            RobotContainer.extensionSubsystem.getPos(telemetry);
            sleep(3000);
            RobotContainer.extensionSubsystem.getPos(telemetry);
            RobotContainer.extensionSubsystem.zero();
            RobotContainer.extensionSubsystem.getPos(telemetry);
            sleep(5000);
            RobotContainer.extensionSubsystem.getPos(telemetry);
*/
        RobotContainer.extensionSubsystem.moveExtension(400);
        sleep(1000);
    }
}
