package org.firstinspires.ftc.teamcode.Commands;

import androidx.annotation.NonNull;

import com.acmerobotics.dashboard.telemetry.TelemetryPacket;
import com.acmerobotics.roadrunner.Action;
import com.acmerobotics.roadrunner.Pose2d;
import com.acmerobotics.roadrunner.TrajectoryActionBuilder;
import com.acmerobotics.roadrunner.Vector2d;
import com.qualcomm.robotcore.hardware.IMU;

import org.firstinspires.ftc.teamcode.Robot.Subsystems.SparkFunOTOSDrive;
import org.firstinspires.ftc.teamcode.Robot.Subsystems.LMECSubsystem;


public class Drive {
    SparkFunOTOSDrive drive;
    LMECSubsystem lock;
    IMU imu;


    public Drive(SparkFunOTOSDrive d, LMECSubsystem l){
        lock = l;
        drive = d;
    }

    Pose2d initialPose = new Pose2d(52, 52, 0);


    private class lock implements Action {
        @Override
        public boolean run(@NonNull TelemetryPacket packet) {
            lock.lockMechanum();
            return false;
        }
    }

    private class unlock implements Action {
        @Override
        public boolean run(@NonNull TelemetryPacket packet) {
            lock.unlockMechanum();
            return false;
        }
    }



    TrajectoryActionBuilder DriveToFirstSpikeMark = drive.actionBuilder(initialPose)
            .strafeToConstantHeading(new Vector2d(48, 12.5)); //drive to spike mark for second sample

    TrajectoryActionBuilder PickupFirstSpikeMark = drive.actionBuilder(new Pose2d(48, 12.5,0))
            .strafeToConstantHeading(new Vector2d(50, 12.5)); //drive to spike mark for second sample

    TrajectoryActionBuilder DriveToBucket2 = drive.actionBuilder(new Pose2d(50, 12.5,0))
//                .setTangent(1) // set tangent line for spline
            .strafeToLinearHeading(new Vector2d(75,35), 45); // drive to bucket for second sample

    TrajectoryActionBuilder DriveToSecondSpikeMark = drive.actionBuilder(new Pose2d(75, 36, 45))
            .strafeToLinearHeading(new Vector2d(54, 11.5), 0); // drive to spikemark for third sample

    TrajectoryActionBuilder PickupSecondSpikeMark = drive.actionBuilder(new Pose2d(52, 11.5, 0))
            .strafeToLinearHeading(new Vector2d(58, 11.5), 0); // drive to spikemark for third sample

    TrajectoryActionBuilder DriveToBucket3 = drive.actionBuilder(new Pose2d(58, 11.5,0))
//                .setTangent(1) // set tangent line for spline
            .strafeToLinearHeading(new Vector2d(75,35), 45); // drive to bucket for second sample

    TrajectoryActionBuilder DriveToThirdSpikeMark = drive.actionBuilder(new Pose2d(75, 36, 45))
            .strafeToLinearHeading(new Vector2d(64, 11.5), 0); // drive to spikemark for third sample

    TrajectoryActionBuilder PickupThirdSpikeMark = drive.actionBuilder(new Pose2d(63, 11.5, 0))
            .strafeToLinearHeading(new Vector2d(68, 11.5), 0); // drive to spikemark for third sample

    TrajectoryActionBuilder DriveToBucket4 = drive.actionBuilder(new Pose2d(63, 11.5,0))
//                .setTangent(1) // set tangent line for spline
            .strafeToLinearHeading(new Vector2d(75,35), 45); // drive to bucket for second sample
    TrajectoryActionBuilder DriveToZero = drive.actionBuilder(new Pose2d(75, 36,45))
//                .setTangent(1) // set tangent line for spline
            .strafeToLinearHeading(new Vector2d(72,32), -Math.PI/2 ); // drive to bucket for second sample


    public Action driveToSpikeMark = DriveToFirstSpikeMark.build();
    public Action pickupSpikeMark = PickupFirstSpikeMark.build();
    public Action driveToBucket2 = DriveToBucket2.build();
    public Action driveToSecondSpikeMark = DriveToSecondSpikeMark.build();
    public Action pickupSecondSpikeMark = PickupSecondSpikeMark.build();
    public Action driveToBucket3 = DriveToBucket3.build();
    public Action driveToThirdSpikeMark = DriveToThirdSpikeMark.build();
    public Action pickupThirdSpikeMark = PickupThirdSpikeMark.build();
    public Action driveToBucket4 = DriveToBucket4.build();
    public Action driveToZero = DriveToZero.build();
    public Action lockMec() {return new Drive.lock();}
    public Action unlockMec() {return new Drive.unlock();}
}
