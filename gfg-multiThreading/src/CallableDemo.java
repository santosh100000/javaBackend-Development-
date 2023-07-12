import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class CallableDemo {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(4);
        CallableTask callableTask = new CallableTask();
       Future<String> future = executorService.submit(callableTask); //Returns future immdiately, like promise in JS
        System.out.println("isDone "+ future.isDone());
        try {
            //blocks unitl task completed
            System.out.println(future.get());
            System.out.println("isDone "+ future.isDone());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
    }
        executorService.shutdown();
        System.out.println("Done");
}}
