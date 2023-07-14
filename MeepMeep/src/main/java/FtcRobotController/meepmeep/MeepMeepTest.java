package FtcRobotController.meepmeep;

import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.acmerobotics.roadrunner.geometry.Vector2d;
import com.noahbres.meepmeep.MeepMeep;
import com.noahbres.meepmeep.roadrunner.DefaultBotBuilder;
import com.noahbres.meepmeep.roadrunner.entity.RoadRunnerBotEntity;
import com.noahbres.meepmeep.roadrunner.trajectorysequence.TrajectorySequence;

public class MeepMeepTest {

    public static Pose2d A = new Pose2d(     36,    -60 , Math.toRadians(270));
    public static Vector2d B = new Vector2d( 36,    -40 ); public  static double BU = Math.toRadians(90); // BU = Unghiul B
    public static Vector2d C = new Vector2d( 29.5, -11.8 ); public  static double CU = Math.toRadians(100);
    public static Vector2d CP = new Vector2d(35.5, -8.75); public  static double CUP = Math.toRadians(130);
    public static Vector2d D = new Vector2d( 55,    -12.7 ); public  static double DU = Math.toRadians(0);
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
                                   /* Brat.power = 1 ;
                                    //se inchide
                                    Intake.setInchis2in1(true,this);
                                    //ne asiguram ca sta in pozitia aia
                                    Intake.setRotire2in1(true,this);
                                    //uraca liftul
                                    Lift.setLiftLevel(3);
                                    //se da peste cap
                                    Brat.setRotireFata(false);*/
                                })
                                .splineTo(B,BU)

                                .splineTo(C, CU) //Ajunge la stalp

                                .UNSTABLE_addTemporalMarkerOffset(0.3, () ->{  //deschide clestele?????
                                   /* //se coboara
                                    Lift.setLiftLevel(4);
                                    //se deschide
                                    Intake.setInchis2in1(false,this);*/

                                })
                                .waitSeconds(0.5)
                                .setReversed(false)
                                .addDisplacementMarker( () -> {/*
                                    //se inchide
                                    Intake.setInchis2in1(true,this);
                                    //se da peste cap
                                    Brat.setRotireFata(true);
                                    //se coboara
                                    Lift.setLiftLevel(level);*/

                                })
                                .UNSTABLE_addTemporalMarkerOffset(0.5,() ->{
                              /*      //se roteste
                                    Intake.setRotire2in1(false,this);
                                    //se deschide
                                    Intake.setInchis2in1(false,this);*/
                                })
                                .splineTo(D,DU)

                                .splineTo(E, EU) //Ajunge la turnul de conuri
                                .UNSTABLE_addTemporalMarkerOffset(0, () -> {
                                    /*//se inchide
                                    Intake.setInchis2in1(true,this);*/

                                })
                                .UNSTABLE_addTemporalMarkerOffset(0.1, () -> {

                                  /*  //se ridica
                                    Lift.setLiftLevel(1);*/

                                })
                                .waitSeconds(0.3)
                                .setReversed(true)
                                .lineTo(D)
                                .addDisplacementMarker(() ->{
                                    /*//se ridica
                                    Lift.setLiftLevel(4);
                                    //se roteste
                                    Intake.setRotire2in1(true, this);*/

                                })
                                .UNSTABLE_addTemporalMarkerOffset(0.2, () ->{
                                    //se da peste cap
//                                    Brat.setRotireFata(false);
                                })
                                .splineTo(CP,CUP)

                                .UNSTABLE_addTemporalMarkerOffset(0.1, () ->{

                                    //deschide clestele
//                                    Intake.setInchis2in1(false,this);
                                })

                                .waitSeconds(0.3)

                                .build());





        meepMeep.setBackground(MeepMeep.Background.FIELD_POWERPLAY_OFFICIAL)
                .setDarkMode(true)
                .setBackgroundAlpha(0.95f)
                .addEntity(myBot)
                .start();
    }
}