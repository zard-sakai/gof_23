package gill_thread.juc.utils.cyclicBarrier;

import java.util.Random;
import java.util.concurrent.CyclicBarrier;

public class Main {

    public static void main(String[] args) {
        int number = 10;
        CyclicBarrier cyclicBarrier = new CyclicBarrier(number);

        for (int i = 0; i < number; i++) {
            new Thread(() -> {
                try {
                    Thread.sleep(new Random().nextInt(5000));
                    System.out.println(Thread.currentThread().getName()+" wait");
                    // 所有线程执行await方法都被阻塞，直到第number个线程执行，将被阻塞的线程都唤醒；
                    // 场景：多个线程相互等待，达到某个条件，再继续执行；
                    cyclicBarrier.await();
                    System.out.println(Thread.currentThread().getName()+ " finish");
                }catch (Exception exception){

                }
            },"thread-"+i).start();
        }
    }

}
