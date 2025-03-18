package org.firstinspires.ftc.teamcode.TeleOP;

import com.acmerobotics.dashboard.config.Config;
import com.acmerobotics.roadrunner.Pose2d;
import com.arcrobotics.ftclib.command.CommandScheduler;
import com.arcrobotics.ftclib.command.ParallelCommandGroup;
import com.arcrobotics.ftclib.command.SequentialCommandGroup;
import com.arcrobotics.ftclib.command.button.Trigger;
import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.arcrobotics.ftclib.gamepad.GamepadKeys;
import com.arcrobotics.ftclib.gamepad.TriggerReader;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.robotcore.external.Const;
import org.firstinspires.ftc.teamcode.Commands.CommandGroups.PickupSpecimenCommand;
import org.firstinspires.ftc.teamcode.Commands.CommandGroups.RaiseBucket;
import org.firstinspires.ftc.teamcode.Commands.CommandGroups.RaiseSpecimenCommand;
import org.firstinspires.ftc.teamcode.Commands.CommandGroups.RetractAllCommand;
import org.firstinspires.ftc.teamcode.Commands.CommandGroups.ScoreSpecimenCommand;
import org.firstinspires.ftc.teamcode.Commands.Custom.DefaultDriveCommand;
import org.firstinspires.ftc.teamcode.Commands.Custom.IntakeSpinCommand;
import org.firstinspires.ftc.teamcode.Commands.Custom.LMECControl;
import org.firstinspires.ftc.teamcode.Commands.Custom.LowerLiftCommand;
import org.firstinspires.ftc.teamcode.Commands.Custom.ManualExtensionControl;
import org.firstinspires.ftc.teamcode.Commands.Custom.MoveExtensionCommand;
import org.firstinspires.ftc.teamcode.Commands.Custom.MoveWristAutoCommand;
import org.firstinspires.ftc.teamcode.Commands.Custom.MoveWristCommand;
import org.firstinspires.ftc.teamcode.Commands.Custom.Pickup;
import org.firstinspires.ftc.teamcode.Commands.Custom.RaiseLiftCommand;
import org.firstinspires.ftc.teamcode.Commands.Custom.ResetIMUCommand;
import org.firstinspires.ftc.teamcode.Commands.Custom.ResetLiftCommand;
import org.firstinspires.ftc.teamcode.Lib.Util;
import org.firstinspires.ftc.teamcode.Lib.Constants;
import org.firstinspires.ftc.teamcode.Subsystems.Robot;
import org.firstinspires.ftc.teamcode.Subsystems.WristSubsystem;


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
        drive.reset();
        cs.schedule(
                new SequentialCommandGroup(
                        new LMECControl(lmec, false),
                        new MoveWristCommand(wrist, Constants.WRIST_START),
                        new ResetLiftCommand(slides),
                        new ResetIMUCommand(drive )
                        )
        );

        double robotMovementMultiplier = 0.5;
        //sets driving command
        CommandScheduler.getInstance().setDefaultCommand(drive,
                new DefaultDriveCommand(
                        drive,
                        () -> driverPad.getLeftX(),
                        () -> driverPad.getLeftY(),
                        () -> driverPad.getRightX(),
                        drive.getHeading()
                )
        );
        //makes wrist return back to zero
