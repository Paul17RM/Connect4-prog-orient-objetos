package menugamemodes;

import java.util.ArrayList;
import java.util.List;

import models.GameMode;
import utils.Console;
import views.MenusView;
import views.UtilsView;

abstract class Menu {
    private String title;
    protected List<Option> options;

    Menu(String title) {
        this.title = title;
        this.options = new ArrayList<>();
    }

    public GameMode interact() {
        return this.interact_();
    }

    protected abstract void addOptions();

    protected GameMode interact_() {
        this.showTitles();
        return this.execChooseOption();
    }

    protected void showTitles() {
        this.showTitle();
        Console.getInstance().writeStr("\nGame modes list:\n");
        for (int i = 0; i < this.options.size(); i++) {
            this.options.get(i).showTitle(i + 1);
        }
        UtilsView.writeMessageStr("\n");
    }

    private void showTitle() {
        String string = "\n" + this.title + "\n";
        for (int i = 0; i < this.title.length(); i++) {
            string += "-";
        }
        UtilsView.writeMessageStr(string);
    }

    protected GameMode execChooseOption() {
        int answer;
        boolean ok;
        do {
            answer = MenusView.chooseMenuOption(this.options.size()) - 1;
            ok = 0 <= answer && answer <= this.options.size() - 1;
            if (!ok) {
                Console.getInstance().writeStr("Error!!! ");
            }
        } while (!ok);
        return this.options.get(answer).interact();
    }

    protected void add(Option option) {
        this.options.add(option);
    }

    protected void removeOptions() {
        this.options.clear();
    }

    protected boolean hasOption(Option option) {
        return this.options.contains(option);
    }
}