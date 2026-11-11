// TODO rename the branch to differentialWristBranch

/* TODO (general todos)
 * figure out our units for position and adjust the data type accordingly
 * position and speed control
 */

package frc.robot.subsystems.mech;

import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.hardware.TalonFX;
import com.google.flatbuffers.Constants;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

// TODO imports (including motor controllers/encoders)
import com.ctre.phoenix6.configs.MotorOutputConfigs;
import com.ctre.phoenix6.configs.TalonFXConfiguration; // TODO we have this import three times

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import com.ctre.phoenix6.configs.MotorOutputConfigs;
import com.ctre.phoenix6.configs.TalonFXConfiguration; // TODO we have this import three times
import com.ctre.phoenix6.hardware.TalonFX; // TODO we have this import twice
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
  // TODO figure out units of currentPosition and change variable type accordingly


  public WristSubsystem() {
    rightMotor = new TalonFX(0, Constants.MECH_CANBUS_NAME); 
    // TODO get a mech canbus name(look at how we do it preseason 2027)
    //TODO switch placeholder to a constant
    leftMotor = new TalonFX(0, Constants.MECH_CANBUS_NAME);
    //TODO find IDs and make the MechName & stuffafa
    
    //TODO find what we want the current limits to actally be
  
    //TODO: Create motor configurations
    double currentLimit = 0 ;
    var talonFXConfigurator = rightMotor.getConfigurator();
    var motorConfigs = new MotorOutputConfigs();
    talonFXConfigurator.CurrentLimits.StatorCurrentLimit = 120;// TODO figure out why CurrentLimits is erroring
    motorConfigs.CurrentLimits.StatorCurrentLimitEnable = true;
    talonFXConfigurator.apply(motorConfigs);

    
    //TODO: Configure PID gains, current limits, other safety things, etc
    pid = new PIDController(0.1, 0.01, 0.001); // Placeholder PID gains, created and set PID
    //TODO ki, kp, and kd should be tuneables
    currentPosition = 0; //placeholder



    
    //TODO: Ask build about inversions of motors
  }

  public void periodic() {}

  // TODO other useful methods



  public void setVoltage(double rightMotorVoltage, double leftMotorVoltage) { // set two voltages
    rightMotor.setVoltage(rightMotorVoltage);
    leftMotor.setVoltage(leftMotorVoltage);
  } 

  // TODO  clarify what this does
  public void setPosition(double desired_position) { // TODO figure out units of desiredPosition and change variable type accordingly
    double voltage = pid.calculate(currentPosition, desired_position); // calculate voltage based on current and desired position
    setVoltage(-voltage, voltage); 
  }

  // TODO write method to get position
  // TODO write degrees to revs method

  //okkkk here is how we should move it:
  //-Position-based: we want to input a rotation and to specify if it is rotating or going up and down
  //-we can use control requests
  //-gear ratio is 1:1
  //basically, we can do math by dividing things by 360 to get it in degrees to be able to rotate it
  //-CTR electronics has good resource: https://v6.docs.ctr-electronics.com/en/stable/docs/api-reference/api-usage/control-requests.html
}

