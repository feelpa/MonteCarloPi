import java.util.concurrent.atomic.AtomicInteger;

class PiMonteCarlo {
    AtomicInteger nAtomSuccess;
    int nThrows;
    double value;
    class MonteCarlo implements Runnable {
        int trialsPerThread;
        public MonteCarlo(int i) {
            this.trialsPerThread = i;
        }
        @Override
        public void run() {
            for (int i = 0; i < trialsPerThread; i++) {
                double x = Math.random();
                double y = Math.random();
                if (x * x + y * y <= 1) {
                    nAtomSuccess.incrementAndGet();
                }
            }
        }
    }
    public PiMonteCarlo(int i) {
        this.nAtomSuccess = new AtomicInteger(0);
        this.nThrows = i;
        this.value = 0;
    }
    public double getPi() throws InterruptedException {
        int nProcessors = Runtime.getRuntime().availableProcessors();
        Thread[] threads = new Thread[nProcessors];
        for (int i = 0; i < nProcessors; i++) {
            Runnable worker = new MonteCarlo((nThrows / nProcessors));
            threads[i] = new Thread(worker);
            threads[i].start();
        }
        for (int i = 0; i < nProcessors; i++) {
            threads[i].join();
        }
        value = 4.0 * nAtomSuccess.get() / nThrows;
        return value;
    }
}