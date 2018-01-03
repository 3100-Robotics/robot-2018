package frc.team3100.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.command.Command;
import frc.team3100.robot.Robot;
import frc.team3100.robot.RobotMap;
import frc.team3100.robot.XBoxController;
import frc.team3100.robot.subsystems.CamServo;
import frc.team3100.robot.subsystems.MainDrive;

public class CameraMotion extends Command {


    public CameraMotion(){
        super("CameraMotion");
        requires(Robot.camServo);
    }
    private static CamServo camServo = Robot.camServo;
    private static XBoxController controller = RobotMap.controls;

    @Override
    protected void initialize() {

    }

    @Override
    protected void execute() {
        camServo.move(controller.getRightStickX() * -1, controller.getRightStickY());
    }


    protected boolean isFinished() {
        return false;
    }


    protected void interrupted(){
        camServo.reset();
    }

    @Override
    protected void end() {

    }
}
