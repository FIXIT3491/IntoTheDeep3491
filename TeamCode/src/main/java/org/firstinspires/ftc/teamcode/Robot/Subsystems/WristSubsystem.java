package org.firstinspires.ftc.teamcode.Robot.Subsystems;

import com.arcrobotics.ftclib.command.SubsystemBase;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.Telemetry;

public class WristSubsystem extends SubsystemBase {

    private Servo wristServoRight;
    private Servo wristServoLeft;


    public WristSubsystem(final HardwareMap hardwareMap, Telemetry telemetry) {
        wristServoRight = hardwareMap.get(Servo.class, "WSR");
        wristServoLeft = hardwareMap.get(Servo.class, "WSL");

        wristServoRight.setDirection(Servo.Direction.REVERSE);
    }

    public void wristMove(double distance){
        wristServoRight.setPosition(distance);
        wristServoLeft.setPosition(distance);
    }


}
