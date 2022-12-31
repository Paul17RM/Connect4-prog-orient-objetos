package menuhistory;

import java.util.ArrayList;
import java.util.List;

import models.Connect4;
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

    public void interact(Connect4 connect) {
        this.addOptions();
        this.interact_(connect);
    }

    protected abstract void addOptions();

    protected void interact_(Connect4 connect) {
        this.showTitles();
        this.execChooseOption(connect);
    }

    protected void showTitles() {
        this.showTitle();
        Console.getInstance().writeStr("\n");
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

    protected void execChooseOption(Connect4 connect) {
        int answer;
        boolean ok;
        do {
            answer = MenusView.chooseMenuOption(this.options.size()) - 1;
            ok = 0 <= answer && answer <= this.options.size() - 1;
            if (!ok) {
                Console.getInstance().writeStr("Error!!! ");
            }
        } while (!ok);
        this.options.get(answer).interact(connect);
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