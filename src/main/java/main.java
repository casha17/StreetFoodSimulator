import org.javasim.RestartException;
import org.javasim.SimulationException;

public class main {

    public static void main(String[] args) throws SimulationException, RestartException {

        //Create Simulator core
        SimulatorCore simulation = new SimulatorCore();
        simulation.await();
        System.exit(0);
    }
}
