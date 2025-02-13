package org.firstinspires.ftc.teamcode.TeleOP;

import com.acmerobotics.dashboard.config.Config;
import com.acmerobotics.roadrunner.Pose2d;
import com.arcrobotics.ftclib.command.CommandScheduler;
import com.arcrobotics.ftclib.command.SequentialCommandGroup;
import com.arcrobotics.ftclib.command.WaitCommand;
import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.arcrobotics.ftclib.gamepad.GamepadKeys;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.Commands.Custom.DefaultDriveCommand;
import org.firstinspires.ftc.teamcode.Commands.Custom.IntakeSpinCommand;
import org.firstinspires.ftc.teamcode.Commands.Custom.MoveExtensionCommand;
import org.firstinspires.ftc.teamcode.Commands.Custom.MoveWristCommand;
import org.firstinspires.ftc.teamcode.Commands.Custom.RaiseLiftCommand;
import org.firstinspires.ftc.teamcode.Lib.Util;
import org.firstinspires.ftc.teamcode.Lib.Constants;
import org.firstinspires.ftc.teamcode.Subsystems.Robot;

@TeleOp
@Config
@Autonomous(name="TeleOpTest", group="01")
public class TeleOpTest extends Robot {


    protected GamepadEx driverPad;
    protected GamepadEx operatorPad;

    @Override
    public void runOpMode() {
        initialize(new Pose2d(-1, -1, -1));

        driverPad = new GamepadEx(gamepad1);
        operatorPad = new GamepadEx(gamepad2);


        //TODO add in the operator drive command stuff
        double robotMovementMultiplier = 0.5;

        CommandScheduler.getInstance().setDefaultCommand(drive,
                new DefaultDriveCommand(
                        drive,
                        () -> Util.halfLinearHalfCubic(Math.abs(driverPad.getLeftY() / driverPad.getLeftX()) < 0.05 ? 0 : driverPad.getLeftY()) * (getState() == FSMStates.INTAKE || getState() == FSMStates.OUTTAKE ? robotMovementMultiplier : 1),
                        () -> Util.halfLinearHalfCubic(Math.abs(driverPad.getLeftX() / driverPad.getLeftY()) < 0.05 ? 0 : driverPad.getLeftX()) * (getState() == FSMStates.INTAKE || getState() == FSMStates.OUTTAKE ? robotMovementMultiplier : 1),
                        () -> Util.halfLinearHalfCubic(driverPad.getRightX()) * (getState() == FSMStates.INTAKE || getState() == FSMStates.OUTTAKE ? robotMovementMultiplier : 1),
                        drive.getHeading()
                )
        );



        //TODO either allow one button for raise slides and one for scoring or keep single score button
        //Basket level 2 score
        operatorPad.getGamepadButton(GamepadKeys.Button.A).whenPressed(
                new SequentialCommandGroup(
                        new RaiseLiftCommand(slides, Constants.LIFT_BUCKET_2),
                        new MoveWristCommand(wrist, Constants.WRIST_OUT)
                )
        );
        //Control of intake
        operatorPad.getGamepadButton(GamepadKeys.Button.RIGHT_BUMPER).whenPressed(
                new IntakeSpinCommand(intake, -0.5)
        );
        //score raise chamber clip on
        operatorPad.getGamepadButton(GamepadKeys.Button.Y).whenPressed(
                new SequentialCommandGroup(
                        new RaiseLiftCommand(slides, Constants.LIFT_CHAMBER_2),
                        new MoveWristCommand(wrist, Constants.WRIST_SCORE_CHAMBER),
                        new WaitCommand(400),
                        new MoveExtensionCommand(slides, Constants.EXTENSION_SCORE_SPECIMEN),
                        new WaitCommand(750),
                        new MoveExtensionCommand(slides, Constants.EXTENSION_MIN),
                        new MoveWristCommand(wrist, Constants.WRIST_RETRACTED)
                )
        );

        //TODO learn how to use condidtional commands for this to check when sample is inside claw
        operatorPad.getGamepadButton(GamepadKeys.Button.RIGHT_BUMPER).whenHeld(
                new IntakeSpinCommand(intake, -Constants.SPINNING)
        );

        //TODO create pickup button maybe?




     }
}
