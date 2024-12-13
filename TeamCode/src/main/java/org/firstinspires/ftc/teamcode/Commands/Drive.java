package org.firstinspires.ftc.teamcode.Commands;


import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.hardwareMap;

import com.acmerobotics.roadrunner.ftc.SparkFunOTOSCorrected;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.Range;

import org.firstinspires.ftc.teamcode.RoadRunnerStuff.MecanumDrive;
import org.firstinspires.ftc.teamcode.Robot.Constants;
import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.robotcore.external.navigation.YawPitchRollAngles;
import org.firstinspires.ftc.teamcode.Robot.Subsystems.DriveSubsystem;
import org.firstinspires.ftc.teamcode.Robot.Subsystems.IMUSubsystem;
import org.firstinspires.ftc.teamcode.Robot.Subsystems.RobotContainer;
import org.firstinspires.ftc.teamcode.Robot.SparkFunOTOSConfig;



public class Drive {

    private LinearOpMode op;
    private SparkFunOTOSConfig.Pose2D pos;
    private MecanumDrive drive;

    public DcMotor DriveFR;
    public DcMotor DriveFL;
    public DcMotor DriveBR;
    public DcMotor DriveBL;
    private DriveSubsystem driveSubsystem;
    private IMUSubsystem imuSubsystem;


    public Drive(LinearOpMode op, Telemetry telemetry){

        this.op = op;
    }

    public Drive(Telemetry telemetry) {

    }


    public void driveForwards(){
        DriveFL = hardwareMap.get(DcMotor.class, "FLD");
        DriveBL = hardwareMap.get(DcMotor.class, "BLD");
        DriveFR = hardwareMap.get(DcMotor.class, "FRD");
        DriveBR = hardwareMap.get(DcMotor.class, "BRD");

        DriveFL.setDirection(DcMotor.Direction.REVERSE);
        DriveBL.setDirection(DcMotor.Direction.REVERSE);
        DriveFR.setDirection(DcMotor.Direction.FORWARD);
        DriveBR.setDirection(DcMotor.Direction.FORWARD);

        //brake on zero
        DriveFL.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        DriveBL.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        DriveFR.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        DriveBR.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

    }
    public void imuTurn(double heading) {

        YawPitchRollAngles orientation;
        double turn, headingError;

        orientation = imuSubsystem.getYawPitchRoll();
        headingError    = heading - orientation.getYaw(AngleUnit.DEGREES);

        while(Math.abs(headingError) > 5/* && opModeIsActive()*/) {  // just guessing that heading error of 3 is close enough

            orientation = imuSubsystem.getYawPitchRoll();
            headingError    = heading - orientation.getYaw(AngleUnit.DEGREES);
            turn   = Range.clip(headingError * Constants.IMU_TURN_GAIN, -Constants.IMU_MAX_AUTO_TURN, Constants.IMU_MAX_AUTO_TURN);
            driveSubsystem.moveRobot(0, 0, turn);
            op.sleep(10);

        }
        driveSubsystem.moveRobot(0, 0, 0);  // stop motors when turn done
    }


}
