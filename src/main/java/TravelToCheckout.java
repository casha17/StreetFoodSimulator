import org.javasim.*;
import org.javasim.streams.ExponentialStream;
import java.io.IOException;

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
                hold(1);
                //using cashier
                System.out.println("c"+ customer.getId() + " Travel to checkout " + Scheduler.currentTime() );
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
