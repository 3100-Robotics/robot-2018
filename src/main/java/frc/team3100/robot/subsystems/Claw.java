package frc.team3100.robot.subsystems;

import edu.wpi.first.wpilibj.*;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.team3100.robot.Robot;
import frc.team3100.robot.RobotMap;


public class Claw extends Subsystem {

    // Defining objects from RobotMap that control the claw
    private static SpeedController clawMotorLeft = RobotMap.clawMotorLeft;
    private static SpeedController clawMotorRight = RobotMap.clawMotorRight;
    private static Solenoid clawGrabberOpen = RobotMap.clawGrabberOpen;
    private static Solenoid clawGrabberClose = RobotMap.clawGrabberClose;
    private static DigitalInput clawButton = RobotMap.clawButton;

    private double wheelSpeed = .9;



    public void initDefaultCommand() {

    }

    // Uses pneumatics to open/close the claw. Can be used to grab boxes from different orientations.
    public void close() {
        clawGrabberClose.set(true);
        clawGrabberOpen.set(false);    }

    public void open() {
        clawGrabberOpen.set(true);
        clawGrabberClose.set(false);    }

    // Changes the speed of the wheels to intake or output the power cube.
    public void collect() {
        clawMotorLeft.set(wheelSpeed);
        clawMotorRight.set(wheelSpeed);
        Robot.oi.clawCollectState = true;
    }

    public void score() {
        clawMotorLeft.set(-wheelSpeed);
        clawMotorRight.set(-wheelSpeed);
        int time = 0;
        while(time < 20) {
            time += 1;
        }
        stop();
    }
    public void stop() {
        clawMotorLeft.set(0);
        clawMotorRight.set(0);
        Robot.oi.clawCollectState = false;
    }


}