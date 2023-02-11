package org.firstinspires.ftc.teamcode.stef.opmodes;


import com.qualcomm.hardware.rev.RevHubOrientationOnRobot;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.IMU;
import com.qualcomm.robotcore.hardware.ImuOrientationOnRobot;
import org.firstinspires.ftc.robotcore.external.navigation.Quaternion;

@TeleOp(name = "gyro")
public class Giroscop extends OpMode {

    public static IMU imu;
    public static RevHubOrientationOnRobot orientare = new RevHubOrientationOnRobot(
            RevHubOrientationOnRobot.LogoFacingDirection.DOWN,
            RevHubOrientationOnRobot.UsbFacingDirection.BACKWARD
    );
    private ImuOrientationOnRobot ImuOrientationOnRobot = new ImuOrientationOnRobot() {
        @Override
        public Quaternion imuCoordinateSystemOrientationFromPerspectiveOfRobot() {
            return null;
        }

        @Override
        public Quaternion imuRotationOffset() {
            return null;
        }

        @Override
        public Quaternion angularVelocityTransform() {
            return null;
        }
    };




    @Override
    public void init() {
        IMU.Parameters parametrii = new IMU.Parameters( ImuOrientationOnRobot =  orientare );

        imu.initialize(parametrii);

    }

    @Override
    public void loop() {

    }

}


