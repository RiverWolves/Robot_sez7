package org.firstinspires.ftc.teamcode.stef.resurse.drives;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.teamcode.stef.resurse.SHardware;

public class Brat {

    private static DcMotor brat = null;
    private static boolean in;
    private static int target = 0;

    public static void init(){
        if(!SHardware.initializat) return;
        brat = SHardware.brat;
        brat.setPower(0);
    }

    public static void loop(){
        if (!in) { brat_fata(); }
        else { brat_spate(); }

        brat.setTargetPosition(target);
        brat.setPower(0.4);
        brat.setMode(DcMotor.RunMode.RUN_TO_POSITION);
    }

    public static int poz(){
        return brat.getCurrentPosition();
    }

    public static void input(boolean buton) {
        in = buton;
    }

    public static void brat_fata() {
        target = 650;
    }

    public static void brat_spate() {
        target = -650;
    }
}
