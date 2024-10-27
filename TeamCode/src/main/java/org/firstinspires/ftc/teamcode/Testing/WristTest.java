package org.firstinspires.ftc.teamcode.Testing;
import android.text.method.Touch;

import com.qualcomm.hardware.rev.RevTouchSensor;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.TouchSensor;

import org.firstinspires.ftc.robotcontroller.external.samples.SensorDigitalTouch;
import org.firstinspires.ftc.robotcore.external.Telemetry;


@Autonomous(name="WristTest", group = "Autonomous")
public class WristTest extends LinearOpMode{
    private CRServo intakeMotor;
    private Servo wristServoOne;
    private Servo wristServoTwo;
    private TouchSensor touch;





    @Override
    public void runOpMode() throws InterruptedException {
        intakeMotor = hardwareMap.get(CRServo.class, "Spinnny");
        wristServoOne = hardwareMap.get(Servo.class, "WSR");
        wristServoTwo = hardwareMap.get(Servo.class, "WSL");
        touch = hardwareMap.get(TouchSensor.class, "touchSensor");


        wristServoTwo.setDirection(Servo.Direction.REVERSE);

        waitForStart();
        while(opModeIsActive()) {
            telemetry.addData("touch", touch.isPressed());
            telemetry.update();
        }
    }
}
