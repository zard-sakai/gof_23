package gill_thread.juc.notify;

/**
 * 线程通信：交替打印  Object wait,notify 实现
 * 1,3,5,7,9
 * 2,4,6,8,10
 */
public class Main {

    private volatile boolean printOdd = true;

    public static void main(String[] args) throws Exception{

        Main main = new Main();
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

    private synchronized void printOdd(){
        for (int i = 1; i <= 9; i=i+2) {
            while (!printOdd){
                try {
                    wait();
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
            System.out.println(Thread.currentThread().getName()+":"+i);
            printOdd = false;
            notify();
        }
    }

    private synchronized void printNotOdd(){
        for (int i = 2; i <= 10; i=i+2) {
            while(printOdd){
                try {
                    wait();
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
            System.out.println(Thread.currentThread().getName()+":"+i);
            printOdd = true;
            notify();
        }
    }

}
