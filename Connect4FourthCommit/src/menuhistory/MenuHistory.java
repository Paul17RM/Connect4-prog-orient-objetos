package menuhistory;

public class MenuHistory extends IterativeMenu {
    public MenuHistory(String title) {
        super(title);
    }

    @Override
    public void addOptions() {
        this.add(new ActionUndo());
        this.add(new ActionRedo());
    }
}
