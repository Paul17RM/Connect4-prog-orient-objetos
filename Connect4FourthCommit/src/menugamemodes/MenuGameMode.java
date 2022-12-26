package menugamemodes;

public class MenuGameMode extends QuitMenu {
    public MenuGameMode(String title) {
        super(title);
    }

    @Override
    public void addOptions() {
        this.add(new MenuModeBasic());
        this.add(new MenuModeTraining());
        this.add(new MenuModeDemo());
    }
}