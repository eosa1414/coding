import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//10진법 수 N
//B진법으로 바꿔 출력하는 프로그램 작성
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();

        while(N > 0){
            int remain = N % B;
            if(remain < 10) sb.append((char)('0' + remain));
//            else sb.append((char)(remain + 55));
            else sb.append((char)('A' + remain - 10));
            N /= B;
        }

        System.out.println(sb.reverse());
    }
}