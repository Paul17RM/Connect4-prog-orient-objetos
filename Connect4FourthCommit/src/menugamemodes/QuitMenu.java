package menugamemodes;

public abstract class QuitMenu extends Menu {
    private QuitOption quitOption;

    QuitMenu(String title) {
        super(title);
        this.quitOption = new QuitOption();
    }

    @Override
    protected void showTitles() {
        this.addQuitOption();
        super.showTitles();
    }

    protected void addQuitOption() {
        if (!this.hasOption(this.quitOption)) {
            this.add(this.quitOption);
        }
    }

    public boolean isExecutedQuitOption() {
        return this.quitOption.isExecuted();
    }
}
