package org.example;

import org.javasim.*;
import org.javasim.streams.ExponentialStream;

public class Arrival extends SimulationProcess {

    private ExponentialStream InterArrivalTime = new ExponentialStream(1);
    public Customer customer;


    public void run ()
    {
        while (!this.terminated()){
            try
            {
                // Time until next customer arrives
                hold(0.1);

                // org.example.Customer arrived increase total arrivals with one
                SimulatorCore.customerArrivals++;

                // Create new org.example.Customer object
                customer = new Customer(SimulatorCore.customerArrivals , Scheduler.currentTime());

                // Print for helping debugging
             //   System.out.println("c"+ customer.getId() + " arrival " + Scheduler.currentTime() );

                // new Travel to
                new TravelTo(customer).activate();

                if(SimulatorCore.customerArrivals >= SimulatorCore.totalNumberOfCustomers) {
                    this.terminate();

                }


            }
            catch (SimulationException e)
            {
            }
            catch (RestartException e)
            {
            }
            /*catch (IOException e) {
                e.printStackTrace();
            }

             */


        }

    }
}
