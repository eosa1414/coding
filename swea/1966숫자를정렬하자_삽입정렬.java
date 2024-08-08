import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution{
	public static void main(String[] args) {
		
		int T;
		try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));) {
			T = Integer.parseInt(br.readLine());
			for(int tc = 1; tc <= T; tc++) {
				int N = Integer.parseInt(br.readLine());
				
				//배열 생성
				int[] nums = new int[N];
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int i = 0; i < nums.length; i++) {
					nums[i] = Integer.parseInt(st.nextToken());
				}
				
				//배열 삽입 정렬
				for(int i = 1; i < nums.length; i++) {
					int data = nums[i];
					int j;
					for(j = i - 1; j >= 0 && data < nums[j]; j--) {
							nums[j + 1] = nums[j];
					}
					nums[j + 1] = data;
				}
				
				StringBuilder sb = new StringBuilder();
				
				System.out.printf("#%d ",tc);
				for(int num : nums) {
					sb.append(num).append(" ");
				}
				System.out.println(sb);
				
			}
			
		} catch (NumberFormatException | IOException e) {
			e.printStackTrace();
		}
		
		
		
	}
}
