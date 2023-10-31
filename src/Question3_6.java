import org.junit.jupiter.api.Test;

import java.io.*;

/**
 * @author 25566
 * @project Algorithm
 * @date 22/10/2023
 */
public class Question3_6 {
	static int count;      //��վ��
	static boolean flag = false;         //��ȡ�ļ�ʱ������һ����

	static int index = 0;
	static int[][] weight;     //Ȩֵ��

	@Test
	public void run() {
		fun("d:/java_home1/exercise");
	}

	public static void fun( String dir ) {
		inPut(dir);            //��ȡ�ļ�����
		int[] dp = new int[count];        //ÿվ��ǰ�����ٻ���, ��1���ϸ���
		for ( int i = 0; i < count; i++ ) {
			for ( int j = i + 1; j < count; j++ ) {
				if ( i == 0 ) {
					dp[j] = weight[i][j];     //������²�
				} else {
					dp[j] = Math.min(dp[i] + weight[i][j], dp[j]);    //���±�������
				}
			}
		}
		outPut(dir, dp[count-1]);     //���������ݵ��ļ�
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
