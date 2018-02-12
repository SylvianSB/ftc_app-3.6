package org.firstinspires.ftc.teamcode;


import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.util.Range;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp(name="ISMDriveBase", group="Exercises")

public class ISMDriveBase extends LinearOpMode {

    DcMotor leftMotor, rightMotor, pullMotor, pullMotor2, clawMotor;
    Servo liftright, liftleft, claw1, claw2;
    float leftY, rightY, pully, clawy;

    public void runOpMode() throws InterruptedException {

        leftMotor = hardwareMap.dcMotor.get("left_motor");
        rightMotor = hardwareMap.dcMotor.get("right_motor");
        pullMotor = hardwareMap.dcMotor.get("pully_motor");
        pullMotor2 = hardwareMap.dcMotor.get("pully_motor_2");
        //clawMotor = hardwareMap.dcMotor.get("claw_motor");
        //claw1 = hardwareMap.servo.get("claw_one");
        //claw2 = hardwareMap.servo.get("claw_two");
        liftright = hardwareMap.servo.get("lift_right");
        liftleft = hardwareMap.servo.get("lift_left");
        leftMotor.setDirection(DcMotorSimple.Direction.REVERSE);
        pullMotor2.setDirection(DcMotorSimple.Direction.REVERSE);
        liftright.setPosition(.40);
        liftleft.setPosition (.30);
        liftleft.setDirection(Servo.Direction.REVERSE);


        waitForStart();
        while(opModeIsActive())
        {
            // Gamepad 1 controls
            leftY = gamepad1.left_stick_y;
            rightY = gamepad1.right_stick_y;



            leftMotor.setPower(-Range.clip(leftY, -1.0, 1.0));
            rightMotor.setPower(-Range.clip(rightY, -1.0, 1.0));


            if (gamepad1.a)
            {
                liftleft.setPosition(-.75);
                liftright.setPosition(-.55);

            }

            if (gamepad1.x)
            {
                liftleft.setPosition(.75);
                liftright.setPosition(.50);
            }

            if (gamepad1.dpad_up)
            {
                pullMotor.setPower(.60);
                pullMotor2.setPower(.30);
                //Some things i need to change
            }

            if (gamepad1.dpad_down)
            {
                pullMotor.setPower(-.15);
                pullMotor2.setPower(-.10);
            }

            if (gamepad1.b)
            {
                pullMotor2.setPower(0);
                pullMotor.setPower(0);
            }


        }
    }
}