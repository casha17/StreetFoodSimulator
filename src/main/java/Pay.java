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
                hold(0.15);

                SimulatorCore.cashiers++;
                if (!SimulatorCore.cashierQueue.isEmpty()) {
                    try {
                        SimulatorCore.cashierQueue.pop().activate();
                    } catch (Exception ex) {

                    }
                }
            //    System.out.println("c"+ customer.getId() + " Pay " + Scheduler.currentTime() );

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
