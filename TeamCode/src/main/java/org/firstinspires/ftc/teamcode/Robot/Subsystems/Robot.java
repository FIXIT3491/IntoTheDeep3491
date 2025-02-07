package org.firstinspires.ftc.teamcode.Robot.Subsystems;

import com.acmerobotics.roadrunner.Pose2d;
import com.arcrobotics.ftclib.command.CommandScheduler;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;


public abstract class Robot extends LinearOpMode {

    public SlideSubsystem slides;
    public WristSubsystem wrist;
    public IntakeSubsystem intake;
    public SparkFunOTOSDrive drive;

    public CommandScheduler cs = CommandScheduler.getInstance();
    public void initialize(Pose2d pose) {


        drive = new SparkFunOTOSDrive(hardwareMap, pose);
        intake = new IntakeSubsystem(hardwareMap, telemetry);
        wrist = new WristSubsystem(hardwareMap, telemetry);
        slides = new SlideSubsystem(hardwareMap, telemetry);

        CommandScheduler.getInstance().registerSubsystem(slides, wrist, intake);
    }

    public void update() {
        CommandScheduler.getInstance().run();
        telemetry.update();
    }
    public void end() {
        cs.reset();
    }



}
