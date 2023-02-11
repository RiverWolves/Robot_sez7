package org.firstinspires.ftc.teamcode.stef.resurse.tag;

import static android.os.SystemClock.sleep;


import com.qualcomm.robotcore.eventloop.opmode.OpMode;

import org.firstinspires.ftc.robotcore.external.hardware.camera.WebcamName;
import org.openftc.apriltag.AprilTagDetection;
import org.openftc.easyopencv.OpenCvCamera;
import org.openftc.easyopencv.OpenCvCameraFactory;
import org.openftc.easyopencv.OpenCvCameraRotation;

import java.util.ArrayList;

public class AutonAprilTagDetection {


    static OpenCvCamera camera;
    static AprilTagDetectionPipeline aprilTagDetectionPipeline;

    static final double FEET_PER_METER = 3.28084;

    // Lens intrinsics
    // UNITS ARE PIXELS
    // NOTE: this calibration is for the C920 webcam at 800x448.
    // You will need to do your own calibration for other configurations!
    static double fx = 578.272;
    static double fy = 578.272;
    static double cx = 402.145;
    static double cy = 221.506;

    // UNITS ARE METERS
    static double tagsize = 0.166;

    int ID_TAG_OF_INTEREST = 18; // Tag ID 18 from the 36h11 family
    static int STANGA = 1;
    static int MIJLOC = 2;
    static int DREAPTA = 3;


    static AprilTagDetection tagOfInterest = null;

    public static void init(OpMode opMode) {

        int cameraMonitorViewId = opMode.hardwareMap.appContext.getResources().getIdentifier("cameraMonitorViewId", "id", opMode.hardwareMap.appContext.getPackageName());
        camera = OpenCvCameraFactory.getInstance().createWebcam(opMode.hardwareMap.get(WebcamName.class, "webcam"), cameraMonitorViewId);
        aprilTagDetectionPipeline = new AprilTagDetectionPipeline(tagsize, fx, fy, cx, cy);

        camera.setPipeline(aprilTagDetectionPipeline);
        camera.openCameraDeviceAsync(new OpenCvCamera.AsyncCameraOpenListener() {
            @Override
            public void onOpened() {
                camera.startStreaming(800, 448, OpenCvCameraRotation.UPRIGHT);
            }

            @Override
            public void onError(int errorCode) {

            }
        });


        /*
         * The INIT-loop:
         * This REPLACES waitForStart!
         */

    }

        /*
         * The START command just came in: now work off the latest snapshot acquired
         * during the init loop.
         */
        public static void loop (OpMode opMode){

            ArrayList<AprilTagDetection> currentDetections = aprilTagDetectionPipeline.getLatestDetections();

            if (currentDetections.size() != 0) {
                boolean tagFound = false;

                for (AprilTagDetection tag : currentDetections) {
                    if (tag.id == STANGA || tag.id == MIJLOC || tag.id == DREAPTA) {
                        tagOfInterest = tag;
                        tagFound = true;
                        break;
                    }
                }


                //telemetry.update();
                sleep(20);
            }
            /* Update the telemetry */
            int parcare;

            /* Actually do something useful */
            if (tagOfInterest.id == STANGA) {
                opMode.telemetry.addLine("Tag stanga");
                opMode.telemetry.update();
                parcare = 1;

            } else if (tagOfInterest.id == MIJLOC) {
                opMode.telemetry.addLine("Tag mijloc");
                opMode.telemetry.update();
                parcare = 2;
            } else {
                opMode.telemetry.addLine("Tag dreapta");
                opMode.telemetry.update();
                parcare = 3;
            }

        }


    }

