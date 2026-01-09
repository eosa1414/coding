import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// 자연수 M과 N
// M 이상, N 이하의 자연수 중 소수들만의 합과, 소수의 최솟값을 줄바꿈으로 구분해서 출력
// 만약 M 이상 N 이하의 자연수에 소수가 없다면 -1만 한 줄 출력
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int M = Integer.parseInt(br.readLine());
        int N = Integer.parseInt(br.readLine());

        long sum = 0;
        List<Integer> decimals = new ArrayList<Integer>();

        for(int i = M; i <=N; i++){
            if(i < 2) continue;
            boolean isDecimal = true;
            for(int j = 2; j <= Math.sqrt(i); j++){
                if(i % j == 0){
                    isDecimal = false;
                    break;
                }
            }
            if(isDecimal){
                sum += i;
                decimals.add(i);
            }
        }

        if(sum > 0){
            System.out.println(sum);
            System.out.println(decimals.get(0));
        }else{
            System.out.println(-1);
        }
    }
}