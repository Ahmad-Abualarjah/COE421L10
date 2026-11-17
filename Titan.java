import java.util.Random;

public class Titan implements Observer {
    private String name;
    private UI ui;
    private Subject eren;
    private Random rand = new Random();

    public Titan(String name, UI ui, Subject eren) {
        this.name = name;
        this.ui = ui;
        this.eren = eren;
        eren.registerObserver(this);
    }

    @Override
    public void update(int energy) {
        // 50% chance to attack Eren
        if (rand.nextBoolean()) {
            ui.print(name + ": attacks Eren!");
            if (energy > 40) {
                ui.print(name + ": Now we got problems, and I don't think we can solve 'em");
            }
        }
    }
}
