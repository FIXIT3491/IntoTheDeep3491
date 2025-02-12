package org.firstinspires.ftc.teamcode.TeleOP;

import com.acmerobotics.dashboard.config.Config;
import com.acmerobotics.roadrunner.Pose2d;
import com.acmerobotics.roadrunner.SleepAction;
import com.arcrobotics.ftclib.command.ConditionalCommand;
import com.arcrobotics.ftclib.command.InstantCommand;
import com.arcrobotics.ftclib.command.SequentialCommandGroup;
import com.arcrobotics.ftclib.command.WaitCommand;
import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.arcrobotics.ftclib.gamepad.GamepadKeys;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Gamepad;

import org.firstinspires.ftc.teamcode.Commands.Custom.DefaultDriveCommand;
import org.firstinspires.ftc.teamcode.Commands.Custom.IntakeSpinCommand;
import org.firstinspires.ftc.teamcode.Commands.Custom.MoveExtensionCommand;
import org.firstinspires.ftc.teamcode.Commands.Custom.MoveWristCommand;
import org.firstinspires.ftc.teamcode.Commands.Custom.RaiseLiftCommand;
import org.firstinspires.ftc.teamcode.Robot.Constants;
import org.firstinspires.ftc.teamcode.Robot.Subsystems.Robot;

@TeleOp
@Config
public class TeleOpTest extends Robot {


    protected GamepadEx driverPad;
    protected GamepadEx operatorPad;

    @Override
    public void runOpMode()  {
        initialize(new Pose2d(-1,-1,-1));

        driverPad = new GamepadEx(gamepad1);
        operatorPad = new GamepadEx(gamepad2);





        //@TODO add in the drive logic for defult drive command here, later down below add in the operator drive command stuff

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
