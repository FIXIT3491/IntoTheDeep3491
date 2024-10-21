package org.firstinspires.ftc.teamcode.Robot.Subsystems;

import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.CRServoImpl;
import com.qualcomm.robotcore.hardware.CRServoImplEx;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class IntakeSubsystem{
    private CRServo intakeMotor;
    private Servo wristServoOne;
    private Servo wristServoTwo;

    public IntakeSubsystem(HardwareMap hardwareMap, Telemetry telemetry) {
        intakeMotor = hardwareMap.get(CRServo.class, "Spinnny");
        wristServoOne = hardwareMap.get(Servo.class, "WSR");
        wristServoTwo = hardwareMap.get(Servo.class, "WSL");

//        wristServoTwo.setDirection(Servo.Direction.REVERSE);
        wristServoOne.setDirection(Servo.Direction.REVERSE);
    }

    // Intake method
    public void spinIntake (double power) {
        intakeMotor.setPower(power);
    }

    public void stopIntake() {
        intakeMotor.setPower(0);
    }

    public void wristUp(){
        wristServoOne.setPosition(0.6);
        wristServoTwo.setPosition(0.6);
    }

    public void wristDown(){
        wristServoOne.setPosition(0.33);
        wristServoTwo.setPosition(0.33);
    }
    public void wristMove(double distance){
        wristServoOne.setPosition(distance);
        wristServoTwo.setPosition(distance);
    }

}

