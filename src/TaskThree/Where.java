package Threads.TaskThree;

enum Where {
    home("домой"),
    room("в зале");

    private String description;

    Where(String description) {
        this.description = description;
    }

    public String toString() {
        return this.description;
    }
}