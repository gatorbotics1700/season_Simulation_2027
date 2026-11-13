package frc.robot;

public final class Constants {
  public static final String CANIVORE_BUS_NAME = "";

  // create constants for the CAN IDs of the left and right shooter motors
  // you can either put placeholder values of 0 or assign a number to these
  /* put your motor ids here */
  //TODO from Vivien: this looks pretty good but make sure to start constants with "public"
  static final int CANID_LEFT = 0;
static final int CANID_RIGHT = 1;
  // add a constant for the limit switch port
  // this can either be a placeholder (0) or a value 0 - 9
  /* put your limit switch port here */
   static final int LIMIT_SWITCH_PORT = 0;
  // you need constants for the shooting voltages
  // the voltage we give it can be a whole number or a decimal value
  // we need a value for the L4 shooting voltage, the trough shooting voltage, and the intake
  // voltage
  // shooting voltages should be negative, and the L4 value should be larger
  /* put your shooting voltages here */
  //TODO from Vivien: you need more than one shooting voltage constant, one for trough and one for l4
  static final int SHOOTING_VOLTAGE = 0;
}
