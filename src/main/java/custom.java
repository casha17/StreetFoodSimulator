import org.javasim.*;
import org.javasim.streams.ExponentialStream;
import java.io.IOException;

public class custom extends SimulationProcess {

    private ExponentialStream InterArrivalTime;
    public Customer customer;

    public custom(Customer customer) {
        this.customer = customer;
    }
    public void run ()
    {
        while (!terminated()){
            try
            {
                //Deciding to only drink
                hold(1);

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
