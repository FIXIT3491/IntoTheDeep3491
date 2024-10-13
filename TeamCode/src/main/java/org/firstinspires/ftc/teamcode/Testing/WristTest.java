package org.firstinspires.ftc.teamcode.Testing;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.Telemetry;

@Autonomous(name="WristTest", group = "Autonomous")
public class WristTest extends LinearOpMode{
    private CRServo intakeMotor;
    private Servo wristServoOne;
    private Servo wristServoTwo;


    @Override
    public void runOpMode() throws InterruptedException {
        intakeMotor = hardwareMap.get(CRServo.class, "Spinnny");
        wristServoOne = hardwareMap.get(Servo.class, "WSO");
        wristServoTwo = hardwareMap.get(Servo.class, "WST");

        wristServoTwo.setDirection(Servo.Direction.REVERSE);

        waitForStart();
        wristServoTwo.setPosition(0);
        wristServoOne.setPosition(0);
    }
}
