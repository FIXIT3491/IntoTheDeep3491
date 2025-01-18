package org.firstinspires.ftc.teamcode.Robot.Subsystems;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.ServoImplEx;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class LMECSubsystem{
    //Declarations
    public ServoImplEx  servoFront;
    public ServoImplEx  servoBack;


    public LMECSubsystem(HardwareMap hardwareMap ) {
        //Hardware maps
        servoFront = hardwareMap.get(ServoImplEx.class, "LMECFront");
        servoBack = hardwareMap.get(ServoImplEx.class, "LMECBack");
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
