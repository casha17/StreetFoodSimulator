package org.example;

import org.javasim.RestartException;
import org.javasim.SimulationException;
import org.javasim.SimulationProcess;
import org.javasim.streams.UniformStream;

import java.io.IOException;

public class PouringDrink extends SimulationProcess {

    private Customer customer;
    private UniformStream pouringTime = new UniformStream(0.15 , 0.45);
    public PouringDrink(Customer customer) {
        this.customer = customer;
    }

    @Override
    public void run() {
        while (!this.terminated()) {
            try {
                //Pouring time
                hold(pouringTime.getNumber());
                //after pouring release drink worker
                SimulatorCore.drinkWorkers++;
                if (!SimulatorCore.drinkingQueue.isEmpty()) {

                        SimulatorCore.drinkingQueue.pop().activate();


                }
              //  System.out.println( "c"+this.customer.getId() +  " Poured drink " + Scheduler.currentTime());

                //Decide only drink or
                new DecideOnlyDrink(this.customer).activate();

                this.terminate();

            } catch (SimulationException e) {
                e.printStackTrace();
            } catch (RestartException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }


}
