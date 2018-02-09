package frc.team3100.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.team3100.robot.Robot;

public class PlatformRampUp extends Command {
    public PlatformRampUp() {
        super("PlatformRampUp");
        requires(Robot.platform);

    }

    public void initialize() {
        Robot.platform.lift();
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

