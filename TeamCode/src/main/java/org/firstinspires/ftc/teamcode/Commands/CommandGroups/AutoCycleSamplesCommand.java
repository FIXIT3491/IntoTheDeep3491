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

public class AutoCycleSamplesCommand extends SequentialCommandGroup {

    Vector2d pos;
    double heading;
    double pickupHeading;
    long delay;

    public AutoCycleSamplesCommand(IntakeSubsystem intake, WristSubsystem wrist, SparkFunOTOSSubSystem drive, SlideSubsystem slides, int cycleCount){

        if (cycleCount == 1){
            pos = Constants.FIRST_SPIKE_MARK_POS;
            heading = 50; // score heading
            pickupHeading = -87;
            delay = 700;

        } else if (cycleCount == 2) {
            pos = Constants.SECOND_SPIKE_MARK_POS;
            heading = 50;
            pickupHeading = -99;
            delay = 800;

        } else if (cycleCount == 3) {
            pos = Constants.THIRD_SPIKE_MARK_POS;
            heading = 50;
            pickupHeading = -64.5;
            delay = 600;
        }

        addCommands(

                new StrafeToPointCommand(drive, new Pose2d(Constants.BUCKET_POS, Math.toRadians(heading)), pos, Math.toRadians(pickupHeading)),
                new AutoSpikeIntakeCommand(intake, slides, wrist),
                new WaitCommand(300),
                new RaiseLiftCommand(slides, Constants.LIFT_BUCKET_2),
                new ParallelCommandGroup(
                        new RaiseLiftCommand(slides, Constants.LIFT_BUCKET_2),
                        new StrafeToPointCommand(drive, new Pose2d(pos, Math.toRadians(pickupHeading)), Constants.BUCKET_POS, Math.toRadians(50))
                ),
                new WaitCommand(delay),
                new ScoreSampleCommand(slides, wrist, intake)
        );



    }



}
