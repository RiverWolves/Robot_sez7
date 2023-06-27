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

@Autonomous( name = "AutonomieDreaptaNew" )
public class DAutonomieNew extends LinearOpMode {
    public static Pose2d A = new Pose2d(36,-60 , Math.toRadians(270));
    public static Vector2d B = new Vector2d(36,-24 ); public  static double BU = Math.toRadians(270); // BU = Unghiul B
    public static Vector2d C = new Vector2d(28.81,-10.6 ); public  static double CU = Math.toRadians(116);
    public static Vector2d CP = new Vector2d(30.91,-11.93 ); public  static double CUP = Math.toRadians(112);
    public static Vector2d D = new Vector2d(48,-12.7 ); public  static double DU = Math.toRadians(0);
    public static Vector2d E = new Vector2d(60,-12.7 ); public  static double EU = Math.toRadians(0);
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

        TrajectorySequence TraiectorieStanga = drive.trajectorySequenceBuilder(A)
                .setReversed(true)
                .addDisplacementMarker(()->{
                    //Brat dat peste cap
                    Intake.setInchis2in1(true,this);
                    Brat.setRotireFata(false);
                    Lift.setLiftLevel(3);
                })
                .lineTo(B)
                 .addDisplacementMarker( () -> {
                      Intake.setRotire2in1(true,this);
                 })
                .splineTo(C, CU) //Ajunge la stalp
                 .UNSTABLE_addTemporalMarkerOffset(0, () ->{  //deschide clestele?????
                     Intake.setInchis2in1(false,this);
                 })
                .waitSeconds(0.3)
                //Incepe loop de la turn
                .setReversed(false)
                 .addDisplacementMarker( () -> {
                   Intake.setInchis2in1(true,this);
                   Lift.setLiftLevel(10);
                   //Brat dat peste cap
                   Intake.setRotire2in1(false,this);
                   Brat.setRotireFata(true);
                   Intake.setInchis2in1(false,this);
                 })
                .splineTo(D,DU)
                .splineTo(E, EU) //Ajunge la turnul de conuri
                .UNSTABLE_addTemporalMarkerOffset(0, () -> {
                   Intake.setInchis2in1(true,this);
//                   Lift.setLiftLevel(1);
               })
                .UNSTABLE_addTemporalMarkerOffset(0.2, () -> {

                   Lift.setLiftLevel(1);
                   Brat.setRotireFata(false);
                })
                .waitSeconds(0.5)
                .setReversed(true)
                .lineTo(D)
                .addDisplacementMarker(() ->{
                    Lift.setLiftLevel(3);
                    //Brat dat peste cap
                    Intake.setRotire2in1(true,this);

                })
                .splineTo(CP,CUP)
                 .UNSTABLE_addTemporalMarkerOffset(0, () ->{  //deschide clestele?????
                   Intake.setInchis2in1(false,this);
               })
                .waitSeconds(0.5)
                .setReversed(false)

                .setReversed(false)
                .addDisplacementMarker( () -> {
                    Intake.setInchis2in1(true,this);
                    Lift.setLiftLevel(20);
                    //Brat dat peste cap
                    Intake.setRotire2in1(false,this);
                    Brat.setRotireFata(true);
                    Intake.setInchis2in1(false,this);
                })
                .splineTo(D,DU)
                .splineTo(E, EU) //Ajunge la turnul de conuri
                .UNSTABLE_addTemporalMarkerOffset(0, () -> {
                    Intake.setInchis2in1(true,this);
//                   Lift.setLiftLevel(1);
                })
                .UNSTABLE_addTemporalMarkerOffset(0.2, () -> {

                    Lift.setLiftLevel(1);
                    Brat.setRotireFata(false);
                })
                .waitSeconds(0.5)
                .setReversed(true)
                .lineTo(D)
                .addDisplacementMarker(() ->{
                    Lift.setLiftLevel(3);
                    //Brat dat peste cap
                    Intake.setRotire2in1(true,this);

                })
                .splineTo(CP,CUP)
                .UNSTABLE_addTemporalMarkerOffset(0, () ->{  //deschide clestele?????
                    Intake.setInchis2in1(false,this);
                })
                .waitSeconds(0.5)
                .setReversed(false)

