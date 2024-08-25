import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	static final short DOUBLE_BORDER = 4;
	static final short BORDER = 2;
	static final short INNER = 1;
	static final short NOTHING = 0;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		short[][] paper = new short[101][101];
		int minR = 100;
		int minC = 100;
		int maxR = 0;
		int maxC = 0;
		for(int i = 0; i < N; i++) {//네 번 반복
			StringTokenizer st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken());
			int y = Integer.parseInt(st.nextToken());
			
			for(int c = y; c <= y + 9; c++) {
				if(paper[x][c] == NOTHING) {
					paper[x][c] = BORDER;
				}
			}
			for(int r = x + 1; r <= x + 8; r++) {
				if(paper[r][y] == NOTHING) {
					paper[r][y] = BORDER;
				}
				for(int c = y + 1; c <= y + 8; c++) {
					paper[r][c] = INNER;
				}
				if(paper[r][y + 9] == NOTHING) {
					paper[r][y + 9] = BORDER;
				}
			}
			for(int c = y; c <= y + 9; c++) {
				if(paper[x + 9][c] == NOTHING) {
					paper[x + 9][c] = BORDER;
				}
			}
			minR = Math.min(minR, x);
			maxR = Math.max(maxR, x + 9);
			minC = Math.min(minC, y);
			maxC = Math.max(maxC, y + 9);
		}
		
		//우하좌상
		int[] dr = {0, 1, 0, -1};
		int[] dc = {1, 0, -1, 0};
		int cnt = 0;
		for(int r = minR; r <= maxR; r++) {
			for(int c = minC; c <= maxC; c++) {
				if(paper[r][c] == BORDER) {
					for (int i = 0; i < 4; i++) {
                        int nr = r + dr[i];
                        int nc = c + dc[i];
                        if (nr < minR || nr > maxR || nc < minC || nc > maxC || paper[nr][nc] == NOTHING) {
                            cnt++;
                        }
                    }
				}
			}
		}
		
		System.out.println(cnt);
	}
}
