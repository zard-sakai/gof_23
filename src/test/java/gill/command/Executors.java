package gill.command;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class Executors {

    private static BlockingQueue<Task> taskQueue = new ArrayBlockingQueue(16);

    public static void submit(Task task){
        taskQueue.add(task);
    }

    public static void execute(Task task){
        task.run();
    }



}
