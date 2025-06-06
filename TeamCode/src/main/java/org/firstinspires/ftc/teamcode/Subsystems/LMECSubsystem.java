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

        servoFront.setDirection(Servo.Direction.REVERSE);
    }


    public void lockMechanum() {
        servoFront.setPosition(0);
        servoBack.setPosition(0);

    }

    public void unlockMechanum() {
        servoFront.setPosition(0.45);
        servoBack.setPosition(0.6);

    }
    public double getPosFront(){
        return axonDataFront.getVoltage();
    }
}
