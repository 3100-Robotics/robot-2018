package frc.team3100.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.team3100.robot.Robot;
import frc.team3100.robot.RobotMap;
import frc.team3100.robot.XBoxTech;

public class ClawActuate extends Command {


    public ClawActuate(){
        super("ClawActuate");
    }
    private static XBoxTech controller = RobotMap.techControls;

    @Override
    protected void initialize() {
        if(Robot.oi.clawOpenState) {
            Robot.claw.close();
            Robot.oi.clawOpenState = false;
        } else {
            Robot.claw.open();
            Robot.oi.clawOpenState = true;
        }
    }

    @Override
    protected void execute() {


    }


    protected boolean isFinished() {
        return true;
    }


    protected void interrupted(){

    }

    @Override
    protected void end() {

    }
}
