//Estimate the value of Pi using Monte-Carlo Method, using parallel program
public class PiEstimate {
    public static void main(String[] args) {
        //Check if number of simulations is present
        if(args.length != 1) {
            System.out.println("Usage:\njava -jar MonteCarloPi.jar 1eX\n" +
                    "The parameter represents the number of points simulated onto the plane.\n" +
                    "'X' is your exponent of choice and in order to get a significant result MUST be >= 3.");
            System.exit(1);
        }
        //Check if number of simulations is big enough to get a significant result
        int nThrows = Double.valueOf(args[0]).intValue();
        if(nThrows < 1000) {
            System.out.println("Usage:\njava -jar MonteCarloPi.jar 1eX\n" +
                    "The parameter represents the number of points simulated onto the plane.\n" +
                    "'X' is your exponent of choice and in order to get a significant result MUST be >= 3.");
            System.exit(1);
        }
        //Run simulations and get result
        try {
            PiMonteCarlo PiVal = new PiMonteCarlo(nThrows);
            long startTime = System.currentTimeMillis();
            double value = PiVal.getPi();
            long stopTime = System.currentTimeMillis();
            System.out.println("Exact value of pi:\t" + Math.PI);
            System.out.println("Approx value:\t\t" + value);
            System.out.println("Error:\t\t\t\t" + (value - Math.PI));
            System.out.println("Percentage error:\t" + (value - Math.PI) / Math.PI * 100 + " %");
            System.out.printf("Simulated points:\t%d\n", nThrows);
            System.out.println("Available cores:\t" + Runtime.getRuntime().availableProcessors());
            System.out.println("Time duration:\t\t" + (stopTime - startTime) + "ms");
        } catch (InterruptedException e) {
            System.out.println(e.getMessage());
            System.exit(1);
        }
    }
}