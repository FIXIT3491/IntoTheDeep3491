package org.firstinspires.ftc.teamcode.Testing;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;

import org.firstinspires.ftc.teamcode.Commands.CommandBase;
import org.firstinspires.ftc.teamcode.Robot.SparkFunOTOSConfig;
import org.firstinspires.ftc.teamcode.Robot.Subsystems.RobotContainer;

@TeleOp
public class OtosTest extends LinearOpMode {

    @Override
    public void runOpMode() {
        CommandBase.initialize(hardwareMap,telemetry, this);

        while(opModeIsActive()){
            SparkFunOTOSConfig.Pose2D currentPos = RobotContainer.sparkFunSubsystem.myPosition();
            telemetry.addData("current X coordinate", currentPos.x);
            telemetry.addData("current Y coordinate", currentPos.y);
            telemetry.addData("current Heading angle", currentPos.h);
            telemetry.addData("heading", RobotContainer.imuSubsystem.getHeading() );
        }
    }
}
