package frc.team3100.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.team3100.robot.Robot;

public class ClawSpit extends Command {
    public ClawSpit() {
        super("ClawSpit");
        requires(Robot.claw);
    }
    @Override
    public void initialize() {
        if (Robot.oi.clawScoreState) {
            Robot.claw.stop();
            Robot.oi.clawScoreState = false;
            Robot.oi.clawCollectState = false;
        } else {
            Robot.claw.score();
            Robot.oi.clawCollectState = false;
            Robot.oi.clawScoreState = true;
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
