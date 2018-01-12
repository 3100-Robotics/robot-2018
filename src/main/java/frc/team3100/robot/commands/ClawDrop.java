package frc.team3100.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.team3100.robot.Robot;

public class ClawDrop extends Command {
    public ClawDrop() {
        super("ClawDrop");
        requires(Robot.claw);

    }

    public void initialize() {
        if(!Robot.oi.clawYState && !Robot.autoVal){
            Robot.claw.rotDown();
            Robot.oi.clawYState = true;
        } else if(Robot.oi.clawYState && !Robot.autoVal) {
            Robot.claw.rotUp();
            Robot.oi.clawYState = false;
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
        Robot.claw.rotDown();
        Robot.oi.clawYState = true;

    }
}

