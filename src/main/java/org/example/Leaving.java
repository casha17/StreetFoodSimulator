package org.example;

import org.javasim.*;
import org.javasim.streams.ExponentialStream;

public class Leaving extends SimulationProcess {

    private ExponentialStream InterArrivalTime;
    public Customer customer;

    public Leaving(Customer customer) {
        this.customer = customer;

    }
    public void run ()
    {
        while (!terminated()){
            try
            {
                //org.example.Leaving time
                hold(0.15);
             //   System.out.println("c"+this.customer.getId() + " org.example.Leaving" + " " + Scheduler.currentTime());
                SimulatorCore.totalCustomersLeaved++;
                this.terminate();
            }
            catch (SimulationException e)
            {
            }
            catch (RestartException e)
            {
            }
        }
    }
}
