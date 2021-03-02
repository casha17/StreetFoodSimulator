
import org.javasim.*;
        import org.javasim.streams.ExponentialStream;
        import java.io.IOException;

public class TravelToPizza extends SimulationProcess {

    private ExponentialStream InterArrivalTime;
    public Customer customer;

    public TravelToPizza(Customer customer) {
        this.customer = customer;
    }
    public void run ()
    {
        while (!terminated()){
            try
            {
                //Traveling to pizza time
                hold(0.15);

                 while (SimulatorCore.pizzaWorkers <= 0) {
                   // System.out.println("c" + customer.getId() + "No Pizzaworkers");
                    SimulatorCore.pizzaQueue.add(this);
                    this.terminate();
                }


                SimulatorCore.pizzaWorkers--;
                new RecievePizza(this.customer).activate();


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
