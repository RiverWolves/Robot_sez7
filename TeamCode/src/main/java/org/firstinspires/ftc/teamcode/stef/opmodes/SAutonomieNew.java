package org.firstinspires.ftc.teamcode.stef.opmodes;

import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.acmerobotics.roadrunner.geometry.Vector2d;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.util.ElapsedTime;

import org.firstinspires.ftc.teamcode.drive.SampleMecanumDrive;
import org.firstinspires.ftc.teamcode.stef.resurse.SHardware;
import org.firstinspires.ftc.teamcode.stef.resurse.drives.Brat;
import org.firstinspires.ftc.teamcode.stef.resurse.drives.Intake;
import org.firstinspires.ftc.teamcode.stef.resurse.drives.Lift;
import org.firstinspires.ftc.teamcode.stef.resurse.tag.TagBase;
import org.firstinspires.ftc.teamcode.trajectorysequence.TrajectorySequence;

@Autonomous( name = "Autonomie_StangaNew" )
public class SAutonomieNew extends LinearOpMode {
    public static Pose2d A = new Pose2d(     -36,    -60 , Math.toRadians(270));
    public static Vector2d B = new Vector2d( -36,    -24 ); public  static double BU = Math.toRadians(90-(106-90)); // BU = Unghiul B
    public static Vector2d C = new Vector2d( -29.31, -11.6 ); public  static double CU = Math.toRadians(90-(118-90));
    public static Vector2d CP = new Vector2d(-37, -9.5); public  static double CUP = Math.toRadians(90-(146-90));
    public static Vector2d D = new Vector2d( -50,    -12.7 ); public  static double DU = Math.toRadians(180);
    public static Vector2d E = new Vector2d( -61   , -12.7 ); public  static double EU = Math.toRadians(180);

    public TrajectorySequence get_tr_inceput(SampleMecanumDrive drive){
        return drive.trajectorySequenceBuilder(A)
                .setReversed(true)
                .addDisplacementMarker(()->{
                    //se inchide
                    Intake.setInchis2in1(true,this);
                    //ne asiguram ca sta in pozitia aia
                    Intake.setRotire2in1(true,this);
                    //uraca liftul
                    Lift.setLiftLevel(3);
                    //se da peste cap
                    Brat.setRotireFata(false);
                })
                .splineTo(B,BU)

                .splineTo(C, CU) //Ajunge la stalp

                .UNSTABLE_addTemporalMarkerOffset(0.3, () ->{  //deschide clestele?????
                    //se coboara
                    Lift.setLiftLevel(4);
                    //se deschide
                    Intake.setInchis2in1(false,this);

                })
                .waitSeconds(0.5)
                .build();
    }
    public TrajectorySequence get_tr_loop(SampleMecanumDrive drive, Pose2d pozStart, int level){
        return drive.trajectorySequenceBuilder(pozStart)
                .setReversed(false)
                .addDisplacementMarker( () -> {
                    //se inchide
                    Intake.setInchis2in1(true,this);
                    //se da peste cap
                    Brat.setRotireFata(true);
                    //se coboara
                    Lift.setLiftLevel(level);

                })
                .splineTo(D,DU)
                .addDisplacementMarker(() ->{
                    //se roteste
                    Intake.setRotire2in1(false,this);
                    //se deschide
                    Intake.setInchis2in1(false,this);
                })
                .splineTo(E, EU) //Ajunge la turnul de conuri
                .UNSTABLE_addTemporalMarkerOffset(0, () -> {
                    //se inchide
                    Intake.setInchis2in1(true,this);

                })
                .UNSTABLE_addTemporalMarkerOffset(0.1, () -> {

                    //se ridica
                    Lift.setLiftLevel(1);

                })
                .waitSeconds(0.3)
                .setReversed(true)
                .lineTo(D)
                .addDisplacementMarker(() ->{
                    //se ridica
                    Lift.setLiftLevel(4);
                    //se roteste
                    Intake.setRotire2in1(true, this);

                })
                .UNSTABLE_addTemporalMarkerOffset(0.21, () ->{
                    //se da peste cap
                    Brat.setRotireFata(false);
                })
                .splineTo(CP,CUP)

                .UNSTABLE_addTemporalMarkerOffset(0.3, () ->{

                    //deschide clestele
                    Intake.setInchis2in1(false,this);
                })

                .waitSeconds(0.5)
                .build();
    }


    public TrajectorySequence get_tr_final(SampleMecanumDrive drive, Pose2d pozStart, float pozX){
        return drive.trajectorySequenceBuilder(pozStart)
                .addDisplacementMarker(()-> {
                    Intake.setInchis2in1(true, this);
                    Brat.setRotireFata(true);
                    Intake.setRotire2in1(false, this);
                    Lift.setLiftLevel(10);
                })
                .splineTo(D.minus(new Vector2d(15,0)),DU)

                .lineTo(new Vector2d(pozX, D.getY()))

                .build();
    }


    @Override
    public void runOpMode() throws InterruptedException {
        SHardware.init(this, true);
        Lift.init();
        Intake.init(this, true);
        Brat.init(true);
        TagBase.init(this);
        Intake.setInchis(true);

        ElapsedTime et = new ElapsedTime();

        SampleMecanumDrive drive = new SampleMecanumDrive(hardwareMap);

        drive.setPoseEstimate(A);


        TrajectorySequence tr_inceput = get_tr_inceput(drive);
        TrajectorySequence tr_loop1 = get_tr_loop(drive, tr_inceput.end(), 10);
        TrajectorySequence tr_loop2 = get_tr_loop(drive, tr_loop1.end(), 20);
        TrajectorySequence tr_loop3 = get_tr_loop(drive, tr_loop2.end(), 30);
        TrajectorySequence tr_loop_fin = get_tr_loop(drive, tr_loop3.end(), 40);

        TrajectorySequence tr_fin_dreapta_1 = get_tr_final(drive, tr_loop_fin.end(), -60);
        TrajectorySequence tr_fin_dreapta_2 = get_tr_final(drive, tr_loop_fin.end(), -36);
        TrajectorySequence tr_fin_dreapta_3 = get_tr_final(drive, tr_loop_fin.end(), -12 );
        while (opModeInInit()){
            TagBase.update(this);
            telemetry.addData("id", TagBase.tag());
            telemetry.update();
        }



        waitForStart();

        et.reset();

        if (opModeIsActive()){

            drive.followTrajectorySequence(tr_inceput);
            drive.followTrajectorySequence(tr_loop1);
            drive.followTrajectorySequence(tr_loop2);
            drive.followTrajectorySequence(tr_loop3);
            drive.followTrajectorySequence(tr_loop_fin);

            switch (TagBase.tag()){
                case 1:
                    drive.followTrajectorySequence(tr_fin_dreapta_1);
                    break;
                case 2:
                    drive.followTrajectorySequence(tr_fin_dreapta_2);
                    break;
                case 3:
                    drive.followTrajectorySequence(tr_fin_dreapta_3);
                    break;

            }

            telemetry.addData("sec: ", et.seconds());
            telemetry.update();
        }


        if(isStopRequested()) {
            TagBase.stop();

        }
    }
}