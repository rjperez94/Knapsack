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
		PrintWriter pw = new PrintWriter(new File("bf_test_results.csv"));
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
	public void testN100() {
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

			Knapsack0NBF kpbf = new Knapsack0NBF(N, N*100, list, new int[] { N, N, N });
			times.get(currentHashID).add(kpbf.runningTime());
		}
	}

	@Test
	public void testN200() {
		names.put(currentHashID,name.getMethodName());
		
		int N = 200;
		for (int i = 0; i < LOOP; i++) {
			List<Item> list = new ArrayList<>();
			Item red = new Item("red", 300, 154);
			Item blue = new Item("blue", 700, 540);
			Item green = new Item("green", 930, 854);
			list.add(red);
			list.add(blue);
			list.add(green);

			Knapsack0NBF kpbf = new Knapsack0NBF(N, N*100, list, new int[] { N, N, N });
			times.get(currentHashID).add(kpbf.runningTime());
		}
	}
	
	@Test
	public void testN300() {
		names.put(currentHashID,name.getMethodName());
		
		int N = 300;
		for (int i = 0; i < LOOP; i++) {
			List<Item> list = new ArrayList<>();
			Item red = new Item("red", 300, 154);
			Item blue = new Item("blue", 700, 540);
			Item green = new Item("green", 930, 854);
			list.add(red);
			list.add(blue);
			list.add(green);

			Knapsack0NBF kpbf = new Knapsack0NBF(N, N*100, list, new int[] { N, N, N });
			times.get(currentHashID).add(kpbf.runningTime());
		}
	}
	
	@Test
	public void testN400() {
		names.put(currentHashID,name.getMethodName());
		
		int N = 400;
		for (int i = 0; i < LOOP; i++) {
			List<Item> list = new ArrayList<>();
			Item red = new Item("red", 300, 154);
			Item blue = new Item("blue", 700, 540);
			Item green = new Item("green", 930, 854);
			list.add(red);
			list.add(blue);
			list.add(green);

			Knapsack0NBF kpbf = new Knapsack0NBF(N, N*100, list, new int[] { N, N, N });
			times.get(currentHashID).add(kpbf.runningTime());
		}
	}
	
	@Test
	public void testN500() {
		names.put(currentHashID,name.getMethodName());
		
		int N = 500;
		for (int i = 0; i < LOOP; i++) {
			List<Item> list = new ArrayList<>();
			Item red = new Item("red", 300, 154);
			Item blue = new Item("blue", 700, 540);
			Item green = new Item("green", 930, 854);
			list.add(red);
			list.add(blue);
			list.add(green);

			Knapsack0NBF kpbf = new Knapsack0NBF(N, N*100, list, new int[] { N, N, N });
			times.get(currentHashID).add(kpbf.runningTime());
		}
	}
	
	@Test
	public void testN600() {
		names.put(currentHashID,name.getMethodName());
		
		int N = 600;
		for (int i = 0; i < LOOP; i++) {
			List<Item> list = new ArrayList<>();
			Item red = new Item("red", 300, 154);
			Item blue = new Item("blue", 700, 540);
			Item green = new Item("green", 930, 854);
			list.add(red);
			list.add(blue);
			list.add(green);

			Knapsack0NBF kpbf = new Knapsack0NBF(N, N*100, list, new int[] { N, N, N });
			times.get(currentHashID).add(kpbf.runningTime());
		}
	}
	
//	@Test
//	public void testN700() {
//		names.put(currentHashID,name.getMethodName());
//		
//		int N = 700;
//		for (int i = 0; i < LOOP; i++) {
//			List<Item> list = new ArrayList<>();
//			Item red = new Item("red", 300, 154);
//			Item blue = new Item("blue", 700, 540);
//			Item green = new Item("green", 930, 854);
//			list.add(red);
//			list.add(blue);
//			list.add(green);
//
//			Knapsack0NBF kpbf = new Knapsack0NBF(N, N*100, list, new int[] { N, N, N });
//			times.get(currentHashID).add(kpbf.runningTime());
//		}
//	}
//	
//	@Test
//	public void testN800() {
//		names.put(currentHashID,name.getMethodName());
//		
//		int N = 800;
//		for (int i = 0; i < LOOP; i++) {
//			List<Item> list = new ArrayList<>();
//			Item red = new Item("red", 300, 154);
//			Item blue = new Item("blue", 700, 540);
//			Item green = new Item("green", 930, 854);
//			list.add(red);
//			list.add(blue);
//			list.add(green);
//
//			Knapsack0NBF kpbf = new Knapsack0NBF(N, N*100, list, new int[] { N, N, N });
//			times.get(currentHashID).add(kpbf.runningTime());
//		}
//	}
//	
//	@Test
//	public void testN900() {
//		names.put(currentHashID,name.getMethodName());
//		
//		int N = 900;
//		for (int i = 0; i < LOOP; i++) {
//			List<Item> list = new ArrayList<>();
//			Item red = new Item("red", 300, 154);
//			Item blue = new Item("blue", 700, 540);
//			Item green = new Item("green", 930, 854);
//			list.add(red);
//			list.add(blue);
//			list.add(green);
//
//			Knapsack0NBF kpbf = new Knapsack0NBF(N, N*900, list, new int[] { N, N, N });
//			times.get(currentHashID).add(kpbf.runningTime());
//		}
//	}
//	
//	@Test
//	public void testN1000() {
//		names.put(currentHashID,name.getMethodName());
//		
//		int N = 1000;
//		for (int i = 0; i < LOOP; i++) {
//			List<Item> list = new ArrayList<>();
//			Item red = new Item("red", 300, 154);
//			Item blue = new Item("blue", 700, 540);
//			Item green = new Item("green", 930, 854);
//			list.add(red);
//			list.add(blue);
//			list.add(green);
//
//			Knapsack0NBF kpbf = new Knapsack0NBF(N, N*100, list, new int[] { N, N, N });
//			times.get(currentHashID).add(kpbf.runningTime());
//		}
//	}
}
