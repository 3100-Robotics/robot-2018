package frc.team3100.robot.subsystems;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.team3100.robot.Robot;
import frc.team3100.robot.RobotMap;


public class Claw extends Subsystem {

    // Defining objects from RobotMap that control the claw
    private static SpeedController clawMotors = RobotMap.clawMotors;
    private static Solenoid clawGrabber = RobotMap.clawGrabber;
    private static Solenoid clawClose = RobotMap.UPP1;
    private static DigitalInput clawButton = RobotMap.clawButton;

    private double wheelSpeed = .6;


    @Override
    protected void initDefaultCommand() {

    }

    // Uses pneumatics to open/close the claw. Can be used to grab boxes from different orientations.
    public void open() {
        clawGrabber.set(true);
        clawClose.set(false);
    }

    public void close() {
        clawGrabber.set(false);
        clawClose.set(true);
    }

    // Changes the speed of the wheels to intake or output the power cube.
    public void collect() {
        clawMotors.set(-wheelSpeed);
        SmartDashboard.putBoolean("ClawTest2",true);
    }

    public void score() {
        if(Robot.autoVal) {
            clawMotors.set(wheelSpeed);

        } else {
            clawMotors.set(wheelSpeed + .3);

        }

    }
    public void stop() {
        clawMotors.set(0);
        SmartDashboard.putBoolean("ClawTest2",false);
    }

    public void buttonCheck() {

    }


}