                .setReversed(false)
                .addDisplacementMarker( () -> {
                    Intake.setInchis2in1(true,this);
                    Lift.setLiftLevel(30);
                    //Brat dat peste cap
                    Intake.setRotire2in1(false,this);
                    Brat.setRotireFata(true);
                    Intake.setInchis2in1(false,this);
                })
                .splineTo(D,DU)
                .splineTo(E, EU) //Ajunge la turnul de conuri
                .UNSTABLE_addTemporalMarkerOffset(0, () -> {
                    Intake.setInchis2in1(true,this);
//                   Lift.setLiftLevel(1);
                })
                .UNSTABLE_addTemporalMarkerOffset(0.2, () -> {

                    Lift.setLiftLevel(1);
                    Brat.setRotireFata(false);
                })
                .waitSeconds(0.5)
                .setReversed(true)
                .lineTo(D)
                .addDisplacementMarker(() ->{
                    Lift.setLiftLevel(3);
                    //Brat dat peste cap
                    Intake.setRotire2in1(true,this);

                })
                .splineTo(CP,CUP)
                .UNSTABLE_addTemporalMarkerOffset(0, () ->{  //deschide clestele?????
                    Intake.setInchis2in1(false,this);
                })
                .waitSeconds(0.5)
                .setReversed(false)

                .setReversed(false)
                .addDisplacementMarker( () -> {
                    Intake.setInchis2in1(true,this);
                    Lift.setLiftLevel(40);
                    //Brat dat peste cap
                    Intake.setRotire2in1(false,this);
                    Brat.setRotireFata(true);
                    Intake.setInchis2in1(false,this);
                })
                .splineTo(D,DU)
                .splineTo(E, EU) //Ajunge la turnul de conuri
                .UNSTABLE_addTemporalMarkerOffset(0, () -> {
                    Intake.setInchis2in1(true,this);
//                   Lift.setLiftLevel(1);
                })
                .UNSTABLE_addTemporalMarkerOffset(0.2, () -> {
                    Lift.setLiftLevel(1);
                    Brat.setRotireFata(false);
                })
                .waitSeconds(0.5)
                .setReversed(true)
                .lineTo(D)
                .addDisplacementMarker(() ->{
                    Lift.setLiftLevel(3);
                    //Brat dat peste cap
                    Intake.setRotire2in1(true,this);

                })
                .splineTo(CP,CUP)
                .UNSTABLE_addTemporalMarkerOffset(0, () ->{  //deschide clestele?????
                    Intake.setInchis2in1(false,this);
                })
//                .waitSeconds(0.5)
                .setReversed(false)

                .build();


        TrajectorySequence third = drive.trajectorySequenceBuilder(TraiectorieStanga.end())

                .addTemporalMarker(() ->{

                    Intake.setInchis(true);
                    Intake.loop(this);
                })
                .waitSeconds(1)
                .addTemporalMarker(()->{
                    Intake.setInchis(false);
                    Intake.loop(this);
                })
                .waitSeconds(0.5)
                .addDisplacementMarker(() ->{
                    Intake.setRotire(true);
                    Intake.loop(this);

                    Brat.input(true);
                    Brat.loop();

                    Lift.setLiftLevel(0);
                })
                .splineTo(new Vector2d(35, -13), Math.toRadians(0))
                .addDisplacementMarker(()->{
                    Intake.setInchis(true);
                    Intake.loop(this);
                })
                .lineTo(new Vector2d(60, -13))
                .build();

        TrajectorySequence second = drive.trajectorySequenceBuilder(TraiectorieStanga.end())

                .addTemporalMarker(() ->{

                    Intake.setInchis(true);
                    Intake.loop(this);
                })
                .waitSeconds(1.5)
                .addTemporalMarker(()->{
                    Intake.setInchis(false);
                    Intake.loop(this);
                })
                .waitSeconds(0.5)
                .addDisplacementMarker(() ->{
                    Intake.setRotire(true);
                    Intake.loop(this);

                    Brat.input(true);
                    Brat.loop();

                    Lift.setLiftLevel(0);
                })
                .splineTo(new Vector2d(35, -16), Math.toRadians(0))

                .waitSeconds(10)

                .build();

        TrajectorySequence first = drive.trajectorySequenceBuilder(TraiectorieStanga.end())

                .addDisplacementMarker(()-> {
                    Intake.setInchis2in1(true, this);
                    Brat.setRotireFata(true);
                    Intake.setRotire2in1(false, this);
                    Lift.setLiftLevel(10);
                })
                .splineTo(new Vector2d(35, -16), Math.toRadians(0))
                .addDisplacementMarker(()->{
                    Intake.setInchis2in1(false, this);
                })
                .lineTo(new Vector2d(12,-16))
                .waitSeconds(10)
                .build();


        while (opModeInInit()){
            TagBase.update(this);
            telemetry.addData("id", TagBase.tag());
            telemetry.update();
        }



        waitForStart();

        et.reset();

        if (opModeIsActive()){



            drive.followTrajectorySequence(TraiectorieStanga);

           /* drive.followTrajectorySequence(principala2);*/


            switch (TagBase.tag()){
                case 2:
                    drive.followTrajectorySequence(first);
                    break;
                case 1:
                    drive.followTrajectorySequence(second);
                    break;
                case 3:
                    drive.followTrajectorySequence(third);
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
