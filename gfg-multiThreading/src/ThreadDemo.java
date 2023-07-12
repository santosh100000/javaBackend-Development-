public class ThreadDemo {

    public static void main(String[] args) {
        MyThread thread = new MyThread();
        thread.setName("Thread-01");
        thread.start();// creates new thread, Moves to runnable state,
        //Then one of cpu core picks this and moves to running state,

        //thread.run();//runs main thread

        try {
            thread.join();//Join make sure runnable is runn
        } catch (InterruptedException e) {
            e.printStackTrace();
        }


        System.out.println("Done :"+Thread.currentThread().getName());

    }
}
