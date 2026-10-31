package frc.robot.commands;

import edu.wpi.first.math.geometry.Pose2d;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.Commands;


public class LineupCommand {

  public LineupCommand() {}

  public static enum YOffset {
    Left,
    Right,
    Center
  }

  public static Command Lineup(
      Pose2d tagPose,
      YOffset yOffset) { // there might be a better way to do this we might not need offsets
    // TODO add path constraints

    Pose2d desiredPose = tagPose;

    // figure out our desired final lineup spot by transforming out from the tag, and
    // rotating 180 (we want to face the reef)
    // left and right poles of the reef are from the perspective of looking from the outside of the
    // reef
    //the below code is kind of just there for reference
    /*if (yOffset == YOffset.Left) {
        // Center to pole offset is negative because from april tag perspective, the left pole is in
        // the negative y direction


        desiredPose = tagPose.transformBy(); // TODO add transformations
      } else if (yOffset == YOffset.Right) {
        desiredPose = tagPose.transformBy(); // TODO add transformations
      } else if (yOffset == YOffset.Center) {
        desiredPose = tagPose.transformBy(); // TODO add transformations
      }


      //return AutoBuilder.pathfindToPose(desiredPose, constraints);

      }
    }
    */
    return Commands.none(); // TODO delete(just in there so the code builds)
  }
}
