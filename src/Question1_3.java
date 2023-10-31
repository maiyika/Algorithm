import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.*;

/**
 * @author 25566
 * @project Algorithm
 * @date 14/9/2023
 */
public class Question1_3 {

	public void run( String dir, int start, int end ) {
		inPut(dir, start, end);
		File file = new File(dir, "input.txt");
		List<Integer> list = new ArrayList<>();
		try (
				BufferedReader br = new BufferedReader(new FileReader(file))
		) {
			br.lines().forEach(info -> {
				list.add(Integer.parseInt(info));
			});
			outPut(dir, mostDiv(list.get(0), list.get(1)));
		} catch ( IOException e ) {
			throw new RuntimeException(e);
		}
	}

	@Test
	public void test() {
		run("d:/java_home1/exercise", 1, 36);
	}


	public boolean isPrim( int number ) {
		for ( int i = 2; i <= number / 2; ++i ) {
			if ( number % i == 0 ) {
				return false;
			}
		}
		return true;
	}

	public int[] mostDiv( int start, int end ) {
		int max = 2, maxNumber = start;    //最少也有两个
		for ( int i = start; i <= end; ++i ) {
			//约数个数等于它每个质因数的个数+1再相乘
			Map<Integer, Integer> map = new HashMap<>();
			for ( int j = 2; j <= i / 2; ++j ) {
				int temp = i, count = 0;
				if ( i % j == 0 && isPrim(j) ) {
					while ( temp % j == 0 ) {
						temp /= j;
						count++;
					}
					map.put(j, count);
				}
			}
			int res = 1;
			for ( Integer integer : map.keySet() ) {
				res *= map.get(integer) + 1;
			}
			if ( res > max ) {
				maxNumber = i;
				max = res;
			}
		}
		int[] maxAndMaxNumber = new int[2];
		maxAndMaxNumber[0] = maxNumber;
		maxAndMaxNumber[1] = max;
		return maxAndMaxNumber;
	}

	public void outPut( String dir, int[] info ) {
		File file = new File(dir, "output.txt");
		try (
				BufferedWriter bw = new BufferedWriter(new FileWriter(file));
		) {
			bw.write("约数最多的数是: " + info[0]);
			bw.newLine();
			bw.write("约数个数为: " + info[1]);
			bw.newLine();
		} catch ( IOException e ) {
			throw new RuntimeException(e);
		}
	}

	public void inPut( String dir, int start, int end ) {
		File file = new File(dir, "input.txt");
		try (
				BufferedWriter bw = new BufferedWriter(new FileWriter(file));
		) {
			bw.write(String.valueOf(start));
			bw.newLine();
			bw.write(String.valueOf(end));
			bw.newLine();
		} catch ( IOException e ) {
			throw new RuntimeException(e);
		}
	}
}
