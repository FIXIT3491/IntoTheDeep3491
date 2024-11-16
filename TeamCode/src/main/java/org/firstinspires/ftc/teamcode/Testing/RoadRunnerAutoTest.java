package org.firstinspires.ftc.teamcode.Testing;

import com.acmerobotics.dashboard.FtcDashboard;
import com.acmerobotics.roadrunner.Pose2d;
import com.acmerobotics.roadrunner.TrajectoryActionBuilder;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.RoadRunnerStuff.MecanumDrive;

@Autonomous
public class RoadRunnerAutoTest extends LinearOpMode {
    public static int a;
    public static int b;
    public static int c;
    public static int d;
    public static int e;
    public static int f;
    FtcDashboard dash;

    @Override
    public void runOpMode() {
        Pose2d initialPose = new Pose2d(-10, -60, Math.toRadians(180));
         MecanumDrive drive = new MecanumDrive(hardwareMap, new Pose2d(0, 0 ,0));
         dash = FtcDashboard.getInstance();




        TrajectoryActionBuilder toBucket = drive.actionBuilder(initialPose)
                .splineToSplineHeading(new Pose2d(-54,-51, Math.toRadians(220)),Math.toRadians(0) );
        TrajectoryActionBuilder toSpikeMark = drive.actionBuilder(new Pose2d(-54,-51,Math.toRadians(220)))
                .splineToSplineHeading(new Pose2d(-54,-51, Math.toRadians(220)),Math.toRadians(0) );
    }
}
