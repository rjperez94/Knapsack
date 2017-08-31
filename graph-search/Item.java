import java.util.Comparator;

public class Item {
	public String label;
	public double value;
	public double weight;	

	public Item(String label, int value, int weight) {
		this.label = label;
		this.value = value;
		this.weight = weight;
	}

	public double getRatio() {
		return value / weight;
	}

	public static Comparator<Item> byRatio() {
		return new Comparator<Item>() {
			public int compare(Item i1, Item i2) {
				return Double.compare(i2.getRatio(), i1.getRatio());
			}
		};
	}
}
