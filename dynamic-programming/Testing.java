import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestName;

public class Testing {
	// helper vars
	private static int currentHashID = 1;
	private static HashMap<Integer, ArrayList<Long>> times = new HashMap<>();
	private static HashMap<Integer, String> names = new HashMap<>();
	private static final int LOOP = 15;
	
	@Rule 
	public TestName name = new TestName();
	
	@Before
	public void makeArray() {
		times.put(currentHashID, new ArrayList<Long>());
	}

	@After
	public void incrementID() {
		currentHashID++;
	}
	
	@AfterClass
	public static void printTimes() throws FileNotFoundException {
		PrintWriter pw = new PrintWriter(new File("dp_test_results.csv"));
        StringBuffer buf = new StringBuffer();
        buf.append("id,name,times\n");
        
		for(Map.Entry<Integer, ArrayList<Long>> entry: times.entrySet()){
			buf.append(entry.getKey()+","+names.get(entry.getKey())+",");
			for (long l : entry.getValue()) {
				buf.append(l+",");
			}
			buf.append('\n');
		}
		
		pw.write(buf.toString());
        pw.close();
	}
	
	@Test
	public void testN100C10000() {
		names.put(currentHashID,name.getMethodName());
		
		int N = 100;
		for (int i = 0; i < LOOP; i++) {
			List<Item> list = new ArrayList<>();
			Item red = new Item("red", 300, 154);
			Item blue = new Item("blue", 700, 540);
			Item green = new Item("green", 930, 854);
			list.add(red);
			list.add(blue);
			list.add(green);

			Knapsack0NDP kpdp = new Knapsack0NDP(N, 10000, list, new int[] { N, N, N });
			times.get(currentHashID).add(kpdp.runningTime());
		}
	}

	@Test
	public void testN100C20000() {
		names.put(currentHashID,name.getMethodName());
		
		int N = 100;
		for (int i = 0; i < LOOP; i++) {
			List<Item> list = new ArrayList<>();
			Item red = new Item("red", 300, 154);
			Item blue = new Item("blue", 700, 540);
			Item green = new Item("green", 930, 854);
			list.add(red);
			list.add(blue);
			list.add(green);

			Knapsack0NDP kpdp = new Knapsack0NDP(N, 20000, list, new int[] { N, N, N });
			times.get(currentHashID).add(kpdp.runningTime());
		}
	}
	
	@Test
	public void testN100C30000() {
		names.put(currentHashID,name.getMethodName());
		
		int N = 100;
		for (int i = 0; i < LOOP; i++) {
			List<Item> list = new ArrayList<>();
			Item red = new Item("red", 300, 154);
			Item blue = new Item("blue", 700, 540);
			Item green = new Item("green", 930, 854);
			list.add(red);
			list.add(blue);
			list.add(green);

			Knapsack0NDP kpdp = new Knapsack0NDP(N, 30000, list, new int[] { N, N, N });
			times.get(currentHashID).add(kpdp.runningTime());
		}
	}
	
	@Test
	public void testN100C40000() {
		names.put(currentHashID,name.getMethodName());
		
		int N = 100;
		for (int i = 0; i < LOOP; i++) {
			List<Item> list = new ArrayList<>();
			Item red = new Item("red", 300, 154);
			Item blue = new Item("blue", 700, 540);
			Item green = new Item("green", 930, 854);
			list.add(red);
			list.add(blue);
			list.add(green);

			Knapsack0NDP kpdp = new Knapsack0NDP(N, 40000, list, new int[] { N, N, N });
			times.get(currentHashID).add(kpdp.runningTime());
		}
	}
	
	@Test
	public void testN100C50000() {
		names.put(currentHashID,name.getMethodName());
		
		int N = 100;
		for (int i = 0; i < LOOP; i++) {
			List<Item> list = new ArrayList<>();
			Item red = new Item("red", 300, 154);
			Item blue = new Item("blue", 700, 540);
			Item green = new Item("green", 930, 854);
			list.add(red);
			list.add(blue);
			list.add(green);

			Knapsack0NDP kpdp = new Knapsack0NDP(N, 50000, list, new int[] { N, N, N });
			times.get(currentHashID).add(kpdp.runningTime());
		}
	}
	
	@Test
	public void testN100C60000() {
		names.put(currentHashID,name.getMethodName());
		
		int N = 100;
		for (int i = 0; i < LOOP; i++) {
			List<Item> list = new ArrayList<>();
			Item red = new Item("red", 300, 154);
			Item blue = new Item("blue", 700, 540);
			Item green = new Item("green", 930, 854);
			list.add(red);
			list.add(blue);
			list.add(green);

			Knapsack0NDP kpdp = new Knapsack0NDP(N, 60000, list, new int[] { N, N, N });
			times.get(currentHashID).add(kpdp.runningTime());
		}
	}
	
	@Test
	public void testN100C70000() {
		names.put(currentHashID,name.getMethodName());
		
		int N = 100;
		for (int i = 0; i < LOOP; i++) {
			List<Item> list = new ArrayList<>();
			Item red = new Item("red", 300, 750);
			Item blue = new Item("blue", 700, 941);
			Item green = new Item("green", 930, 854);
			list.add(red);
			list.add(blue);
			list.add(green);

			Knapsack0NDP kpdp = new Knapsack0NDP(N, 70000, list, new int[] { N, N, N });
			times.get(currentHashID).add(kpdp.runningTime());
		}
	}
	
	@Test
	public void testN100C80000() {
		names.put(currentHashID,name.getMethodName());
		
		int N = 100;
		for (int i = 0; i < LOOP; i++) {
			List<Item> list = new ArrayList<>();
			Item red = new Item("red", 300, 750);
			Item blue = new Item("blue", 700, 941);
			Item green = new Item("green", 930, 854);
			list.add(red);
			list.add(blue);
			list.add(green);

			Knapsack0NDP kpdp = new Knapsack0NDP(N, 80000, list, new int[] { N, N, N });
			times.get(currentHashID).add(kpdp.runningTime());
		}
	}
	
	@Test
	public void testN100C90000() {
		names.put(currentHashID,name.getMethodName());
		
		int N = 100;
		for (int i = 0; i < LOOP; i++) {
			List<Item> list = new ArrayList<>();
			Item red = new Item("red", 300, 750);
			Item blue = new Item("blue", 700, 941);
			Item green = new Item("green", 930, 854);
			list.add(red);
			list.add(blue);
			list.add(green);

			Knapsack0NDP kpdp = new Knapsack0NDP(N, 90000, list, new int[] { N, N, N });
			times.get(currentHashID).add(kpdp.runningTime());
		}
	}
	
	@Test
	public void testN100C100000() {
		names.put(currentHashID,name.getMethodName());
		
		int N = 100;
		for (int i = 0; i < LOOP; i++) {
			List<Item> list = new ArrayList<>();
			Item red = new Item("red", 300, 750);
			Item blue = new Item("blue", 700, 941);
			Item green = new Item("green", 930, 854);
			list.add(red);
			list.add(blue);
			list.add(green);

			Knapsack0NDP kpdp = new Knapsack0NDP(N, 100000, list, new int[] { N, N, N });
			times.get(currentHashID).add(kpdp.runningTime());
		}
	}
}
