package Threads.TaskThree;

import java.util.LinkedList;
import java.util.Queue;

class Book{
    private static Queue<String> NAMES = new LinkedList<String>() {{
        add("Война и мир");
        add("Палата №6");
        add("Мастер и Маргарита");
        add("Cобачье сердце");
        add("Горе от ума");
        add("Приключения Шерлока Холмса");
        add("Географ глобус пропил");
        add("Собака Баскервилей");
        add("Трое в лодке, не считая собаки");
        add("Герой нашего времени");
    }};

    private String name;

    public Book() {
        name = NAMES.poll();
    }

    public String toString() {
        return name == null ? super.toString() : name;
    }

}