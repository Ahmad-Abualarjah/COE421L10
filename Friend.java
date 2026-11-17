import java.util.Random;

public class Friend implements Observer {
    private String name;
    private UI ui;
    private Subject eren;
    private Random rand = new Random();

    public Friend(String name, UI ui, Subject eren) {
        this.name = name;
        this.ui = ui;
        this.eren = eren;
        eren.registerObserver(this);
    }

    @Override
    public void update(int energy) {
        // 50% chance to ask Eren to be safe
        if (rand.nextBoolean()) {
            ui.print(name + ": Eren, please be safe!");
        }
        if (energy < 20) {
            ui.print(name + ": Rage, rage against the dying of the light!");
        }
    }
}
