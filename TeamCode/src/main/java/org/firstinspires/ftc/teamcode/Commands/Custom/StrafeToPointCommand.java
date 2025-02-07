package org.firstinspires.ftc.teamcode.Commands.Custom;

import com.acmerobotics.roadrunner.Action;
import com.acmerobotics.roadrunner.Pose2d;
import com.acmerobotics.roadrunner.TrajectoryActionBuilder;
import com.acmerobotics.roadrunner.Vector2d;
import com.acmerobotics.roadrunner.ftc.Actions;
import com.arcrobotics.ftclib.command.InstantCommand;

import org.firstinspires.ftc.teamcode.Robot.Subsystems.SparkFunOTOSDrive;

public class StrafeToPointCommand extends InstantCommand {

    SparkFunOTOSDrive sparkFunOTOSDrive;
    Pose2d startingPose;
    Vector2d endingPose;
    double endingHeading;
    boolean Linear;



    //strafeToConstantHeading
    public StrafeToPointCommand(SparkFunOTOSDrive sparkFunOTOSDrive, Pose2d startingPose, Vector2d endingPose){
        this.sparkFunOTOSDrive = sparkFunOTOSDrive;
        this.startingPose = startingPose;
        this.endingPose = endingPose;
        Linear = false;

    }
    //StrafeToLinearHeading
    public StrafeToPointCommand(SparkFunOTOSDrive sparkFunOTOSDrive, Pose2d startingPose, Vector2d endingPose, double endingHeading){
        this.sparkFunOTOSDrive = sparkFunOTOSDrive;
        this.startingPose = startingPose;
        this.endingPose = endingPose;
        this.endingHeading = endingHeading;
        Linear = true;
    }



    @Override
    public void initialize() {
        Action driveToSpikeMark;
        TrajectoryActionBuilder DriveToFirstSpikeMark;//drive to spike mark for second sample

        if (Linear) {
            DriveToFirstSpikeMark = sparkFunOTOSDrive.actionBuilder(startingPose)
                    .strafeToLinearHeading(endingPose, endingHeading);
        } else {
            DriveToFirstSpikeMark = sparkFunOTOSDrive.actionBuilder(startingPose)
                    .strafeToConstantHeading(endingPose);
        }
        driveToSpikeMark = DriveToFirstSpikeMark.build();


        // @TODO i dont think this will work plz check
        Actions.runBlocking(
                driveToSpikeMark
        );

    }

}
