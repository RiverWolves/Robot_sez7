package org.firstinspires.ftc.teamcode.stef.resurse.drives;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.teamcode.stef.resurse.SHardware;

public class  Brat {
    public static float power = 1;
    private static DcMotor brat = null;
    private static boolean in;
    private static int target = 0;

    public static void init(boolean isAutonomie){
        if(!SHardware.initializat) return;

        brat = SHardware.brat;
        if (isAutonomie) {

        }
        brat.setMode(DcMotor.RunMode.RUN_TO_POSITION);
    }

    public static void loop(){
        if (!in) { brat_fata(); }
        else { brat_spate(); }

        brat.setTargetPosition(target);
        brat.setPower(power);
        brat.setMode(DcMotor.RunMode.RUN_TO_POSITION);
    }

    public static int poz(){
        return brat.getCurrentPosition();
    }

    public static void input(boolean buton) {
        in = buton;
    } //false= spate true = fata
    public static void setRotireFata(boolean stare){
        in = stare;
        loop();
    }

    public static void brat_fata() {
        target = 650;
    }

    public static void brat_spate() {
        target = -650;
    }
}
