import java.util.Scanner;

public class Main {
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		
		int[] nums = new int[N];
		for(int i = 0; i < N; i++) {
			nums[i] = sc.nextInt();
		}
		
		sortArr(nums);
		
		for(int n : nums) {
			System.out.println(n);
		}
		
		
	}
	
	static int[] sortArr(int[] arr) {//버블정렬
		for(int i = arr.length - 1; i > 0; i--) {
			for(int j = 0; j < i; j++) {
				if(arr[j] > arr[j+1]) {
					int tmp = arr [j];
					arr[j] = arr[j+1];
					arr[j+1] = tmp;
				}
			}
		}
		return arr;
	}
	
	
}
