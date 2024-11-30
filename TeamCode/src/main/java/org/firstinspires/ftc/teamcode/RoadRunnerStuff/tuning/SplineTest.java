package org.firstinspires.ftc.teamcode.RoadRunnerStuff.tuning;

import com.acmerobotics.roadrunner.Pose2d;
import com.acmerobotics.roadrunner.Vector2d;
import com.acmerobotics.roadrunner.ftc.Actions;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.RoadRunnerStuff.MecanumDrive;
import org.firstinspires.ftc.teamcode.RoadRunnerStuff.SparkFunOTOSDrive;

public final class SplineTest extends LinearOpMode {
    @Override
    public void runOpMode(){
        Pose2d beginPose = new Pose2d(48, 48, 0);
//        if (TuningOpModes.DRIVE_CLASS.equals(MecanumDrive.class)) {
            SparkFunOTOSDrive drive = new SparkFunOTOSDrive(hardwareMap, beginPose);

            waitForStart();

            Actions.runBlocking(
                drive.actionBuilder(beginPose)
                        .strafeToLinearHeading(new Vector2d(48, -40), 0)
                        .waitSeconds(0.1)
                        .strafeToLinearHeading(new Vector2d(-40, -40), Math.PI /2)
                        .waitSeconds(0.1)
                        .strafeToLinearHeading(new Vector2d(-40, 48), 0)
                        .waitSeconds(0.1)
                        .strafeToLinearHeading(new Vector2d(48, 48), 0 )

//                        .splineTo(new Vector2d(0, 60), Math.PI)
                        .build());
//        }


        sleep(2000);

//        else if (TuningOpModes.DRIVE_CLASS.equals(TankDrive.class)) {
//            TankDrive drive = new TankDrive(hardwareMap, beginPose);
//
//            waitForStart();
//
//            Actions.runBlocking(
//                    drive.actionBuilder(beginPose)
//                            .splineTo(new Vector2d(30, 30), Math.PI / 2)
//                            .splineTo(new Vector2d(0, 60), Math.PI)
//                            .build());
//        } else {
//            throw new RuntimeException();
//        }
    }
}
