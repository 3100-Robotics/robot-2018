package frc.team3100.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.team3100.robot.Robot;
import frc.team3100.robot.RobotMap;
import frc.team3100.robot.XBoxTech;
import frc.team3100.robot.subsystems.Elevator;

public class ElevatorMotion extends Command {


    private static double targetLocation;

    public ElevatorMotion(double location) {
        super("ElevatorMotion");
        requires(Robot.elevator);
        location = targetLocation;

    }
    private static Elevator elevator = Robot.elevator;
    private static XBoxTech controller = RobotMap.techControls;

    public void initialize() {

    }

    public void execute() {
        if(Robot.elevator.elevation > targetLocation) {
            elevator.move(-1);
        } else if(Robot.elevator.elevation < targetLocation) {
            elevator.move(1);
        }
    }

    public boolean isFinished() {
        return false;
    }

    public void end() {

    }

    public void interrupted() {


    }
}

