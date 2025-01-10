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
import org.firstinspires.ftc.teamcode.Robot.Subsystems.IntakeSubsystem;
import org.firstinspires.ftc.teamcode.Robot.Subsystems.RobotContainer;

@Autonomous(name="WristTest", group = "Autonomous")
    public class WristTest extends LinearOpMode{


        RobotContainer robot = new RobotContainer(hardwareMap);
        IntakeSubsystem intakeSubsystem;

        @Override
        public void runOpMode() throws InterruptedException {

            Intake intake = new Intake(hardwareMap, intakeSubsystem);



            waitForStart();

            Actions.runBlocking(
                    intake.wristBasket()
            );

            sleep(1000);
        }

}
