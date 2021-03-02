
import org.javasim.*;
        import org.javasim.streams.ExponentialStream;
import org.javasim.streams.UniformStream;

import java.io.IOException;

public class RecievePizza extends SimulationProcess {

    private UniformStream pizzaMakingTime = new UniformStream(0.15,0.45);
    public Customer customer;

    public RecievePizza(Customer customer) {
        this.customer = customer;
    }
    public void run ()
    {
        while (!terminated()){
            try
            {
                //Waiting for pizza to finish
                hold(pizzaMakingTime.getNumber());
                SimulatorCore.pizzaWorkers++;
                new OrderAgainOrLeave(this.customer).activate();
                this.terminate();
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
