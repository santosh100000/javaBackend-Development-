import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class RaceConditionDemo implements Runnable{

    private int count = 0;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public static void main(String[] args) {

        ExecutorService es = Executors.newFixedThreadPool(10);
        RaceConditionDemo rcd = new RaceConditionDemo();

        for (int i = 0; i < 200; i++) {
           // es.submit(new RaceConditionDemo());
            es.submit(rcd);
            try {
                Thread.sleep(1);
                System.out.println("Thread executing "+ Thread.currentThread().getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
        es.shutdown();

        try {
            es.awaitTermination(1, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("count: "+rcd.getCount());
        System.out.println("Done executing");

    }

    @Override
    public void run() {
        count++;
    }
}
