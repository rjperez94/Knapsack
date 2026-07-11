package graph.search;

import abst.Knapsack;
import ecs100.UI;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

public class Knapsack0NGS extends Knapsack {
	private int n;
	private int capacity;
	private List<ItemGS> items;
	
	private long startTime;
	private long endTime;

	public Knapsack0NGS(UI ui, int n, int capacity, List<ItemGS> initialItems, int[] initialCounts)
			throws IllegalArgumentException {
        super(ui);
		checkConsistent(n, capacity, initialItems, initialCounts);

		this.capacity = capacity;
		this.n = n;

		initialiseDependencies(initialItems, initialCounts);
		Node best = solve();
		printItems(best);
	}

	private void checkConsistent(int n, int capacity, List<ItemGS> initialItems, int[] initialCounts) {
		if (n < 1)
			throw new IllegalArgumentException("N must be >=1");
		if (capacity < 0)
			throw new IllegalArgumentException("Knapsack capacity must be >=0");
		if (initialItems.isEmpty())
			throw new IllegalArgumentException("There must at least be 1 item type");
		if (initialItems.size() != initialCounts.length)
			throw new IllegalArgumentException("Item type does not match item counts");

        for (ItemGS initialItem : initialItems)
            if (initialItem == null)
                throw new IllegalArgumentException("Cannot have NULL item types");
	}

	private void initialiseDependencies(List<ItemGS> initialItems, int[] initialCounts) {
		startTime = System.currentTimeMillis();
		
		this.items = new ArrayList<>();
		for (int i = 0; i < initialCounts.length; i++) {
			for (int j = 0; j < initialCounts[i] && j < this.n; j++) {
				this.items.add(initialItems.get(i));
			}
		}

	}

	private Node solve() {
		items.sort(ItemGS.byRatio());

		Node best = new Node();
		Node root = new Node();
		root.computeBound(items, capacity);

		PriorityQueue<Node> q = new PriorityQueue<Node>();
		q.offer(root);

		while (!q.isEmpty()) {
			Node node = q.poll();

			if (node.bound > best.value && node.h < items.size() - 1) {

				Node left = new Node(node);
				ItemGS item = items.get(node.h);
				left.weight += item.weight;

				if (left.weight <= capacity) {

					left.taken.add(items.get(node.h));
					left.value += item.value;
					left.computeBound(items, capacity);

					if (left.value > best.value) {
						best = left;
					}
					if (left.bound > best.value) {
						q.offer(left);
					}
				}

				Node right = new Node(node);
				right.computeBound(items, capacity);

				if (right.bound > best.value) {
					q.offer(right);
				}
			}
		}
		return best;
	}

	private void printItems(Node node) {
		printf("Items Chosen\n%s%7s%7s\n", "Item", "Weight", "Profit");
		for (int i = 0; i < node.taken.size(); i++) {
			printf("%s%7.0f%7.0f\n", node.taken.get(i).label, node.taken.get(i).weight,
					node.taken.get(i).value);
		}

		println("Knapsack weight  : " + node.weight);
		println("Maximum profit : " + node.value);
		endTime = System.currentTimeMillis();
	}
	
	public long runningTime() {
		return endTime - startTime;
	}
}
