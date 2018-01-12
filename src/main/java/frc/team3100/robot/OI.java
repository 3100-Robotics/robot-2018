package frc.team3100.robot;

import edu.wpi.first.wpilibj.buttons.Button;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import frc.team3100.robot.commands.*;


public class OI {

    // Initialize the XBox Controllers
    private XBoxDrive driveControls = RobotMap.driveControls;
    private XBoxTech techControls = RobotMap.techControls;

    // Define all of the buttons used on the controllers
    private Button vaultLevel = new JoystickButton(techControls, XBoxTech.xButton);
    private Button clawYToggle = new JoystickButton(techControls, XBoxTech.aButton);
    private Button collectToggle = new JoystickButton(techControls, XBoxTech.bButton);
    private Button clawXToggle = new JoystickButton(techControls, XBoxTech.leftBumper);

    // Defining state variables to log the states of different subsystems
    //In low position = true
    public boolean clawYState = false;
    //Grabbed onto cube = true
    public boolean clawXState = true;
    // starting position = 0
    public int elevatorLevel = 0;
    // target elevator position
    public int elevatorTarget;


    public double getDriveMoveSpeed() {
            return driveControls.getLeftStickY();
        }

    public double getRotateSpeed() {return driveControls.getRightStickX(); }


    public OI() {

        // Run commands based on button presses
        vaultLevel.whenPressed(new);
        clawXToggle.whenPressed(new ClawGrab());
        clawYToggle.whenPressed(new ClawDrop());

        // Run commands based on D-Pad presses
        int checkVal = techControls.getPOV();
        if(checkVal == 0) {
            elevatorTarget = 5;
        } else if(checkVal == 90) {
            elevatorTarget = 2;
        } else if(checkVal == 180) {
            elevatorTarget = 3;
        } else if(checkVal == 270) {
            elevatorTarget = 4;
        }


    }


}
