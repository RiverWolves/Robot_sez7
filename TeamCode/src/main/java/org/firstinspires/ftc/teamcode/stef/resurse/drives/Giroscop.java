package org.firstinspires.ftc.teamcode.stef.resurse.drives;


import com.qualcomm.robotcore.hardware.IMU;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.teamcode.stef.resurse.SHardware;

public class Giroscop {

    public static IMU imu = null;
    public static int unghi_y = 0;
    public static boolean drept = true;

    public static void init() {
        imu = SHardware.imu;
    }

    public static void loop() {
        unghi_y = (int) imu.getRobotYawPitchRollAngles().getPitch(AngleUnit.DEGREES);

        drept = Math.abs(unghi_y) < 10;
    }

}


