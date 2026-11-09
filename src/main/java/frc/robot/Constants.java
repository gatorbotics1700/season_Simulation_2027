package frc.robot;

public final class Constants {
  public static final String CANIVORE_BUS_NAME = "";

  // create constants for the CAN IDs of the left and right shooter motors
  // you can either put placeholder values of 0 or assign a number to these
  public static final double LEFT_MOTOR_CAN_ID = 0;
  public static final double RIGHT_MOTOR_CAN_ID = 0;
  /* TODO: put your motor ids here */

  // add a constant for the limit switch port
  // this can either be a placeholder (0) or a value 0 - 9
  public static final double LIMIT_SWITCH_CAN_ID = 0;/* TODO: put your limit switch port here */

  // you need constants for the shooting voltages
  // the voltage we give it can be a whole number or a decimal value
  // we need a value for the L4 shooting voltage, the trough shooting voltage, and the intake
  // voltage
  // shooting voltages should be negative, and the L4 value should be larger
  //TODO from Vivien: perfect! for organizational reasons, make all these names ALL_CAPS_SEPARATED_WITH_HYPHENS
  public static final double L4shooterVoltage = -1.0;
  public static final double troughShootingVoltage = -0.1;
  public static final double intakeVoltage = 1.1;/* TODO: put your shooting voltages here */
}
