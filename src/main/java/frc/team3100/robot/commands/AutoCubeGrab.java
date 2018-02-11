package frc.team3100.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.team3100.robot.Robot;


public class AutoCubeGrab extends Command {
    public AutoCubeGrab() {
        super("AutoCubeGrab");
        requires(Robot.claw);
        requires(Robot.drive);
    }


    protected void initialize() {
        Robot.drive.storedValRight = 0;
        Robot.drive.storedValLeft = 0;
    }

    protected void execute() {

        Robot.drive.drive(.65,0);
    }


    protected boolean isFinished() {
        return Robot.oi.cubeHeld;
    }


    protected void interrupted(){
        Robot.drive.drive(0, 0);
    }


    protected void end() {
        Robot.drive.drive(0,0);
        Robot.oi.distanceDriven = Robot.drive.storedValLeft * 12;
    }
}

