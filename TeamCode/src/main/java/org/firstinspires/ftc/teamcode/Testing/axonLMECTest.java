package org.firstinspires.ftc.teamcode.Testing;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.AnalogInput;
import com.qualcomm.robotcore.hardware.Servo;
@Autonomous(name="axon test", group="KaiGoodCode")
public class axonLMECTest extends LinearOpMode {
    Servo servo;

    AnalogInput analogInput;



    @Override
    public void runOpMode() {


    servo = hardwareMap.get(Servo.class, "axon");
    analogInput = hardwareMap.get(AnalogInput.class, "axonDataFront");

        waitForStart();
        while (opModeIsActive()) {
            double position = analogInput.getVoltage() / 3.3 * 360;

            if (gamepad1.a)
                servo.setPosition(0.5);

            if (gamepad1.b)
                servo.setPosition(0);

            telemetry.addData("axon", position);
            telemetry.update();
        }

    }
}
