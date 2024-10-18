package gill_thread.juc.notify;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 线程通信：交替打印  Condition await,signal 实现
 * 1,3,5,7,9
 * 2,4,6,8,10
 */
public class Main2 {

    private final ReentrantLock lock = new ReentrantLock();
    private final Condition printOddCondition = lock.newCondition();
    private final Condition printNotOddCondition = lock.newCondition();

    private volatile boolean printOdd = true;

    public static void main(String[] args) throws Exception {
        Main2 main = new Main2();
        Thread printOddThread = new Thread(() -> {
            main.printOdd();
        },"Print-Odd-Thread");

        Thread printNotOddThread = new Thread(() -> {
            main.printNotOdd();
        },"Print-NotOdd-Thread");

        printOddThread.start();
        printNotOddThread.start();

        printOddThread.join();
        printNotOddThread.join();
    }

    private void printOdd(){
        for (int i = 1; i <= 9; i=i+2) {
            lock.lock();
            try {
                while(!printOdd){
                    printOddCondition.await();
                }
                System.out.println(Thread.currentThread().getName()+":"+i);
                printOdd = false;
                printNotOddCondition.signal();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                e.printStackTrace();
            } finally {
                lock.unlock();
            }

        }
    }

    private void printNotOdd(){
        for (int i = 2; i <= 10; i=i+2) {
            lock.lock();
            try {
                while (printOdd){
                    printNotOddCondition.await();
                }
                System.out.println(Thread.currentThread().getName()+":"+i);
                printOdd = true;
                printOddCondition.signal();
            } catch (Exception e) {
                Thread.currentThread().interrupt();
                e.printStackTrace();
            } finally {
                lock.unlock();
            }
        }
    }

}
