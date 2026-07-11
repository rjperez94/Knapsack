package dynamic.programming;

import abst.Knapsack;
import ecs100.UI;

import java.util.ArrayList;
import java.util.List;

public class Knapsack0NDP extends Knapsack {
	private int n;
	private int capacity;
	
	private List<ItemDP> items;
	private int[][] matrix;
	private int[][] keep;
	
	private long startTime;
	private long endTime;

	public Knapsack0NDP(UI ui, int n, int capacity, List<ItemDP> initialItems, int[] initialCounts) throws IllegalArgumentException {
		super(ui);
		checkConsistent(n,capacity,initialItems,initialCounts);

		this.capacity = capacity;
		this.n = n;
		
		initialiseDependencies(initialItems, initialCounts);		
		solve();
		printItems();
		printTable();
	}

	private void checkConsistent(int n, int capacity, List<ItemDP> initialItems, int[] initialCounts) {
		if (n < 1) throw new IllegalArgumentException("N must be >=1");
		if (capacity < 0) throw new IllegalArgumentException("Knapsack capacity must be >=0");
		if (initialItems.size() < 1) throw new IllegalArgumentException("There must at least be 1 item type");
		if (initialItems.size() != initialCounts.length) throw new IllegalArgumentException("Item type does not match item counts");
		
		for (int i = 0; i < initialItems.size(); i++) 
			if(initialItems.get(i) == null) throw new IllegalArgumentException("Cannot have NULL item types");
	}

	private void initialiseDependencies(List<ItemDP> initialItems, int[] initialCounts) {
		startTime = System.currentTimeMillis();
		
		this.items = new ArrayList<>();
		for (int i = 0; i < initialCounts.length; i++) {
			for (int j = 0; j < initialCounts[i] && j < this.n; j++) {
				this.items.add(initialItems.get(i));
			}
		}
		
		this.matrix = new int[items.size() + 1][capacity + 1];
		this.keep = new int[items.size() + 1][capacity + 1];
	}

	private void solve() {		
		for (int col = 0; col <= capacity; col++) {
			matrix[0][col] = 0;
		}
		for (int i = 1; i <= items.size(); i++) {
			for (int j = 0; j <= capacity; j++) {
				if ((items.get(i - 1).weight <= j)
						&& (items.get(i - 1).value + matrix[i - 1][j - items.get(i - 1).weight] > matrix[i - 1][j])) {
					matrix[i][j] = items.get(i - 1).value + matrix[i - 1][j - items.get(i - 1).weight];
					keep[i][j] = 1;
				} else {
					matrix[i][j] = matrix[i - 1][j];
					keep[i][j] = 0;
				}
			}
		}
	}

	private void printItems() {
		// backtracking
		int totWeight = 0;
		printf("Items Chosen\n%s%7s%7s\n", "Item", "Weight", "Profit");
		int K = capacity;
		for (int i = items.size(); i >= 1; i--) {
			if (keep[i][K] == 1) {
				printf("%s%7d%7d\n", items.get(i - 1).label, items.get(i - 1).weight, items.get(i - 1).value);
				totWeight+=items.get(i - 1).weight;
				K -= items.get(i - 1).weight;
			}
		}

		println("Knapsack weight  : " + totWeight);
		println("Maximum profit : " + matrix[items.size()][capacity]);
		endTime = System.currentTimeMillis();
	}

	private void printTable() {
		// Printing the matrix
		println("Printing the matrix");
		for (int[] rows : matrix) {
			for (int col : rows) {
				printf("%5d", col);
			}
			printf("\n");
		}
	}
	
	public long runningTime() {
		return endTime - startTime;
	}
}
