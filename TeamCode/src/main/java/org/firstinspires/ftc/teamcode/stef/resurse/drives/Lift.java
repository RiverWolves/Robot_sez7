package org.firstinspires.ftc.teamcode.stef.resurse.drives;

import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;

import org.firstinspires.ftc.teamcode.stef.resurse.SHardware;

public class Lift {

    public static final int LIMITARE_SUS_LIFT = 6800,
                            NIVEL_00 = 0,
                            NIVEL_0 = 200,
                            NIVEL_1 = 2500,
                            NIVEL_2 = 4400,
                            NIVEL_3 = 6800;

    private static final float LIMITARE_JOS_LIFT = 0;
    private static float y = 0;
    private static float putere = 1;
    private static float pow_nivel = 0.4f;
    public static float pozitie_lift = 0;

    private static DcMotor lift1 = null,
                           lift2 = null;

    public static boolean enivel = false,
            nivel0 = false,
            nivel1 = false,
            nivel2 = false,
            nivel3 = false;

    public static int nivel = 0,
                      target = 1;

    public static  void init() {
        if (!SHardware.initializat) {
            return;
        }
        if (lift1 == null) {
            lift1 = SHardware.lift1;
        }
        if (lift2 == null) {
            lift2 = SHardware.lift2;
        }

        lift1.setTargetPosition(0);
        lift2.setTargetPosition(0);
        lift1.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        lift2.setMode(DcMotor.RunMode.RUN_TO_POSITION);
    }

    public static void loop(OpMode opMode) {
        float input = y;
        pozitie_lift = lift1.getCurrentPosition();

        if (input > 0.3f && pozitie_lift < LIMITARE_SUS_LIFT) {
            putere = 1;
        }
        else if (input < -0.3f && pozitie_lift > LIMITARE_JOS_LIFT) {
           putere = -1;
        }
        else {
            putere = 0;
        }

        putere = Ceva.fineControl(opMode.gamepad2.left_bumper, putere);

        if (input != 0) {
            lift1.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
            lift2.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

            lift1.setPower(putere);
            lift2.setPower(putere);
        }


        if (input > 0.3f && pozitie_lift >= LIMITARE_SUS_LIFT){
            Ceva.rumble(opMode.gamepad2);
        }
        else if (input < -0.3f && pozitie_lift <= LIMITARE_JOS_LIFT){
            Ceva.rumble(opMode.gamepad2);
        }

        opMode.telemetry.addData("input lift: ", input);
        opMode.telemetry.addData("pozitie lift: ", pozitie_lift);
    }

    public static void nivelLoop(OpMode opMode) {
        int poz_lift = lift1.getCurrentPosition();

        if (nivel0){
            nivel = 0;
        }
        else if (nivel1){
            nivel = 1;
        }
        else if (nivel2){
            nivel = 2;
        }
        else if (nivel3){
            nivel = 3;
        }

        if (y == 0) {
            if (nivel0) {
                target = NIVEL_0;
                pow_nivel = 1;
            }
            else if (nivel1) {
                target = NIVEL_1;
                pow_nivel = 1;
            }
            else if (nivel2) {
                target = NIVEL_2;
                pow_nivel = 1;
            }
            else if (nivel3) {
                target = NIVEL_3;
                pow_nivel = 1;
            }
        }
        else {
            target = 0;
            pow_nivel = 0;
        }

        lift1.setTargetPosition(target);
        lift2.setTargetPosition(target);

        if (y == 0) {
            lift1.setPower(pow_nivel);
            lift2.setPower(pow_nivel);

            lift1.setMode(DcMotor.RunMode.RUN_TO_POSITION);
            lift2.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        }

        if (poz_lift <= target+10 && poz_lift >= target-10){
            pow_nivel = 0;
            enivel = true;
        }
        else {
            enivel = false;
        }

        if (poz_lift <= target+10 && poz_lift >= target-10 && lift1.getPower() != 0){
            Ceva.rumble(opMode.gamepad2);
        }

        opMode.telemetry.addData("putere", lift2.getPower());
        opMode.telemetry.addData("putere: ", lift1.getPower());
        opMode.telemetry.addData("nivel: ", nivel);
        opMode.telemetry.addData("Este nivel: ", enivel);
    }

    public static void setLiftLevel(int nivel) {
        int target_position = 0, lift_power_level = 1;

        switch (nivel) {
            case 0:
                target_position = Lift.NIVEL_00;
                break;

            case 1:
                target_position = Lift.NIVEL_1;
                break;

            case 2:
                target_position = Lift.NIVEL_2;
                break;

            case 3:
                target_position = Lift.NIVEL_3;
                break;
        }

        lift1.setTargetPosition(target_position);
        lift2.setTargetPosition(target_position);

        lift1.setPower(lift_power_level);
        lift2.setPower(lift_power_level);

        lift1.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        lift2.setMode(DcMotor.RunMode.RUN_TO_POSITION);
    }

    public static void setVal(float stick, boolean bool0, boolean bool1, boolean bool2, boolean bool3) {
        nivel0 = bool0;
        nivel1 = bool1;
        nivel2 = bool2;
        nivel3 = bool3;
        y = stick;
    }

    public static float getPoz() {
        return pozitie_lift;
    }

    public static void setNivel(int nivel) {
        if(nivel == 0){
            nivel0 = true;
        }
        else if(nivel == 1){
            nivel1 = true;
        }
        else if(nivel == 2){
            nivel2 = true;
        }
        else if(nivel == 3){
            nivel3 = true;
        }
    }
}

