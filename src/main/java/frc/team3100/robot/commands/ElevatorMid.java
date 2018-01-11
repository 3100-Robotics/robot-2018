package frc.team3100.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.team3100.robot.Robot;
import frc.team3100.robot.subsystems.Elevator;

public class ElevatorMid extends Command {
    public ElevatorMid() {
        super("ElevatorMid");
        requires(Robot.elevator);

    }
    private static Elevator elevator = Robot.elevator;

    public void initialize() {

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

