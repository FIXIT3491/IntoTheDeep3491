package org.firstinspires.ftc.teamcode.Auton;

import com.acmerobotics.roadrunner.Pose2d;
import com.acmerobotics.roadrunner.SleepAction;
import com.acmerobotics.roadrunner.Vector2d;
import com.arcrobotics.ftclib.command.ParallelCommandGroup;
import com.arcrobotics.ftclib.command.SequentialCommandGroup;
import com.arcrobotics.ftclib.command.WaitCommand;

import org.firstinspires.ftc.teamcode.Commands.CommandGroups.AutoCycleSamplesCommand;
import org.firstinspires.ftc.teamcode.Commands.CommandGroups.AutoCycleSpecCommand;
import org.firstinspires.ftc.teamcode.Commands.CommandGroups.RaiseBucket;
import org.firstinspires.ftc.teamcode.Commands.CommandGroups.RaiseSpecimenCommand;
import org.firstinspires.ftc.teamcode.Commands.CommandGroups.RetractAllCommand;
import org.firstinspires.ftc.teamcode.Commands.CommandGroups.ScoreSampleCommand;
import org.firstinspires.ftc.teamcode.Commands.CommandGroups.ScoreSpecimenCommand;
import org.firstinspires.ftc.teamcode.Commands.Custom.LowerLiftCommand;
import org.firstinspires.ftc.teamcode.Commands.Custom.MoveExtensionCommand;
import org.firstinspires.ftc.teamcode.Commands.Custom.MoveWristCommand;
import org.firstinspires.ftc.teamcode.Commands.Custom.RaiseLiftCommand;
import org.firstinspires.ftc.teamcode.Commands.Custom.StrafeToPointCommand;
import org.firstinspires.ftc.teamcode.Lib.Constants;
import org.firstinspires.ftc.teamcode.Subsystems.IntakeSubsystem;
import org.firstinspires.ftc.teamcode.Subsystems.Robot;
import org.firstinspires.ftc.teamcode.Subsystems.SlideSubsystem;
import org.firstinspires.ftc.teamcode.Subsystems.WristSubsystem;

public abstract class Auto100Spec extends Robot {

    @Override
    public void runOpMode() throws InterruptedException{
        Pose2d startPose = new Pose2d(0,61, Math.toRadians(-90));
        initialize(startPose);
//        end();

//        wrist.wristMove(Constants.WRIST_RETRACTED);

        slides.encoderReset();

        waitForStart();

        //there are two potential paths here either driving for spike mark or pushing with intake i think driving would work better - kai
        cs.schedule(
                new SequentialCommandGroup(

                        new RaiseSpecimenCommand(slides, wrist),
                        new StrafeToPointCommand(drive, startPose, new Vector2d( 0,33) , Math.toRadians(-90)), // score preload
                        new RaiseLiftCommand(slides, 500),
                        new MoveExtensionCommand(slides, 0),
                        new WaitCommand(400),
                        new MoveWristCommand(wrist, Constants.WRIST_RETRACTED),
                        new LowerLiftCommand(slides),

                        // sweep sample in obbie
                        new StrafeToPointCommand(drive, new Pose2d ( 0 , 33, Math.toRadians(-90)), new Vector2d( -27,37) , Math.toRadians(-130)),
                        new MoveExtensionCommand(slides, 1450),
                        new MoveWristCommand(wrist, Constants.WRIST_DOWN),
                        new WaitCommand(450),
                        new StrafeToPointCommand(drive, new Pose2d ( -27, 37, Math.toRadians(-130)), new Vector2d( -19,47) , Math.toRadians(-200)),

                        // sweep sample in obbie
                        new MoveWristCommand(wrist, Constants.WRIST_RETRACTED),
                        new StrafeToPointCommand(drive, new Pose2d ( -19, 47, Math.toRadians(-200)), new Vector2d( -33,36) , Math.toRadians(-130)),
                        new MoveExtensionCommand(slides, 1850),
                        new MoveWristCommand(wrist, Constants.WRIST_DOWN),
                        new WaitCommand(250),
                        new StrafeToPointCommand(drive, new Pose2d ( -33, 36, Math.toRadians(-130)), new Vector2d( -26,50) , Math.toRadians(-205)),

                        new AutoCycleSpecCommand(intake, wrist, drive, slides)


        ));

        while (!isStopRequested()){
            update();


        }
        end();

    }


}
