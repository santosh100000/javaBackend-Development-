public class RunnableDemo {

    public static void main(String[] args) {

        System.out.println("Starting :"+ Thread.currentThread().getName());
        MyTask task = new MyTask("API CALL");

        Thread t1 = new Thread(task);
        t1.start();

        Thread t2 = new Thread(task);
        t2.start();

        try {
            t1.join();
            t2.join();//wait for t2 to execute
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("Done :"+Thread.currentThread().getName());
    }
}
