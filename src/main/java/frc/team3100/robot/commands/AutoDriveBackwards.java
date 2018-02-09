package frc.team3100.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.team3100.robot.Robot;
import frc.team3100.robot.subsystems.MainDrive;


public class AutoDriveBackwards extends Command {

    private int targetValue;

    public AutoDriveBackwards(int targetVal) {
        super("AutoDriveBackwards");
        requires(Robot.drive);
        targetValue = targetVal;

    }
    private static MainDrive drive = Robot.drive;

    protected void initialize() {
        drive.storedValRight = 0;
        drive.storedValLeft = 0;
    }

    protected void execute() {

        drive.drive(-.65, 0);

    }


    protected boolean isFinished() {
        if(Robot.drive.storedValRight >= targetValue) {
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

