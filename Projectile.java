/*
 * Jason Chang
 * CS 16000-03 Fall Semester 2022
 * Project 1: Compute the Projectile Motion
 * 
 * Description. Enter target distance, initial velocity, and launch angle using fancy joptionpane. Then the
 * program will tell you if the porjetile hit the target or not via fancy joptionpane. If not, enter a new 
 * initial velocity and launch angle and repeat until you hit the target. After four attemptes, you start 
 * again.
 */


import javax.swing.JOptionPane;
public class Projectile {

    private static final int GRAVITATION=32;
    private static double distanceToTarget, initialVelocity, launchAngle;
    private static double radiant, flightTime, hightestPoint;
    private static double distanceTraveled, error, minError;
    private static String trajectory, title, task;
    public static void main(String[] args) throws Exception {


        task = "Enter distnace to targey in feet";
        title ="Input";

        distanceToTarget = Double.parseDouble(JOptionPane.showInputDialog(null,task, title, JOptionPane.OK_CANCEL_OPTION));
        //System.out.println(distanceToTarget);

        task="Enter initial velocity";

        initialVelocity = Double.parseDouble(JOptionPane.showInputDialog(null,task, title, JOptionPane.OK_CANCEL_OPTION));
        
        // initla launchAngle must be 45 degree
        task="Enter the launch angle";
        launchAngle = Double.parseDouble(JOptionPane.showInputDialog(null,task, title, JOptionPane.OK_CANCEL_OPTION));
        if (launchAngle !=45){
            task="Failed to enter 45 degrees on 1st attempts.\nRestart the program with the initial launch angle of 45 egrees!";
            title="Modification needed";
            JOptionPane.showMessageDialog(null, task, title, JOptionPane.WARNING_MESSAGE);
            System.exit(0);
        }

        radiant = launchAngle * Math.PI / 180;
        flightTime = 2 * initialVelocity * Math.sin(radiant) / GRAVITATION;
        hightestPoint = initialVelocity * Math.sin(radiant) * flightTime/2 +(-0.5 * GRAVITATION * Math.pow((flightTime/2),2.0));
        distanceTraveled= initialVelocity*Math.cos(radiant)*flightTime;
        error=distanceTraveled-distanceToTarget;
        minError=Math.abs(error);
        trajectory=String.format("inital velocity: %.2f feet/sec\n" +
                                "launch angle: %.2f degrees\n" + 
                                "flight time: %.2f seconds\n" +
                                "maximum height: %.2f feet\n" +
                                "distance travled: %.2f feet\n" +
                                "target missed by: %.2f feet\n", initialVelocity, launchAngle, flightTime, hightestPoint, distanceTraveled, error );

        title = "trajectory data";
        JOptionPane.showMessageDialog(null, trajectory, title, JOptionPane.INFORMATION_MESSAGE);
        System.out.println(error);

        //if we can never hit the target, prompt user for new setups
        if (error<0){
            task="Target is too far!\n Restart the program with greater initial velocity!";
            title="Modification needed";
            JOptionPane.showMessageDialog(null, task, title, JOptionPane.WARNING_MESSAGE);
            System.exit(0);
        }

        if (minError<1){
            task="Target is hit within an error 1 foot!\nThe program terminates.";
            title="Message";
            JOptionPane.showMessageDialog(null, task, title, JOptionPane.INFORMATION_MESSAGE);
            
        }
        launchAngle=Double.parseDouble(JOptionPane.showInputDialog(null, task, title, JOptionPane.OK_CANCEL_OPTION));

        minError= Math.min(minError,error);
        System.exit(0);
    }//end of main
    public static void repeat() {
        task="Enter the launch angle";
        launchAngle = Double.parseDouble(JOptionPane.showInputDialog(null,task, title, JOptionPane.OK_CANCEL_OPTION));
        
        radiant = launchAngle * Math.PI / 180;
        flightTime = 2 * initialVelocity * Math.sin(radiant) / GRAVITATION;
        hightestPoint = initialVelocity * Math.sin(radiant) * flightTime/2 +(-0.5 * GRAVITATION * Math.pow((flightTime/2),2.0));
        distanceTraveled= initialVelocity*Math.cos(radiant)*flightTime;
        error=distanceTraveled-distanceToTarget;
        minError=Math.abs(error);
        trajectory=String.format("inital velocity: %.2f feet/sec\n" +
                                "launch angle: %.2f degrees\n" + 
                                "flight time: %.2f seconds\n" +
                                "maximum height: %.2f feet\n" +
                                "distance travled: %.2f feet\n" +
                                "target missed by: %.2f feet\n", initialVelocity, launchAngle, flightTime, hightestPoint, distanceTraveled, error );

        title = "trajectory data";
        JOptionPane.showMessageDialog(null, trajectory, title, JOptionPane.INFORMATION_MESSAGE);
    }
}//end of projectile
