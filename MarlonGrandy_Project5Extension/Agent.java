
/*
Marlon Grandy
CS231 
3/15/2022
Agent super class contains methods to manipulate and retrive data regarding a generalized agent 
Agent.java
*/
import java.awt.Graphics;
import java.awt.*;

public class Agent {
    boolean effected = false;
    boolean move = false;
    double x;
    double y;
    int category;

    Agent(double x0, double y0, boolean effect) { // a constructor that sets the position.
        x = x0;
        y = y0;
        effected = effect;
    }

    public void setEffected(boolean effect) {// sets if the cell has been effected by a chaser
        this.effected = effect;
    }

    public boolean getEffected() {// returns effected
        return effected;
    }

    public double getX() { // returns the x position.
        return x;
    }

    public double getY() { // returns the y position.
        return y;
    }

    public void setX(double newX) { // sets the x position.
        x = newX;
    }

    public void setY(double newY) { // sets the y position.
        y = newY;
    }

    public String toString() { // returns a String containing the x and y positions, e.g. "(3.024, 4.245)".
        return "(" + x + ", " + y + ")";
    }

    public void updateState(Landscape scape) { // does nothing, for now.

    }

    public void draw(Graphics g, Color color1, Color color2) { // does nothing, for now.

        g.setColor(Color.WHITE);
        g.drawOval((int) x, (int) y, 1, 1);
    }

    public int getCat() { // category getter
        return category;
    }

    public static void main(String[] args) { // main method to test class mkethods
        Agent a = new Agent(5, 5, false);
        System.out.println(a.getX() + " " + a.getY()); // x and y getter
        a.setX(6); // xsetter
        a.setY(6); // ysetter
        System.out.println(a.getX() + " " + a.getY()); // x and y getter after se

        System.out.println(a.toString()); // toString
    }

}