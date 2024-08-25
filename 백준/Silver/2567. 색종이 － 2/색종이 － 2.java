import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        
        boolean[][] paper = new boolean[101][101];
        
        // 색종이 붙이기
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());
            
            for (int r = x; r < x + 10; r++) {
                for (int c = y; c < y + 10; c++) {
                    paper[r][c] = true;
                }
            }
        }
        
        // 둘레 길이 계산
        int[] dr = {0, 1, 0, -1}; // 우하좌상
        int[] dc = {1, 0, -1, 0};
        int perimeter = 0;
        
        for (int r = 0; r < 101; r++) {
            for (int c = 0; c < 101; c++) {
                if (paper[r][c]) {
                    for (int d = 0; d < 4; d++) {
                        int nr = r + dr[d];
                        int nc = c + dc[d];
                        
                        if (nr < 0 || nr >= 101 || nc < 0 || nc >= 101 || !paper[nr][nc]) {
                            perimeter++;
                        }
                    }
                }
            }
        }
        
        System.out.println(perimeter);
    }
}
