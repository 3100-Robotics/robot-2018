package frc.team3100.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.team3100.robot.Robot;

public class ClawCollect extends Command {
    public ClawCollect() {
        super("ClawCollect");
        requires(Robot.claw);
    }

    @Override
    public void initialize() {
        if(!Robot.oi.cubeHeld) {
            if (Robot.oi.clawCollectState) {
                Robot.claw.stop();
                Robot.oi.clawCollectState = false;
            } else {
                Robot.claw.collect();
                Robot.oi.clawCollectState = true;
            }
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
