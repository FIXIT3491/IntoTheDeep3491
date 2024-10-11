package org.firstinspires.ftc.teamcode.Robot;

import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.ServoImplEx;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class LMECSubsystem {
    //Declarations
    public ServoImplEx  LMFRServo;
    public ServoImplEx  LMFLServo;
    public ServoImplEx  LMBRServo;
    public ServoImplEx  LMBLServo;

    public LMECSubsystem(HardwareMap hardwareMap, Telemetry telemetry) {
        //Hardware maps
        LMFRServo = hardwareMap.get(ServoImplEx.class, "LMFRS");
        LMFLServo = hardwareMap.get(ServoImplEx.class, "LMFLS");
        LMBRServo = hardwareMap.get(ServoImplEx.class, "LMBRS");
        LMBLServo = hardwareMap.get(ServoImplEx.class, "LMBLS");

        //Direction Servo
        LMFLServo.setDirection(Servo.Direction.REVERSE);
        LMBRServo.setDirection(Servo.Direction.REVERSE);

    }

    // Intake method
    public void LockMechanum() {
        LMFRServo.setPosition(0.3);
        LMFLServo.setPosition(0.3);
        LMBRServo.setPosition(0.3);
        LMBLServo.setPosition(0.4);

        LMFRServo.setPosition(0.19);
        LMFLServo.setPosition(0.19);
        LMBRServo.setPosition(0.19);
        LMBLServo.setPosition(0.25);
    }

    public void unlockMechanum() {
        LMFRServo.setPosition(0);
        LMFLServo.setPosition(0);
        LMBRServo.setPosition(0);
        LMBLServo.setPosition(0);
    }
}
