package menugamemodes;

import models.GameMode;
import models.GameModeDemo;

class MenuModeDemo extends Option {
    MenuModeDemo() {
        super("Demo (machine v. machine)");
    }

    @Override
    public GameMode interact() {
        return new GameModeDemo();
    }
}