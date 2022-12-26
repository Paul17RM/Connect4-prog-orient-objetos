package menugamemodes;

import models.GameMode;
import models.GameModeTraining;

class MenuModeTraining extends Option {
    MenuModeTraining() {
        super("Training (player v. machine)");
    }

    @Override
    public GameMode interact() {
        return new GameModeTraining();
    }
}