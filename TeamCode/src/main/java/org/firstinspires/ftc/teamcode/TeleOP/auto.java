package org.firstinspires.ftc.teamcode.TeleOP;

import com.acmerobotics.roadrunner.Pose2d;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;

import org.firstinspires.ftc.teamcode.Commands.Custom.RaiseLiftCommand;
import org.firstinspires.ftc.teamcode.Subsystems.Robot;

@Autonomous
public class auto extends Robot {

    @Override
    public void runOpMode() throws InterruptedException  {
        initialize(new Pose2d(1,1,1));
        waitForStart();

        cs.schedule(new RaiseLiftCommand(slides, 1500));
        sleep(4000);



    }
}
