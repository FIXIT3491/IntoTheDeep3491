package org.firstinspires.ftc.teamcode.Robot;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;


public class ExtensionSubsystem{
    private DcMotorEx extensionMotor;
    private DcMotorEx liftMotor1;
    private DcMotorEx liftMotor2;


    public ExtensionSubsystem(HardwareMap hardwareMap, Telemetry telemetry) {

        extensionMotor = hardwareMap.get(DcMotorEx.class, "extension");
        liftMotor1 = hardwareMap.get(DcMotorEx.class, "Lift1");
        liftMotor2 = hardwareMap.get(DcMotorEx.class, "Lift2");

        liftMotor1.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        liftMotor2.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        liftMotor2.setDirection(DcMotor.Direction.REVERSE);

    }

    public void moveExtension(int pos){
        extensionMotor.setTargetPosition(1);
        extensionMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        extensionMotor.setPower(0.4);
    }
    public void moveLift(int pos){
        liftMotor1.setTargetPosition(pos);
        liftMotor1.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        liftMotor1.setPower(0.4);
        liftMotor2.setTargetPosition(pos);
        liftMotor2.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        liftMotor2.setPower(0.4);
    }

    public void chamberLow() {
        moveLift(1000);
    }
    public void chamberHigh() {
        moveLift(2000);

    }
    public void bucketLow() {
        moveLift(1250);

    }
    public void bucketHigh() {
        moveLift(2500);
    }
}
