package frc.robot.subsystems.mech;

import com.ctre.phoenix6.hardware.TalonFX;
import com.google.flatbuffers.Constants;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

// TODO imports (including motor controllers/encoders)

public class WristSubsystem extends SubsystemBase {
  // The differential wrist (might help to look at a picture online) consists of two motors.
  // If they spin in the same direction, the wrist moves up and down. If they spin in opposite
  // directions, the wrist rotates.
  private TalonFX rightMotor;
  private TalonFX leftMotor;

  public WristSubsystem() {
    rightMotor = new TalonFX(0, Constants.MECH_CANBUS_NAME);
    //TODO placeholders+set value to MECH_CANBUS_NAME
    leftMotor = new TalonFX(0, Constants.MECH_CANBUS_NAME);
    //TODO find IDs and make the MechName & stuffafa
  
    //TODO: Create motor configurations

    //TODO: Configure PID gains, current limits, other safety things, etc
    //AAAAH

    //TODO: Apply configurations
  }

  public void periodic() {}

  // TODO other useful methods

  public void setVoltage(double voltage, double voltage2) {}

  public void setPosition(double desired_position) {

  } 


