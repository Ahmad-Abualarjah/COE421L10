public class UI {
    // synchronized so messages from different threads don't get mixed up
    public synchronized void print(String message) {
        System.out.println(message);
    }
}
