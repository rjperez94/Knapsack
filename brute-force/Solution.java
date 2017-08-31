import java.util.Comparator;

public class Solution {
	public final int x;
	public final int y;
	public final int z;
	public final int value;
	public final int weight;
	public final String[] labels;
	
	public Solution(int x, int y, int z, int value, int weight, String[] labels) {
		this.x = x;
		this.y = y;
		this.z = z;
		this.value = value;
		this.weight = weight;
		this.labels = labels;
	}

	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append(labels[0]+": "+x+" "+labels[1]+": "+y+" "+labels[2]+": "+z);
		sb.append("\nMaximum weight "+weight);
		sb.append("\nMaximum profit "+ value);
		return sb.toString();
	}
	
	public static Comparator<Solution> SolutionComparator() {
		return new Comparator<Solution>() {
			public int compare(Solution s1, Solution s2) {
				return Integer.compare(s2.value, s1.value);
			}
		};
	}
}
