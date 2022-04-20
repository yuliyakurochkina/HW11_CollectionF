package Exe1;

import java.util.concurrent.*;
//Задание1

public class ConsumerProducer {
    public static void main(String[] args) {
        BlockingQueue<String> queue = new LinkedBlockingDeque<>();


//        Producer producer = new Producer(queue);
        Consumer consumer = new Consumer(queue);

//        ExecutorService executorService = Executors.newFixedThreadPool(3);
//        executorService.submit(producer);
//        Future future = executorService.submit(consumer);
//        executorService.shutdown();
//
//        try {
//            future.get(2L, TimeUnit.SECONDS);
//        } catch (InterruptedException | ExecutionException | TimeoutException e) {
//            future.cancel(true);
//        }

        System.out.println(consumer.getNumber());
    }
}
