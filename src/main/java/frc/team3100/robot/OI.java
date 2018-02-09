package frc.team3100.robot;

import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.buttons.Trigger;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.team3100.robot.commands.*;


public class OI {

    // Initialize the XBox Controllers
    private XBoxDrive driveControls = RobotMap.driveControls;
    private XBoxTech techControls = RobotMap.techControls;



    // Define all of the buttons used
    private Button vaultLevel = new JoystickButton(techControls, XBoxTech.xButton);
    private Button pickupLevel = new JoystickButton(techControls,XBoxTech.bButton);
    private Trigger highLevel = new POVR();
    private Trigger switchLevel = new POVL();
    private Trigger lowLevel = new POVL();
    private Trigger midLevel = new POVD();

    private Button clawOutput = new JoystickButton(driveControls, XBoxDrive.aButton);
    private Button clawInput = new JoystickButton(driveControls,XBoxDrive.bButton);
    private Button clawOpenClose = new JoystickButton(techControls,XBoxTech.aButton);

    private Button rampDeployButton = new JoystickButton(driveControls, XBoxDrive.backButton);
    private Button rampRaiseButton = new JoystickButton(driveControls, XBoxDrive.startButton);



    // Defining state variables to log the states of different subsystems
    public boolean clawOpenState = false;
    public boolean clawCollectState = false;
    public double elevatorTargetLevel = 0;
    public boolean cubeHeld = false;

    public double getDriveMoveSpeed() {
            return driveControls.getLeftStickY();
        }

    public double getRotateSpeed() {return driveControls.getRightStickX(); }

    public double getLeftTrigger() {
        return techControls.getLeftTrigger();
    }

    public double geRightTrigger() {
        return techControls.getRightTrigger();
    }


    public OI() {

        highLevel.whenActive(new ElevatorSet(Robot.elevator.highLevel()));
        midLevel.whenActive(new ElevatorSet(Robot.elevator.midLevel()));
        lowLevel.whenActive(new ElevatorSet(Robot.elevator.lowLevel()));
        switchLevel.whenActive(new ElevatorSet(Robot.elevator.switchLevel()));
        pickupLevel.whenPressed(new ElevatorSet(Robot.elevator.pickupLevel()));
        vaultLevel.whenPressed(new ElevatorSet(Robot.elevator.vaultLevel()));

        clawOpenClose.whenPressed(new ClawGrab());
        clawOutput.whenPressed(new ClawSpit());
        clawInput.whenPressed(new ClawCollect());

        rampDeployButton.whenPressed(new PlatformRelease());
        rampRaiseButton.whenPressed(new PlatformRampUp());

    }
}
