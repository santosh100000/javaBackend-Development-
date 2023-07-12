import java.util.concurrent.Callable;

public class CallableTask implements Callable<String> {

    @Override
    public String call() throws Exception {
        System.out.println("Returning data from thread"+Thread.currentThread().getName());
        return "Returning data from thread";

    }
}
