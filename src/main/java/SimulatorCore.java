
import org.javasim.*;
import org.javasim.internal.SimulationProcessList;
import org.javasim.simset.Link;
import org.javasim.streams.ExponentialStream;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.TreeSet;


public class SimulatorCore extends SimulationProcess {

    public static int customerArrivals = 0;
    public static int tables = 100;
    public static int drinkWorkers = 3;
    public static LinkedList<SimulationProcess> drinkingQueue = new LinkedList<>();
    public static LinkedList<SimulationProcess> tableQueue = new LinkedList<>();
    public static LinkedList<SimulationProcess> PizzaQueue = new LinkedList<>();
    public static LinkedList<SimulationProcess> burgerQueue = new LinkedList<>();
    public static LinkedList<SimulationProcess> chineseQueue = new LinkedList<>();
    public static int cashiers = 3;
    public static int pizzaWorkers = 3;
    public static int burgerWorkers = 3;
    public static int chineseWorkers = 3;
    public ExponentialStream interArrivalTime = new ExponentialStream(1);
    public SimulatorCore() {

    }


    public void run() {
        try {
            //Creater Arrival thread
            Arrival a = new Arrival();
            // Start Arrival
            a.activate();

            //Start Simulation
            Simulation.start();

            // Run simulation until arrivals hit 200
            while (customerArrivals < 10){
                hold(1);
            }
            Simulation.stop();
            a.interrupt();
            a.terminate();
            SimulationProcess.mainResume();
            System.out.println("Stopping simulation");




        }
        catch (final Exception e)
        {

        }

    }

    public void await() {
        this.resumeProcess();
        SimulationProcess.mainSuspend();
    }


    public static int getBranch() {
        return (int) (Math.random() * (1 - 10)) + 10;
    }

    public static int getBigBranch() {
        return (int) (Math.random() * (1 - 100)) + 100;
    }





}
