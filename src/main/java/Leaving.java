import org.javasim.*;
import org.javasim.streams.ExponentialStream;
import java.io.IOException;

public class Leaving extends SimulationProcess {

    private ExponentialStream InterArrivalTime;
    public Customer customer;

    public Leaving(Customer customer) {
        this.customer = customer;

    }
    public void run ()
    {
        while (!terminated()){
            try
            {
                //Leaving time
                hold(1);
                System.out.println("c"+this.customer.getId() + " Leaving!!" + " " + Scheduler.currentTime());
                Simulation.printQueue();
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