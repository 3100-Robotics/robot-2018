package frc.team3100.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.team3100.robot.Robot;
import frc.team3100.robot.subsystems.MainDrive;


public class AutoElevator extends Command {


    public AutoElevator(String level) {
        super("AutoElevator");
        requires(Robot.elevator);
        if(level == "pickup") {
            Robot.oi.elevatorTargetLevel = Robot.elevator.pickupLevel();
        } else if(level == "vault") {
            Robot.oi.elevatorTargetLevel = Robot.elevator.pickupLevel();
        } else if(level == "switch") {
            Robot.oi.elevatorTargetLevel = Robot.elevator.pickupLevel();
        } else if(level == "low") {
            Robot.oi.elevatorTargetLevel = Robot.elevator.pickupLevel();
        } else if(level == "mid") {
            Robot.oi.elevatorTargetLevel = Robot.elevator.pickupLevel();
        } else if(level == "high") {
            Robot.oi.elevatorTargetLevel = Robot.elevator.pickupLevel();
        } else {
            SmartDashboard.putString("Error", "Invalid ElevatorPosition");
        }
    }


    private static MainDrive drive = Robot.drive;

    protected void initialize() {

    }

    protected void execute() {

    }


    protected boolean isFinished() {
        if(Robot.oi.elevatorTargetLevel == Robot.elevator.elevation) {
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

