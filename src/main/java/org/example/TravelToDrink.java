package org.example;

import org.javasim.RestartException;
import org.javasim.SimulationException;
import org.javasim.SimulationProcess;
import org.javasim.streams.ExponentialStream;

public class TravelToDrink extends SimulationProcess {

    private Customer customer;
    private ExponentialStream time = new ExponentialStream(1);
    public TravelToDrink(Customer customer) {
        this.customer = customer;
    }

    @Override
    public  void run() {
        while (!this.terminated()) {
            try {
                // Travel to drink time
                hold(0.15);
             //   System.out.println("c" + customer.getId() + " Travel To Drink + " + Scheduler.currentTime());

                // check if any drink workers are available
                while (SimulatorCore.drinkWorkers <= 0) {
               //     System.out.println("c" + customer.getId() + "No drinkWorkers");
                    SimulatorCore.drinkingQueue.add(this);
                    this.suspendProcess();
                }


                SimulatorCore.drinkWorkers--;
                new PouringDrink(this.customer).activate();


                this.terminate();

            } catch (SimulationException e) {
                e.printStackTrace();
            } catch (RestartException e) {
                e.printStackTrace();

            }


        }
    }


}
