package frc.team3100.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.team3100.robot.Robot;


public class AutoElevator extends Command {

    String target;
    public AutoElevator(String level) {
        super("AutoElevator");
        requires(Robot.elevator);
        level = target;
    }

    protected void initialize() {

    }

    protected void execute() {
        if(target == "pickup") {
            Robot.oi.elevatorTargetLevel = Robot.elevator.pickupLevel();
        } else if(target == "vault") {
            Robot.oi.elevatorTargetLevel = Robot.elevator.pickupLevel();
        } else if(target == "switch") {
            Robot.oi.elevatorTargetLevel = Robot.elevator.pickupLevel();
        } else if(target == "low") {
            Robot.oi.elevatorTargetLevel = Robot.elevator.pickupLevel();
        } else if(target == "mid") {
            Robot.oi.elevatorTargetLevel = Robot.elevator.pickupLevel();
        } else if(target == "high") {
            Robot.oi.elevatorTargetLevel = Robot.elevator.pickupLevel();
        } else {
            SmartDashboard.putString("Error", "Invalid ElevatorPosition");
        }
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

