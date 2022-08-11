
/*
Marlon Grandy
CS231 
3/15/2022
SocialAgent sub class contains methods to manipulate and retrive data regarding a a social agent.
The agent is either moving or not moving based on certain set conditions.
SocialAgent.java
*/

import java.awt.Graphics;
import java.awt.*;
import java.util.Random;

public class SocialAgent extends Agent {
    boolean move = false;
    int radius;
    Graphics g;

    SocialAgent(double x, double y, int radius, boolean effect) { // constructor that sets radius and calls super
                                                                  // constructor
        super(x, y, effect);
        this.radius = radius;

    }

    @Override
    public void setEffected(boolean effect) {// sets if the cell has been effected by a chaser
        this.effected = effect;
    }

    @Override
    public boolean getEffected() {// returns effected
        return effected;
    }

    public void setRadius(int radius) {// sets the cell's radius of sensitivity to the value of radius.
        this.radius = radius;
    }

    public int getRadius() {// returns the cell's radius of sensitivity.
        return radius;
    }

    @Override
    public void draw(Graphics g, Color color1, Color color2) {// draws a circle of radius 5 at agent location
        if (move) {
            g.setColor(color1);
            g.fillOval((int) x, (int) y, 5, 5);

        } else if (effected) {
            g.setColor(Color.RED);
            g.fillOval((int) x, (int) y, 5, 5);
        }

        else {
            g.setColor(color2);
            g.fillOval((int) x, (int) y, 5, 5);

        }
    }

    @Override
    public void updateState(Landscape scape) { // updates the state (moves) of an agent based on conditions
        Random rand = new Random();
        if (effected) { // if the agent has been effected they are permenently set to move = false
            move = false;
        } else { // if the agent is not effected they follow the same conditions set in the
                 // porject
            int chance = rand.nextInt(100);
            int[] sign = { -1, 1 };
            if (scape.getNeighbors(x, y, radius).size() > 3) {
                if (chance == 1) {
                    int index = rand.nextInt(2);
                    double newX = rand.nextDouble() * 10 * sign[index] + x;
                    double newY = rand.nextDouble() * 10 * sign[index] + y;
                    setY(newY);
                    setX(newX);
                    move = true;
                } else {
                    move = false;
                }
            } else {
                int index = rand.nextInt(2);
                double newX = rand.nextDouble() * 10 * sign[index] + x;
                double newY = rand.nextDouble() * 10 * sign[index] + y;
                setY(newY);
                setX(newX);
                move = true;
            }

        }

    }

    public static void main(String[] args) { // main method to test methods in class
        // //SocialAgent one = new SocialAgent(5, 5, 5);
        // //SocialAgent two = new SocialAgent(10, 10, 5);
        // // SocialAgent three = new SocialAgent(15, 15, 5);
        // //SocialAgent four = new SocialAgent(20, 20, 5);

        // // System.out.println(sa.getRadius());
        // // sa.setRadius(7);
        // // System.out.println(sa.getRadius());

        // Landscape l = new Landscape(500, 500);
        // l.addAgent(one);
        // l.addAgent(two);
        // l.addAgent(three);
        // l.addAgent(four);
        // one.updateState(l);
        // System.out.println(l.getNeighbors(one.getX(), one.getY(), 25).size());

    }
}
