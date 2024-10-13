package org.firstinspires.ftc.teamcode.Testing;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;

import org.firstinspires.ftc.teamcode.Robot.RobotContainer;

@Autonomous

public class ExtensionTest extends LinearOpMode {

//    private DcMotor extensionMotor;
    private DcMotor liftMotor1;
    private DcMotor liftMotor2;

    @Override
    public void runOpMode() {

//        extensionMotor = hardwareMap.get(DcMotor.class, "extension");
        liftMotor1 = hardwareMap.get(DcMotor.class, "Lift1");
        liftMotor2 = hardwareMap.get(DcMotor.class, "Lift2");

        waitForStart();

        liftMotor1.setPower(1);
        liftMotor2.setPower(-1);
        sleep(1000);


    }
}
