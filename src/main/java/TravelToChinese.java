
import org.javasim.*;
import org.javasim.streams.ExponentialStream;
import java.io.IOException;

public class TravelToChinese extends SimulationProcess {

    public Customer customer;

    public TravelToChinese(Customer customer) {
        this.customer = customer;
    }
    public void run ()
    {
        while (!terminated()){
            try
            {
                //Traveling to chinese time
                hold(0.15);

                while (SimulatorCore.chineseWorkers <= 0) {
              //      System.out.println("c" + customer.getId() + "No chinese workers");
                    SimulatorCore.chineseQueue.add(this);
                    this.suspendProcess();
                }


                SimulatorCore.chineseWorkers--;
                new RecieveChinese(this.customer).activate();


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
