package frc.team3100.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.team3100.robot.Robot;


public class AutoCubeGrab extends Command {
    public AutoCubeGrab() {
        super("AutoCubeGrab");
        requires(Robot.claw);

    }


    protected void initialize() {

    }

    protected void execute() {
        Robot.drive.drive(.65,0);


    }


    protected boolean isFinished() {
        return Robot.oi.cubeHeld;
    }


    protected void interrupted(){

    }


    protected void end() {
        Robot.drive.drive(0,0);
    }
}

