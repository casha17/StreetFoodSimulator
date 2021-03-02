import org.javasim.*;
import org.javasim.streams.ExponentialStream;
import java.io.IOException;

public class DecideOnlyDrink extends SimulationProcess {

    private ExponentialStream InterArrivalTime;
    public Customer customer;
    public TravelTo to;

    public DecideOnlyDrink(Customer customer) {
        this.customer = customer;
    }
    public void run ()
    {
        while (!terminated()){
            try
            {
                //Time Deciding to only drink
                hold(0.15);

              //  System.out.println( "c"+this.customer.getId() +  " Decide " + Scheduler.currentTime());


                //Also Food

                if (SimulatorCore.getBranch() < 6) {
              //      System.out.println( "c"+this.customer.getId() +  " Decided also food " + Scheduler.currentTime());
                    new TravelToFoodStandChoice(this.customer).activate();
                } else {
             //       System.out.println( "c"+this.customer.getId() +  " Decided only drink " + Scheduler.currentTime());
                    new OrderAgainOrLeave(this.customer).activate();


                }


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
