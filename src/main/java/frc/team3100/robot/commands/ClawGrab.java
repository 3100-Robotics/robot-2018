package frc.team3100.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.team3100.robot.Robot;

public class ClawGrab extends Command {
    public ClawGrab() {
        super("ClawGrab");
        requires(Robot.claw);
    }

    public void initialize() {
        if(Robot.oi.clawXState){
            Robot.claw.open();
            Robot.oi.clawXState = false;
        } else {
            Robot.claw.close();
            Robot.oi.clawXState = true;
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
        Robot.claw.open();
        Robot.oi.clawXState = false;

    }
}
