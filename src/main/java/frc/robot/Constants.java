package frc.robot;

public final class Constants {
  public static final String CANIVORE_BUS_NAME = "";

  // create constants for the CAN IDs of the left and right shooter motors
  // you can either put placeholder values of 0 or assign a number to these
  /* TODO: put your motor ids here */
  public static final int SHOOTER_MOTOR_LEFT_CAN_ID = 0;
  public static final int SHOOTER_MOTOR_RIGHT_CAN_ID = 1;
  // add a constant for the limit switch port
  // this can either be a placeholder (0) or a value 0 - 9
  /* TODO: put your limit switch port here */
  public static final int LIMIT_SWITCH_PORT = 2;

  // you need constants for the shooting voltages
  // the voltage we give it can be a whole number or a decimal value
  // we need a value for the L4 shooting voltage, the trough shooting voltage, and the intake
  // voltage
  // shooting voltages should be negative, and the L4 value should be larger
  /* TODO: put your shooting voltages here */
  public static final double l4_SHOOTING_VOLTAGE = -7.8;
  public static final double TROUGH_SHOOTING_VOLTAGE = -5.5;
  public static final double INTAKE_VOLTAGE = 4.5;
}
