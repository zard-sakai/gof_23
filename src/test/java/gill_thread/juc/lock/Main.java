package gill_thread.juc.lock;

import java.util.Random;
import java.util.concurrent.locks.ReentrantLock;

public class Main {

    public static void main(String[] args) {
        int number = 10;
        ReentrantLock lock = new ReentrantLock();

        for (int i = 0; i < number; i++) {
            new Thread(() -> {
                try {
                    System.out.println(Thread.currentThread().getName()+" acquire lock");
                    lock.lock();
                    System.out.println(Thread.currentThread().getName()+" get lock and do sth");
                    Thread.sleep(5000);
                }catch(Exception exception){

                }finally {
                    lock.unlock();
                    System.out.println(Thread.currentThread().getName()+" release lock");
                }
            }, "thread-" + i).start();
        }

    }

}
