package frc.team3100.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import frc.team3100.robot.Robot;
import frc.team3100.robot.RobotMap;
import frc.team3100.robot.XBoxDrive;
import frc.team3100.robot.subsystems.MainDrive;

public class Drive extends Command {


    public Drive(){
        super("Drive");
        requires(Robot.drive);
    }
    private static MainDrive drive = Robot.drive;
    private static XBoxDrive controller = RobotMap.driveControls;

    @Override
    protected void initialize() {

    }

    @Override
    protected void execute() {
        drive.drive(controller.getLeftStickY(), controller.getLeftStickX());
    }


    protected boolean isFinished() {
        return false;
    }


    protected void interrupted(){
        drive.drive(0, 0);
    }

    @Override
    protected void end() {

    }
}