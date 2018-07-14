package frc.team3100.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.team3100.robot.Robot;
import frc.team3100.robot.RobotMap;
import frc.team3100.robot.XBoxTech;

public class ClimbingPiston extends Command {
    public ClimbingPiston() {
        super("ClimbingPiston");
    }

    @Override
    public void initialize() {
        if(Robot.oi.climbState) {
            Robot.climber.out();
            Robot.oi.climbState = false;
        } else {
            Robot.climber.in();
            Robot.oi.climbState = true;
        }
    }

    @Override
    public void execute() {


    }

    public boolean isFinished() {
        return true;
    }

    @Override
    public void end() {

    }

    public void interrupted() {

    }
}
