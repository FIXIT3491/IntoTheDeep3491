package org.firstinspires.ftc.teamcode.Testing;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.hardware.TouchSensor;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.Commands.CommandBase;
import org.firstinspires.ftc.teamcode.Commands.Pickup;
import org.firstinspires.ftc.teamcode.Robot.Subsystems.RobotContainer;


@Autonomous(name= "ServoTesting", group = "Autonomous")
public class ServoTesting extends LinearOpMode {

   // private CRServo intakeMotor;
    private Servo wristServoOne;
    private Servo wristServoTwo;
   // private TouchSensor touch;
    private CRServo axon;

    @Override
    public void runOpMode() {
      //  CommandBase.initialize(hardwareMap, telemetry, this);
        axon = hardwareMap.get(CRServo.class, "Axon");
        wristServoOne = hardwareMap.get(Servo.class, "WSR");
        wristServoTwo = hardwareMap.get(Servo.class, "WSL");
      //  touch = hardwareMap.get(TouchSensor.class, "touchSensor");

        wristServoTwo.setDirection(Servo.Direction.REVERSE);

//        RobotContainer.intakeSubsystem.wristDown();
        waitForStart();

        while (opModeIsActive()) {

            wristServoOne.setPosition(0.5);
            wristServoTwo.setPosition(0.5);
            sleep(2000);
            wristServoOne.setPosition(0);
            wristServoTwo.setPosition(0);
            sleep(2000);
            axon.setPower(1);
            sleep(5000);
            axon.setPower(0);
        }

    }
}
