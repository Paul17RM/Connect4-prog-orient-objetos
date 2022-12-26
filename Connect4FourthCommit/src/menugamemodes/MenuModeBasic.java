package menugamemodes;

import models.GameMode;
import models.GameModeBasic;

class MenuModeBasic extends Option {
    MenuModeBasic() {
        super("Basic (player v. player)");
    }

    @Override
    public GameMode interact() {
        return new GameModeBasic();
    }
}