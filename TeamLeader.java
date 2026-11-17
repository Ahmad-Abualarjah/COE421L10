public class TeamLeader implements Observer {
    private String name;
    private int patience;
    private UI ui;
    private Subject eren;

    public TeamLeader(String name, int patience, UI ui, Subject eren) {
        this.name = name;
        this.patience = patience;
        this.ui = ui;
        this.eren = eren;
        eren.registerObserver(this);
    }

    @Override
    public void update(int energy) {
        if (patience <= 0) {
            return;   // Levi has stopped talking
        }

        patience -= 5;
        ui.print(name + ": Eren transformed again. (Patience: " + patience + ")");

        if (patience == 10) {
            ui.print(name + ": My patience is waning!");
        } else if (patience == 5) {
            ui.print(name + ": Is this entertaining?");
        } else if (patience <= 0) {
            ui.print(name + ": Omae wa mou shindeiru");
        }
    }
}
