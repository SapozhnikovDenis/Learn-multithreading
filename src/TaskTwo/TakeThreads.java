package Threads.TaskTwo;

//Разгружающий поток
class TakeThreads implements Runnable {

    @Override
    public void run() {
        while (true) {
            if (Stock.product > 0) {
                Stock.takeProduct();
                try {
                    Thread.sleep(5);
                } catch (InterruptedException e) {break;}
            }
            else {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {break;}
            }
        }
    }
}