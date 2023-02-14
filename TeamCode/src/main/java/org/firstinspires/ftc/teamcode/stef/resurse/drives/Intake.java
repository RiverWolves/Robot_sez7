    package org.firstinspires.ftc.teamcode.stef.resurse.drives;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.teamcode.stef.resurse.SHardware;

public class Intake {

    private static Servo intake1, intake2, rotire = null;
    public static boolean inchis;
    public static boolean rotit;

    public static void init(){
        if (!SHardware.initializat) return;
//
        inchis = false;
        rotit = true;

        intake1 = SHardware.intake1;
        intake2 = SHardware.intake2;
        rotire = SHardware.rotire;

        intake1.setPosition(0);
        intake2.setPosition(1);
        rotire.setPosition(0);
    }

    public static void loop(OpMode opMode){

        boolean einchis = inchis;
        boolean erotit = rotit;

        if (einchis) {
//            intake.setPosition(Ceva.servoToDegrees(300));
            intake1.setPosition(0.1);
            intake2.setPosition(0.9);
        }else {

//            intake.setPosition(Ceva.servoToDegrees(250));
            intake1.setPosition(0);
            intake2.setPosition(1);
        }

        if (erotit) {
//            rotire.setPosition(Ceva.servoToDegrees(180));
            rotire.setPosition(0);
        }else {
//            rotire.setPosition(Ceva.servoToDegrees(0));
            rotire.setPosition(0.68);
        }


        opMode.telemetry.addData("intake", einchis);
        opMode.telemetry.addData("rotire", rotire.getPosition());

    }



    public static void setInchis(boolean stare){
        inchis = stare;
    }
    public static void setRotire(boolean stare){
        rotit = stare;
    }
}
