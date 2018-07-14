package frc.team3100.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.team3100.robot.Robot;
import frc.team3100.robot.RobotMap;
import frc.team3100.robot.XBoxTech;

public class ElevatorMotion extends Command {


    public ElevatorMotion() {
        super("ElevatorMotion");
        requires(Robot.elevator);
    }
    private static XBoxTech controller = RobotMap.techControls;

    public void initialize() {

    }

    public void execute() {
        Robot.elevator.move(-controller.getLeftStickY());
    }

    public boolean isFinished() {
        return false;
    }

    public void end() {

    }

    public void interrupted() {


    }
}