//        CommandScheduler.getInstance()
//                .setDefaultCommand(wrist,
//                        new MoveWristCommand(wrist, Constants.WRIST_RETRACTED)
//                        );
//        CommandScheduler.getInstance()
//                .setDefaultCommand(intake,
//                        new IntakeSpinCommand(intake, 0)
//                );

        configureOperator();

        waitForStart();


        while (opModeIsActive()){

            telemetry.addData("touch sensor",slides.getTouchSensor());
            telemetry.addData("distance sensor", intake.getDistance());
            telemetry.addData("extension pos", slides.getExtensionPos());
            telemetry.addData("heading", drive.getHeading());
            telemetry.addData("Gamepad y", gamepad2.right_stick_y);


            update();
        }
        CommandScheduler.getInstance().reset();
    }
    public void configureOperator() {
        //Basket level 2 score
        operatorPad.getGamepadButton(GamepadKeys.Button.B).whenPressed(
                new RaiseBucket(slides, wrist)
        );
        //Zero Lift
        operatorPad.getGamepadButton(GamepadKeys.Button.A).and(new Trigger(() ->!slides.getTouchSensor())).whenActive(
                new RetractAllCommand(slides, wrist, intake)
        );

        //Raise to score specimen
        driverPad.getGamepadButton(GamepadKeys.Button.LEFT_BUMPER)
                .whenHeld(new PickupSpecimenCommand(slides, wrist))
                .whenReleased(new RaiseSpecimenCommand(slides, wrist));

        driverPad.getGamepadButton(GamepadKeys.Button.A).whenPressed(
                new RetractAllCommand(slides, wrist, intake)
        );


        operatorPad.getGamepadButton(GamepadKeys.Button.X)
                .whenHeld(new RaiseSpecimenCommand(slides, wrist))
                .whenReleased(new RetractAllCommand(slides, wrist, intake));

        operatorPad.getGamepadButton(GamepadKeys.Button.LEFT_BUMPER)
                .whenHeld(new IntakeSpinCommand(intake, Constants.OUTTAKE))
                .whenReleased(new IntakeSpinCommand(intake, 0));
        new Trigger(() -> gamepad1.left_trigger > 0).whileActiveContinuous(
                new SequentialCommandGroup(
                        new MoveWristCommand(wrist, Constants.WRIST_DOWN),
                        new IntakeSpinCommand(intake,   Constants.SPINNING)
                )
        ).whenInactive(
                new SequentialCommandGroup(
                    new MoveWristCommand(wrist, Constants.WRIST_RETRACTED),
                    new IntakeSpinCommand(intake, 0)
        ));

        new Trigger(() ->  (-operatorPad.getRightY() < 0.05 )).whenActive(
                new ManualExtensionControl(slides, 0)
        );
        new Trigger(() ->  (-operatorPad.getRightY()  < 0.24 && -operatorPad.getRightY() >0 )).whenActive(
                new ManualExtensionControl(slides, 500)

        );
        new Trigger(() ->  (-operatorPad.getRightY()  < 0.49 && -operatorPad.getRightY() > 0.25)).whenActive(
                new ManualExtensionControl(slides, 1000)
        );
        new Trigger(() ->  (-operatorPad.getRightY()  < 0.74 && -operatorPad.getRightY() > 0.5)).whenActive(
                new ManualExtensionControl(slides, 1500)
        );
        new Trigger(() ->  (-operatorPad.getRightY() > 0.75)).whenActive(
                new ManualExtensionControl(slides, 2000)
        );

        driverPad.getGamepadButton(GamepadKeys.Button.BACK).whenPressed(
                new ResetIMUCommand(drive)
        );

        new Trigger(() -> gamepad1.right_trigger > 0).whileActiveContinuous(
                new Pickup(wrist, intake)
        );
        new Trigger(() -> gamepad1.right_trigger > 0).whenInactive(
                new SequentialCommandGroup(
                        new MoveWristCommand(wrist, Constants.WRIST_RETRACTED),
                        new IntakeSpinCommand(intake, 0)
                )
        );
        driverPad.getGamepadButton(GamepadKeys.Button.RIGHT_BUMPER).toggleWhenPressed(
                new LMECControl(lmec, true),
                new LMECControl(lmec, false)
        );
        new Trigger(() ->slides.getTouchSensor()).whenActive(
                new SequentialCommandGroup(
                        new ResetLiftCommand(slides),
                        new LowerLiftCommand(slides, 0)
                )
        );
    }


//    intake sample (g1 right trigger held) wrist down, intake spin, slides down, while held (need to check color sensor inside pickup method logic) add while active continus and then if(distance blah blag balh)
//    lock mechanum (g1 right bumper) toggle locked or unlocked
//    reset feild centric ( options)
//    intake specimens ( hold, raises arm to value and drops down after
//



// Op gamepad
//
//  lift zero (a while active continus) brings down the lift checks once done to see if touch sensor is pushed
//  lift bucket (b while active)
//  score specimen (when released x ) resets stuff
//  outtake (when held left bumper)
//  extension (manual joystick button

    // DRIVER GAMEPAD

//
//          ^                           y
//    <           >               x           b
//         \ /                          a

}