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

    }



    @Override
    public void execute() {
        Robot.claw.score();
    }

    public boolean isFinished() {
        return false;
    }
    @Override
    public void end() {
        Robot.claw.stop();
    }

    public void interrupted() {
        Robot.claw.stop();
    }
}
