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
    private static DigitalInput clawButton = RobotMap.clawButton;

    private double wheelSpeed = .5;


    @Override
    protected void initDefaultCommand() {

    }

    // Uses pneumatics to open/close the claw. Can be used to grab boxes from different orientations.
    public void close() {
        clawGrabber.set(true);    }

    public void open() {
        clawGrabber.set(false);    }

    // Changes the speed of the wheels to intake or output the power cube.
    public void collect() {
        clawMotors.set(wheelSpeed);
    }

    public void score() {
        clawMotors.set(-wheelSpeed);

    }
    public void stop() {
        clawMotors.set(0);
    }
    public void buttonCheck() {
        Robot.oi.cubeHeld = RobotMap.clawButton.get();
        if(Robot.oi.cubeHeld && Robot.oi.clawCollectState) {
            stop();
            Robot.oi.clawCollectState = false;
        }
        SmartDashboard.putBoolean("cubeHeld",Robot.oi.cubeHeld);
    }


}