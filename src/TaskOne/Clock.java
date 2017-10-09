package Threads.TaskOne;


class Clock implements Runnable {

    @Override
    public void run() {
        while (true){
            Main.decrement();
            try {
                Thread.sleep(5);
            } catch (InterruptedException e) {}
            if (Main.time < 0) {
                break;
            }
        }
    }
}
