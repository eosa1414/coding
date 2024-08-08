import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Solution {
	public static void main(String[] args) {

		
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));) {
			int T = Integer.parseInt(br.readLine());
			for (int tc = 1; tc <= T; tc++) {
				
				int total = 0;
				
				int N = Integer.parseInt(br.readLine());
				int[][] farm = new int[N][N];
				for (int r = 0; r < N; r++) {
					String st = br.readLine();
					for (int c = 0; c < N; c++) {
						farm[r][c] = st.charAt(c) - '0';
					}
				}

				//윗줄
				for (int r = 0; r < farm.length / 2 + 1; r++) {
					for (int c = N / 2 - r; c <= N / 2 + r; c++) {
						total += farm[r][c];
					}
				}
				
				//아랫줄
				if(N != 1) {
					for (int r = farm.length / 2 + 1; r < farm.length; r++) {
						for (int c = r - N / 2; c <= 3 * N / 2 - r - 1 ; c++) {
							total += farm[r][c];
						}
					}
				}
				
				System.out.printf("#%d %d\n", tc, total);

			}

		} catch (NumberFormatException | IOException e) {
			e.printStackTrace();
		}

	}
}
