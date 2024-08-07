import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;
import java.io.FileInputStream;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			int N = Integer.parseInt(br.readLine());
			long money = 0;
			
			Stack<Long> stack = new Stack<>();
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int i = 0 ; i < N; i++) {
				stack.add(Long.parseLong(st.nextToken()));
			}
			
			long p = stack.pop();
			
			//2개부터 비교 가능하다 (이미 하나는 pop함
			while(stack.size() >= 1) {
				long p2 = stack.pop();
				while(p2 < p && !stack.isEmpty()) {
					money += p - p2;
					p2 = stack.pop();
				}
				if(p2 < p && stack.isEmpty()) {
					money += p - p2;
				}
				p = p2;
			}

			System.out.printf("#%d %d\n", test_case, money);
		}
		br.close();
	}
}
