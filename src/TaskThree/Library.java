package Threads.TaskThree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Library {
    private static List<Book> homeBookInit = Arrays.asList(
            new Book(),new Book(),new Book(),new Book());
    private static List<Book> roomBookInit = Arrays.asList(
            new Book(),new Book(),new Book(),new Book(),new Book(),new Book());
    private static ArrayList<Book> homeBook = new ArrayList<>(homeBookInit);
    private static ArrayList<Book> roomBook = new ArrayList<>(roomBookInit);

    public static Book getBook(Where where) {
        Book takeBook = null;
        if (where == Where.home) {
            takeBook = homeBook.get(homeBook.size() - 1);
            homeBook.remove(homeBook.size() - 1);
        }
        else {
            takeBook = roomBook.get(roomBook.size() - 1);
            roomBook.remove(roomBook.size() - 1);
        }
        return takeBook;
    }

    public static void restoreBook(Book takeBook,Where where) {
        if (where == Where.home) {
            homeBook.add(takeBook);
        }
        else {
            roomBook.add(takeBook);
        }
    }
}