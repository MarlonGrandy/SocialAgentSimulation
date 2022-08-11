
/*
Marlon Grandy
CS231 
3/15/2022
Landscape class copntains emthods to manipulate the landscape visualuzation as well as methods to work with all agents on the landscape
Landscape.java
*/
import java.lang.Math;
import java.util.ArrayList;
import java.awt.Color;
import java.awt.Graphics;

public class Landscape {
    int width;
    int height;
    LinkedList<Agent> agentList;
    LinkedList<Agent> chaserList;

    public Landscape(int w, int h) {// a constructor that sets the width and height fields, and initializes the
                                    // agent list.
        width = w;
        height = h;
        agentList = new LinkedList<Agent>();
        chaserList = new LinkedList<Agent>();
    }

    public int getHeight() {// returns the height.
        return height;
    }

    public int getWidth() { // returns the width.
        return width;
    }

    public void addAgent(SocialAgent a) { // inserts an agent at the beginning of its list of agents.
        agentList.addLast(a);
    }

    public void addChaserAgent(Chaser a) { // inserts an agent at the beginning of its list of agents.
        chaserList.addLast(a);
    }

    public String toString() { // returns a String representing the Landscape. It can be as simple as
                               // indicating the number of Agents on the Landscape.
        return "The number of agents on the landscape is " + agentList.size();
    }

    public ArrayList<Agent> getNeighbors(double x0, double y0, double radius) { // returns a list of the Agents within
                                                                                // radius distance of the location x0,
                                                                                // y0.
        ArrayList<Agent> neighbors = new ArrayList<Agent>();
        for (Agent i : agentList) {
            double length = Math.sqrt(Math.pow((i.getX() - x0), 2) + Math.pow((i.getY() - y0), 2));
            if (length < radius && length != 0 && !i.getEffected()) {
                neighbors.add(i);
            }
        }
        return neighbors;
    }

    public void draw(Graphics g) { // Calls the draw method of all the agents on the Landscape.
        for (Agent i : agentList) {
            i.draw(g, Color.BLUE.brighter().brighter().brighter(), Color.BLUE.darker().darker().darker().darker());
        }
        for (Agent j : chaserList) {
            j.draw(g, Color.YELLOW.brighter().brighter().brighter(), Color.YELLOW.darker().darker().darker().darker());
        }

    }

    public void updateAgents(Landscape scape) { // updates state of agents in random order using shuffled ArrayList
        ArrayList<Agent> chasers = chaserList.toShuffledList();
        for (Agent j : chasers) {
            System.out.println("chaser update");
            j.updateState(scape);
        }

        ArrayList<Agent> l = agentList.toShuffledList();
        for (Agent i : l) {
            System.out.println("landscape update");
            i.updateState(scape);
        }

    }

}
