import java.io.*;
import java.util.*;
 
public class Solution {
    static int V; // V개의 작업을 해야 한다.
    static int[][] adjArr; // 인접행렬 - 선행 관계가 있는 유향 그래프
    static int[] degree; //진입차수 저장 배열
     
    // 각 작업은 하나씩의 정점으로 표시됨
    // 사이클은 존재하지 않는다 -> 위상정렬 가능
     
    // V개의 작업과 선행 관계가 주어질 때, 일을 끝낼 수 있는 작업 순서를 찾는 프로그램 작성
     
    public static void main(String[] args) throws IOException{
         
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         
        StringTokenizer st;
        int T = 10;
        for(int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine());
            V = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());
             
            adjArr = new int[V + 1][V + 1]; //1번부터 시작
            degree = new int[V + 1];
             
            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < E; i++) {
                int A = Integer.parseInt(st.nextToken());
                int B = Integer.parseInt(st.nextToken());
                adjArr[A][B] = 1; //가중치 없음
                degree[B]++;
            }
             
            Queue<Integer> queue = new LinkedList<>();
             
            for(int i = 1; i < V + 1; i++) {
                if(degree[i] == 0) {
                    queue.add(i); //인덱스 번호를 저장함
                }
            }
             
            StringBuilder sb = new StringBuilder();
            while(!queue.isEmpty()) {
                int crr = queue.poll();
                sb.append(crr).append(" ");
                 
                for(int i = 1; i < V + 1; i++) {
                    if(adjArr[crr][i] == 1) {
                        degree[i]--;
                        if(degree[i] == 0){
                            queue.add(i);
                        }
                    }
                }
            }
             
            //정답이 여러 개일 수 있다
            //출력 : 올바른 작업 순서를 공백으로 구분하여 출력
            System.out.printf("#%d %s\n",tc,sb);
        }
        br.close();
    }
}
