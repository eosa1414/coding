import java.util.*;
import java.io.*;
 
public class Solution{
    // N * N 크기의 도시 중 마름모 영역으로 K 크기에 홈방범 서비스 제공
    // 서비스 영역 크기(K)가 커질수록 운영 비용이 커짐
    // 운영 비용은 서비스 영역의 면적과 동일, K * K + (K - 1) * (K - 1)로 구할 수 있음
    // K는 1 이상의 정수
    // 도시를 벗어난 영역에 제공해도 비용은 변경되지 않음
     
    // 손해를 보지 않는 한 최대한 많은 집에 홈방범 서비스 제공
     
    // 손해를 보지 않으면서, 홈방범 서비스를 가장 많은 집에 제공하는 서비스 영역을 찾고,
    // 그 때 홈방범 서비스를 제공 받는 집 수를 출력하는 프로그램 작성
     
    // 최대 50개 테스트 케이스 통과에 3초
    // N은 5~20의 정수
    // M은 1~10의 정수
    // 집이 있는 위치는 1, 없으면 0이다
    // 도시에는 최소 1개 이상의 집이 있다
    static int N, M, K, price;
    static int[][] city;
    static boolean[][] visited;
    static int cnt;
    //상하좌우
    static final int[] DR = {-1,1,0,0};
    static final int[] DC = {0,0,-1,1};
     
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
         
        int T = Integer.parseInt(br.readLine());
        for(int x = 1; x <= T; x++) {
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
             
            int homeCnt = 0;
            city = new int[N][N];
            for(int r = 0; r < N; r++) {
                st = new StringTokenizer(br.readLine());
                for(int c = 0; c < N; c++) {
                    int obj = Integer.parseInt(st.nextToken());
                    city[r][c] = obj;
                    if(obj == 1) homeCnt++;
                }
            }
             
            K = 1;
            price = 1;
            while(price <= homeCnt * M) {
                K++;
                price = K * K + (K - 1) * (K - 1);
            }
            K = K - 1;
            price = K * K + (K - 1) * (K - 1);
             
            //모든 집이 비용을 낸다는 전제 하에 최대 가능한 크기는 K임
             
//          System.out.println("K는 "+K+"이며, price는 "+price+"입니다");          
             
            int max = 0;
             
            boolean find = false;
            while(!find) {
//              System.out.println("K는 "+K);
                //최대 크기부터 시작하여 모든 집을 넣을 수 있는지 확인
                for(int r = 0; r < N; r++) {
                    for(int c = 0; c < N; c++) {
                        //모든 행열을 중심으로 한 마름모..
                        visited = new boolean[N][N];
                        cnt = 0;
                        BFS(r, c);
                        if(cnt * M >= price && max < cnt) {
                            max = cnt;
                            find = true;
                        }
                    }
                }
                 
                K--;
                price = K * K + (K - 1) * (K - 1);
            }
             
            //출력 : 손해를 보지 않으면서 홈방범 서비스를 가장 많은 집에 제공하는 서비스 영역에서, 서비스를 제공받는 집들의 수
            System.out.printf("#%d %s\n",x,max);
        }
        br.close();
    }
     
    //DFS를 쓰면 안 된다..! 같은 넓이로 퍼져 나가니까 BFS를 쓰자, 아래처럼 chk를 써도 재귀의 visit 순서 탓에 제대로 작동하지 않는다
//  static void count(int r, int c, int chk) {
//      if(chk >= K) return;
//      visited[r][c] = true;
//      if(city[r][c] == 1) {
//          cnt++;
//      }
//      System.out.println("r:"+r+"c:"+c);
//      for(int i = 0; i < 4; i++) {
//          int nr = r + DR[i];
//          int nc = c + DC[i];
//          if(nr < 0 || nr >= N || nc < 0 || nc >= N || visited[nr][nc]) continue;
//          count(nr, nc, chk + 1);
//      }
//  }
     
    static void BFS(int r, int c) {
         
        Queue<Integer> Rs = new LinkedList<>();
        Queue<Integer> Cs = new LinkedList<>();
         
        Rs.add(r);
        Cs.add(c);
        visited[r][c] = true;
         
        int depth = 0;
         
        while(!Rs.isEmpty()) {
             
            int size = Rs.size();
             
            if(depth == K) break;
 
            for(int s = 0; s < size; s++) {//깊이를 파악하기 위한 방식, 기억해두기
                int currR = Rs.poll();
                int currC = Cs.poll();
                if(city[currR][currC] == 1) {
                    cnt++;
                }   
                 
//              System.out.println("r:"+currR+"c:"+currC);
                for(int i = 0; i < 4; i++) {
                    int nr = currR + DR[i];
                    int nc = currC + DC[i];
                     
                    if(nr < 0 || nr >= N || nc < 0 || nc >= N || visited[nr][nc]) continue;
                    Rs.add(nr);
                    Cs.add(nc);
                    visited[nr][nc] = true;
                }
            }
             
            depth++;
             
        }
             
    }
     
}
