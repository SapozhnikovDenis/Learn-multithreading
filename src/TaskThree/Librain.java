package Threads.TaskThree;

import java.util.concurrent.Exchanger;
import java.util.concurrent.Semaphore;

class Librain implements Runnable {
    private static boolean flagRestoreBook = false;
    private static boolean flagGetBook = false;
    private static Semaphore semaphoreGet = new Semaphore(1, true);
    private static Semaphore semaphoreRestore = new Semaphore(1, true);
    private static Exchanger<Book> exchangerGet = new Exchanger<>();
    private static Exchanger<Book> exchangerRestore = new Exchanger<>();
    private static Where whereGet = null;
    private static Where whereRestore = null;

    @Override
    public void run() {
        try {
            while (!Main.finish) {
                getBookLibrain();
                Thread.sleep(100);
                restoreBookLibrain();
            }
        } catch (InterruptedException e) {}
    }

    public static Book getBookLibrain() {
        Book getBook = null;
        Book returnBook = null;
        try {
            if (flagGetBook) {
                try {
                    getBook = Main.library.getBook(whereGet);
                } catch (ArrayIndexOutOfBoundsException e) {
                    return null;
                }
                //System.out.println(Thread.currentThread().getName() + " принес с библиотеки книгу " + getBook);
            }
            else return null;

            returnBook = exchangerGet.exchange(getBook);

            //System.out.println(Thread.currentThread().getName() + " осталось на руках " + returnBook);
        } catch (InterruptedException e) {}
        return returnBook;
    }

    public static Book getBookReader(Where where){
        Book getBook = null;
        Book returnBook = null;
        try {
            semaphoreGet.acquire();
            flagGetBook = true;
            Librain.whereGet = where;

            //System.out.println(Thread.currentThread().getName() + " просит у библиотекаря книгу. На руках у него " + returnBook);

            returnBook = exchangerGet.exchange(getBook);

            //System.out.println(Thread.currentThread().getName() + " взял книгу " + returnBook);

            flagGetBook = false;
            semaphoreGet.release();
        } catch (InterruptedException e) {}
        return returnBook;
    }

    public static void restoreBookLibrain() {
        if (flagRestoreBook) {
            Book returnBook = null;
            try {
                returnBook = exchangerRestore.exchange(null);
                Main.library.restoreBook(returnBook, whereRestore);
                System.out.println(Thread.currentThread().getName() + " принимает книгу " + returnBook + ". Книг возвращено " + ++Main.counter);
                flagRestoreBook = false;
                semaphoreRestore.release();
            } catch (InterruptedException e) {
            }
        }
    }

    public static void restoreBookReader(Where where,Book getBook){
        try {
            semaphoreRestore.acquire();
        } catch (InterruptedException e){}
        flagRestoreBook = true;
        whereRestore = where;

        //System.out.println(Thread.currentThread().getName() + " хочет вернуть книгу " + getBook);

        if (flagRestoreBook) {
            try {
                exchangerRestore.exchange(getBook);
            } catch (InterruptedException e) {}
        }
    }
}