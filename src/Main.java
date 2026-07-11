import brute.force.ItemBF;
import brute.force.Knapsack0NBF;
import dynamic.programming.ItemDP;
import dynamic.programming.Knapsack0NDP;
import ecs100.UI;
import ecs100.UIButtonListener;
import graph.search.ItemGS;
import graph.search.Knapsack0NGS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main implements UIButtonListener {
    private UI ui;

    public Main() {
        UI.addButton("Brute Force", this);
        UI.addButton("Dynamic Programming", this);
        UI.addButton("Graph Search", this);
        UI.addButton("Quit", this);

        UI.repaintGraphics();
        this.ui = getUIfromECS();
    }

    private static UI getUIfromECS() {
        // Access UI.theUI via reflection since it may not be publicly accessible
        try {
            java.lang.reflect.Field theUIField = UI.class.getDeclaredField("theUI");
            theUIField.setAccessible(true);
            return (UI) theUIField.get(null);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public void buttonPerformed(String name) {
        UI.clearText();

        if ("Brute Force".equals(name)) {
            List<ItemBF> list = new ArrayList<>();
            ItemBF red = new ItemBF("red", 3, 54);
            ItemBF blue = new ItemBF("blue", 70, 154);
            ItemBF green = new ItemBF("green", 30, 4);
            list.add(red);
            list.add(blue);
            list.add(green);
            new Knapsack0NBF(this.ui, 200, 200, list, new int[]{10, 10, 10});

        } else if ("Dynamic Programming".equals(name)) {
            List<ItemDP> list = new ArrayList<>();
            ItemDP red = new ItemDP("red", 3, 54);
            ItemDP blue = new ItemDP("blue", 70, 154);
            ItemDP green = new ItemDP("green", 30, 4);
            list.add(red);
            list.add(blue);
            list.add(green);
            new Knapsack0NDP(this.ui, 200, 200, list, new int[]{10, 10, 10});

        } else if ("Graph Search".equals(name)) {
            List<ItemGS> list = new ArrayList<>();
            ItemGS red = new ItemGS("red", 3, 54);
            ItemGS blue = new ItemGS("blue", 70, 154);
            ItemGS green = new ItemGS("green", 30, 4);
            list.add(red);
            list.add(blue);
            list.add(green);
            new Knapsack0NGS(this.ui, 200, 200, list, new int[]{10, 10, 10});

        } else if ("Quit".equals(name)) {
            UI.quit();
        }
    }

    public static void main(String[] args) {
        new Main();
    }
}
