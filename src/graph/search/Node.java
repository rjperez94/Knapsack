package graph.search;

import java.util.ArrayList;
import java.util.List;

public class Node implements Comparable<Node>{
	public int h;
    List<ItemGS> taken;
    public double bound;
    public double value;
    public double weight;
    
    public Node() {
       taken = new ArrayList<ItemGS>();
    }
    
    public Node(Node parent) {
       h = parent.h + 1;
       taken = new ArrayList<ItemGS>(parent.taken);
       bound = parent.bound;
       value = parent.value;
       weight = parent.weight;
    }
    
    public void computeBound(List<ItemGS> items, int capacity) {
       int i = h;
       double w = weight;
       bound = value;
       ItemGS item;
       do {
          item = items.get(i);
          if (w + item.weight > capacity) break;
          w += item.weight;
          bound += item.value;
          i++;
       } while (i < items.size());
       bound += (capacity - w) * (item.value / item.weight);
    }
    
	@Override
	public int compareTo(Node o) {
		return (int) (o.bound - this.bound);
	}

}
