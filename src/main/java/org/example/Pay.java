package org.example;

import org.javasim.*;
import org.javasim.streams.ExponentialStream;

public class Pay extends SimulationProcess {

    private ExponentialStream InterArrivalTime;
    public Customer customer;

    public Pay(Customer customer) {
        this.customer = customer;
    }
    public void run ()
    {
        while (!terminated()){
            try
            {
                //Paying time
                hold(0.15);

                SimulatorCore.cashiers++;
                if (!SimulatorCore.cashierQueue.isEmpty()) {

                        SimulatorCore.cashierQueue.pop().activate();

                }
             //   System.out.println("c"+ customer.getId() + " org.example.Pay " + Scheduler.currentTime() );

                new Leaving(this.customer).activate();

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
