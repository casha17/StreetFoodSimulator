import org.javasim.*;
import org.javasim.streams.ExponentialStream;
import java.io.IOException;

public class LeaveTable extends SimulationProcess {

    private ExponentialStream InterArrivalTime;
    public Customer customer;

    public LeaveTable(Customer customer) {
        this.customer = customer;
    }
    public void run ()
    {
        while (!terminated()){
            try
            {
                //Leaving table
                hold(0.15);
            //    System.out.println("c"+ customer.getId() + " Leave table " + Scheduler.currentTime() );
                //release table
                SimulatorCore.tables++;
                if (!SimulatorCore.tableQueue.isEmpty()) {

                        SimulatorCore.tableQueue.pop().activate();

                }

                new TravelToCheckout(this.customer).activate();

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
