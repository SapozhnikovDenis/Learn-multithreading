package Threads.TaskThree;

class Reader implements Runnable {
    private Book takeBook = null;
    private static Where[] WhereAll = Where.values();
    private static Where where = WhereAll[Main.random.nextInt(2)];

    @Override
    public void run() {
        takeBook = Main.librain.getBookReader(where);
        System.out.println(Thread.currentThread().getName() + " взял почтитать книгу " + takeBook);
        try {
            Thread.sleep((Main.random.nextInt(3) + 2) * 1000);
        } catch (InterruptedException e) {}
        Main.librain.restoreBookReader(where,takeBook);
        System.out.println(Thread.currentThread().getName() + " вернул книгу");
    }
}