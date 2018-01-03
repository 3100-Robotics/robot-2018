package frc.team3100.robot.subsystems;

import edu.wpi.first.wpilibj.Jaguar;
import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.networktables.NetworkTable;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.team3100.robot.RobotMap;
import frc.team3100.robot.commands.CameraMotion;

import static java.lang.Math.abs;


public class CamServo extends Subsystem {


    private static Servo servoX = RobotMap.xServo;
    private static Servo servoY = RobotMap.yServo;
    //NetworkTable targetInfo = NetworkTable.getTable("GRIP/myContoursReport");



    public void initDefaultCommand() {
        setDefaultCommand(new CameraMotion());
        servoX.set(0);
        servoY.set(0);
    }


    public void move(double x, double y) {
        SmartDashboard.putNumber("x", x);
        SmartDashboard.putNumber("y", y);
        double currentX = servoX.get();
        double currentY = servoY.get();
        if(abs(x) > 0.1) {
            servoX.set(currentX + (x * .01));
            SmartDashboard.putNumber("CX", currentX + (x * .01));
        }
        if(abs(y) > 0.1) {
            servoY.set(currentY + (y * .01));
            SmartDashboard.putNumber("CY", currentY + (y * .01));
        }

        //double centerX = targetInfo.getNumber("centerX");
        //double centerY = targetInfo.getNumber("centerY");
        //private static final int IMG_WIDTH = 320;
        //private static final int IMG_HEIGHT = 240;

        /*if(centerX > 160) {
            servoX.set(currentX + .001);
        } else if(centerX < 160) {
            servoX.set(currentX - .001);
        }

        if (centerY > 120) {
            servoY.set(currentY - .001);
        } else if(centerY < 120) {
            servoY.set(currentY - .001);
        }*/
    }
    public void reset() {
        servoX.set(0);
        servoY.set(0);
    }

}