import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer nm = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(nm.nextToken());
		int M = Integer.parseInt(nm.nextToken());
		
		int[][] ijArr = new int[N][M];
		
		for(int i = 0; i < N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j = 0; j < M; j++) {
				ijArr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		int K = Integer.parseInt(br.readLine()); //합을 구할 부분의 개수
		
		//K개의 줄동안 i j x y가 주어진다.
		for(int tc = 0; tc < K; tc++) {
			int total = 0;
			
			StringTokenizer ijxy = new StringTokenizer(br.readLine());
			int i = Integer.parseInt(ijxy.nextToken());
			int j = Integer.parseInt(ijxy.nextToken());
			int x = Integer.parseInt(ijxy.nextToken());
			int y = Integer.parseInt(ijxy.nextToken());
			
			for(int r = i - 1; r < x; r++) {
				for(int c = j - 1; c < y; c++) {
					total += ijArr[r][c];
				}
			}
			
			System.out.println(total);
		}
	}

}
