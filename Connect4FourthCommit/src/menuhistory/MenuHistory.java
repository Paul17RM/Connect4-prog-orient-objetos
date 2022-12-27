package menuhistory;

public class MenuHistory extends IterativeMenu {
    protected ActionUndo actionUndo = new ActionUndo();
    protected ActionRedo actionRedo = new ActionRedo();

    public MenuHistory(String title) {
        super(title);
    }

    @Override
    public void addOptions() {
        this.add(this.actionUndo);
        this.actionUndo.resetUndoOption();
        this.add(this.actionRedo);
        this.actionRedo.resetRedoOption();
    }

    public boolean isExecutedUndo() {
        return this.actionUndo.isExecuted();
    }

    public boolean isExecutedRedo() {
        return this.actionRedo.isExecuted();
    }
}