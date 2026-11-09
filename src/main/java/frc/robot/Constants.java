package frc.robot;

public final class Constants {
  public static final String CANIVORE_BUS_NAME = "";

  // create constants for the CAN IDs of the left and right shooter motors
  // you can either put placeholder values of 0 or assign a number to these
  /* put your motor ids here */
  //TODO from Vivien: all constants should be "public" not private. otherwise, the rest of your code won't be able to use them :(
    private static final int RIGHT_MOTOR_CAN_ID = 0;
    private static final int LEFT_MOTOR_CAN_ID = 0;
  // add a constant for the limit switch port
  // this can either be a placeholder (0) or a value 0 - 9
  /* put your limit switch port here */
    private static final int LIMIT_SWITCH_CAN_ID = 0;
  // you need constants for the shooting voltages
  // the voltage we give it can be a whole number or a decimal value
  // we need a value for the L4 shooting voltage, the trough shooting voltage, and the intake
  // voltage
  // shooting voltages should be negative, and the L4 value should be larger
  /* put your shooting voltages here */
    private static final double THROUGH_SHOOTING_VOLTAGE = -2.0;
    private static final double L4_SHOOTING_VOLTAGE = 10.0;
    private static final double INTAKE_VOLTAGE = 2.0;
}
