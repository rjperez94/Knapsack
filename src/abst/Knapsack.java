package abst;

import ecs100.UI;

public abstract class Knapsack {
    private UI ui;

    public Knapsack (UI ui) {
        this.ui = ui;
    }

    protected void println(String s) {
        if (ui == null) {
            System.out.println(s);
        } else {
            ui.println(s);
        }
    }

    protected void printf(String format, Object ... args)  {
        if (ui == null) {
            System.out.printf(format, args);
        } else {
            ui.printf(format, args);
        }
    }
}
