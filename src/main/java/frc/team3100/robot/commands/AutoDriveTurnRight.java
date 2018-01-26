package frc.team3100.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.team3100.robot.Robot;
import frc.team3100.robot.subsystems.MainDrive;


public class AutoDriveTurnRight extends Command {

    private int targetValue;
    private int time = 0;
    public AutoDriveTurnRight(int targetVal) {
        super("AutoDriveTurnRight");
        requires(Robot.drive);
        targetValue = targetVal;
    }


    private static MainDrive drive = Robot.drive;

    protected void initialize() {
        drive.storedValLeft = 0;
        drive.storedValRight = 0;
    }

    protected void execute() {
        time += 1;
        drive.drive(0, .65);
        SmartDashboard.putNumber("turnTime", time);
    }


    protected boolean isFinished() {
        if(drive.storedValRight <= (targetValue / 15) + 1) {
            return false;
        } else {
            return true;
        }
    }


    protected void interrupted(){

    }


    protected void end() {

    }
}

