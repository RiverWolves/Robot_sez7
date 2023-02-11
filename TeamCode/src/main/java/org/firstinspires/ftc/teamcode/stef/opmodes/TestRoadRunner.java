package org.firstinspires.ftc.teamcode.stef.opmodes;

import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.acmerobotics.roadrunner.geometry.Vector2d;
import com.acmerobotics.roadrunner.trajectory.Trajectory;
import com.acmerobotics.roadrunner.trajectory.constraints.TankVelocityConstraint;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.drive.SampleMecanumDrive;
import org.firstinspires.ftc.teamcode.stef.resurse.SHardware;
import org.firstinspires.ftc.teamcode.stef.resurse.drives.Brat;
import org.firstinspires.ftc.teamcode.stef.resurse.drives.Intake;
import org.firstinspires.ftc.teamcode.stef.resurse.drives.Lift;
import org.firstinspires.ftc.teamcode.stef.resurse.tag.TagBase;
import org.firstinspires.ftc.teamcode.trajectorysequence.TrajectorySequence;

@TeleOp(name = "test")
public class TestRoadRunner extends LinearOpMode {
    @Override
    public void runOpMode() throws InterruptedException {

        SHardware.init(this, true);
        Lift.init();
        Intake.init();
        Brat.init();
        TagBase.init(this);

        Intake.setInchis(true);

        ElapsedTime et = new ElapsedTime();

        SampleMecanumDrive drive = new SampleMecanumDrive(hardwareMap);

        drive.setPoseEstimate(new Pose2d(-33, -62, Math.toRadians(90)));

        TrajectorySequence traj2 = drive.trajectorySequenceBuilder(new Pose2d(-33, -62, Math.toRadians(90)))
                .forward(2.5)
                .waitSeconds(0.2)
                .addDisplacementMarker( () -> {
                    Intake.setInchis(false);
                    Intake.loop(this);
                    Lift.setLiftLevel(3);
                })
                .strafeRight(25)
                .waitSeconds(0.2)
//                .addDisplacementMarker(()->{
//                    Brat.brat_fata();
//                    Brat.loop(this);
//                })

                .splineTo(new Vector2d(-20, -8.8), Math.toRadians(120) )

                .waitSeconds(0.5)
                .addTemporalMarker(4,  ()->{
                    Intake.setInchis(true);
                    Intake.loop(this);
//                    Lift.setLiftLevel(0);
                })
                .back(4)
                .turn(Math.toRadians(60))
                .waitSeconds(0.5)
                .splineTo(new Vector2d(-62, -12), Math.toRadians(180))
//                .waitSeconds(1)
                .addDisplacementMarker(() ->{
                    Intake.setInchis(false);
                    Intake.loop(this);
                })
                .waitSeconds(0.5)
//                .addDisplacementMarker( () -> {
//
//                    Lift.setLiftLevel(3);
//                })
                .setReversed(true)
                .lineTo(new Vector2d(-47, -12))
                .splineTo(new Vector2d(-31, -12), Math.toRadians(60))
                .setReversed(false)
                .waitSeconds(5)

                .build();

        while (opModeInInit()){
            TagBase.update(this);
        }



        waitForStart();

        et.reset();

        if (opModeIsActive()){
            drive.followTrajectorySequence(traj2);

            telemetry.addData("sec: ", et.seconds());
            telemetry.update();
        }


        if(isStopRequested()) {
            TagBase.stop();
            return;
        }





    }

}
