import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ProducerConsumer {

    //Here we have a buffer Queque producer should add new item in queque while consumer should remove from buffer

    Queue<Integer> buffer = new LinkedList<>();


    public static int generateItems(){
        int item = (int)(Math.random()*10);
        return item;
    }

    public void produceBuffer(){
        if(buffer.size() <= 10){
            int generatedItems = ProducerConsumer.generateItems();
            buffer.add(generatedItems);
            System.out.println("Produced : "+generatedItems);
        }

    }

    public void consumerBuffer(){
            if(!buffer.isEmpty()){
                int item = buffer.remove();
                System.out.println("Consumed :"+item);
            }
    }


    static class ProducerThread extends Thread{
    private  ProducerConsumer producerConsumer;

        @Override
        public void run(){

            try {
                producerConsumer.produceBuffer();
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
    static class ConsumerThread implements Runnable{
        private  ProducerConsumer producerConsumer;

        @Override
        public void run() {
            try {
                producerConsumer.consumerBuffer();
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

    public static void main(String[] args) {
        ProducerConsumer producerConsumer = new ProducerConsumer();
        Thread producerThread = new Thread(new ProducerThread());
        Thread consumerThread = new Thread(new ConsumerThread());

        producerThread.start();
        consumerThread.start();
    }

}
