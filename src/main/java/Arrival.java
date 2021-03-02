import org.javasim.*;
import org.javasim.streams.ExponentialStream;

import java.io.IOException;

public class Arrival extends SimulationProcess {

    private ExponentialStream InterArrivalTime = new ExponentialStream(1);
    public Customer customer;


    public void run ()
    {
        while (!this.terminated()){
            try
            {
                // Time until next customer arrives
                hold(InterArrivalTime.getNumber());

                // Customer arrived increase total arrivals with one
                SimulatorCore.customerArrivals++;

                // Create new Customer object
                customer = new Customer(SimulatorCore.customerArrivals , Scheduler.currentTime());

                // Print for helping debugging
                System.out.println("c"+ customer.getId() + " arrival " + Scheduler.currentTime() );

                // new Travel to
                new TravelTo(customer).activate();



            }
            catch (SimulationException e)
            {
            }
            catch (RestartException e)
            {
            } catch (IOException e) {
                e.printStackTrace();
            }


        }

    }
}
