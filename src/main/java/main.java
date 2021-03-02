import org.javasim.RestartException;
import org.javasim.Simulation;
import org.javasim.SimulationException;

import java.util.Timer;

public class main {

    public static void main(String[] args) throws SimulationException, RestartException {

        //Create Simulator core
        for (int i = 0; i<3;i++) {
            long startTime = System.currentTimeMillis();
            SimulatorCore simulation = new SimulatorCore();
            SimulatorCore.totalNumberOfCustomers = 100000;
            simulation.await();
            SimulatorCore.reset();
            long stopTime = System.currentTimeMillis();
            long elapsedTime = stopTime - startTime;
            System.out.println(elapsedTime);
        }


        System.exit(0);

    }
}
