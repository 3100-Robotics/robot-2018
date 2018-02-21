package frc.team3100.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.team3100.robot.Robot;
import frc.team3100.robot.subsystems.MainDrive;


public class AutoDriveForwards extends Command {

    private double targetValue;
    private int time = 0;
    public AutoDriveForwards(double targetVal) {
        super("AutoDriveForwards");
        requires(Robot.drive);
        targetValue = targetVal;

    }
    private static MainDrive drive = Robot.drive;

    protected void initialize() {
        drive.storedValRight = 0;
        drive.storedValLeft = 0;
    }

    protected void execute() {

        drive.drive(-1, 0);
        time += 1;

    }


    protected boolean isFinished() {
        if(Robot.drive.storedValRight >= targetValue || time > 400) {
            return true;
        } else {
            return false;
        }
    }


    protected void interrupted(){

    }


    protected void end() {

    }
}

