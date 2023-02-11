package org.firstinspires.ftc.teamcode.stef.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.teamcode.stef.resurse.SHardware;
import org.firstinspires.ftc.teamcode.stef.resurse.drives.Brat;
import org.firstinspires.ftc.teamcode.stef.resurse.drives.Intake;

@TeleOp ( name = "teleop test")
public class TestTeleop extends LinearOpMode {

    public static Servo intake, rotire;

    @Override
    public void runOpMode() throws InterruptedException {

        SHardware.init(this, false);
        Brat.init();

        waitForStart();

        if (isStopRequested()) return;


        while (opModeIsActive()){
            Brat.loop(this);

            Brat.input(gamepad1.right_bumper);

            telemetry.update();

//            Intake.inchis = Ceva.buttonToSwich(gamepad1.right_bumper);
//            Intake.rotit = Ceva.buttonToSwich(gamepad1.left_bumper);

        }



    }
}
