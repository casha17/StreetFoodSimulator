import org.javasim.RestartException;
import org.javasim.Simulation;
import org.javasim.SimulationException;

public class main {

    public static void main(String[] args) throws SimulationException, RestartException {

        //Create Simulator core
        for (int i = 0; i<10;i++) {
            SimulatorCore simulation = new SimulatorCore();
            SimulatorCore.totalNumberOfCustomers = 3;
            simulation.await();
            SimulatorCore.reset();
        }


        System.exit(0);

    }
}
