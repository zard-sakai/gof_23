package gill_thread.juc.utils.semaphore;

import java.util.Random;
import java.util.concurrent.Semaphore;

public class Main {

    public static void main(String[] args) {
        int number = 10;
        Semaphore semaphore = new Semaphore(2);// 2个资源

        for (int i = 0; i < number; i++) {
            new Thread(() -> {
                try {
                    semaphore.acquire(1);
                    System.out.println(Thread.currentThread().getName() + " get lock resource");
                    Thread.sleep(new Random().nextInt(5000));
                } catch (Exception exception) {

                }finally {
                    semaphore.release(1);
                }
            }, "thread-" + i).start();
        }

        // 场景：控制线程 并发数 的场景；
    }

}
