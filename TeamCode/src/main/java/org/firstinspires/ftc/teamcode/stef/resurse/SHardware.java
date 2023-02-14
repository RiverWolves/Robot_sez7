package org.firstinspires.ftc.teamcode.stef.resurse;


import com.qualcomm.hardware.rev.RevHubOrientationOnRobot;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.IMU;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.teamcode.drive.SampleMecanumDrive;

public class SHardware {

    public static boolean initializat = false;

    public static DcMotor lift1, lift2, brat;
    public static Servo intake1, intake2, rotire;
    public static IMU imu;
    public static SampleMecanumDrive mecanum = null;

    public static void init(OpMode opMode, boolean auto) {


        //Giroscop
        imu = opMode.hardwareMap.get(IMU.class, "imu");
        IMU.Parameters parameters = new IMU.Parameters(new RevHubOrientationOnRobot(
                RevHubOrientationOnRobot.LogoFacingDirection.DOWN,
                RevHubOrientationOnRobot.UsbFacingDirection.BACKWARD)
        );
        imu.initialize(parameters);

        //MOTOARE LIFT
        lift1 = (DcMotor) opMode.hardwareMap.get("lift1");
        lift2 = (DcMotor) opMode.hardwareMap.get("lift2");

        lift1.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);
        lift2.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        lift1.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        lift1.setDirection(DcMotor.Direction.REVERSE);

        lift2.setMode(DcMotor.RunMode.RUN_USING_ENCODER);



        //servo cleste
        intake1 = (Servo) opMode.hardwareMap.get("intake1");
        intake2 = (Servo) opMode.hardwareMap.get("intake2");
        rotire = (Servo) opMode.hardwareMap.get("rotire");

        //motor brat
        brat = (DcMotor) opMode.hardwareMap.get("brat");
        brat.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        brat.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        mecanum = new SampleMecanumDrive(opMode.hardwareMap);
        mecanum.setZeroPowerBehavior(DcMotor.ZeroPowerBehavior.BRAKE);

        if (auto) {
            lift1.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            lift2.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

            brat.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        }

        //Flag-ul ce macheza initializarea hardwareului
        initializat = true;
        opMode.telemetry.addData("Hardware initializat: ", initializat);
    }
}
