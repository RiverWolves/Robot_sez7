package org.firstinspires.ftc.teamcode.stef.resurse.drives;

import com.qualcomm.hardware.bosch.BNO055IMU;
import com.qualcomm.robotcore.hardware.IMU;

import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.teamcode.stef.resurse.SHardware;

public class Field_Centric_Drive {

    public static IMU imu = null;
    public static double rotx, roty;

    public static void init(){
        if (!SHardware.initializat) return;

        imu = SHardware.imu;
    }

    public static void loop(double x, double y, boolean resetyaw){

        if (resetyaw) {
            imu.resetYaw();
        }

        double botHeading = imu.getRobotYawPitchRollAngles().getYaw(AngleUnit.RADIANS);
        rotx = x * Math.cos(-botHeading) - y * Math.sin(-botHeading);
        roty = x * Math.sin(-botHeading) + y * Math.cos(-botHeading);

    }
}
