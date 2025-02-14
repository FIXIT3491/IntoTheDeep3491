package org.firstinspires.ftc.teamcode.TeleOP;

import com.acmerobotics.dashboard.config.Config;
import com.acmerobotics.roadrunner.Pose2d;
import com.arcrobotics.ftclib.command.CommandScheduler;
import com.arcrobotics.ftclib.command.ParallelCommandGroup;
import com.arcrobotics.ftclib.command.SequentialCommandGroup;
import com.arcrobotics.ftclib.command.WaitCommand;
import com.arcrobotics.ftclib.command.button.Trigger;
import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.arcrobotics.ftclib.gamepad.GamepadKeys;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.Commands.CommandGroups.RaiseSpecimenCommand;
import org.firstinspires.ftc.teamcode.Commands.CommandGroups.ScoreSpecimenCommand;
import org.firstinspires.ftc.teamcode.Commands.Custom.DefaultDriveCommand;
import org.firstinspires.ftc.teamcode.Commands.Custom.IntakeSpinCommand;
import org.firstinspires.ftc.teamcode.Commands.Custom.LowerLiftCommand;
import org.firstinspires.ftc.teamcode.Commands.Custom.MoveExtensionCommand;
import org.firstinspires.ftc.teamcode.Commands.Custom.MoveWristCommand;
import org.firstinspires.ftc.teamcode.Commands.Custom.Pickup;
import org.firstinspires.ftc.teamcode.Commands.Custom.RaiseLiftCommand;
import org.firstinspires.ftc.teamcode.Lib.Util;
import org.firstinspires.ftc.teamcode.Lib.Constants;
import org.firstinspires.ftc.teamcode.Subsystems.Robot;


@Config
@TeleOp(name="TeleOpTest", group="01")
public class TeleOpTest extends Robot {


    protected GamepadEx driverPad;
    protected GamepadEx operatorPad;

    @Override
    public void runOpMode() {
        initialize(new Pose2d(-1, -1, -1));

        driverPad = new GamepadEx(gamepad1);
        operatorPad = new GamepadEx(gamepad2);


        double robotMovementMultiplier = 0.5;
        CommandScheduler.getInstance().setDefaultCommand(drive,
                new DefaultDriveCommand(
                        drive,
                        () -> Util.halfLinearHalfCubic(driverPad.getLeftY()) * (getState() == FSMStates.INTAKE || getState() == FSMStates.OUTTAKE ? robotMovementMultiplier : 1),
                        () -> Util.halfLinearHalfCubic(driverPad.getLeftX()) * (getState() == FSMStates.INTAKE || getState() == FSMStates.OUTTAKE ? robotMovementMultiplier : 1),
                        () -> Util.halfLinearHalfCubic(driverPad.getRightX()) * (getState() == FSMStates.INTAKE || getState() == FSMStates.OUTTAKE ? robotMovementMultiplier : 1),
                        drive.getHeading()
                )
        );
        configureOperator();

        waitForStart();
        while (opModeIsActive()){
            update();
        }
        CommandScheduler.getInstance().reset();
    }
    public void configureOperator() {
        //Basket level 2 score
        operatorPad.getGamepadButton(GamepadKeys.Button.B).whenPressed(
                new SequentialCommandGroup(
                        new RaiseLiftCommand(slides, Constants.LIFT_BUCKET_2),
                        new MoveWristCommand(wrist, Constants.WRIST_OUT)));
        //Control of slides
        operatorPad.getGamepadButton(GamepadKeys.Button.A).whenPressed(
                new LowerLiftCommand(slides));
        operatorPad.getGamepadButton(GamepadKeys.Button.Y).whenPressed(
                new RaiseSpecimenCommand(slides, wrist));
        operatorPad.getGamepadButton(GamepadKeys.Button.X).whenPressed(
                new ScoreSpecimenCommand(slides, wrist));
        operatorPad.getGamepadButton(GamepadKeys.Button.RIGHT_BUMPER).whenPressed(
                new IntakeSpinCommand(intake, -0.5));

        //TODO learn how to use condidtional commands for this to check when sample is inside claw
        operatorPad.getGamepadButton(GamepadKeys.Button.RIGHT_BUMPER)
                .whenHeld(new IntakeSpinCommand(intake, -Constants.SPINNING))
                .whenReleased(new IntakeSpinCommand(intake, 0)
        );
        //TODO create pickup button maybe?
        new Trigger(() -> gamepad1.right_trigger > 0).whenActive(
                new Pickup(wrist, intake)
        );


    }

}