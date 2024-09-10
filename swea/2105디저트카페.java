import java.io.*;
import java.util.*;
 
public class Solution {
     
    //한 변의 길이가 N인 정사각형 모양 지역에 디저트 카페가 모여 있음
    //각 칸의 숫자는 해당 디저트 카페에서 팔고 있는 디저트 종류
    //카페들 사이에는 대각선 방향으로 움직일 수 있는 길이 있음
    //어느 한 카페에서 출발하여 대각선 방향으로 움직이고 사각형 모양을 그리며 출발한 카페로 돌아오는 디저트 카페 투어를 할 것임
    // ㄴ도중에 지역을 벗어나지 않도록 한다
    // ㄴ같은 숫자의 디저트를 팔고 있는 카페가 있으면 안 된다
    // ㄴ두 개 이상의 카페를 투어해야 한다
    // ㄴ왔던 길을 되돌아갈 수 없다
    // 되도록 많은 디저트를 먹으려고 한다.
     
    static int N;
    static int[][] dessert;
    static boolean[][] visited;
    static int max;
     
    //오른쪽아래, 왼쪽아래, 왼쪽위, 오른쪽위
    static final int[] DR = {1,1,-1,-1};
    static final int[] DC = {1,-1,-1,1};
     
    //시간제한: 최대 50개 테스트 케이스 통과까지 Java 3초
    // N은 4~20의 정수
    // 디저트 종류는 1~100의 정수
     
    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int T = Integer.parseInt(br.readLine());
         
        for(int t = 1; t <= T; t++) {
             
            N = Integer.parseInt(br.readLine());
             
            dessert = new int[N][N];
            visited = new boolean[N][N];
             
            for(int r = 0; r < N; r++) {
                st = new StringTokenizer(br.readLine());
                for(int c = 0; c < N; c++) {
                    dessert[r][c] = Integer.parseInt(st.nextToken());
                }
            }
             
            max = 0;
            for(int r = 0; r < N - 2; r++) {
                for(int c = 1; c < N - 1; c++) {
                    tour(r,c);
                }
            }
             
            //출력 : 가능한 경우 중 디저트를 가장 많이 먹을 때의 디저트 수
            //만일 디저트를 먹을 수 없다면 정답은 -1 (주의)
            int result = max == 0 ? -1 : max;
            System.out.printf("#%d %s\n",t,result);
        }
         
        br.close();
    }
     
    static void tour(int r, int c) {
         
         
         
        //만일 c가 0이라면 될 수 있는 것은 없음
        //만일 c가 1이고 크기가 4라면 왼쪽1, 오른쪽1 / 왼쪽1, 오른쪽2 의 가능성
        //만일 c가 1이고 크기가 5라면 왼쪽1, 오른쪽1 / 왼쪽1, 오른쪽2 / 왼쪽1, 오른쪽3 의 가능성
         
        //만일 c가 2고 크기가 4라면 왼쪽1, 오른쪽1 /왼쪽2, 오른쪽1 의 가능성
         
        for(int R = 1; R < N - c; R++) {//오른쪽
            for(int L = 1; L <= c; L++) {//왼쪽
                if(r + L + R >= N) continue; //오른쪽 왼쪽 다 갔더니 높이 넘었다면 불가능
                 
                Set<Integer> set = new HashSet<>();
                 
                int nr = r;
                int nc = c;
                int cnt = 0;
                 
                //오른쪽 아래로 감
                for(int i = 0; i < R; i++) {
                    nr = nr + DR[0];
                    nc = nc + DC[0];
                     
                    set.add(dessert[nr][nc]);
                    cnt++;
                }
                //왼쪽 아래로 감
                for(int i = 0; i < L; i++) {
                    nr = nr + DR[1];
                    nc = nc + DC[1];
                     
                    set.add(dessert[nr][nc]);
                    cnt++;
                }
                //왼쪽 위로 감
                for(int i = 0; i < R; i++) {
                    nr = nr + DR[2];
                    nc = nc + DC[2];
                     
                    set.add(dessert[nr][nc]);
                    cnt++;
                }
                //오른쪽 위로 감
                for(int i = 0; i < L; i++) {
                    nr = nr + DR[3];
                    nc = nc + DC[3];
                     
                    set.add(dessert[nr][nc]);
                    cnt++;
                }
                 
                if(set.size() == cnt && cnt > max) {
                    max = cnt;
                }
                 
            }
        }
         
    }
}
