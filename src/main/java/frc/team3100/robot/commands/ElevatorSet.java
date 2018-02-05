package frc.team3100.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.team3100.robot.Robot;
import frc.team3100.robot.subsystems.Elevator;

public class ElevatorSet extends Command {


    private static double targetLocation;

    public ElevatorSet(double location) {
        super("ElevatorMotion");
        requires(Robot.elevator);
        location = targetLocation;

    }

    public void initialize() {
        if(Robot.oi.cubeHeld) {
            Robot.oi.elevatorTargetLevel = targetLocation;
        } else {
            Robot.oi.elevatorTargetLevel = Robot.elevator.pickupLevel();
        }
    }

    public void execute() {

    }

    public boolean isFinished() {
        return true;
    }

    public void end() {

    }

    public void interrupted() {


    }
}

