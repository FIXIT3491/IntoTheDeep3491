package org.firstinspires.ftc.teamcode.Commands.CommandGroups;

import com.acmerobotics.roadrunner.Pose2d;
import com.acmerobotics.roadrunner.Vector2d;
import com.arcrobotics.ftclib.command.ParallelCommandGroup;
import com.arcrobotics.ftclib.command.SequentialCommandGroup;
import com.arcrobotics.ftclib.command.WaitCommand;

import org.firstinspires.ftc.teamcode.Commands.Custom.RaiseLiftCommand;
import org.firstinspires.ftc.teamcode.Commands.Custom.StrafeToPointCommand;
import org.firstinspires.ftc.teamcode.Lib.Constants;
import org.firstinspires.ftc.teamcode.Subsystems.IntakeSubsystem;
import org.firstinspires.ftc.teamcode.Subsystems.SlideSubsystem;
import org.firstinspires.ftc.teamcode.Subsystems.SparkFunOTOSSubSystem;
import org.firstinspires.ftc.teamcode.Subsystems.WristSubsystem;

public class AutoCycleSpecCommand extends SequentialCommandGroup {

    Vector2d pos;
    double heading;
    double pickupHeading;
    long delay;

    public AutoCycleSpecCommand(IntakeSubsystem intake, WristSubsystem wrist, SparkFunOTOSSubSystem drive, SlideSubsystem slides){





        addCommands(

                new ParallelCommandGroup(
                //pickup spec command
                //strafe to point (align pickup sample)
                )
                // strafe to point (pickup spec)
                // new parallel {
                    // RaiseSpec
                    // strafeToPoint (AlignToScore)
                //}
                //strafeToPoint (score

        );



    }



}
