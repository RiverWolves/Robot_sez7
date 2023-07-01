package FtcRobotController.meepmeep;

import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.acmerobotics.roadrunner.geometry.Vector2d;
import com.noahbres.meepmeep.MeepMeep;
import com.noahbres.meepmeep.roadrunner.DefaultBotBuilder;
import com.noahbres.meepmeep.roadrunner.entity.RoadRunnerBotEntity;
import com.noahbres.meepmeep.roadrunner.trajectorysequence.TrajectorySequence;

public class MeepMeepTest {

    public static Pose2d A = new Pose2d(     36,    -60 , Math.toRadians(270));
    public static Vector2d B = new Vector2d( 36,    -24 ); public  static double BU = Math.toRadians(106); // BU = Unghiul B
    public static Vector2d C = new Vector2d( 29.5, -11.8 ); public  static double CU = Math.toRadians(100);
    public static Vector2d CP = new Vector2d(35, -8.5); public  static double CUP = Math.toRadians(130);
    public static Vector2d D = new Vector2d( 50,    -12.7 ); public  static double DU = Math.toRadians(0);
    public static Vector2d E = new Vector2d( 61   , -12.7 ); public  static double EU = Math.toRadians(0);
    public static void main(String[] args) {
        MeepMeep meepMeep = new MeepMeep(800);

        RoadRunnerBotEntity myBot = new DefaultBotBuilder(meepMeep)
                // Set bot constraints: maxVel, maxAccel, maxAngVel, maxAngAccel, track width
                .setConstraints(45, 35, Math.toRadians(180), Math.toRadians(180), 11.99)
                .followTrajectorySequence(drive ->
                        drive.trajectorySequenceBuilder(A)
                                .setReversed(true)
                                .addDisplacementMarker(()->{
                                    //Brat dat peste cap
                                    /*Intake.setInchis2in1(true,this);
                                    Brat.setRotireFata(false);
                                    Lift.setLiftLevel(3);*/
                                })
                                .splineTo(B,BU)
                                .addDisplacementMarker( () -> {
                                    /*Intake.setRotire2in1(true,this);*/
                                })
                                .splineTo(C, CU) //Ajunge la stalp
                                .UNSTABLE_addTemporalMarkerOffset(0, () ->{  //deschide clestele?????
                                  /*  Intake.setInchis2in1(false,this);*/
                                })
                                .waitSeconds(0.3)
                                //Incepe loop de la turn
                                .setReversed(false)
                                .addDisplacementMarker( () -> {
                                  /*  Intake.setInchis2in1(true,this);
                                    Lift.setLiftLevel(10);
                                    //Brat dat peste cap
                                    Intake.setRotire2in1(false,this);
                                    Brat.setRotireFata(true);
                                    Intake.setInchis2in1(false,this);*/
                                })
                                .splineTo(D,DU)
                                .splineTo(E, EU) //Ajunge la turnul de conuri
                                .UNSTABLE_addTemporalMarkerOffset(0, () -> {
                                  /*  Intake.setInchis2in1(true,this);*/
//                   Lift.setLiftLevel(1);
                                })
                                .UNSTABLE_addTemporalMarkerOffset(0.2, () -> {

                                  /*  Lift.setLiftLevel(1);
                                    Brat.setRotireFata(false);*/
                                })
                                .waitSeconds(0.5)
                                .setReversed(true)
                                .lineTo(D)
                                .addDisplacementMarker(() ->{
                                  /*  Lift.setLiftLevel(3);
                                    //Brat dat peste cap
                                    Intake.setRotire2in1(true,this);*/

                                })
                                .splineTo(CP,CUP)
                                .UNSTABLE_addTemporalMarkerOffset(0, () ->{  //deschide clestele?????
                                   /* Intake.setInchis2in1(false,this);*/
                                })
                                .waitSeconds(0.5)
                                .setReversed(false)

                                .setReversed(false)
                                .addDisplacementMarker( () -> {
                                   /* Intake.setInchis2in1(true,this);
                                    Lift.setLiftLevel(20);
                                    //Brat dat peste cap
                                    Intake.setRotire2in1(false,this);
                                    Brat.setRotireFata(true);
                                    Intake.setInchis2in1(false,this);*/
                                })
                                .splineTo(D,DU)
                                .splineTo(E, EU) //Ajunge la turnul de conuri
                                .UNSTABLE_addTemporalMarkerOffset(0, () -> {
                                    /*Intake.setInchis2in1(true,this);*/
//                   Lift.setLiftLevel(1);
                                })
                                .UNSTABLE_addTemporalMarkerOffset(0.2, () -> {

                                  /*  Lift.setLiftLevel(1);
                                    Brat.setRotireFata(false);*/
                                })
                                .waitSeconds(0.5)
                                .setReversed(true)
                                .lineTo(D)
                                .addDisplacementMarker(() ->{
                                   /* Lift.setLiftLevel(3);
                                    //Brat dat peste cap
                                    Intake.setRotire2in1(true,this);*/

                                })
                                .splineTo(CP,CUP)
                                .UNSTABLE_addTemporalMarkerOffset(0, () ->{  //deschide clestele?????
                                   /* Intake.setInchis2in1(false,this);*/
                                })
                                .waitSeconds(0.5)
                                .setReversed(false)

                                .setReversed(false)
                                .addDisplacementMarker( () -> {
                                    /*Intake.setInchis2in1(true,this);
                                    Lift.setLiftLevel(30);
                                    //Brat dat peste cap
                                    Intake.setRotire2in1(false,this);
                                    Brat.setRotireFata(true);
                                    Intake.setInchis2in1(false,this);*/
                                })
                                .splineTo(D,DU)
                                .splineTo(E, EU) //Ajunge la turnul de conuri
                                .UNSTABLE_addTemporalMarkerOffset(0, () -> {
                                    /*Intake.setInchis2in1(true,this);*/
//                   Lift.setLiftLevel(1);
                                })
                                .UNSTABLE_addTemporalMarkerOffset(0.2, () -> {

                                  /*  Lift.setLiftLevel(1);
                                    Brat.setRotireFata(false);*/
                                })
                                .waitSeconds(0.5)
                                .setReversed(true)
                                .lineTo(D)
                                .addDisplacementMarker(() ->{
                                   /* Lift.setLiftLevel(3);
                                    //Brat dat peste cap
                                    Intake.setRotire2in1(true,this);*/

                                })
                                .splineTo(CP,CUP)
                                .UNSTABLE_addTemporalMarkerOffset(0, () ->{  //deschide clestele?????
                                  /*  Intake.setInchis2in1(false,this);*/
                                })
                                .waitSeconds(0.5)
                                .setReversed(false)

                                .setReversed(false)
                                .addDisplacementMarker( () -> {
                                  /*  Intake.setInchis2in1(true,this);
                                    Lift.setLiftLevel(40);
                                    //Brat dat peste cap
                                    Intake.setRotire2in1(false,this);
                                    Brat.setRotireFata(true);
                                    Intake.setInchis2in1(false,this);*/
                                })
                                .splineTo(D,DU)
                                .splineTo(E, EU) //Ajunge la turnul de conuri
                                .UNSTABLE_addTemporalMarkerOffset(0, () -> {
                                 /*   Intake.setInchis2in1(true,this);*/
//                   Lift.setLiftLevel(1);
                                })
                                .UNSTABLE_addTemporalMarkerOffset(0.2, () -> {
                                   /* Lift.setLiftLevel(1);
                                    Brat.setRotireFata(false);*/
                                })
                                .waitSeconds(0.5)
                                .setReversed(true)
                                .lineTo(D)
                                .addDisplacementMarker(() ->{
                                /*    Lift.setLiftLevel(3);
                                    //Brat dat peste cap
                                    Intake.setRotire2in1(true,this);*/

                                })
                                .splineTo(CP,CUP)
                                .UNSTABLE_addTemporalMarkerOffset(0, () ->{  //deschide clestele?????
                                /*    Intake.setInchis2in1(false,this);*/
                                })
//                .waitSeconds(0.5)
                                .setReversed(false)

                                .build());





        meepMeep.setBackground(MeepMeep.Background.FIELD_POWERPLAY_OFFICIAL)
                .setDarkMode(true)
                .setBackgroundAlpha(0.95f)
                .addEntity(myBot)
                .start();
    }
}