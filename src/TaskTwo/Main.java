package Threads.TaskTwo;

public class Main {

    public static void main(String args[]) {

        Thread threadG0 = new Thread(new GiveThreads());
        threadG0.start();
        Thread threadG1 = new Thread(new GiveThreads());
        threadG1.start();
        Thread threadG2 = new Thread(new GiveThreads());
        threadG2.start();

        Thread threadT0 = new Thread(new TakeThreads());
        threadT0.start();
        Thread threadT1 = new Thread(new TakeThreads());
        threadT1.start();
        Thread threadT2 = new Thread(new TakeThreads());
        threadT2.start();

        while (true) {
            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {}

            System.out.println("Now " + Stock.product + " products in stock.");
        }
    }
}