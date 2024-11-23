package org.firstinspires.ftc.teamcode.Robot.Subsystems;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.PIDFCoefficients;
import com.qualcomm.robotcore.hardware.TouchSensor;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.Robot.Constants;


public class ExtensionSubsystem{
    private DcMotorEx extensionMotor;
    private DcMotorEx liftMotorRight;
    private DcMotorEx liftMotorLeft;
    private TouchSensor touchSensor;


    public ExtensionSubsystem(HardwareMap hardwareMap, Telemetry telemetry) {

        extensionMotor = hardwareMap.get(DcMotorEx.class, "extension");
        liftMotorRight = hardwareMap.get(DcMotorEx.class, "liftRight");
        liftMotorLeft = hardwareMap.get(DcMotorEx.class, "liftLeft");
        touchSensor = hardwareMap.get(TouchSensor.class, "touchSensor");

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
        telemetry.addData("touch sensor", getTouchSensor());
    }
    public void encoderReset(){
        liftMotorRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        liftMotorLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        extensionMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
    }
    public void resetExtension(){
        extensionMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
    }

    public void liftZero(){
        liftMotorRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        liftMotorLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

    }
    public boolean getTouchSensor(){
        return touchSensor.isPressed();
    }
    public int getRightLift(){
        return liftMotorRight.getCurrentPosition();
    }
    public void moveLiftRight(double power){
//        liftMotorRight.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        liftMotorRight.setPower(power);
    }
    public int getLeftPosition(){
        return liftMotorLeft.getCurrentPosition();
    }
    public void resetRightEncoder(){
        liftMotorRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
    }

    public void moveExtension(int pos){
        extensionMotor.setTargetPosition(pos);
        extensionMotor.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        extensionMotor.setPower(0.8);
    }
    public void moveLift(int pos, double power){
        liftMotorRight.setTargetPosition(pos);
        liftMotorRight.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        liftMotorRight.setPower(power);
        liftMotorLeft.setTargetPosition(pos);
        liftMotorLeft.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        liftMotorLeft.setPower(power);
    }
    public void powerExtension(int power){
        liftMotorRight.setPower(power);
        liftMotorLeft.setPower(power);
    }
    public void extenderRetract(double speed) {
        liftMotorRight.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        liftMotorRight.setPower(speed);
        liftMotorLeft.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        liftMotorLeft.setPower(speed);
    }

    public void raiseLift(int pos){
        moveLift(pos, 1);
    }
    public void lowerLift(int pos){
        moveLift(pos, 0.8);
        //**must add checking system to make sure moveLiftOut > moveLiftIn**
    }
    public void zero(){
        if (!RobotContainer.extensionSubsystem.getTouchSensor()) {
            RobotContainer.extensionSubsystem.extenderRetract(-0.01);
        } else
            RobotContainer.extensionSubsystem.liftZero();
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
