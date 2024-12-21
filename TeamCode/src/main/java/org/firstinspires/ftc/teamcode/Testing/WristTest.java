package org.firstinspires.ftc.teamcode.Testing;
import android.text.method.Touch;

import com.acmerobotics.roadrunner.ftc.Actions;
import com.qualcomm.hardware.rev.RevTouchSensor;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.TouchSensor;

import org.firstinspires.ftc.robotcontroller.external.samples.SensorDigitalTouch;
import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.Commands.Intake;

@Autonomous(name="WristTest", group = "Autonomous")
    public class WristTest extends LinearOpMode{
        Intake intake = new Intake(hardwareMap);




        @Override
        public void runOpMode() throws InterruptedException {

            Actions.runBlocking(intake.wristBasket());


        }

}
