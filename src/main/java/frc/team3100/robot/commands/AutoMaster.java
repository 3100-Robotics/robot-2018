package frc.team3100.robot.commands;
import edu.wpi.first.wpilibj.command.CommandGroup;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.team3100.robot.Robot;

/*
COPY AND PASTE THESE

TO DRIVE FORWARDS:
addSequential(new AutoDriveForwards(FEET));

TO DRIVE BACKWARDS:
addSequential(new AutoDriveBackwards(FEET));

TO TURN RIGHT:
addSequential(new AutoDriveTurnRight(DEGREES));

TO TURN LEFT:
addSequential(new AutoDriveTurnLeft(DEGREES));

TO COLLECT A CUBE:
addSequential(new AutoCubeCollect());

*/
public class AutoMaster extends CommandGroup {
    public AutoMaster(Character autoChoice, String autoData, Character autoType, Character autoPriority, Character autoFar) {
        SmartDashboard.putString("INPUT",autoData + autoChoice + autoPriority + autoType);
        SmartDashboard.putString("AutoData", autoData);

        if (autoData.length() == 0) {
            autoChoice = 'A';
            SmartDashboard.putString("Error", "No FMS Data");
        }

        if (autoChoice == 'A') {
            addSequential(new AutoDriveForwards(28));
            addParallel(new AutoDriveBackwards(4));
        }

        if (autoType == 'O') {
            if (autoChoice == 'A') {
                addSequential(new AutoDriveForwards(28));
                addParallel(new AutoDriveBackwards(4));
            } else if (autoChoice == 'R') {
                if (Robot.gameData.charAt(0) == 'R') {
                    addParallel(new AutoElevator("switch"));

          addSequential(new AutoDriveForwards(28));
                    addSequential(new AutoCubeScore());
                    addParallel(new AutoDriveBackwards(10));

                } else if (Robot.gameData.charAt(1) == 'R' && Robot.gameData.charAt(0) == 'L') {
                    //IF SCALE ON OPPOSITE SIDE
                    addSequential(new AutoDriveForwards(2));
                    addSequential(new AutoDriveTurnRight(30));
                    addSequential(new AutoDriveForwards(28));
                    addSequential(new AutoDriveTurnLeft(26));
                    addSequential(new AutoDriveForwards(43));
                    addParallel(new AutoDriveBackwards(6));

                } else {
                    addSequential(new AutoDriveForwards(28));
                }
            } else if (autoChoice == 'L') {
                if (autoData.charAt(0) == 'L') {
                    addParallel(new AutoElevator("switch"));
                    addSequential(new AutoDriveForwards(28));
                    addSequential(new AutoCubeScore());
                    addParallel(new AutoDriveBackwards(10));

                } else if (autoData.charAt(1) == 'L' && autoData.charAt(0) == 'R') {
                    //IF SCALE ON OPPOSITE SIDE
                    addSequential(new AutoDriveForwards(2));
                    addSequential(new AutoDriveTurnLeft(30));
                    addSequential(new AutoDriveForwards(20));
                    addSequential(new AutoDriveTurnRight(34));
                    addSequential(new AutoDriveForwards(43));
                    addParallel(new AutoDriveBackwards(6));

                } else {
                    addSequential(new AutoDriveForwards(28));
                    addParallel(new AutoDriveBackwards(6));
                }
            } else if (autoChoice == 'C') {
                if (Robot.gameData.charAt(0) == 'R') {
                    addSequential(new AutoDriveForwards(6));
                    addParallel(new AutoElevator("switch"));
                    addSequential(new AutoDriveTurnRight(40));
                    addSequential(new AutoDriveForwards(25));
                    addSequential(new AutoDriveTurnLeft(10));
                    addSequential(new AutoCubeScore());
                } else {
                    addSequential(new AutoDriveForwards(6));
                    addParallel(new AutoElevator("switch"));
                    addSequential(new AutoDriveTurnLeft(30));
                    addSequential(new AutoDriveForwards(30));
                    addSequential(new AutoDriveTurnRight(10));
                    addSequential(new AutoCubeScore());
                }
            }
        } else {
            if(autoPriority == 'W') {
                if(autoChoice == 'L') {
                    if(autoData.charAt(0) == 'L') {
                        //Left Side near switch
                        addSequential(new AutoDriveForwards(43));
                        addParallel(new AutoElevator("switch"));
                        addSequential(new AutoDriveTurnRight(90));
                        addSequential(new AutoDriveForwards(4));
                        addSequential(new AutoCubeScore());
                    } else {
                        //Left Side Far Switch
                        if(autoFar == 'Y') {
                            addSequential(new AutoDriveForwards(66));
                            addSequential(new AutoDriveTurnRight(90));
                            addParallel(new AutoElevator("switch"));
                            addSequential(new AutoDriveForwards(54));
                            addSequential(new AutoDriveTurnRight(90));
                            addSequential(new AutoDriveForwards(3));
                            addSequential(new AutoCubeScore());
                        }
                    }
                } else if(autoChoice == 'R') {
                    if(autoData.charAt(0) == 'R') {
                        //Right Side Near Switch
                        addSequential(new AutoDriveForwards(43));
                        addParallel(new AutoElevator("switch"));
                        addSequential(new AutoDriveTurnLeft(90));
                        addSequential(new AutoDriveForwards(2));
                        addSequential(new AutoCubeScore());
                    } else {
                        //Right Side Far Switch
                        addSequential(new AutoDriveForwards(66));
                        addSequential(new AutoDriveTurnLeft(90));
                        addParallel(new AutoElevator("switch"));
                        addSequential(new AutoDriveForwards(54));
                        addSequential(new AutoDriveTurnLeft(90));
                        addSequential(new AutoDriveForwards(3));
                        addSequential(new AutoCubeScore());
                    }
                }
            } else {
                if(autoChoice == 'L') {
                    if(autoData.charAt(1) == 'L') {
                        //Left Side Near Scale
                        addSequential(new AutoDriveForwards(92));
                        addParallel(new AutoElevator("scale"));
                        addSequential(new AutoDriveTurnRight(90));
                        addSequential(new AutoCubeScore());
                    } else {
                        //Left Side Far Scale
                        addSequential(new AutoDriveForwards(63));
                        addSequential(new AutoDriveTurnRight(90));
                        addSequential(new AutoDriveForwards(56));
                        addParallel(new AutoElevator("scale"));
                        addSequential(new AutoDriveTurnLeft(90));
                        addSequential(new AutoDriveForwards(17));
                        addSequential(new AutoCubeScore());
                    }
                } else if (autoChoice == 'R') {
                    if(autoData.charAt(0) == 'R') {
                        //Right Side Near Scale
                        addSequential(new AutoDriveForwards(92));
                        addParallel(new AutoElevator("scale"));
                        addSequential(new AutoDriveTurnLeft(90));
                        addSequential(new AutoCubeScore());
                    } else {
                        //Right Side Far Scale
                        addSequential(new AutoDriveForwards(63));
                        addSequential(new AutoDriveTurnLeft(90));
                        addSequential(new AutoDriveForwards(56));
                        addParallel(new AutoElevator("scale"));
                        addSequential(new AutoDriveTurnRight(90));
                        addSequential(new AutoDriveForwards(14));
                        addSequential(new AutoCubeScore());
                    }
                }
            }
        }





/*
        if (autoType == 'O') {
            SmartDashboard.putString("YOU RAN OLD CODE!!","true");
            if (autoChoice == 'A') {
                SmartDashboard.putString("AutoRan", "A");
                addSequential(new AutoDriveForwards(28));
                addParallel(new AutoDriveBackwards(4));
            } else if (autoChoice == 'R') {
                SmartDashboard.putString("AutoRan", "R");
                if (Robot.gameData.charAt(0) == 'R') {
                    addParallel(new AutoElevator("switch"));
                    addSequential(new AutoDriveForwards(28));
                    addSequential(new AutoCubeScore());
                    addParallel(new AutoDriveBackwards(10));

                } else if (Robot.gameData.charAt(1) == 'R' && Robot.gameData.charAt(0) == 'L') {
                    //IF SCALE ON OPPOSITE SIDE
                    addSequential(new AutoDriveForwards(2));
                    addSequential(new AutoDriveTurnRight(30));
                    addSequential(new AutoDriveForwards(28));
                    addSequential(new AutoDriveTurnLeft(26));
                    addSequential(new AutoDriveForwards(43));
                    addParallel(new AutoDriveBackwards(6));

                } else {
                    addSequential(new AutoDriveForwards(28));
                }
            } else if (autoChoice == 'L') {
                SmartDashboard.putString("AutoRan", "L");
                if (autoData.charAt(0) == 'L') {
                    addParallel(new AutoElevator("switch"));
                    addSequential(new AutoDriveForwards(28));
                    addSequential(new AutoCubeScore());
                    addParallel(new AutoDriveBackwards(10));

                } else if (autoData.charAt(1) == 'L' && autoData.charAt(0) == 'R') {
                    //IF SCALE ON OPPOSITE SIDE
                    addSequential(new AutoDriveForwards(2));
                    addSequential(new AutoDriveTurnLeft(30));
                    addSequential(new AutoDriveForwards(20));
                    addSequential(new AutoDriveTurnRight(34));
                    addSequential(new AutoDriveForwards(43));
                    addParallel(new AutoDriveBackwards(6));

                } else {
                    addSequential(new AutoDriveForwards(28));
                    addParallel(new AutoDriveBackwards(6));
                }
            } else if (autoChoice == 'C') {
                SmartDashboard.putString("AutoRan", "C");
                if (Robot.gameData.charAt(0) == 'R') {
                    addSequential(new AutoDriveForwards(6));
                    addParallel(new AutoElevator("switch"));
                    addSequential(new AutoDriveTurnRight(40));
                    addSequential(new AutoDriveForwards(25));
                    addSequential(new AutoDriveTurnLeft(10));
                    addSequential(new AutoCubeScore());
                } else {
                    addSequential(new AutoDriveForwards(6));
                    addParallel(new AutoElevator("switch"));
                    addSequential(new AutoDriveTurnLeft(30));
                    addSequential(new AutoDriveForwards(30));
                    addSequential(new AutoDriveTurnRight(10));
                    addSequential(new AutoCubeScore());
                }
            }
        } else {
            SmartDashboard.putString("Running New Code", "true");
            SmartDashboard.putString("Only one?","true");
            if (autoChoice == 'L') {
                SmartDashboard.putString("YAY", "true");
                SmartDashboard.putString("AutoRan", "L1");
                if (Robot.gameData == "LLL") {
                    if (autoPriority == 'C') {
                        SmartDashboard.putString("help", "CLLL");
                        addSequential(new AutoDriveForwards(92));
                        addParallel(new AutoElevator("scale"));
                        addSequential(new AutoDriveTurnRight(90));
                        addSequential(new AutoCubeScore());
                    } else {
                        SmartDashboard.putString("help", "CLLL");
                        addSequential(new AutoDriveForwards(43));
                        addParallel(new AutoElevator("switch"));
                        addSequential(new AutoDriveTurnRight(90));
                        addSequential(new AutoDriveForwards(4));
                        addSequential(new AutoCubeScore());
                    }
                } else if (Robot.gameData == "LRL") {
                    if (autoPriority == 'C') {
                        SmartDashboard.putString("help", "CLRL");
                        addSequential(new AutoDriveForwards(63));
                        addSequential(new AutoDriveTurnRight(90));
                        addSequential(new AutoDriveForwards(56));
                        addParallel(new AutoElevator("scale"));
                        addSequential(new AutoDriveTurnLeft(90));
                        addSequential(new AutoDriveForwards(17));
                        addSequential(new AutoCubeScore());
                    } else {
                        SmartDashboard.putString("help", "WLRL");
                        addSequential(new AutoDriveForwards(43));
                        addParallel(new AutoElevator("switch"));
                        addSequential(new AutoDriveTurnRight(90));
                        addSequential(new AutoDriveForwards(5));
                        addSequential(new AutoCubeScore());
                    }
                } else if (Robot.gameData == "RLR") {
                    if (autoPriority == 'C') {
                        SmartDashboard.putString("help", "CRLR");
                        addSequential(new AutoDriveForwards(92));
                        addParallel(new AutoElevator("scale"));
                        addSequential(new AutoDriveTurnRight(90));
                        addSequential(new AutoCubeScore());
                    } else {
                        SmartDashboard.putString("help", "WRLR");
                        addSequential(new AutoDriveForwards(63));
                        addSequential(new AutoDriveTurnRight(90));
                        addParallel(new AutoElevator("switch"));
                        addSequential(new AutoDriveForwards(54));
                        addSequential(new AutoDriveTurnRight(90));
                        addSequential(new AutoDriveForwards(2));
                        addSequential(new AutoCubeScore());
                    }
                } else if (Robot.gameData == "RRR") {
                    if (autoPriority == 'C') {
                        SmartDashboard.putString("help", "CRRR");
                        addSequential(new AutoDriveForwards(63));
                        addSequential(new AutoDriveTurnRight(90));
                        addSequential(new AutoDriveForwards(56));
                        addParallel(new AutoElevator("scale"));
                        addSequential(new AutoDriveTurnLeft(90));
                        addSequential(new AutoDriveForwards(17));
                        addSequential(new AutoCubeScore());
                    } else {
                        SmartDashboard.putString("help", "WRRR");
                        addSequential(new AutoDriveForwards(63));
                        addSequential(new AutoDriveTurnRight(90));
                        addParallel(new AutoElevator("switch"));
                        addSequential(new AutoDriveForwards(54));
                        addSequential(new AutoDriveTurnRight(90));
                        addSequential(new AutoDriveForwards(2));
                        addSequential(new AutoCubeScore());
                    }
                }
            }else if (autoChoice == 'R') {
                    SmartDashboard.putString("AutoRan", "R1");
                    if (Robot.gameData == "RRR") {
                        if (autoPriority == 'C') {
                            addSequential(new AutoDriveForwards(92));
                            addParallel(new AutoElevator("scale"));
                            addSequential(new AutoDriveTurnLeft(90));
                            addSequential(new AutoCubeScore());
                        } else {
                            addSequential(new AutoDriveForwards(43));
                            addParallel(new AutoElevator("switch"));
                            addSequential(new AutoDriveTurnLeft(90));
                            addSequential(new AutoDriveForwards(2));
                            addSequential(new AutoCubeScore());
                        }
                    } else if(Robot.gameData == "RLR") {
                        if (autoPriority == 'C') {
                            addSequential(new AutoDriveForwards(63));
                            addSequential(new AutoDriveTurnLeft(90));
                            addSequential(new AutoDriveForwards(56));
                            addParallel(new AutoElevator("scale"));
                            addSequential(new AutoDriveTurnRight(90));
                            addSequential(new AutoDriveForwards(14));
                            addSequential(new AutoCubeScore());
                        } else {
                            addSequential(new AutoDriveForwards(43));
                            addParallel(new AutoElevator("switch"));
                            addSequential(new AutoDriveTurnLeft(90));
                            addSequential(new AutoDriveForwards(2));
                            addSequential(new AutoCubeScore());
                        }
                    } else if(Robot.gameData == "LRL") {
                        if (autoPriority == 'C') {
                            addSequential(new AutoDriveForwards(92));
                            addParallel(new AutoElevator("scale"));
                            addSequential(new AutoDriveTurnLeft(90));
                            addSequential(new AutoCubeScore());
                        } else {
                            addSequential(new AutoDriveForwards(63));
                            addSequential(new AutoDriveTurnLeft(90));
                            addParallel(new AutoElevator("switch"));
                            addSequential(new AutoDriveForwards(54));
                            addSequential(new AutoDriveTurnLeft(90));
                            addSequential(new AutoDriveForwards(2));
                            addSequential(new AutoCubeScore());
                        }
                    } else if(Robot.gameData == "LLL") {
                        if (autoPriority == 'C') {
                            addSequential(new AutoDriveForwards(63));
                            addSequential(new AutoDriveTurnLeft(90));
                            addSequential(new AutoDriveForwards(56));
                            addParallel(new AutoElevator("scale"));
                            addSequential(new AutoDriveTurnRight(90));
                            addSequential(new AutoDriveForwards(14));
                            addSequential(new AutoCubeScore());
                        } else {
                            addSequential(new AutoDriveForwards(63));
                            addSequential(new AutoDriveTurnLeft(90));
                            addParallel(new AutoElevator("switch"));
                            addSequential(new AutoDriveForwards(54));
                            addSequential(new AutoDriveTurnLeft(90));
                            addSequential(new AutoDriveForwards(2));
                            addSequential(new AutoCubeScore());
                        }
                    }

                } else if (autoChoice == 'C') {
                    SmartDashboard.putString("AutoRan", "C1");

                } else if (autoChoice == 'A') {
                    SmartDashboard.putString("AutoRan", "A1");
                    addSequential(new AutoDriveForwards(28));
                    addParallel(new AutoDriveBackwards(4));
                }


            }

        }
    */
    }
}
