package frc.team3100.robot.subsystems;

import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.team3100.robot.RobotMap;


public class Platform extends Subsystem {

    // Defining objects from RobotMap that control the platform
    private static Servo platformDeployLeft = RobotMap.platformDeployLeft;
    private static Servo platformDeployRight = RobotMap.platformDeployRight;
    private static Solenoid platformLift = RobotMap.rampLeftRaise;



    public void initDefaultCommand() {

    }

    public void deploy() {
        platformDeployLeft.setAngle(180);
        platformDeployRight.setAngle(0);
    }

    public void lift() {
        platformLift.set(true);
        RobotMap.UPP5.set(false);
    }
    public  void retract() {
        platformLift.set(false);
        RobotMap.UPP5.set(true);
    }

}