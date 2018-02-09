package frc.team3100.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.team3100.robot.Robot;

public class ClawGrab extends Command {
    public ClawGrab() {
        super("ClawGrab");
        requires(Robot.claw);
    }

    public void initialize() {
        if (Robot.oi.clawOpenState) {
            Robot.claw.close();
            Robot.oi.clawOpenState = false;
        } else {
            Robot.claw.open();
            Robot.oi.clawOpenState = true;
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
