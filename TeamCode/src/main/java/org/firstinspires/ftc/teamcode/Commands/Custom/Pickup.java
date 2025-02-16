package org.firstinspires.ftc.teamcode.Commands.Custom;

import com.arcrobotics.ftclib.command.InstantCommand;

import org.firstinspires.ftc.teamcode.Lib.Constants;
import org.firstinspires.ftc.teamcode.Subsystems.IntakeSubsystem;
import org.firstinspires.ftc.teamcode.Subsystems.WristSubsystem;

public class Pickup extends InstantCommand {

    WristSubsystem wrist;
    IntakeSubsystem intake;

    public Pickup(WristSubsystem wrist, IntakeSubsystem intake ) {
        addRequirements(wrist, intake);

        this.wrist = wrist;
        this.intake = intake;
    }

    @Override
    public void initialize() {
        //todo check while loops work
        wrist.wristMove(Constants.WRIST_DOWN);
//        while (intake.getDistance() < Constants.DISTANCE_WHEN_IN){
        intake.spinIntake(Constants.SPINNING);
//        }
//        intake.spinIntake(Constants.STOPPED);
//        wrist.wristMove(Constants.WRIST_RETRACTED);

    }

}