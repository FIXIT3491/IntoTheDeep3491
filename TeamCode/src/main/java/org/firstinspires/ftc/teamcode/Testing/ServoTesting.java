package org.firstinspires.ftc.teamcode.Testing;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.HardwareMap;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.Commands.CommandBase;
import org.firstinspires.ftc.teamcode.Commands.Pickup;
import org.firstinspires.ftc.teamcode.Robot.Subsystems.RobotContainer;

@Autonomous(name="ServoTesting", group = "Autonomous")
public class ServoTesting extends LinearOpMode {


    @Override
    public void runOpMode() {
        CommandBase.initialize(hardwareMap, telemetry, this);

//        RobotContainer.intakeSubsystem.wristDown();
        waitForStart();


        boolean taco = CommandBase.pickup.SpikeMarkAuto("blue", telemetry);
        while (!taco){
            taco = CommandBase.pickup.SpikeMarkAuto("blue", telemetry);
        }

        sleep(2000);


    }
}
