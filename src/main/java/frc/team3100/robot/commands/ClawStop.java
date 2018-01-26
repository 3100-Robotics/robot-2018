package frc.team3100.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.team3100.robot.Robot;

public class ClawStop extends Command {
    public ClawStop() {
        super("ClawStop");
        requires(Robot.claw);
    }
    @Override
    public void initialize() {

    }
    @Override
    public void execute() {
        Robot.claw.stop();

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
