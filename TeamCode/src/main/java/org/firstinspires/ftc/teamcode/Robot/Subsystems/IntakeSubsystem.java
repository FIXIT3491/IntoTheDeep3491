package org.firstinspires.ftc.teamcode.Robot.Subsystems;

import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.Robot.Constants;

public class IntakeSubsystem{
    private CRServo intakeMotor;
    private Servo wristServoRight;
    private Servo wristServoLeft;

    public IntakeSubsystem(HardwareMap hardwareMap, Telemetry telemetry) {
        intakeMotor = hardwareMap.get(CRServo.class, "Spinnny");
        wristServoRight = hardwareMap.get(Servo.class, "WSR");
        wristServoLeft = hardwareMap.get(Servo.class, "WSL");

//        wristServoTwo.setDirection(Servo.Direction.REVERSE);
        wristServoRight.setDirection(Servo.Direction.REVERSE);
    }

    // Intake method
    public void spinIntake(double power) {
        intakeMotor.setPower(power);
    }

    public void stopIntake() {
        intakeMotor.setPower(0);
    }
    public void wristBucket(){
        wristMove(0.25);
    }

    public void wristUp(){
        wristMove(Constants.WRIST_UP);
    }
    public void wristChamber(){
        wristMove(0.2);
    }

    public void wristDown(){
        wristMove(0.01);
    }
    public void getTelemetry(Telemetry telemetry){
        telemetry.addData("WristServoRight", wristServoRight.getPosition());
        telemetry.addData("WristServoLeft", wristServoLeft.getPosition());
        telemetry.addData("Intake motor", intakeMotor.getPower());
    }
    public void wristOut(){
        wristMove(Constants.WRIST_OUT);
    }
    public void wristMove(double distance){
        wristServoRight.setPosition(distance);
        wristServoLeft.setPosition(distance);
    }

}

