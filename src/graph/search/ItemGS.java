package graph.search;

import java.util.Comparator;

public class ItemGS {
	public String label;
	public double value;
	public double weight;	

	public ItemGS(String label, int value, int weight) {
		this.label = label;
		this.value = value;
		this.weight = weight;
	}

	public double getRatio() {
		return value / weight;
	}

	public static Comparator<ItemGS> byRatio() {
		return (i1, i2) -> Double.compare(i2.getRatio(), i1.getRatio());
	}
}
