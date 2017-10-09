package Threads.TaskTwo;

//Cклад
class Stock {
    public static final int maxProduct = 100_000_000;
    public volatile static Integer product = 800_000_00;

    public synchronized static void takeProduct()
    {
        product--;
    }

    public synchronized static void giveProduct() {
        product++;
    }
}