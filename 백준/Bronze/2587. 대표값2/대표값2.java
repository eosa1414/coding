import java.util.Scanner;

public class Main {
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		
		int[] nums = new int[5];
		for(int i = 0; i < 5; i++) {
			nums[i] = sc.nextInt();
		}
		
		sortArr(nums);
		
		int total = 0;
		for(int n : nums) {
			total += n;
		}
		int avg = total / 5;
		System.out.println(avg);
		System.out.println(nums[2]);
		
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
