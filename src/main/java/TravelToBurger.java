
import org.javasim.*;
import org.javasim.streams.ExponentialStream;
import java.io.IOException;

public class TravelToBurger extends SimulationProcess {

    public Customer customer;

    public TravelToBurger(Customer customer) {
        this.customer = customer;
    }
    public void run ()
    {
        while (!terminated()){
            try
            {
                //Traveling to Burger time
                hold(0.15);

                while (SimulatorCore.burgerWorkers <= 0) {
                 //   System.out.println("c" + customer.getId() + "No burgerWorkers");
                    SimulatorCore.burgerQueue.add(this);
                    this.terminate();
                }


                SimulatorCore.burgerWorkers--;
                new RecieveBurger(this.customer).activate();


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
