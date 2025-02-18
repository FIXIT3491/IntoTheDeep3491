package org.firstinspires.ftc.teamcode.Commands.Custom;

import com.acmerobotics.roadrunner.Action;
import com.acmerobotics.roadrunner.Pose2d;
import com.acmerobotics.roadrunner.TrajectoryActionBuilder;
import com.acmerobotics.roadrunner.Vector2d;
import com.acmerobotics.roadrunner.ftc.Actions;
import com.arcrobotics.ftclib.command.InstantCommand;

import org.firstinspires.ftc.teamcode.Subsystems.SparkFunOTOSSubSystem;

public class StrafeToPointCommand extends InstantCommand {

    SparkFunOTOSSubSystem sparkFunOTOSSubSystem;
    Pose2d startingPose;
    Vector2d endingPose;
    double endingHeading;
    boolean Linear;



    //strafeToConstantHeading
//    public StrafeToPointCommand(SparkFunOTOSSubSystem sparkFunOTOSSubSystem, Pose2d startingPose, Vector2d endingPose){
//        this.sparkFunOTOSSubSystem = sparkFunOTOSSubSystem;
//        //TODO make sure this returns the current value and not how much it has move or something
//        this.startingPose = startingPose;
//        this.endingPose = endingPose;
//        Linear = false;
//
//    }
    //StrafeToLinearHeading
    public StrafeToPointCommand(SparkFunOTOSSubSystem sparkFunOTOSSubSystem, Pose2d startingPose, Vector2d endingPose, double endingHeading){
        this.sparkFunOTOSSubSystem = sparkFunOTOSSubSystem;
        //TODO PLZ CHECK THIS ASWELL LEO IM TALKING TO YOU PROBABLLY
        this.startingPose = startingPose;
        this.endingPose = endingPose;
        this.endingHeading = endingHeading;
        Linear = true;
    }



    @Override
    public void initialize() {
        Action driveToSpikeMark;
        TrajectoryActionBuilder DriveToFirstSpikeMark;//drive to spike mark for second sample

//        if (Linear) {
            DriveToFirstSpikeMark = sparkFunOTOSSubSystem.actionBuilder(startingPose)
                    .strafeToLinearHeading(endingPose, endingHeading);
//        } else {
//            DriveToFirstSpikeMark = sparkFunOTOSSubSystem.actionBuilder(startingPose)
//                    .strafeToConstantHeading(endingPose);
//        }
        driveToSpikeMark = DriveToFirstSpikeMark.build();


        // @TODO i dont think this will work plz check
        Actions.runBlocking(
                driveToSpikeMark
        );

    }

}
