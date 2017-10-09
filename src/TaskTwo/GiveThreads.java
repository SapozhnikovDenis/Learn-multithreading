package Threads.TaskTwo;

//Загружающий поток
class GiveThreads implements Runnable {

    @Override
    public void run() {
        while (true) {
            if (Stock.product < Stock.maxProduct) {
                Stock.giveProduct();
                if (Stock.product > (Stock.maxProduct / 100 * 30)) {
                    try {
                        Thread.sleep(100);
                    } catch (InterruptedException e) {break;}
                }
                else {
                    try {
                        Thread.sleep(5);
                    } catch (InterruptedException e) {break;}
                }
            } else {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {break;}
            }
        }
    }
}

