import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {

    public static void main(String[] args) {
        //mimiciing a server that runs 24/7
        ExecutorService es = Executors.newFixedThreadPool(5);
        while(true){
            Scanner sc = new Scanner(System.in);
            System.out.println("Please input the data to run program : ");
            String data = sc.nextLine();
            es.submit(new Runnable() {
                @Override
                public void run() {
                    try {

                        Thread.sleep(500);
                        System.out.println("The entered data at current thread"+Thread.currentThread().getName()+" "+ " : "+data);


                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
            });

        }

    }

}
