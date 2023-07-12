import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolExecutorDemo {


    public static void main(String[] args) {
        int corePoolSize= 5; // initially this size
        int maxPoolSize = 10000;// tasks increase then threads get upto this
        long keepALiveTime = 5000; // checks, if tasks is decrease with this time then thread decreas
        ExecutorService threadPoolExecutor = new ThreadPoolExecutor(
                corePoolSize,
                maxPoolSize,
                keepALiveTime,
                TimeUnit.MILLISECONDS,
                new LinkedBlockingDeque<Runnable>(100)
        );

        for (int i = 0; i < 20000; i++) {
            threadPoolExecutor.submit(new Runnable() {
                @Override
                public void run() {
                    System.out.println("Executing this thread "+ Thread.currentThread().getName());
                }
            });

        }

        threadPoolExecutor.shutdown();//all task is done, don't take any more task;

        try {
            threadPoolExecutor.awaitTermination(1, TimeUnit.MILLISECONDS);//TERMINATE. THREAD within maximum of 1 MIN
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Done after 1 min"+Thread.currentThread().getName());
    }
}
