package frc.team3100.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.team3100.robot.Robot;


public class AutoCubeScore extends Command {
    public AutoCubeScore() {
        super("AutoCubeScore");
        requires(Robot.claw);

    }


    protected void initialize() {

    }

    protected void execute() {
        Robot.claw.score();


    }


    protected boolean isFinished() {
        return Robot.oi.cubeHeld;
    }


    protected void interrupted(){
        Robot.drive.drive(0, 0);
    }


    protected void end() {
        Robot.claw.stop();
        Robot.claw.open();

    }
}

