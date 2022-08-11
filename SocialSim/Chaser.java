
/*
Marlon Grandy
CS231 
3/15/2022
Chaser sub class contains methods to manipulate and retrive data regarding a chaser agent.
The chaser agent chases after the closest social agent and with a 10% chance will permently set the agents move to false.
The agent fights the grouping pattern naturally seen based on the given conditions. 
Chaser.java
*/
import java.awt.Graphics;
import java.awt.*;
import java.util.Random;

public class Chaser extends Agent {
    int radius;
    boolean move = false;

    Chaser(double x0, double y0, int radius, boolean effect) { // constructor for chaser
        super(x0, y0, effect); // calls to super class consturctor
        this.radius = radius;
    }

    public void setRadius(int radius) {// sets the cell's radius of sensitivity to the value of radius.
        this.radius = radius;
    }

    public int getRadius() {// returns the cell's radius of sensitivity.
        return radius;
    }

    @Override
    public void draw(Graphics g, Color color1, Color color2) {// draws a circle of radius 5 at agent location
        System.out.println("drawing");
        g.setColor(Color.RED);
        g.fillOval((int) x, (int) y, 5, 5);

    }

    public Agent findBest(Landscape scape) { // finds the closest cell to go to
        Double currentCloseVal = 5000.0; // sets value high to be replaced by lower values
        Agent closest = null;
        for (Agent i : scape.agentList) {
            if (!i.getEffected() && scape.getNeighbors(i.getX(), i.getY(), radius).size() < 3) {
                double length = Math.sqrt(Math.pow((x - i.getX()), 2) + Math.pow((y - i.getY()), 2));
                /*
                 * calcualtes for each agent the distance between the
                 * chaser and the agent
                 */
                if (length < currentCloseVal) { // finds the smallest length
                    currentCloseVal = length;
                    closest = i;
                }
            }
        }
        return closest; // returns the closest agent
    }

    @Override
    public void updateState(Landscape scape) { // updates the state (moves) off an agent based on conditions
        Agent a = findBest(scape); // gets the closest agent from findbest method
        if (a == null) { // if the chaser has run through all possible next best cells
            System.out.println("The simulation is over!");
        } else {
            setX(a.getX()); // sets chasers position to the closest agent
            setY(a.getY());
            move = true; // sets chasers moce to true
            Random rand = new Random();
            int chance = rand.nextInt(20);
            if (chance == 1) { // 10% chance of setting agents move to false permanently
                a.setEffected(true);

            }
        }
    }

    // public static void main(String[] args) { // main method to test methods in
    // class
    // Chaser one = new Chaser(5, 5, 5);

    // // System.out.println(sa.getRadius());
    // // sa.setRadius(7);
    // // System.out.println(sa.getRadius());

    // Landscape l = new Landscape(500, 500);
    // l.addChaserAgent(one);

    // // one.updateState(l);
    // System.out.println(one.getX() + one.getY());

    // }
}