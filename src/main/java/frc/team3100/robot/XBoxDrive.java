package frc.team3100.robot;

import edu.wpi.first.wpilibj.Joystick;

public class XBoxDrive extends Joystick {

    //Setup all of the ports on the XBox controller
    private static final int rightXAxis = 4;
    private static final int rightYAxis = 5;
    private static final int leftXAxis = 0;
    private static final int leftYAxis = 1;

    public static final int aButton = 1;
    public static final int bButton = 2;
    public static final int xButton = 3;
    public static final int yButton = 4;

    public static final int rightBumper = 6;
    public static final int leftBumper = 5;

    public static final int backButton = 7;
    public static final int startButton = 8;

    public static final int rightTrigger = 3;
    public static final int leftTrigger = 2;

    public XBoxDrive(int port) {
            super(port);
        }

        // set up methods to retrieve the values from variable inputs on the controller.
        public double getRightStickX() {
            return getRawAxis(rightXAxis);
        }

        public double getRightStickY() {
            return getRawAxis(rightYAxis);
        }

        public double getLeftStickX() {
            return getRawAxis(leftXAxis);
        }

        public double getLeftStickY() {
            return getRawAxis(leftYAxis);
        }

        public boolean getButtonA() {
            return getRawButton(aButton);
        }

        public boolean getButtonB() {
            return getRawButton(bButton);
        }

        public boolean getButtonX() {
            return getRawButton(xButton);
        }

        public boolean getButtonY() {
            return getRawButton(yButton);
        }

        public boolean getRightBumper() {
            return getRawButton(rightBumper);
        }

        public boolean getLeftBumper() {
            return getRawButton(leftBumper);
        }

        public double getRightTrigger() {
            return getRawAxis(rightTrigger);
        }

        public double getLeftTrigger() { return getRawAxis(leftTrigger); }


}