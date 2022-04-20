package Exe1;

import java.io.File;
import java.util.concurrent.BlockingQueue;

//Задание1
public class Producer implements Runnable {
    private final Parser1 parser1 = new Parser1();
    private final BlockingQueue<String> queue;
    public Producer(BlockingQueue<String> queue) {
        this.queue = queue;
    }

    @Override
    public void run() {
        File file = new File("voyna1.txt");
        for (String str : parser1.parse(file)) {
            if (str.matches("^[Сс]трада(.*)")) {
                try {
                    queue.put(str);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}