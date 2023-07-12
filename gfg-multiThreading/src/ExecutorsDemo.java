import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ExecutorsDemo {

    public static void main(String[] args) {
        ExecutorService fixExecutorService = Executors.newFixedThreadPool(6);//6 workers thread

        long start = System.currentTimeMillis();

        for (int i = 0; i < 20; i++) {
            //Passing task , obj of runnable
            fixExecutorService.submit(new Runnable() {
                @Override
                public void run() {
                    System.out.println(  "Tasking Runnning in: "+Thread.currentThread().getName());
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            })   ;
        }
        fixExecutorService.shutdown();

        try {
//            fixExecutorService.wait();
            fixExecutorService.awaitTermination(100, TimeUnit.MINUTES);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        long end = System.currentTimeMillis();
        System.out.println("total time taken : "+(end-start));
    }
}
