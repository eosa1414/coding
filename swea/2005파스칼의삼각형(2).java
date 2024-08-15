import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		for(int tc = 1; tc <= T; tc++) {
			
			int N = Integer.parseInt(br.readLine());
			//크기가 N인 파스칼 삼각형을 만든다
			
			int[][] pascal = new int[N][];
			
			pascal[0] = new int[]{1}; //1번째 줄은 그냥 미리 넣어둠
			
			for(int n = 1; n < N; n++) {//2번째줄부터 수행함
				pascal[n] = new int[n + 1]; //n이 1이면 2번째 줄이고, 크기가 2이다
				pascal[n][0] = 1; //앞의 숫자 1
				for(int i = 1; i < n; i++) {//두 번째 줄은 0번, 세 번째 줄은 1번 ...
					pascal[n][i] = pascal[n - 1][i - 1] + pascal[n - 1][i]; //중간에 끼는 숫자
				}
				pascal[n][n] = 1; //뒤의 숫자 1
			}
			
			//출력
			System.out.printf("#%d\n",tc);
			for(int i = 0; i < N; i++) {//n줄동안 출력함
				for(int j = 0; j <= i; j++) {
					System.out.print(pascal[i][j]+" ");
				}
				System.out.println();
			}
			
		}
	}
}
