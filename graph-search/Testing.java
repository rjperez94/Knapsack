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
		PrintWriter pw = new PrintWriter(new File("gs_test_results.csv"));
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
	public void testN10() {
		names.put(currentHashID,name.getMethodName());
		
		int N = 10;
		for (int i = 0; i < LOOP; i++) {
			List<Item> list = new ArrayList<>();
			Item red = new Item("red", 300, 154);
			Item blue = new Item("blue", 700, 540);
			Item green = new Item("green", 930, 854);
			list.add(red);
			list.add(blue);
			list.add(green);

			Knapsack0NGS kpgs = new Knapsack0NGS(N, N * 25, list, new int[] { N, N, N });
			times.get(currentHashID).add(kpgs.runningTime());
		}
	}

	@Test
	public void testN20() {
		names.put(currentHashID,name.getMethodName());
		
		int N = 20;
		for (int i = 0; i < LOOP; i++) {
			List<Item> list = new ArrayList<>();
			Item red = new Item("red", 300, 154);
			Item blue = new Item("blue", 700, 540);
			Item green = new Item("green", 930, 854);
			list.add(red);
			list.add(blue);
			list.add(green);

			Knapsack0NGS kpgs = new Knapsack0NGS(N, N * 25, list, new int[] { N, N, N });
			times.get(currentHashID).add(kpgs.runningTime());
		}
	}
	
	@Test
	public void testN30() {
		names.put(currentHashID,name.getMethodName());
		
		int N = 30;
		for (int i = 0; i < LOOP; i++) {
			List<Item> list = new ArrayList<>();
			Item red = new Item("red", 300, 154);
			Item blue = new Item("blue", 700, 540);
			Item green = new Item("green", 930, 854);
			list.add(red);
			list.add(blue);
			list.add(green);

			Knapsack0NGS kpgs = new Knapsack0NGS(N, N * 25, list, new int[] { N, N, N });
			times.get(currentHashID).add(kpgs.runningTime());
		}
	}
	
	@Test
	public void testN40() {
		names.put(currentHashID,name.getMethodName());
		
		int N = 40;
		for (int i = 0; i < LOOP; i++) {
			List<Item> list = new ArrayList<>();
			Item red = new Item("red", 300, 154);
			Item blue = new Item("blue", 700, 540);
			Item green = new Item("green", 930, 854);
			list.add(red);
			list.add(blue);
			list.add(green);

			Knapsack0NGS kpgs = new Knapsack0NGS(N, N * 25, list, new int[] { N, N, N });
			times.get(currentHashID).add(kpgs.runningTime());
		}
	}
	
	@Test
	public void testN50() {
		names.put(currentHashID,name.getMethodName());
		
		int N = 50;
		for (int i = 0; i < LOOP; i++) {
			List<Item> list = new ArrayList<>();
			Item red = new Item("red", 300, 154);
			Item blue = new Item("blue", 700, 540);
			Item green = new Item("green", 930, 854);
			list.add(red);
			list.add(blue);
			list.add(green);

			Knapsack0NGS kpgs = new Knapsack0NGS(N, N * 25, list, new int[] { N, N, N });
			times.get(currentHashID).add(kpgs.runningTime());
		}
	}
	
	@Test
	public void testN60() {
		names.put(currentHashID,name.getMethodName());
		
		int N = 60;
		for (int i = 0; i < LOOP; i++) {
			List<Item> list = new ArrayList<>();
			Item red = new Item("red", 300, 154);
			Item blue = new Item("blue", 700, 540);
			Item green = new Item("green", 930, 854);
			list.add(red);
			list.add(blue);
			list.add(green);

			Knapsack0NGS kpgs = new Knapsack0NGS(N, N * 25, list, new int[] { N, N, N });
			times.get(currentHashID).add(kpgs.runningTime());
		}
	}
	
	@Test
	public void testN70() {
		names.put(currentHashID,name.getMethodName());
		
		int N = 70;
		for (int i = 0; i < LOOP; i++) {
			List<Item> list = new ArrayList<>();
			Item red = new Item("red", 300, 750);
			Item blue = new Item("blue", 700, 941);
			Item green = new Item("green", 930, 854);
			list.add(red);
			list.add(blue);
			list.add(green);

			Knapsack0NGS kpgs = new Knapsack0NGS(N, N * 25, list, new int[] { N, N, N });
			times.get(currentHashID).add(kpgs.runningTime());
		}
	}
	
	@Test
	public void testN80() {
		names.put(currentHashID,name.getMethodName());
		
		int N = 80;
		for (int i = 0; i < LOOP; i++) {
			List<Item> list = new ArrayList<>();
			Item red = new Item("red", 300, 750);
			Item blue = new Item("blue", 700, 941);
			Item green = new Item("green", 930, 854);
			list.add(red);
			list.add(blue);
			list.add(green);

			Knapsack0NGS kpgs = new Knapsack0NGS(N, N * 25, list, new int[] { N, N, N });
			times.get(currentHashID).add(kpgs.runningTime());
		}
	}
	
	@Test
	public void testN90() {
		names.put(currentHashID,name.getMethodName());
		
		int N = 90;
		for (int i = 0; i < LOOP; i++) {
			List<Item> list = new ArrayList<>();
			Item red = new Item("red", 300, 750);
			Item blue = new Item("blue", 700, 941);
			Item green = new Item("green", 930, 854);
			list.add(red);
			list.add(blue);
			list.add(green);

			Knapsack0NGS kpgs = new Knapsack0NGS(N, N * 25, list, new int[] { N, N, N });
			times.get(currentHashID).add(kpgs.runningTime());
		}
	}
	
	@Test
	public void testN100() {
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

			Knapsack0NGS kpgs = new Knapsack0NGS(N, N * 25, list, new int[] { N, N, N });
			times.get(currentHashID).add(kpgs.runningTime());
		}
	}
}
