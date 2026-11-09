// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.CoralShooterSubsystem;

/* You should consider using the more terse Command factories API instead https://docs.wpilib.org/en/stable/docs/software/commandbased/organizing-command-based.html#defining-commands */
public class CoralShooterCommand extends Command {
  // The command needs to have an instance of the CoralShooterSubsystem,
  // a variable to keep track of our voltage, and one to track the start time of the command
  //TODO from Vivien: you have some unnecessary stuff here, should instead be:
  //public CoralShooterSubsystem viviensCoralShooterSubsystem;
  public class CoralShooterSubsystem coralShooterSubsystem(CoralShooterSubsystem coralShooterSubsystem, double voltage);/* declare the CoralShooterSubsystem, voltage, and start time variables here */
  public double shooterMotorVoltage;
  public long shooterStartTime;
  /** Creates a new CoralShooterCommand. */
  //TODO from Vivien: your constructor is flawless
  public CoralShooterCommand(CoralShooterSubsystem coralShooterSubsystem, double voltage) {// come back to this
    this.coralShooterSubsystem = coralShooterSubsystem;
    this.shooterMotorVoltage = shooterMotorVoltage;/* assign the values of the parameters to the variables you instantiated */
    addRequirements(coralShooterSubsystem);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    //TODO from Vivien: System.currentTimeMillis() doesn't need a parameter. instead, you have to say that shooterStartTime equalssss the current time
    System.currentTimeMillis(shooterStartTime);/* TODO: initialize the start time variable with the current time */
    // HINT: System.currentTimeMillis() gets you the current time
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    // We want to set the motor voltage of the Coral Shooter Subsystem to the voltage we passed into
    // the command
    // It's also helpful to have print statements to indicate what the shooter is doing
    // if our voltage is positive, we're intaking
    // if our voltage is equal to the L4 shooting voltage, we're shooting l4
    // if our voltage is equal to the trough shooting voltage, we're shooting trough

    /* set motor voltage */
    //TODO from Vivien: you never actually call your methods here. to do that, you would say:
    //coralShooterSubsystem.setLeftMotorVoltage(shooterMotorVoltage);
    setLeftMotorVoltage = shooterMotorVoltage;
    setRightMotorVoltage = shooterMotorVoltage
    /* add print statements depending on the voltage to indicate the state the shooter is currently in */
    if(shooterMotorVoltage>0){
      System.out.println("we're intaking");
    }else if(shooterMotorVoltage==L4_SHOOTING_VOLTAGE){//TODO from Vivien: when you use this constant you have to say Constants.L4_SHOOTING_VOLTAGE
      System.out.println("we're shooting l4");
    }else(shooterMotorVoltage==THROUGH_SHOOTING_VOLTAGE){
      System.out.println("we're shooting trough");
    }
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    // if we're intaking, we want to end either if it's been 5 seconds or the limit switch is
    // triggered
    // the limit switch is triggered if the value it's getting is true
    // TODO from Vivien: if our voltage is zero, we can just end, but to be safe also set speed to zero
    // if we're outtaking, we want to end if it's been 1.5 seconds
    // in each case, we want to print what's causing the command to end,
    // set the motor voltage to 0, and return true
    // otherwise, we want to return false

    /* TODO: calculate how much time has passed and store it in a variable */
    // you have the start time and can get the current time
    // this value is stored in milliseconds
    long currentTime = System.currentTimeMillis();
    long timePassed = currentTime - startTime;
    /* TODO: write the logic for when to end the command */
    // refer to the descriptions above to write this part
    if(shooterMotorVoltage>0){
      if(timePassed>=5000 || limitSwitch==true){//TODO from Vivien: "limitSwitch" isn't a real variable you made. instead, use the limitSwitchValue() method that you wrote in the subsystem
        //TODO from Vivien: love that you added these extra print statements! would be very helpful for testing
        if(timePassed>=5000){
          System.out.println("command ended, 5 second intake reached");
        }else{
          System.out.println("command ended, limit switch triggered");
        }
        //TODO from Vivien: your command doesn't have access to ur motors, so for everything you have to say "coralShooterSubsystem.doThisThing()"
        motor.setVoltage(0);
        return true;
      }
    }else if(outtaking){//TODO from Vivien: we know we're outtaking if shooterMotorVoltage is negative
      if(timePassed>=1500){
        System.out.println("command ended, 1.5 second outtake reached");

        motor.setVoltage(0);
        return true;
      }
    }
    return false;
  }
}
