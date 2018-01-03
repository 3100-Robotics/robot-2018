package frc.team3100.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import frc.team3100.robot.Robot;
import frc.team3100.robot.subsystems.MainDrive;

import static frc.team3100.robot.Robot.shooter;


public class Auto extends Command {

    public Auto() {
        super("Auto");
        requires(Robot.drive);
        requires(shooter);

    }

    private static MainDrive drive = Robot.drive;

    @Override
    protected void initialize() {

    }

    @Override
    protected void execute() {
        shooter.shoot();
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

