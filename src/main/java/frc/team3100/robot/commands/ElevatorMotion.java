package frc.team3100.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.team3100.robot.Robot;

public class ElevatorMotion extends Command {

    private double targetLocation = Robot.oi.elevatorTargetLevel;

    public ElevatorMotion() {
        super("ElevatorMotion");
        requires(Robot.elevator);
    }

    public void initialize() {

    }

    public void execute() {
        targetLocation = Robot.oi.elevatorTargetLevel;

        if(Robot.elevator.elevation > targetLocation) {
            Robot.elevator.move(-1);
        } else if(Robot.elevator.elevation < targetLocation) {
            Robot.elevator.move(1);
        } else {
            Robot.elevator.move(0);
        }
        SmartDashboard.putNumber("target",targetLocation);
        SmartDashboard.putNumber("elevatorLevel",Robot.elevator.elevation);
    }

    public boolean isFinished() {
        return false;
    }

    public void end() {

    }

    public void interrupted() {


    }
}

