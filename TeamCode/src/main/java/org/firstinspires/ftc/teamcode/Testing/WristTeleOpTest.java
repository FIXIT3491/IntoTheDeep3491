package org.firstinspires.ftc.teamcode.Testing;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp
public class WristTeleOpTest extends LinearOpMode{

    private Servo wristServoLeft;
    private Servo wristServoRight;
    @Override
    public void runOpMode() {
        wristServoLeft = hardwareMap.get(Servo.class, "WSL");
        wristServoRight = hardwareMap.get(Servo.class, "WSR");

        wristServoRight.setDirection(Servo.Direction.REVERSE);

        wristServoLeft.setPosition(0);
        wristServoRight.setPosition(0);

        waitForStart();

        // drop wrist
        while (opModeIsActive()) {
            if (gamepad1.a) {
                wristServoLeft.setPosition(0);
                wristServoRight.setPosition(0);
            }

            // retract wrist
            if (gamepad1.b) {
                wristServoLeft.setPosition(0.2);
                wristServoRight.setPosition(0.2);
            }
            if (gamepad1.x) {
                wristServoLeft.setPosition(0.4);
                wristServoRight.setPosition(0.4);
            }
            if (gamepad1.y) {
                wristServoLeft.setPosition(0.5);
                wristServoRight.setPosition(0.5);
            }


        }
    }
}
