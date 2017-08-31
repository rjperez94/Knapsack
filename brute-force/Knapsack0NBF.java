import java.awt.Point;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Knapsack0NBF {
	private int n;
	private int capacity;
	private List<Item> items;
	private int[] counts;
	private List<Solution> solutions = new ArrayList<>();
	
	private long startTime;
	private long endTime;

	public Knapsack0NBF(int n, int capacity, List<Item> initialItems, int[] initialCounts) throws IllegalArgumentException {
		checkConsistent(n,capacity,initialItems,initialCounts);
		
		this.n = n;
		this.capacity = capacity;
		this.items = initialItems;
		this.counts = initialCounts;
		
		System.out.println("ALL POSSIBLE CHOICES: ");
		solve();
		
		System.out.println("\n\nBEST SOLUTION IS: ");
		System.out.println(getBest().toString());
	}
	
	private void checkConsistent(int n, int capacity, List<Item> initialItems, int[] initialCounts) {
		if (n < 1) throw new IllegalArgumentException("N must be >=1");
		if (capacity < 0) throw new IllegalArgumentException("Knapsack capacity must be >=0");
		if (initialItems.size() < 1) throw new IllegalArgumentException("There must at least be 1 item type");
		if (initialItems.size() != initialCounts.length) throw new IllegalArgumentException("Item type does not match item counts");
		
		for (int i = 0; i < initialItems.size(); i++) 
			if(initialItems.get(i) == null) throw new IllegalArgumentException("Cannot have NULL item types");
	}

	private void solve() {
		startTime = System.currentTimeMillis();
		for (int x = 0; x <= counts[0] && x <= n ; x++) {
			for (int y = 0; y <= counts[1] && y <= n; y++) {
				for (int z = 0; z <= counts[2] && z <= n; z++) {
					Point p = computeValueAndWeight(items, new int [] {x,y,z});
					if (p.y <= capacity) { 	
						solutions.add(new Solution(x, y, z, p.x, p.y, new String[]{items.get(0).label,items.get(1).label,items.get(2).label}));
						System.out.println("\nCHOICE "+solutions.size());
						System.out.println(solutions.get(solutions.size()-1).toString());
					}
					
				}
			}
		}
	}
	
	private Point computeValueAndWeight(List<Item> items, int[] itemCounts) {
		int value = 0;
		int weight = 0;
		
		for (int i = 0; i < items.size(); i++) {
			value+=(items.get(i).value*itemCounts[i]);
			weight+=(items.get(i).weight*itemCounts[i]);
		}
		
		return new Point(value,weight);
	}
	
	private Solution getBest() {
		Collections.sort(solutions, Solution.SolutionComparator());
		
		endTime = System.currentTimeMillis();
		
		return solutions.get(0);
	}
	
	public long runningTime() {
		return endTime - startTime;
	}

	public static void main(String[] args) {
		List<Item> list = new ArrayList<>();
		Item red = new Item("red", 3,54);
		Item blue = new Item("blue", 70,154);
		Item green = new Item("green", 30,4);
		list.add(red);
		list.add(blue);
		list.add(green);
		new Knapsack0NBF(200, 200, list, new int[]{10,10,10});
	}
}