package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.util.Range;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp(name="RCCar", group="Exercises")

public class RCCar extends LinearOpMode {

    DcMotor driveMotor;
    Servo steer;
    float driver;
    double steerer;
    public void runOpMode() throws InterruptedException {

        driveMotor = hardwareMap.dcMotor.get("drive_motor");
        steer = hardwareMap.servo.get("steer_motor");
        driveMotor.setDirection(DcMotorSimple.Direction.REVERSE);
        steer.setPosition(0);

        waitForStart();
        while (opModeIsActive())
        {
            driver = gamepad1.right_trigger;
            steerer =  gamepad1.left_stick_x;

            steer.setPosition(-Range.clip(steerer, -1.0, 1.0));
        }
    }
}
