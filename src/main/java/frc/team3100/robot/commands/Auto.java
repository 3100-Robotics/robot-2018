package frc.team3100.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.team3100.robot.Robot;
import frc.team3100.robot.subsystems.MainDrive;


public class Auto extends CommandGroup {

    public Auto() {
        addSequential(new AutoDriveForwards(37));
    }


    protected void initialize() {

    }


    protected void execute() {
    }


    protected boolean isFinished() {
        return false;
    }


    protected void interrupted(){

    }


    protected void end() {

    }
}

