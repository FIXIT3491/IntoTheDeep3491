package org.firstinspires.ftc.teamcode.Testing;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.Servo;

@Autonomous

public class LockingMechanumTest extends LinearOpMode {

    //Servo Declarations
    public Servo LMFRServo;
    public Servo LMFLServo;
    public Servo LMBRServo;
    public Servo LMBLServo;

    @Override
    public void runOpMode() {

        //Hardware Maps
        LMFRServo = hardwareMap.get(Servo.class, "LMFRS");
        LMFLServo = hardwareMap.get(Servo.class, "LMFLS");
        LMBRServo = hardwareMap.get(Servo.class, "LMBRS");
        LMBLServo = hardwareMap.get(Servo.class, "LMBLS");

        LMFLServo.setDirection(Servo.Direction.REVERSE);
        LMBRServo.setDirection(Servo.Direction.REVERSE);

        LMFRServo.setPosition(0);
        LMFLServo.setPosition(0);
        LMBRServo.setPosition(0);
        LMBLServo.setPosition(0);

        waitForStart();

        LMFRServo.setPosition(0.28);
        LMFLServo.setPosition(0.28);
        LMBRServo.setPosition(0.28);
        LMBLServo.setPosition(0.28);


        sleep(4000);

    }
}
