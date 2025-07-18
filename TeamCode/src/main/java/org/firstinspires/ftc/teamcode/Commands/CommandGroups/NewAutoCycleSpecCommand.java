package org.firstinspires.ftc.teamcode.Commands.CommandGroups;

import com.acmerobotics.roadrunner.Pose2d;
import com.acmerobotics.roadrunner.Vector2d;
import com.arcrobotics.ftclib.command.ParallelCommandGroup;
import com.arcrobotics.ftclib.command.SequentialCommandGroup;
import com.arcrobotics.ftclib.command.WaitCommand;

import org.firstinspires.ftc.teamcode.Commands.Custom.LowerLiftCommand;
import org.firstinspires.ftc.teamcode.Commands.Custom.MoveExtensionCommand;
import org.firstinspires.ftc.teamcode.Commands.Custom.MoveWristCommand;
import org.firstinspires.ftc.teamcode.Commands.Custom.RaiseLiftCommand;
import org.firstinspires.ftc.teamcode.Commands.Custom.StrafeToPointCommand;
import org.firstinspires.ftc.teamcode.Lib.Constants;
import org.firstinspires.ftc.teamcode.Subsystems.IntakeSubsystem;
import org.firstinspires.ftc.teamcode.Subsystems.SlideSubsystem;
import org.firstinspires.ftc.teamcode.Subsystems.SparkFunOTOSSubSystem;
import org.firstinspires.ftc.teamcode.Subsystems.WristSubsystem;

public class NewAutoCycleSpecCommand extends SequentialCommandGroup {

    Vector2d pos;
    double heading;
    double pickupHeading;
    long delay;

    public NewAutoCycleSpecCommand(IntakeSubsystem intake, WristSubsystem wrist, SparkFunOTOSSubSystem drive, SlideSubsystem slides){

        addCommands(
                // pick up
                new PickupSpecimenCommand(slides, wrist),
                new StrafeToPointCommand(drive, new Pose2d (-26, 50, Math.toRadians(-205)),new Vector2d( -35,46) , Math.toRadians(90)),
                new StrafeToPointCommand(drive, new Pose2d (-35, 46, Math.toRadians(90)),new Vector2d( -35,56) , Math.toRadians(90)),

                // score
                new RaiseLiftCommand(slides, (Constants.LIFT_CHAMBER_2 - 17)),
                new MoveWristCommand(wrist, Constants.WRIST_SCORE_CHAMBER),
                new StrafeToPointCommand(drive, new Pose2d (-34, 56, Math.toRadians(90)),new Vector2d( -5,29) , Math.toRadians(-90)),
                new MoveExtensionCommand(slides, Constants.EXTENSION_SCORE_SPECIMEN),
                new WaitCommand(200),
                new RaiseLiftCommand(slides, 550),
                new MoveExtensionCommand(slides, 550),

                // pick up
                new StrafeToPointCommand(drive, new Pose2d (-5, 29, Math.toRadians(-90)),new Vector2d( -35,42) , Math.toRadians(90)),
                new PickupSpecimenCommand(slides, wrist),
                new WaitCommand(100),
                new StrafeToPointCommand(drive, new Pose2d (-35, 42, Math.toRadians(90)),new Vector2d( -35,56) , Math.toRadians(90)),

                // score
                new RaiseLiftCommand(slides, (Constants.LIFT_CHAMBER_2 - 17)),
                new MoveWristCommand(wrist, Constants.WRIST_SCORE_CHAMBER),
                new StrafeToPointCommand(drive, new Pose2d (-35, 56, Math.toRadians(90)),new Vector2d( -3,29) , Math.toRadians(-90)),
                new MoveExtensionCommand(slides, Constants.EXTENSION_SCORE_SPECIMEN),
                new WaitCommand(230),
                new RaiseLiftCommand(slides, 550),
                new MoveExtensionCommand(slides, 550),

                // pick up
                new StrafeToPointCommand(drive, new Pose2d (-3, 29, Math.toRadians(-90)),new Vector2d( -35,42) , Math.toRadians(90)),
                new PickupSpecimenCommand(slides, wrist),
                new WaitCommand(100),
                new StrafeToPointCommand(drive, new Pose2d (-35, 42, Math.toRadians(90)),new Vector2d( -35,56) , Math.toRadians(90)),

                // score
                new RaiseLiftCommand(slides, (Constants.LIFT_CHAMBER_2 - 17)),
                new MoveWristCommand(wrist, Constants.WRIST_SCORE_CHAMBER),
                new StrafeToPointCommand(drive, new Pose2d (-35, 56, Math.toRadians(90)),new Vector2d( -1,29) , Math.toRadians(-90)),
                new MoveExtensionCommand(slides, Constants.EXTENSION_SCORE_SPECIMEN),
                new WaitCommand(275),
                new RaiseLiftCommand(slides, 500),
                new MoveExtensionCommand(slides, 0),
                new MoveWristCommand(wrist, Constants.WRIST_RETRACTED),
                new WaitCommand(100),
                new LowerLiftCommand(slides),
                new StrafeToPointCommand(drive, new Pose2d (-1, 29, Math.toRadians(-90)),new Vector2d( -37,58) , Math.toRadians(-90))

        );



    }



}
