package frc.team3100.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.team3100.robot.Robot;
import frc.team3100.robot.RobotMap;
import frc.team3100.robot.XBoxDrive;
import frc.team3100.robot.XBoxTech;

public class Climbing extends Command {
    public Climbing() {
        super("Climbing");
        requires(Robot.climber);
    }

    private static XBoxTech controller = RobotMap.techControls;
    @Override
    public void initialize() {

    }

    @Override
    public void execute() {
        SmartDashboard.putNumber("ClimbVal",controller.getRightStickY());
        Robot.climber.move(controller.getRightStickY());
    }

    public boolean isFinished() {
        return false;
    }
    @Override
    public void end() {

    }

    public void interrupted() {

    }
}
