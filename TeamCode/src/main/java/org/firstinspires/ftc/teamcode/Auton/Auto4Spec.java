package org.firstinspires.ftc.teamcode.Auton;

import com.acmerobotics.roadrunner.Pose2d;
import com.acmerobotics.roadrunner.SleepAction;
import com.acmerobotics.roadrunner.Vector2d;
import com.arcrobotics.ftclib.command.ParallelCommandGroup;
import com.arcrobotics.ftclib.command.SequentialCommandGroup;
import com.arcrobotics.ftclib.command.WaitCommand;

import org.firstinspires.ftc.teamcode.Commands.CommandGroups.AutoCycleSamplesCommand;
import org.firstinspires.ftc.teamcode.Commands.CommandGroups.AutoCycleSpecCommand;
import org.firstinspires.ftc.teamcode.Commands.CommandGroups.NewAutoCycleSpecCommand;
import org.firstinspires.ftc.teamcode.Commands.CommandGroups.RaiseBucket;
import org.firstinspires.ftc.teamcode.Commands.CommandGroups.RaiseSpecimenCommand;
import org.firstinspires.ftc.teamcode.Commands.CommandGroups.RetractAllCommand;
import org.firstinspires.ftc.teamcode.Commands.CommandGroups.ScoreSampleCommand;
import org.firstinspires.ftc.teamcode.Commands.CommandGroups.ScoreSpecimenCommand;
import org.firstinspires.ftc.teamcode.Commands.Custom.IntakeSpinCommand;
import org.firstinspires.ftc.teamcode.Commands.Custom.LMECControl;
import org.firstinspires.ftc.teamcode.Commands.Custom.LowerLiftCommand;
import org.firstinspires.ftc.teamcode.Commands.Custom.MoveExtensionCommand;
import org.firstinspires.ftc.teamcode.Commands.Custom.MoveWristCommand;
import org.firstinspires.ftc.teamcode.Commands.Custom.RaiseLiftCommand;
import org.firstinspires.ftc.teamcode.Commands.Custom.ResetIMUCommand;
import org.firstinspires.ftc.teamcode.Commands.Custom.ResetLiftCommand;
import org.firstinspires.ftc.teamcode.Commands.Custom.StrafeToPointCommand;
import org.firstinspires.ftc.teamcode.Lib.Constants;
import org.firstinspires.ftc.teamcode.Subsystems.IntakeSubsystem;
import org.firstinspires.ftc.teamcode.Subsystems.Robot;
import org.firstinspires.ftc.teamcode.Subsystems.SlideSubsystem;
import org.firstinspires.ftc.teamcode.Subsystems.WristSubsystem;

public abstract class Auto4Spec extends Robot {

    @Override
    public void runOpMode() throws InterruptedException{
        Pose2d startPose = new Pose2d(0,61, Math.toRadians(-90));
        initialize(startPose);
//        end();

//        wrist.wristMove(Constants.WRIST_RETRACTED);
        cs.schedule(
                new SequentialCommandGroup(
                        new LMECControl(lmec, true),
                        new MoveWristCommand(wrist, Constants.WRIST_START),
                        new ResetLiftCommand(slides),
                        new ResetIMUCommand(drive )
                )
        );
        slides.encoderReset();

        waitForStart();

        //there are two potential paths here either driving for spike mark or pushing with intake i think driving would work better - kai
        cs.schedule(
                new SequentialCommandGroup(

                        new RaiseSpecimenCommand(slides, wrist),
                        new StrafeToPointCommand(drive, startPose, new Vector2d( 0,31) , Math.toRadians(-90)), // score preload
                        new RaiseLiftCommand(slides, 500),
                        new MoveExtensionCommand(slides, 0),
                        new WaitCommand(150),
                        new MoveWristCommand(wrist, Constants.WRIST_RETRACTED),
                        new LowerLiftCommand(slides),

                        // sweep sample in obbie
                        new StrafeToPointCommand(drive, new Pose2d ( 0 , 31, Math.toRadians(-90)), new Vector2d( -27,37.5) , Math.toRadians(-150)),
                        new MoveWristCommand(wrist, Constants.WRIST_DOWN),
                        new IntakeSpinCommand(intake, 1),
                        new WaitCommand(200),
                        new MoveExtensionCommand(slides, 1450),
                        new WaitCommand(750),
                        new IntakeSpinCommand(intake, 0),
                        new StrafeToPointCommand(drive, new Pose2d ( -27, 37.5, Math.toRadians(-150)), new Vector2d( -19,47) , Math.toRadians(-210)),
                        new IntakeSpinCommand(intake, -1),
                        new WaitCommand(150),

                        // sweep sample in obbie
                        new MoveWristCommand(wrist, 0.2),
                        new IntakeSpinCommand(intake, 1),
                        new MoveExtensionCommand(slides, 700),
                        new StrafeToPointCommand(drive, new Pose2d ( -19, 47, Math.toRadians(-210)), new Vector2d( -33.5,38) , Math.toRadians(-150)),
                        new MoveWristCommand(wrist, Constants.WRIST_DOWN),
                        new WaitCommand(250),
                        new MoveExtensionCommand(slides, 1550),
                        new WaitCommand(600),
                        new IntakeSpinCommand(intake, 0),
                        new StrafeToPointCommand(drive, new Pose2d ( -33.5, 38, Math.toRadians(-150)), new Vector2d( -26,50) , Math.toRadians(-205)),
                        new IntakeSpinCommand(intake, -1),
                        new WaitCommand(150),
                        new IntakeSpinCommand(intake, 0),

                        new NewAutoCycleSpecCommand(intake, wrist, drive, slides)


                ));

        while (!isStopRequested()){
            update();


        }
        end();

    }


}
