package org.firstinspires.ftc.teamcode.Subsystems;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.qualcomm.robotcore.hardware.AnalogInput;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.ServoImplEx;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class LMECSubsystem extends SubsystemBase {
    //Declarations
    private final ServoImplEx  servoFront;
    private final ServoImplEx  servoBack;
    private final AnalogInput axonDataFront;


    public LMECSubsystem(final HardwareMap hardwareMap ) {
        //Hardware maps
        servoFront = hardwareMap.get(ServoImplEx.class, "LMECFront");
        servoBack = hardwareMap.get(ServoImplEx.class, "LMECBack");
        axonDataFront = hardwareMap.get(AnalogInput.class, "axonDataFront");

//        servoFront.setDirection(Servo.Direction.REVERSE);
    }

    // Intake method
    public void lockMechanum() {
        servoFront.setPosition(0.7);
        servoBack.setPosition(0.5);

    }

    public void unlockMechanum() {
        servoFront.setPosition(0);
        servoBack.setPosition(0);

    }
    public double getPosFront(){
        return axonDataFront.getVoltage();
    }
}
