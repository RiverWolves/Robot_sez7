package org.firstinspires.ftc.teamcode.stef.resurse;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.Gamepad;

import org.firstinspires.ftc.teamcode.stef.resurse.drives.Brat;
import org.firstinspires.ftc.teamcode.stef.resurse.drives.Ceva;
import org.firstinspires.ftc.teamcode.stef.resurse.drives.Intake;
import org.firstinspires.ftc.teamcode.stef.resurse.drives.Lift;
import org.firstinspires.ftc.teamcode.stef.resurse.drives.Roti;


public class SGamepad {
    private static float x, y, r, putere_lift;
    private static boolean fc_roti,
            fc_lift;

    private static Ceva inchis, rotit = null;



    public static void init() {
        x = 0;
        y = 0;
        r = 0;
        putere_lift = 0;

        fc_roti = false;
        fc_lift = false;
        inchis = new Ceva();
        rotit = new Ceva();

    }

    public static void loop(OpMode opMode) {

        Gamepad gamepad1 = opMode.gamepad1;
        Gamepad gamepad2 = opMode.gamepad2;
        fc_lift = gamepad2.left_bumper;    //conditie fine control lift
        fc_roti = gamepad1.left_bumper;   //conditie fine control roti
        putere_lift = -gamepad2.left_stick_y;

        //Roti
        x = Ceva.fineControl(fc_roti, gamepad1.left_stick_x);            //setam puterea lui x
        y = Ceva.fineControl(fc_roti, gamepad1.left_stick_y);           //setam puterea lui y
        r = Ceva.fineControl(fc_roti, gamepad1.right_stick_x);         //setam puterea lui r
        Roti.setVelXYR(x, y, r);


     /*   STeleop.mecanum.setWeightedDrivePower(new Pose2d(
                x,
                y,
                Math.toRadians(Ceva.mapF(r, -1, 1, -90, 90)))
        );//atribuim puterile(x, y, r)

        STeleop.mecanum.setWeightedDrivePower(new Pose2d(
                -gamepad1.left_stick_y,
                -gamepad1.left_stick_x,
                -gamepad1.right_stick_x
                )
        );


      */

        //Lift
        Lift.setVal(putere_lift,     //atribuim stick-ul
                gamepad2.dpad_down,            //nivel 0
                gamepad2.dpad_right,           //nivel 1
                gamepad2.dpad_up,              //nivel 2
                gamepad2.dpad_left             //nivel 3
        );

        //Intake
        boolean buton1 = inchis.buttonToSwich(gamepad2.x); //transformam bumperul in switch
        boolean buton2;

        if(Lift.getPoz() > 800){
            buton2 = rotit.buttonToSwich(gamepad2.right_bumper);
        }else {
            buton2 = true;
        }

        Intake.setInchis(buton1); //setam starea intake-ului
        Brat.input(buton2);
        Intake.setRotire(!buton2);


        //Brat
//        boolean brat = Ceva.buttonToSwich(gamepad2.square);


//        opMode.telemetry.addData("buton ", nivel0);
//        opMode.telemetry.update();

        opMode.telemetry.addData("ceva : ", SHardware.ss.getCurrentPosition()+" "+ SHardware.df.getCurrentPosition()+" "+ SHardware.sf.getCurrentPosition());
    }
}