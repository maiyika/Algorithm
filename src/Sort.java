import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Sort {
	public static void swap( int i, int j ) {
		int t = i;
		i = j;
		j = t;
	}

	/*
	��������(���Ż�)
	 */
	public static void quickSort( int[] arr ) {
		quickSort(arr, 0, arr.length - 1);
	}

	public static void quickSort( int[] arr, int begin, int end ) {
		if ( begin >= 0 && begin < end && end < arr.length ) {
			int pivot = arr[begin];              //pivotΪ��׼��,���ｫ��һ��Ԫ����Ϊ��׼��
			int i = begin, j = end;
			while ( i != j ) {
				for ( ; i < j; j-- ) {
					if ( arr[j] < pivot ) {
						arr[i++] = arr[j];
						break;
					}
				}
				for ( ; i < j; i++ ) {
					if ( arr[i] > pivot ) {
						arr[j--] = arr[i];
						break;
					}
				}
			}
			arr[i] = pivot;
			quickSort(arr, 0, i - 1);
			quickSort(arr, j + 1, end);
		}
	}

	public static void main( String[] args ) {
		/*Scanner scanner = new Scanner(System.in);
		System.out.println("����������Ĵ�С");
		int count = scanner.nextInt();
		int[] arr = new int[count];
		System.out.println("��������");
		for ( int i = 0; i < arr.length; i++ ) {
			arr[i] = scanner.nextInt();
		}
		quickSort(arr);
		System.out.println("����С���������Ϊ");
		for ( int i : arr )
			System.out.print(i + " ");*/
		List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));
		list.stream().map(x -> x * 1.5).forEach(System.out::println);
	}

}

