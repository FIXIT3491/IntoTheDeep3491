package org.firstinspires.ftc.teamcode.Testing;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.AnalogInput;
import com.qualcomm.robotcore.hardware.Servo;
@Autonomous(name="axon test", group="KaiGoodCode")
public class axonLMECTest extends LinearOpMode {
    Servo servoFront;
    Servo servoBack;

    AnalogInput analogInput;



    @Override
    public void runOpMode() {


    servoFront = hardwareMap.get(Servo.class, "LMECFront");
    servoBack = hardwareMap.get(Servo.class, "LMECBack");

        analogInput = hardwareMap.get(AnalogInput.class, "axonDataFront");

        waitForStart();
        while (opModeIsActive()) {
            double position = analogInput.getVoltage() / 3.3 * 360;

            if (gamepad1.a)
                servoFront.setPosition(0.5);
            if (gamepad1.b)
                servoFront.setPosition(0);
            if (gamepad1.x)
                servoBack.setPosition(0.5);
            if (gamepad1.y)
                servoBack.setPosition(0);



            telemetry.addData("Gamepad a ", "lock");
            telemetry.addData("Gamepad b", "unlock");
            telemetry.addData("Gamepad x", "lock");
            telemetry.addData("Gamepad y", "unlock");
            telemetry.addData("axon", position);

            telemetry.update();
        }

    }
}