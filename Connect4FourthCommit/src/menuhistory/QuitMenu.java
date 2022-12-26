package menuhistory;

abstract class QuitMenu extends Menu {
    private QuitOption quitOption;

    public QuitMenu(String title) {
        super(title);
        this.quitOption = new QuitOption();
    }

    @Override
    protected void showTitles() {
        this.addQuitOption();
        this.quitOption.resetQuitOption();
        super.showTitles();
    }

    protected void addQuitOption() {
        if (!this.hasOption(this.quitOption)) {
            this.add(this.quitOption);
        }
    }

    /*
    public boolean isExecutedUndo() {
        return this.options -- undo.isExecuted();
    }    

    public boolean isExecutedRedo() {
        return this.options -- redo.isExecuted();
    }
     */

    public boolean isExecutedQuitOption() {
        return this.quitOption.isExecuted();
    }
}