import java.util.ArrayList;
import java.util.Random;

public class Eren implements Subject, Runnable {
    private int energy;
    private UI ui;
    private ArrayList<Observer> observers = new ArrayList<>();
    private Random rand = new Random();

    public Eren(int energy, UI ui) {
        this.energy = energy;
        this.ui = ui;
        new Thread(this).start();   // Eren starts running as soon as he is created
    }

    @Override
    public synchronized void registerObserver(Observer o) {
        observers.add(o);
    }

    @Override
    public synchronized void removeObserver(Observer o) {
        observers.remove(o);
    }

    @Override
    public synchronized void notifyObservers() {
        for (Observer o : observers) {
            o.update(energy);
        }
    }

    public int getEnergy() {
        return energy;
    }

    @Override
    public void run() {
        try {
            while (energy > 0) {
                // wait a random time between 5 and 10 seconds
                int wait = rand.nextInt(6) + 5;
                Thread.sleep(wait * 1000);

                // transform
                ui.print("\n*** Eren has transformed into a Titan! (Energy: " + energy + ") ***");
                notifyObservers();

                // lose 5 energy per transformation
                energy -= 5;

                // stay a titan for 10 seconds
                Thread.sleep(10 * 1000);
                ui.print("*** Eren has turned back to human. Energy left: " + energy + " ***");
            }
            ui.print("\nEren has no energy left and can no longer transform.");
        } catch (InterruptedException ex) {
            ui.print("Eren's thread was interrupted.");
        }
    }
}
