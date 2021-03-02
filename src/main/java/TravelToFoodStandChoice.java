import org.javasim.*;
        import org.javasim.streams.ExponentialStream;
        import java.io.IOException;

public class TravelToFoodStandChoice extends SimulationProcess {

    private ExponentialStream InterArrivalTime;
    public Customer customer;

    public TravelToFoodStandChoice(Customer customer) {
        this.customer = customer;
    }
    public void run ()
    {
        while (!terminated()){
            try
            {
                //Traveling time
                hold(0.15);

                // Get branching probability
                int branch = SimulatorCore.getBigBranch();


                if (branch < 34) {
                   // System.out.println( "c"+this.customer.getId() +  " Decided Pizza" + Scheduler.currentTime());
                    new TravelToPizza(this.customer).activate();
                } else if (branch < 67) {
                   // System.out.println( "c"+this.customer.getId() +  " Decided Chinese " + Scheduler.currentTime());
                    new TravelToChinese(this.customer).activate();
                } else {
                   // System.out.println( "c"+this.customer.getId() +  " Decided Burger " + Scheduler.currentTime());
                    new TravelToBurger(this.customer).activate();
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
