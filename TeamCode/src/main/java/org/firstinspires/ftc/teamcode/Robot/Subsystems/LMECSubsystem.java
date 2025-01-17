package org.firstinspires.ftc.teamcode.Robot.Subsystems;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.ServoImplEx;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class LMECSubsystem{
    //Declarations
    public ServoImplEx  servoFront;
    public ServoImplEx  servoBack;


    public LMECSubsystem(HardwareMap hardwareMap, Telemetry telemetry) {
        //Hardware maps
//        LMFRServo = hardwareMap.get(ServoImplEx.class, "LMFRS");
//        LMFLServo = hardwareMap.get(ServoImplEx.class, "LMFLS");
//        LMBRServo = hardwareMap.get(ServoImplEx.class, "LMBRS");
//        LMBLServo = hardwareMap.get(ServoImplEx.class, "LMBLS");

        //Direction Servo
//        LMFLServo.setDirection(Servo.Direction.REVERSE);
//        LMBRServo.setDirection(Servo.Direction.REVERSE);

    }

    // Intake method
    public void lockMechanum() {
        servoFront.setPosition(0.5);
        servoBack.setPosition(0.5);

    }


    public void unlockMechanum() {
        servoFront.setPosition(0);
        servoBack.setPosition(0);

    }
}
