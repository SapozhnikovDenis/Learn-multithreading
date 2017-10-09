package Threads.TaskOne;


public class Main {

        public static int time = 10;

        public static void main(String args[]) {
            Thread oneThread = new Thread(new Clock());
            Thread twoThread = new Thread(new Clock());

            oneThread.start();
            twoThread.start();
        }

        public static synchronized void decrement() {
            System.out.println(Thread.currentThread().getName() + " " + Main.time);
            Main.time--;
        }
    }


