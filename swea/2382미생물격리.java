import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;
 
class Micro{
    int r;
    int c;
    int total;
    int status;
     
    public Micro(int r, int c, int total, int status) {
        super();
        this.r = r;
        this.c = c;
        this.total = total;
        this.status = status;
    }
 
    @Override
    public String toString() {
        String s;
        if(status == 0) {
            s = "-";
        }else if(status == 1) {
            s = "상";
        }else if(status == 2) {
            s = "하";
        }else if(status == 3) {
            s = "좌";
        }else {
            s = "우";
        }
         
        return total + "("+ s +")";
    }
     
}
 
public class Solution{
     
    static int N, M, K;
    static List<Micro>[][] cell;
    static Micro[] micro;
     
    static final int none = 0, up=1, down=2, left=3, right=4;
    static final int[] dr = {0,-1,1,0,0};
    static final int[] dc = {0,0,0,-1,1};
     
    static int ans;
     
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        StringTokenizer st;
         
        // 정사각형 안에 미생물 군집이 K개.
        // 가로 N개, 세로 N개, 총 N * N 개의 정사각형 셀
        // 미생물이 구역을 벗어나지 않게 가장 바깥 테두리 셀엔 특수 약품 O
         
        for(int t = 1; t <= T; t++) {
            st = new StringTokenizer(br.readLine());
             
            N = Integer.parseInt(st.nextToken()); // 한 변에 있는 셀의 N
            M = Integer.parseInt(st.nextToken()); // 격리 시간 M
            K = Integer.parseInt(st.nextToken()); // 미생물 군집의 개수 K
             
            cell = new List[N][N];
            for(int r = 0; r < N; r++) {
                for(int c = 0; c < N; c++) {
                    cell[r][c] = new LinkedList<Micro>();
                }
            }
             
            micro = new Micro[K];
            for(int i = 0; i < K; i++) { //K줄에 거쳐서 미생물 군집 K의 정보가 주어진다
                st = new StringTokenizer(br.readLine());
                //최초 각 미생물 군집의 위치와 군집 내 미생물 수, 이동 방향(상하좌우)이 주어짐
                Micro newMicro = new Micro(
                        Integer.parseInt(st.nextToken()),
                        Integer.parseInt(st.nextToken()),
                        Integer.parseInt(st.nextToken()),
                        Integer.parseInt(st.nextToken())
                        );
                micro[i] = newMicro;
                cell[newMicro.r][newMicro.c].add(newMicro); //배치
            }
             
            int time = 1;
            while(time++ <= M) {
                     
                for(int i = 0; i < K; i++) {//있는 군집 수만큼 이동한다
                    Micro crr = micro[i];
                    if(crr.status == none) continue;//사라진 군집이라면 넘김
                     
                    //존재하는 군집이라면
                    int nr = crr.r + dr[crr.status];
                    int nc = crr.c + dc[crr.status];
                     
                    int j;
                    for(j = 0; j < cell[crr.r][crr.c].size(); j++) {
                        if(cell[crr.r][crr.c].get(j).equals(crr)) break;
                    }
                    cell[crr.r][crr.c].remove(j);//원래 있던 곳은 비우고
                     
                    cell[nr][nc].add(crr);//새로운 곳에 위치한다
                    crr.r = nr;
                    crr.c = nc;
                     
                    if(nr == 0 || nr == N - 1 || nc == 0 || nc == N - 1) {//약품 셀에 가게 된다면
                        //미생물 수가 절반이 된다
                        crr.total = crr.total / 2;
                        if(crr.total == 0) {//죽어버리면
                            crr.status = none;
                        }
                         
                        //이동방향이 반대로 바뀐다
                        if(crr.status == up) {
                            crr.status = down;
                        }else if(crr.status == down) {
                            crr.status = up;
                        }else if(crr.status == left) {
                            crr.status = right;
                        }else if(crr.status == right) {
                            crr.status = left;
                        }
                    }
                }
                 
                //만일 겹치는 게 있다면
                for(int r = 0; r < N; r++) {
                    for(int c = 0; c < N; c++) {
                        if(cell[r][c].size() >= 2) {
                            int total = 0;
                            int max = 0;
                            int maxIdx = 0;
                            for(int i = 0; i < cell[r][c].size(); i++) {
                                if(cell[r][c].get(i).status == none) continue;
                                total += cell[r][c].get(i).total;
                                if(cell[r][c].get(i).total > max) {
                                    max = cell[r][c].get(i).total;
                                    maxIdx = i;
                                }
                            }
                            for(int i = 0; i < cell[r][c].size(); i++) {
                                if(i == maxIdx) continue;
                                cell[r][c].get(i).status = none;
                            }
                            cell[r][c].get(maxIdx).total = total;
                        }
                    }
                }
                 
            }
             
            // 각 군집은 1시간마다 이동방향에 있는 다음 셀로 이동한다.
            // 미생물 군집 이동 후 약품이 칠해진 셀에 도착하면 군집 내 미생물의 반이 죽고, 이동방향이 반대로 바뀐다
            // ㄴ미생물 수가 홀수라면 2로 나누고 소수점 이하를 버림 -> 1마리라면 다 죽음
            // 이동 후 두 개 이상의 군집이 모이면 이 군집들은 합쳐짐
            // 합쳐진 군집 미생물 수는 군집 미생물 수의 합, 이동방향은 수가 더 많은 군집의 것으로
            // ~합쳐지는 군집의 미생물 수가 같은 경우는 안 주어지므로 고려 안 해도 됨~
             
            ans = 0;
            for(int i = 0; i < K; i++) {
                if(micro[i].status == none) continue;
                ans += micro[i].total;
            }
             
            // M시간 동안 군집을 격리. M시간 후 남아 있는 미생물 수 총합 구하기
            System.out.printf("#%d %s\n",t,ans);
        }
        br.close();
    }
}
