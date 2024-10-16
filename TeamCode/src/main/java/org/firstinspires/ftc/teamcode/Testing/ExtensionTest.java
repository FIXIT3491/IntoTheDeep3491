package org.firstinspires.ftc.teamcode.Testing;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;

import org.firstinspires.ftc.teamcode.Robot.RobotContainer;

@Autonomous

public class ExtensionTest extends LinearOpMode {

    private DcMotorEx extensionMotor;
    private DcMotor liftMotor1;
    private DcMotor liftMotor2;

    @Override
    public void runOpMode() {

        RobotContainer.initialize(hardwareMap, telemetry);


        waitForStart();


            RobotContainer.extensionSubsystem.moveLift(1);
            sleep(3000);
            RobotContainer.extensionSubsystem.moveLift(0);


            sleep(3000);








    }
}
