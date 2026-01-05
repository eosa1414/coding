import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//숫자 N이 주어질 때, 중앙에서 N번 방까지 갈 때 최소로 거치는 방의 최소 개수 구하기
//※이동하는 횟수가 아니라 방의 개수임에 유의
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

//      1: 1
//      2~7: 2
//      8~19: 3
//      20~37: 4
//      ...
//      1까지, 1에 6을 더한 수까지, 1+6+6*2=19까지, 1+6+6*2+6*3=37까지...
//      특정 규칙에 따라 최소 방 개수가 증가하는 형식임

        int num = 1;
        int cnt = 1;

        while(num<N){
            num += 6*cnt;
            cnt++;
        }

        System.out.println(cnt);

    }
}