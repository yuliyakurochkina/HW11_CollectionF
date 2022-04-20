package Exe1;

import java.util.concurrent.BlockingQueue;

//Задание1
public class Consumer implements Runnable {
    private int number = 0;
    private final BlockingQueue<String> queue;

    public Consumer(BlockingQueue<String> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        while (true) {
            try {
                String word = queue.take();
                System.out.println(word);
                number = number + 1;
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public int getNumber() {
        return number;
    }
}

