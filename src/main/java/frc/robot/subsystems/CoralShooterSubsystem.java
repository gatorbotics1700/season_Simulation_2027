// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix6.configs.MotorOutputConfigs;
import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.InvertedValue;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class CoralShooterSubsystem extends SubsystemBase {
 // You need to have two TalonFX motors (left and right) and a DigitalInput limit switch
  /* TODO: declare your motors and limit switch here */
  private TalonFX rightMotor;
  private TalonFX leftMotor;
  private boolean limitSwitch;
  /** Creates a new CoralShooterSubsystem. */
  public CoralShooterSubsystem() {
    // To instantiate your motor, you want to create a new TalonFX object
    // Make sure to include both the CAN ID and the CANBus name from Constants.java
    /* TODO: instantiate your motors here */
    rightMotor = new TalonFX(Constants.RIGHT_MOTOR_CAN_ID, Constants.MECH_CANBUS_NAME);
    leftMotor = new TalonFX(Constants.LEFT_MOTOR_CAN_ID, Constants.MECH_CANBUS_NAME);
    // This part of the code is making it so if we give the motors the same voltage, they'll go in
    // opposite directions
    // Since the wheels have to spin the same direction but the motors are mounted on opposite sides
    /* TODO: put your right motor name here and uncomment the next few lines */
    rightMotor
     .getConfigurator()
     .apply(
         new TalonFXConfiguration()
             .withMotorOutput(
                 new MotorOutputConfigs().withInverted(InvertedValue.Clockwise_Positive)));

    // You must also instantiate your limit switch by creating a new DigitalInput object
    // Make sure to use the limit switch constant in Constants.java
    /* instantiate your limit switch here */
    //TODO from Vivien: you don't need the canbus name for limit switches!
    limitSwitch = new DigitalInput(Constants.LIMIT_SWITCH_CAN_ID, Constants.MECH_CANBUS_NAME);
  }

  /* GETTER AND SETTER METHODS */

  // We need methods to set the motor voltage and to get the value of the limit switch

  /* write a method to set motor voltage
   * You can use the TalonFX method setVoltage() on each motor to give the motor the voltages
   */
  //TODO from Vivien: just some formatting issues, you have too many semicolons and you forgot a }
  //this should instead be:
//  public void setRightMotorVoltage(double voltage){
//     rightMotor.setVoltage(voltage);
//  }
//   public void setLeftMotorVoltage(double voltage){
//     leftMotor.setVoltage(voltage);
//   }
  public void setRightMotorVoltage(double voltage);{
    rightMotor.setVoltage(voltage);
    
  public void setLeftMotorVoltage(double voltage);{
    leftMotor.setVoltage(voltage);
  }
  /* write a method to get the limit switch value
   * You can use the DigitalInput method get()
   */
  //TODO from Vivien: limit switches are buttons that are either on or off. their value is a boolean, not a double
  public double limitSwitchValue(){
    limitSwitch.get(value);
      return value;
  }

}
