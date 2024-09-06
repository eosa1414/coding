import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Solution{
    static int N, M, R, C, L;
    static int[][] map;
    static int[][] visited;
    static int total;
     
    static final int UP = 0, DOWN = 1, LEFT = 2, RIGHT = 3;
    static final int[] DR = {-1,1,0,0};
    static final int[] DC = {0,0,-1,1};
     
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
        for(int x = 1; x <= T; x++) {
            // 탈출한 흉악범을 찾고자 함
            // 탈출한 지 한 시간 뒤, 탈주범은 맨홀로 지하터널의 한 지점에 들어감
            // 현재 지하 터널 어딘가에 은신 중
            // 터널끼리 연결되어 있으면 이동이 가능하므로, 탈주범이 있을 수 있는 위치의 개수를 계산해야 함
            // 탈주범은 시간당 1의 거리를 움직일 수 있음
             
            //조건부 DFS?
 
            //지하 터널 지도, 맨홀 뚜껑 위치, 경과 시간이 주어질 때,
            //탈주범이 위치할 수 있는 장소의 개수를 계산
 
            //제약조건:
            // 50개 TC, Java 1초 1억번 계산?
            // 5~ 세로N, 가로M ~50
            // 0~ 맨홀 뚜껑의 세로 위치 R ~ N - 1
            // 0~ 맨홀 뚜껑의 가로 위치 C ~ M - 1
            // 1~ 탈출 후 소요된 시간 L ~20
            // 지하 터널 지도엔 반드시 1개 이상의 터널이 있음이 보장됨
            // 맨홀 뚜껑은 항상 터널이 있는 위치에 존재함
             
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            R = Integer.parseInt(st.nextToken());
            C = Integer.parseInt(st.nextToken());
            L = Integer.parseInt(st.nextToken());
             
            map = new int[N][M];
            for(int r = 0; r < N; r++) {
                st = new StringTokenizer(br.readLine());
                for(int c = 0; c < M; c++) {
                    map[r][c] = Integer.parseInt(st.nextToken());
                }
            }
             
            visited = new int[N][M];
            total = 0;
             
            DFS(R,C, 1);
             
            for(int r = 0; r < N; r++) {
                for(int c = 0; c < M; c++) {
                    if(visited[r][c] > 0) {
                        total++;
                    }
                }
            }
             
            //출력 : 탈주범이 위치할 수 있는 장소 개수
            System.out.printf("#%d %s\n",x,total);
        }
        br.close();
    }
     
    static void DFS(int r, int c, int cnt) {
        if(cnt > L) {
            return;
        }
        visited[r][c] = cnt;
         
        // 지하 터널은 총 7종류의 구조물로 구성돼 있음
        int op = map[r][c];
        for(int d = 0; d < 4; d++) {//상하좌우
             
            int nr = r + DR[d];
            int nc = c + DC[d];
             
            if(nr < 0 || nr >= N || nc < 0 || nc >= M || (visited[nr][nc] > 0 && visited[nr][nc] <= cnt)|| map[nr][nc] == 0) continue;
             
            int op2 = map[nr][nc];
             
            //1상하좌우 2상하 3좌우 4상우 5하우 6하좌 7상좌
            if(d == UP && (op == 3 || op == 5 || op == 6 || op2 == 3 || op2 == 4 || op2 == 7)) {
                continue;
            }else if(d == DOWN && (op == 3 || op == 4 || op == 7 || op2 == 3 || op2 == 5 || op2 == 6)) {
                continue;
            }else if(d == LEFT && (op == 2 || op == 4 || op == 5 || op2 == 2 || op2 == 6 || op2 == 7)) {
                continue;
            }else if(d == RIGHT && (op == 2 || op == 6 || op == 7 || op2 == 2 || op2 == 4 || op2 == 5)) {
                continue;
            }
             
             
            DFS(nr, nc, cnt + 1);
        }
         
    }
}
