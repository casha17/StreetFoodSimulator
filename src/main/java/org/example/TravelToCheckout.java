package org.example;

import org.javasim.*;
import org.javasim.streams.ExponentialStream;

public class TravelToCheckout extends SimulationProcess {

    private ExponentialStream InterArrivalTime;
    public Customer customer;

    public TravelToCheckout(Customer customer) {
        this.customer = customer;
    }
    public void run ()
    {
        while (!terminated()){
            try
            {
                //Traveling time
                hold(0.15);
                //using cashier
             //   System.out.println("c"+ customer.getId() + " Travel to checkout " + Scheduler.currentTime() );
                while (SimulatorCore.cashiers <= 0) {
              //      System.out.println("c" + customer.getId() + "No Cashier");
                    SimulatorCore.cashierQueue.add(this);
                    this.suspendProcess();
                }

                SimulatorCore.cashiers--;

                new Pay(this.customer).activate();

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
