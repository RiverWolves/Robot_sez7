package org.firstinspires.ftc.teamcode.stef.resurse.drives;

import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.util.ElapsedTime;

public class Util {

     ElapsedTime et, lastDebounceTime;
     boolean buttonState = false;
     boolean debounced = false;

     private static final float constanta = 0.3f;


     public boolean buttonToSwich(boolean buton) {

        if (et == null) {
            et = new ElapsedTime();
            et.reset();
        }
        if (lastDebounceTime == null) {
            lastDebounceTime = new ElapsedTime();
            lastDebounceTime.reset();
        }

        if (buton) {
            lastDebounceTime.reset();
        }
        if ((et.milliseconds() - lastDebounceTime.milliseconds()) > 20) {
            if (buton != buttonState) {
                buttonState = buton;

                if (buttonState) {
                    debounced = !debounced;
                }
                et.reset();
            }
        }

        return debounced;
    }



    public static void rumble(Gamepad gamepad ){
        Gamepad.RumbleEffect rum = new Gamepad.RumbleEffect.Builder()
                .addStep(1, 0.2, 200)
                .addStep(0, 0, 100)
                .addStep(0.2, 1, 200)
                .addStep(0, 0, 600)
                .build();

        gamepad.runRumbleEffect(rum);
    }

    public static float mapF (float x, float in_min, float in_max, float out_min, float out_max) {
        return (x - in_min) * (out_max - out_min) / (in_max - in_min) + out_min;
    }

    public static float servoToDegrees (float degree) {
        float in_min = 0;
        float in_max = 300;
        float out_min = 0;
        float out_max = 1;
        return (degree - in_min) * (out_max - out_min) / (in_max - in_min) + out_min;
    }

    public static float fineControl(boolean conditie, float in) {
        if(conditie){
            return in * constanta;
        }
        return in;
    }

}
