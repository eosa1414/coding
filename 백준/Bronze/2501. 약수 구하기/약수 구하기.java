import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

//두 자연수 N K
// N의 약수들 중 K번째로 작은 수를 출력
// 만일 N의 약수의 개수가 K개보다 적어서 K번째 약수가 존재하지 않을 경우에는 0을 출력
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int cnt = 0;

        List<Integer> factors = new ArrayList<>();

        for(int i = 1; i * i <= N; i++){
            if(N % i == 0){
                factors.add(i);
                cnt++;
                if(N/i != i){
                    factors.add(N / i);
                    cnt++;
                }
            }
        }

        Collections.sort(factors);

        if(cnt < K) System.out.println(0);
        else System.out.println(factors.get(K-1)); //K는 1 이상이므로 입력에서 오류가 없다고 가정함
    }
}