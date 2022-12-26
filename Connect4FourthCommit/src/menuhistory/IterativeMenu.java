package menuhistory;

import models.Connect4;

abstract class IterativeMenu extends QuitMenu {
    public IterativeMenu(String title) {
        super(title);
    }

    @Override
    public void interact(Connect4 connect) {
        do {
            this.removeOptions();
            this.addOptions();
            this.interact_(connect);
        } while (!this.isExecutedQuitOption());
    }
}