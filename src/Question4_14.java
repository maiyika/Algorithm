import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.*;

/**
 * @author 25566
 * @project Algorithm
 * @date 27/10/2023
 */
public class Question4_14 {
	static int n;
	static int k;
	static Integer[] nums;

	@Test
	public void run() {
		fun("d:/java_home1/exercise");
	}

	public static void fun( String dir ) {
		inPut(dir);
		Arrays.sort(nums);
		//求最小值,....
		List<Integer> list = new ArrayList<>();
		list.addAll(Arrays.asList(nums));
		int num = n / k + n % k;
		while ( num > k ) {
			num = num / k + num % k;
		}
		if ( num < k ) {
			//要补"0",否则就不需要
			for ( int i = 0; i < (k - num); i++ ) {
				list.add(0, 0);
			}
		}
		//之后就是贪心算法, 降序每组都是k个合并(此时list空间已经是填充过)

		int sum = 0;  //记录费用
		while ( list.size() != 1 ) {
			int number = 0;
			for ( int i = 0; i < k; i++ ) {
				number += list.get(0);
				list.remove(0);
			}
			list.add(number);
			sum += number;
			Collections.sort(list);
		}
		//求最大值
		List<Integer> list1 = new ArrayList<>();
		list1.addAll(Arrays.asList(nums));
		Collections.reverse(list1);
		//两两组合就可以
		int sum1 = 0;
		while ( list1.size() != 1 ) {
			int number = 0;
			number = list1.get(0) + list1.get(1);
			list1.remove(0);
			list1.remove(0);
			list1.add(number);
			sum1 += number;
			Collections.sort(list1, ( o1, o2 ) -> o2 - o1);
		}
		outPut(dir, sum1, sum);
	}

	private static void inPut( String dir ) {
		File file = new File(dir, "input.txt");
		try (
				BufferedReader br = new BufferedReader(new FileReader(file))
		) {
			String s = "";
			int index = 0;
			while ( (s = br.readLine()) != null ) {
				String[] split = s.split(" ");
				if ( index == 0 ) {
					n = Integer.parseInt(split[0]);
					k = Integer.parseInt(split[1]);
					index++;
				} else {
					nums = new Integer[n];
					for ( int i = 0; i < nums.length; i++ ) {
						nums[i] = Integer.parseInt(split[i]);
					}
				}
			}
		} catch ( IOException e ) {
			throw new RuntimeException(e);
		}
	}

	private static void outPut( String dir, int max, int min ) {
		File file = new File(dir, "output.txt");
		try (
				BufferedWriter bw = new BufferedWriter(new FileWriter(file))
		) {
			bw.write(max + " " + min);
			bw.newLine();
		} catch ( IOException e ) {
			throw new RuntimeException(e);
		}
	}
}
