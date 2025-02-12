package org.firstinspires.ftc.teamcode.TeleOP;

import com.acmerobotics.dashboard.config.Config;
import com.acmerobotics.roadrunner.Pose2d;
import com.arcrobotics.ftclib.command.CommandScheduler;
import com.arcrobotics.ftclib.command.SequentialCommandGroup;
import com.arcrobotics.ftclib.command.WaitCommand;
import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.arcrobotics.ftclib.gamepad.GamepadKeys;
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
public class TeleOpTest extends Robot {


    protected GamepadEx driverPad;
    protected GamepadEx operatorPad;

    @Override
    public void runOpMode() {
        initialize(new Pose2d(-1, -1, -1));

        driverPad = new GamepadEx(gamepad1);
        operatorPad = new GamepadEx(gamepad2);


        //@TODO add in the drive logic for defult drive command here, later down below add in the operator drive command stuff
        double robotMovementMultiplier = 0.5;

        CommandScheduler.getInstance().setDefaultCommand(drive, new DefaultDriveCommand(
                drive,
                () -> Util.halfLinearHalfCubic(Math.abs(driverPad.getLeftY() / driverPad.getLeftX()) < 0.05 ? 0 : driverPad.getLeftY()) * (getState() == FSMStates.INTAKE || getState() == FSMStates.OUTTAKE ? robotMovementMultiplier : 1),
                () -> Util.halfLinearHalfCubic(Math.abs(driverPad.getLeftX() / driverPad.getLeftY()) < 0.05 ? 0 : driverPad.getLeftX()) * (getState() == FSMStates.INTAKE || getState() == FSMStates.OUTTAKE ? robotMovementMultiplier : 1),
                () -> Util.halfLinearHalfCubic(driverPad.getRightX()) * (getState() == FSMStates.INTAKE || getState() == FSMStates.OUTTAKE ? robotMovementMultiplier : 1),
                () ->
//TODO need to get the heading pos here could probably just create a imu subsytsem and then add in the get heading value thingy
                )
        );

//        cs.schedule(new DefaultDriveCommand);

        //Basket level 2 score
        operatorPad.getGamepadButton(GamepadKeys.Button.A).whenPressed(
                new SequentialCommandGroup(
                        new RaiseLiftCommand(slides, Constants.LIFT_BUCKET_2),
                        new MoveWristCommand(wrist, Constants.WRIST_OUT)
                )
        );

        operatorPad.getGamepadButton(GamepadKeys.Button.Y).whenPressed(
                new SequentialCommandGroup(
                        new RaiseLiftCommand(slides, Constants.LIFT_CHAMBER_2),
                        new MoveWristCommand(wrist, Constants.WRIST_SCORE_CHAMBER),
                        new WaitCommand(100),
                        new MoveExtensionCommand(slides, Constants.EXTENSION_SCORE_SPECIMEN)
                )
        );

        //TODO learn how to use condidtional commands for this
        operatorPad.getGamepadButton(GamepadKeys.Button.RIGHT_BUMPER).whenHeld(
                new IntakeSpinCommand(intake, -Constants.SPINNING)
        );


     }
}
