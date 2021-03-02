import org.javasim.RestartException;
import org.javasim.Scheduler;
import org.javasim.SimulationException;
import org.javasim.SimulationProcess;
import org.javasim.streams.ExponentialStream;

import java.io.IOException;

public class TravelTo extends SimulationProcess {

    private Customer customer;
    private ExponentialStream InterArrivalTime = new ExponentialStream(1);
    public TravelTo(Customer customer) {
        this.customer = customer;
    }

    @Override
    public void run() {
        while (!this.terminated()) {
        try {
            // time to Travel to street Food
            hold(0.15);

            //Check if there are tables
            while (SimulatorCore.tables <= 0) {
           //     System.out.println("c" + customer.getId() + "No tables waiting");

                // Add to waiting queue and suspend
                SimulatorCore.tableQueue.add(this);
                this.suspendProcess();
            }
            // If tablesQueue is not empty take next customer and enter

            // Reserve table
            SimulatorCore.tables--;

            // Travel to foodOrDrink
            new TravelToFoodOrDrink(this.customer).activate();


            this.terminate();

        } catch (SimulationException e) {
            e.printStackTrace();
        } catch (RestartException e) {
            e.printStackTrace();
        }
        }


    }


}
