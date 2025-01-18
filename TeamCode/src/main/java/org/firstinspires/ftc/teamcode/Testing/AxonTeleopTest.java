package org.firstinspires.ftc.teamcode.Testing;

import com.acmerobotics.roadrunner.Pose2d;
import com.acmerobotics.roadrunner.Vector2d;
import com.acmerobotics.roadrunner.ftc.Actions;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.AnalogInput;

import org.firstinspires.ftc.teamcode.Commands.Drive;
import org.firstinspires.ftc.teamcode.Robot.Subsystems.SparkFunOTOSDrive;
import org.firstinspires.ftc.teamcode.Robot.Subsystems.LMECSubsystem;

@TeleOp(name="axon teleop test", group="LeoGoodCode")

public class AxonTeleopTest extends LinearOpMode {

    AnalogInput analogInput;

    Drive drive = new Drive(new SparkFunOTOSDrive(hardwareMap, new Pose2d(new Vector2d(3, 3),3)), new LMECSubsystem(hardwareMap));

    @Override
    public void runOpMode() {

        waitForStart();


        while (opModeIsActive()) {

            if (gamepad1.b) {
                Actions.runBlocking(
                        drive.unlockMec()
                );
            }

            if (gamepad1.a) {
                Actions.runBlocking(
                        drive.lockMec()
                );
            }
        }
    }
}
