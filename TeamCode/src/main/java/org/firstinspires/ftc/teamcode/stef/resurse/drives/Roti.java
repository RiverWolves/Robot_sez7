package org.firstinspires.ftc.teamcode.stef.resurse.drives;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.teamcode.stef.resurse.SHardware;

public class Roti {

    public static double[] puteri = {0,0,0};//respectiv x, y ,r(rotatie)

    public static void loop(OpMode opMode){

        //luam elementele si le punem in variabile
        double x = -puteri[0];
        double y = puteri[1];
        double r = -puteri[2];

        if(x == Double.NaN)
            x=0;

        opMode.telemetry.addData("puteri",x+" - "+y+" - "+r);

        //facem un normalizator ca sa nu treaca suma puterilor de 1
        double normalizator = Math.max(Math.abs(y) + Math.abs(x) + Math.abs(r), 1);

        //aplicam formula mecanum cu numalizatorul
        double sf = (y + x + r) / normalizator;
        double ss = (y - x + r) / normalizator;
        double df = (y - x - r) / normalizator;
        double ds = (y + x - r) / normalizator;

        opMode.telemetry.addData("puteriSF",sf);
        opMode.telemetry.addData("puteriSS",ss);
        opMode.telemetry.addData("puteriDF",df);
        opMode.telemetry.addData("puteriDS",ds);

        //daca hardware-ul este initializat, setam puterile
        //in caz contrar, e posibil sa dea erori!
        if(SHardware.initializat){
            SHardware.ss.setPower(ss);
            SHardware.sf.setPower(sf);
            SHardware.ds.setPower(ds);
            SHardware.df.setPower(df);
        }
    }

    public static void setVelXYR(double x, double y, double r){
        puteri[0] = x;
        puteri[1] = y;
        puteri[2] = r;
    }

    public static void setVelXY(double x, double y){
        puteri[0] = x;
        puteri[1] = y;
    }

    public static void setVelX(double x){
        puteri[0] = x;
    }

    public static void setVelY(double y){
        puteri[1] = y;
    }

    public static void setVelR(double r){
        puteri[2] = r;
    }

    public static void setVelPolar(double putere, double unghi, AngleUnit angleUnit){
        if(angleUnit == AngleUnit.DEGREES)
            unghi = angleUnit.toRadians(unghi);
        puteri[0] = (double) Math.cos(unghi) * putere;
        puteri[1] = (double) Math.sin(unghi) * putere;
    }


}
