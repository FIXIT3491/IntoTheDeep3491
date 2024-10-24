package org.firstinspires.ftc.teamcode.Robot.Subsystems;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.Robot.Constants;


public class ExtensionSubsystem{
    private DcMotorEx extensionMotor;
    private DcMotorEx liftMotorRight;
    private DcMotorEx liftMotorLeft;


    public ExtensionSubsystem(HardwareMap hardwareMap, Telemetry telemetry) {

        extensionMotor = hardwareMap.get(DcMotorEx.class, "extension");
        liftMotorRight = hardwareMap.get(DcMotorEx.class, "liftRight");
        liftMotorLeft = hardwareMap.get(DcMotorEx.class, "liftLeft");

        liftMotorRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        liftMotorLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        liftMotorLeft.setDirection(DcMotor.Direction.REVERSE);
//        liftMotor1.setDirection(DcMotorSimple.Direction.REVERSE);
        extensionMotor.setDirection(DcMotor.Direction.REVERSE);
        extensionMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        liftMotorRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        liftMotorLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    }
    public void getTelemetry(Telemetry telemetry){
        telemetry.addData("lift motor left", liftMotorLeft.getCurrentPosition());
        telemetry.addData("lift motor right", liftMotorRight.getCurrentPosition());
        telemetry.addData("extension", extensionMotor.getCurrentPosition());
    }
    public void encoderReset(){
        liftMotorRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        liftMotorLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        extensionMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
    }

    public void moveExtension(int pos){
        extensionMotor.setTargetPosition(pos);
        extensionMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        extensionMotor.setPower(0.4);
    }
    public void moveLift(int pos, double power){
        liftMotorRight.setTargetPosition(pos);
        liftMotorRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        liftMotorRight.setPower(power);
        liftMotorLeft.setTargetPosition(pos);
        liftMotorLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        liftMotorLeft.setPower(power);
    }
    public void raiseLift(int pos){
        moveLift(pos, 1);
    }
    public void lowerLift(int pos){
        moveLift(pos, 0.5 );
        //**must add checking system to make sure moveLiftOut > moveLiftIn**
    }
    public void zero(){
        lowerLift(0);
    }
    public void chamberLow() {
        raiseLift(1000);
    }
    public void chamberHigh() {
        raiseLift(2000);
    }
    public void bucketLow() {
        raiseLift(Constants.LIFT_BUCKET_1);
    }
    public void bucketHigh() {
        raiseLift(Constants.LIFT_BUCKET_2);
    }
}
