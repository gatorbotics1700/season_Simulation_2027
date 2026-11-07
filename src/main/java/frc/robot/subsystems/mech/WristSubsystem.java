package frc.robot.subsystems.mech;

import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.hardware.TalonFX;
import com.google.flatbuffers.Constants;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

// TODO imports (including motor controllers/encoders)
import com.ctre.phoenix6.configs.MotorOutputConfigs;
import com.ctre.phoenix6.configs.TalonFXConfiguration;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.ctre.phoenix6.configs.MotorOutputConfigs;
import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.InvertedValue;
import edu.wpi.first.math.controller.PIDController; // pid (converts position to voltage)
import edu.wpi.first.wpilibj2.command.PIDSubsystem; 


public class WristSubsystem extends SubsystemBase {
  // The differential wrist (might help to look at a picture online) consists of two motors.
  // If they spin in the same direction, the wrist moves up and down. If they spin in opposite
  // directions, the wrist rotates.
  private TalonFX rightMotor;
  private TalonFX leftMotor;
  private PIDController pid;
  private double currentPosition;
 
  

  public WristSubsystem() {
    rightMotor = new TalonFX(0, Constants.MECH_CANBUS_NAME);
    //TODO placeholders+set value to MECH_CANBUS_NAME
    leftMotor = new TalonFX(0, Constants.MECH_CANBUS_NAME);
    //TODO find IDs and make the MechName & stuffafa
    
    //TODO find what we want the current limits to actally be
  
    //TODO: Create motor configurations
    double currentLimit = 0 ;
    var talonFXConfigurator = rightMotor.getConfigurator();
    var motorConfigs = new MotorOutputConfigs();
    talonFXConfigurator.CurrentLimits.StatorCurrentLImit = 120;
    motorConfigs.CurrentLimits.StatorCurrentLimitEnable = true;
    talonFXConfigurator.apply(motorConfigs);

    
    //TODO: Configure PID gains, current limits, other safety things, etc
    pid = new PIDController(0.1, 0.01, 0.001); // Placeholder PID gains, created and set PID
    currentPosition = 0; //placeholder



    
    //TODO: Apply configurations
  }

  public void periodic() {}

  // TODO other useful methods

  public void setVoltage(double rightMotorvoltage, double leftMotorVoltage) { // set two voltages
    this.rightMotor.setVoltage(rightMotorvoltage);
    this.leftMotor.setVoltage(leftMotorVoltage);
  } 


  public void setPosition(double desired_position) {
    double voltage = this.pid.calculate(this.currentPosition, desired_position); // calculate voltage based on current and desired position
    this.setVoltage(-voltage, voltage);
  }



  //okkkk here is how we should move it:
  //-Position-based: we want to input a rotation and to specify if it is rotating or going up and down
  //-we can use control requests
  //-gear ratio is 1:1
  //basically, we can do math by dividing things by 360 to get it in degrees to be able to rotate it
  //-CTR electronics has good resource: https://v6.docs.ctr-electronics.com/en/stable/docs/api-reference/api-usage/control-requests.html
}

