package org.firstinspires.ftc.teamcode.stef.opmodes;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.teamcode.stef.resurse.SGamepad;
import org.firstinspires.ftc.teamcode.stef.resurse.SHardware;
import org.firstinspires.ftc.teamcode.stef.resurse.drives.Brat;
import org.firstinspires.ftc.teamcode.stef.resurse.drives.Field_Centric_Drive;
import org.firstinspires.ftc.teamcode.stef.resurse.drives.Giroscop;
import org.firstinspires.ftc.teamcode.stef.resurse.drives.Intake;
import org.firstinspires.ftc.teamcode.stef.resurse.drives.Lift;



@TeleOp(name = "NewTeleop")
public class Test extends LinearOpMode {


    public static Servo intakeD , intakeS;
    @Override
    public void runOpMode() throws InterruptedException {

        intakeD = (Servo) hardwareMap.get("intakeD");
        intakeS = (Servo) hardwareMap.get("intakeS");


        waitForStart();

        if (isStopRequested()) return;

        while (opModeIsActive()){
        if(gamepad1.left_stick_y > 0.1 || gamepad1.left_stick_y < -0.1)
            intakeD.setPosition(gamepad1.left_stick_y);
            intakeS.setPosition(-gamepad1.left_stick_y);


        }


    }
}