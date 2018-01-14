package frc.team3100.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.team3100.robot.Robot;

public class PlatformRelease extends Command {
    public PlatformRelease() {
        super("PlatformRelease");
        requires(Robot.platform);

    }

    public void initialize() {
        Robot.platform.deploy();
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

