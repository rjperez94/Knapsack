import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

public class Knapsack0NGS {
	private int n;
	private int capacity;
	private List<Item> items;
	
	private long startTime;
	private long endTime;

	public Knapsack0NGS(int n, int capacity, List<Item> initialItems, int[] initialCounts)
			throws IllegalArgumentException {
		checkConsistent(n, capacity, initialItems, initialCounts);

		this.capacity = capacity;
		this.n = n;

		initialiseDependencies(initialItems, initialCounts);
		Node best = solve();
		printItems(best);
	}

	private void checkConsistent(int n, int capacity, List<Item> initialItems, int[] initialCounts) {
		if (n < 1)
			throw new IllegalArgumentException("N must be >=1");
		if (capacity < 0)
			throw new IllegalArgumentException("Knapsack capacity must be >=0");
		if (initialItems.size() < 1)
			throw new IllegalArgumentException("There must at least be 1 item type");
		if (initialItems.size() != initialCounts.length)
			throw new IllegalArgumentException("Item type does not match item counts");

		for (int i = 0; i < initialItems.size(); i++)
			if (initialItems.get(i) == null)
				throw new IllegalArgumentException("Cannot have NULL item types");
	}

	private void initialiseDependencies(List<Item> initialItems, int[] initialCounts) {
		startTime = System.currentTimeMillis();
		
		this.items = new ArrayList<>();
		for (int i = 0; i < initialCounts.length; i++) {
			for (int j = 0; j < initialCounts[i] && j < this.n; j++) {
				this.items.add(initialItems.get(i));
			}
		}

	}

	private Node solve() {
		Collections.sort(items, Item.byRatio());

		Node best = new Node();
		Node root = new Node();
		root.computeBound(items, capacity);

		PriorityQueue<Node> q = new PriorityQueue<Node>();
		q.offer(root);

		while (!q.isEmpty()) {
			Node node = q.poll();

			if (node.bound > best.value && node.h < items.size() - 1) {

				Node left = new Node(node);
				Item item = items.get(node.h);
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
		System.out.printf("Items Chosen\n%s%7s%7s\n", "Item", "Weight", "Profit");
		for (int i = 0; i < node.taken.size(); i++) {
			System.out.printf("%s%7.0f%7.0f\n", node.taken.get(i).label, node.taken.get(i).weight,
					node.taken.get(i).value);
		}

		System.out.println("Knapsack weight  : " + node.weight);
		System.out.println("Maximum profit : " + node.value);
		endTime = System.currentTimeMillis();
	}
	
	public long runningTime() {
		return endTime - startTime;
	}

	public static void main(String[] args) {
		List<Item> list = new ArrayList<>();
		Item red = new Item("red", 3, 54);
		Item blue = new Item("blue", 70, 154);
		Item green = new Item("green", 30, 4);
		list.add(red);
		list.add(blue);
		list.add(green);
		new Knapsack0NGS(200, 200, list, new int[] { 10, 10, 10 });
	}
}
