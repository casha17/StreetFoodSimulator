package org.example;

import org.javasim.*;
        import org.javasim.streams.ExponentialStream;

public class TravelToFoodOrDrink extends SimulationProcess {

    private ExponentialStream InterArrivalTime = new ExponentialStream(1);
    public Customer customer;
    public TravelTo to;

    public TravelToFoodOrDrink(Customer customer) {
        this.customer = customer;
    }
    public void run ()
    {
        while (!terminated()){
            try
            {
                // Travel to Food or drink traveling time
                hold(0.15);

                //Printer helper
             //   System.out.println("c"+ customer.getId() + " Travel to food or drink " + Scheduler.currentTime() );
                // 40% chance
                if (SimulatorCore.getBranch() > 4) {
                   // System.out.println( "c"+this.customer.getId() +  " Decided Food " + Scheduler.currentTime());
                    new TravelToFoodStandChoice(this.customer).activate();

                    // 60% chance
                } else {
                 //   System.out.println( "c"+this.customer.getId() +  " Decided Drink " + Scheduler.currentTime());
                    new TravelToDrink(this.customer).activate();
                }

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
