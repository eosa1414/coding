import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution{
	static int[] H, sel;
	static int N, B;
	static int min;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		for(int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken());
			B = Integer.parseInt(st.nextToken());			
			
			st = new StringTokenizer(br.readLine());
			H = new int[N];
			for(int i = 0; i < N; i++) {
				H[i] = Integer.parseInt(st.nextToken());
			}
			
			min = Integer.MAX_VALUE;
			sel = new int[N];
			부분집합(0,0);
			
			//출력: 가장 B와 가까운 것
			System.out.printf("#%d %s\n",t,min - B);
		}
		br.close();
	}
	
	static void 부분집합(int idx, int sum) {
		if(sum >= min) return;
		if(idx == N) {
			if(sum < B) return;
			min = sum;
			return;
		}
		
		//고른다
		sel[idx] = H[idx];
		부분집합(idx + 1,sum + H[idx]);
		//고르지 않는다
		sel[idx] = 0;
		부분집합(idx + 1,sum);
		
	}
}
