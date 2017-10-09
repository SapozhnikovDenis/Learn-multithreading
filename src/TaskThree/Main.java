package Threads.TaskThree;

import java.util.*;

/*Есть библиотека. В библиотеке 10 книг, 6 которые можно взять на руки, 4 которые можно только в читальный зал.
Читатель может взять либо одну, либо другу книгу. После прочтения, он должен вернуть книгу.
Выбор книги и время чтения случайное (от 2-5 секунд). В библиотеку заходят 100 читателей.
Реализовать работу этой библиотеки, чтоб каждый читатель был обслужен.
О количестве книг знает только библиотекарь.
Библиотекарь и читатели это потоки.
Все действия писать консоль.*/

public class Main {
    public static final int readersAll = 100;
    public static Random random = new Random();
    public static boolean finish = false;
    public static volatile int counter = 0;
    public static Librain librain = new Librain();
    public static Library library = new Library();

    public static void main(String args[]) {
        Thread threadLibrain = new Thread(librain);
        threadLibrain.setName("Библиотекарь");
        threadLibrain.start();

        for (int i = 1; i < readersAll + 1; i++) {
            Thread thread = new Thread(new Reader());
            thread.setName("Читатель №" + i);
            thread.start();
        }

        while (counter < readersAll){}
        finish = true;
    }
}