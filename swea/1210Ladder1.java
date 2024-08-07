import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for(int test_case = 1; test_case <= 10; test_case++)
		{
			int tc = Integer.parseInt(br.readLine());
			
			int[][] ladder = new int[100][100];
			for(int r = 0; r < 100; r++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				for(int c = 0; c < 100; c++) {
					ladder[r][c] = Integer.parseInt(st.nextToken());
				}
			}
			
			// 1) 출발지점을 찾는다
			int end = 0;
			for(int c = 0; c < 100; c++) {
				if(ladder[99][c] == 2)
					end = c;
			}
			
			// 2) 출발지점으로부터 위로 올라가서 출발지점을 찾는다
			int r = 99;
			int c = end;
			
			//상좌우
			int[] dr = {-1, 0, 0};
			int[] dc = {0, -1, 1};
			int d = 0;
			while(r >= 0) {
				if(c != 0 && ladder[r + dr[1]][c + dc[1]] == 1) {//좌측이 1이라면
					d = 1;
					while(c != 0 && ladder[r + dr[1]][c + dc[1]] != 0) {
						r = r + dr[d];
						c = c + dc[d];
					}
					d = 0;
				}else if(c != 99 && ladder[r + dr[2]][c + dc[2]] == 1) {//우측이 1이라면
					d = 2;
					while(c != 99 && ladder[r + dr[2]][c + dc[2]] != 0) {
						r = r + dr[d];
						c = c + dc[d];
					}
					d = 0;
				}
				r = r + dr[d];
				c = c + dc[d];//위로 올려줌
			}

			System.out.printf("#%d %d\n", tc, c);
		}
		br.close();
	}
}
