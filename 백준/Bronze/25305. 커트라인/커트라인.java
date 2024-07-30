import java.util.Arrays;
import java.util.Scanner;

public class Main {
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int k = sc.nextInt();
		
		int[] nums = new int[N];
		for(int i = 0; i < N; i++) {
			nums[i] = sc.nextInt();
		}
		
		System.out.println(selectSort(nums,k));
	}
	
	static int selectSort(int[] arr, int k) {//선택정렬
		if(k <= 0 || k > arr.length) return -1;//오류
		for(int i = 0; i < k; i++) {
			int max_idx = i;
			for(int j = i; j < arr.length; j++) {
				if(arr[j] > arr[max_idx]) {
					max_idx = j;
				}
			}
			int tmp = arr[i];
			arr[i] = arr[max_idx];
			arr[max_idx] = tmp;
		}
		return arr[k - 1];
	}
	
	
}
