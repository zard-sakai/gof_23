package gill_thread.juc.utils.countdownlatch;

import java.util.Random;
import java.util.concurrent.CountDownLatch;

public class Main {

    public static void main(String[] args) throws Exception{
        int number = 10;

        CountDownLatch countDownLatch = new CountDownLatch(number);


        for (int i = 0; i < number; i++) {
            new Thread(() -> {
                try {
                    Thread.sleep(new Random().nextInt(5000));
                    System.out.println(Thread.currentThread().getName());
                    countDownLatch.countDown();
                }catch (Exception exception){

                }
            },"thread-"+i).start();
        }

        // 1个线程 等待 多个线程
        System.out.println(Thread.currentThread().getName()+" wait");
        countDownLatch.await();
    }

}
