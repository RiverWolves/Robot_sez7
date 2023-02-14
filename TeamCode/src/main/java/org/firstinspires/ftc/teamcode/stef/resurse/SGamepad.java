package org.firstinspires.ftc.teamcode.stef.resurse;

import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.Gamepad;

import org.firstinspires.ftc.teamcode.drive.SampleMecanumDrive;
import org.firstinspires.ftc.teamcode.stef.resurse.drives.Brat;
import org.firstinspires.ftc.teamcode.stef.resurse.drives.Giroscop;
import org.firstinspires.ftc.teamcode.stef.resurse.drives.Intake;
import org.firstinspires.ftc.teamcode.stef.resurse.drives.Lift;
import org.firstinspires.ftc.teamcode.stef.resurse.drives.Util;


public class SGamepad {
    private static float x, y, r, putere_lift;
    private static boolean fc_roti, buton1, buton2;
    private static Util inchis, rotit, roti, lift;

    private static SampleMecanumDrive mecanum = null;

    public static void init() {
        x = 0;
        y = 0;
        r = 0;
        putere_lift = 0;

        fc_roti = false;
        inchis = new Util();
        rotit = new Util();
        roti = new Util();
        lift = new Util();
    }

    public static void loop(OpMode opMode) {

        mecanum = SHardware.mecanum;

        Gamepad gamepad1 = opMode.gamepad1;
        Gamepad gamepad2 = opMode.gamepad2;
           //conditie fine control roti

        //Roti
        fc_roti = gamepad1.left_bumper;

        y = roti.fineControl(fc_roti, -gamepad1.left_stick_x);            //setam puterea lui x
        x = roti.fineControl(fc_roti, -gamepad1.left_stick_y);           //setam puterea lui y
        r = roti.fineControl(fc_roti, -gamepad1.right_stick_x);         //setam puterea lui r


        if (Giroscop.drept) {
            mecanum.setWeightedDrivePower(
                    new Pose2d(x, y, r)
            );
        } else {
            mecanum.setWeightedDrivePower(
                    new Pose2d(-0.3*x, -0.3*y, r)
            );
        }



        //Lift
        putere_lift = lift.fineControl(gamepad2.right_bumper, -gamepad2.left_stick_y);
        Lift.setVal(putere_lift,     //atribuim stick-ul
                gamepad2.dpad_down,            //nivel 0
                gamepad2.dpad_right,           //nivel 1
                gamepad2.dpad_up,              //nivel 2
                gamepad2.dpad_left             //nivel 3
        );

        //Intake + Brat

        //Safety mode brat
        if(Lift.getPoz() > 1200){
            buton2 = rotit.buttonToSwich(gamepad2.right_bumper);
        }else {
            buton2 = false;
        }

        //Safetey mode rotire cleste
        buton1 = inchis.buttonToSwich(gamepad2.x);

        if(Brat.poz() < 400 && Brat.poz() > 100){
            buton1 = false;
        }

        Intake.setInchis(buton1);
        Brat.input(!buton2);
        Intake.setRotire(!buton2);
    }
}