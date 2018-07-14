package frc.team3100.robot.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.SpeedController;
import edu.wpi.first.wpilibj.command.Subsystem;
import frc.team3100.robot.Robot;
import frc.team3100.robot.RobotMap;
import frc.team3100.robot.commands.Climbing;


public class Climber extends Subsystem {

    // Defining objects from RobotMap that control the claw
    private static SpeedController climbMotors = RobotMap.climbMotor;
    private double wheelSpeed = .75;


    @Override
    protected void initDefaultCommand() {
        setDefaultCommand(new Climbing());
    }

    public void move(double speed) {
        climbMotors.set(speed);
    }

    public void out() {
        RobotMap.climbOut.set(true);
        RobotMap.climbIn.set(false);
    }

    public void in() {
        RobotMap.climbOut.set(false);
        RobotMap.climbIn.set(true);

    }

    public void stop() {
        climbMotors.set(0);
    }


}