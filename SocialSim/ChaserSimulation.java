
/*
Marlon Grandy
CS231 
3/15/2022
ChaserSimulation class runs a simulation for the chaser and socialAgent classes. 
Class initializes new agents, updates their state between generations and
repaints the simulation landscape.  

ChaserSimulation.java
*/
import java.util.Random;

public class ChaserSimulation {

    public static void main(String[] args) throws InterruptedException { // main method to run a chaser simulation
        Landscape scape = new Landscape(500, 500);
        LandscapeDisplay display = new LandscapeDisplay(scape);
        Random gen = new Random();

        for (int i = 0; i < 200; i++) { // initializes new social agents
            scape.addAgent(new SocialAgent(gen.nextDouble() *
                    display.scape.getWidth(),
                    gen.nextDouble() * display.scape.getHeight(), 35, false));
        }
        for (int j = 0; j < 1; j++) { // initializes new chaser agents
            scape.addChaserAgent(new Chaser(500, 500, 100, false));
        }

        int simNumber = 10000000;
        for (int j = 0; j < simNumber; j++) {
            scape.updateAgents(scape); // makes call to update agents to update the location
            display.repaint(); // repaints thge landscpae
            Thread.sleep(50);
        }

    }
}
