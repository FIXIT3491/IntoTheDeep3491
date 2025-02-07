package org.firstinspires.ftc.teamcode.Robot.Subsystems;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.TouchSensor;

import org.firstinspires.ftc.robotcore.external.Telemetry;


public class SlideSubsystem extends SubsystemBase {
    private DcMotorEx extensionMotor;
    private DcMotorEx liftMotorRight;
    private DcMotorEx liftMotorLeft;
    private TouchSensor touchSensor;


    public SlideSubsystem(final HardwareMap hardwareMap, Telemetry telemetry) {

        extensionMotor = hardwareMap.get(DcMotorEx.class, "extension");
        liftMotorRight = hardwareMap.get(DcMotorEx.class, "liftRight");
        liftMotorLeft = hardwareMap.get(DcMotorEx.class, "liftLeft");
        touchSensor = hardwareMap.get(TouchSensor.class, "touchSensor");

        liftMotorRight.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        liftMotorLeft.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        liftMotorLeft.setDirection(DcMotor.Direction.REVERSE);
        extensionMotor.setDirection(DcMotor.Direction.REVERSE);

        extensionMotor.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        liftMotorRight.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        liftMotorLeft.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
    }
    public void encoderReset(){
        liftMotorRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        liftMotorLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        extensionMotor.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
    }
    public void liftEncoderReset(){
        liftMotorRight.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        liftMotorLeft.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
    }

    public boolean getTouchSensor(){
        return touchSensor.isPressed();
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

    public void liftRetract(double speed) {
        liftMotorRight.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        liftMotorRight.setPower(speed);
        liftMotorLeft.setMode(DcMotor.RunMode.RUN_WITHOUT_ENCODER);
        liftMotorLeft.setPower(speed);
    }

    public void raiseLift(int pos){
        moveLift(pos, 1);
    }
}
