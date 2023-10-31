import org.junit.jupiter.api.Test;

import java.io.*;

/**
 * @author 25566
 * @project Algorithm
 * @date 22/10/2023
 */
public class Question3_6 {
	static int count;      //租站数
	static boolean flag = false;         //读取文件时跳过第一个数

	static int index = 0;
	static int[][] weight;     //权值表

	@Test
	public void run() {
		fun("d:/java_home1/exercise");
	}

	public static void fun( String dir ) {
		inPut(dir);            //读取文件数据
		int[] dp = new int[count];        //每站当前的最少花销, 从1不断更新
		for ( int i = 0; i < count; i++ ) {
			for ( int j = i + 1; j < count; j++ ) {
				if ( i == 0 ) {
					dp[j] = weight[i][j];     //填充最下层
				} else {
					dp[j] = Math.min(dp[i] + weight[i][j], dp[j]);    //更新表中数据
				}
			}
		}
		outPut(dir, dp[count-1]);     //最后输出数据到文件
	}

	private static void outPut( String dir, int number ) {
		File file = new File(dir, "output.txt");
		try (
				BufferedWriter bw = new BufferedWriter(new FileWriter(file))
		) {
			bw.write(String.valueOf(number));
			bw.newLine();
		} catch ( IOException e ) {
			throw new RuntimeException(e);
		}
	}

	private static void inPut( String dir ) {
		File file = new File(dir, "input.txt");
		try (
				BufferedReader br = new BufferedReader(new FileReader(file));
		) {
			br.lines().forEach(x -> {
				String[] split = x.split(" ");
				if ( !flag ) {
					count = Integer.parseInt(split[0]);
					flag = true;
					weight = new int[count-1][count];
				} else {
					for ( int i = 0; i < split.length; i++ ) {
						weight[index][index + i + 1] = Integer.parseInt(split[i]);
					}
					index++;
				}
			});
		} catch ( IOException e ) {
			throw new RuntimeException(e);
		}
	}
}
