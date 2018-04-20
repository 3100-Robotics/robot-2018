package frc.team3100.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.team3100.robot.Robot;
import frc.team3100.robot.subsystems.MainDrive;


public class AutoDriveForwards extends Command {

    private double targetValue;
    private int time = 0;
    private int checkVal;
    private int currentVal;
    private boolean finished = false;
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

        drive.drive(-.9, 0);
        if(time == 50) {
            checkVal = Robot.drive.storedValRight;

        }
        if(time == 100) {
            if(checkVal == Robot.drive.storedValRight) {
                time = 0;
                finished = true;
            }
        }
        time += 1;


    }


    protected boolean isFinished() {
        if(Robot.drive.storedValRight >= targetValue || finished) {
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

