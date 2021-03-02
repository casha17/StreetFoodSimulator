import org.javasim.*;
import org.javasim.streams.ExponentialStream;
import java.io.IOException;

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
                hold(1);
                System.out.println("c"+ customer.getId() + " Pay " + Scheduler.currentTime() );
                //release cashier
                SimulatorCore.cashiers++;
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
