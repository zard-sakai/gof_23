package gill.command;

public class Main {

    public static void main(String[] args) {
        Task task = new Task() {
            @Override
            public void run() {
                // do sth
            }
        };
        Executors.execute(task);
    }
}
