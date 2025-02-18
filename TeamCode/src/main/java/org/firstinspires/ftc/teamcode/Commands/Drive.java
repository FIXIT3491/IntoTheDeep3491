package org.firstinspires.ftc.teamcode.Commands;

import androidx.annotation.NonNull;

import com.acmerobotics.dashboard.telemetry.TelemetryPacket;
import com.acmerobotics.roadrunner.Action;
import com.acmerobotics.roadrunner.Pose2d;
import com.acmerobotics.roadrunner.SequentialAction;
import com.acmerobotics.roadrunner.SleepAction;
import com.acmerobotics.roadrunner.TrajectoryActionBuilder;
import com.acmerobotics.roadrunner.Vector2d;
import com.acmerobotics.roadrunner.ftc.Actions;
import com.arcrobotics.ftclib.command.WaitCommand;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.IMU;

import org.firstinspires.ftc.teamcode.Subsystems.Robot;
import org.firstinspires.ftc.teamcode.Subsystems.SparkFunOTOSSubSystem;
import org.firstinspires.ftc.teamcode.Subsystems.LMECSubsystem;

@Autonomous(name="OnlyDriveTest", group="01")
public class Drive extends Robot {


    //    LMECSubsystem lock;
//    IMU imu;
    Pose2d startPose = new Pose2d(36,61,0);

    TrajectoryActionBuilder DriveToFirstSpikeMark = drive.actionBuilder(startPose)
            .strafeToLinearHeading(new Vector2d(54, 46), 45); //drive to spike mark for second sample

    TrajectoryActionBuilder PickupFirstSpikeMark = drive.actionBuilder(new Pose2d(54, 46,45))
            .strafeToLinearHeading(new Vector2d(51, 43), -90); //drive to spike mark for second sample

    TrajectoryActionBuilder DriveToBucket2 = drive.actionBuilder(new Pose2d(51, 43,-90))
//                .setTangent(1) // set tangent line for spline
            .strafeToLinearHeading(new Vector2d(54,46), 45); // drive to bucket for second sample



    public Action driveToSpikeMark = DriveToFirstSpikeMark.build();
    public Action pickupSpikeMark = PickupFirstSpikeMark.build();
    public Action driveToBucket2 = DriveToBucket2.build();

    @Override
    public void runOpMode() throws InterruptedException {
        initialize(startPose);

        Actions.runBlocking(
                new SequentialAction(
                        driveToSpikeMark,
                        new SleepAction(1),
                        pickupSpikeMark,
                        new SleepAction(1),
                        driveToBucket2
                )
        );
    }
}
