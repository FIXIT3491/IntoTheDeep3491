package org.firstinspires.ftc.teamcode.Testing;

import com.acmerobotics.roadrunner.Pose2d;
import com.acmerobotics.roadrunner.Trajectory;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.MecanumDrive;

@Autonomous
public class RoadRunnerAutoTest extends LinearOpMode {

    @Override
    public void runOpMode() {
         MecanumDrive drive = new MecanumDrive(hardwareMap, new Pose2d(0, 0 ,0));



    }
}
