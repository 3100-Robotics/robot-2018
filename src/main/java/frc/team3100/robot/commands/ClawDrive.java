package frc.team3100.robot.commands;

import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.team3100.robot.Robot;
import frc.team3100.robot.RobotMap;
import frc.team3100.robot.XBoxDrive;
import frc.team3100.robot.XBoxTech;

public class ClawDrive extends Command {


    public ClawDrive(){
        super("ClawDrive");
        requires(Robot.claw);
    }
    private static XBoxTech controller = RobotMap.techControls;
    private double triggerError = 0.1;

    @Override
    protected void initialize() {

    }

    @Override
    protected void execute() {
        SmartDashboard.putNumber("triggerVal",controller.getLeftTrigger());
        if(controller.getLeftTrigger() > triggerError) {
            Robot.claw.run(controller.getLeftTrigger());
        } else if(controller.getRightBumper()) {
            Robot.claw.run(.9);
        } else {
            Robot.claw.run(0);
        }
    }


    protected boolean isFinished() {
        return false;
    }


    protected void interrupted(){

    }

    @Override
    protected void end() {

    }
}
