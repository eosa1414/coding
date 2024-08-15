import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
 
public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for(int tc = 1; tc <= T; tc++) {
             
            int N = Integer.parseInt(br.readLine());
            //크기가 N인 파스칼 삼각형을 만든다
             
            List<Integer> pascal = new LinkedList<>();
             
            pascal.add(1); //1번째 줄은 그냥 미리 넣어둠
             
            for(int n = 1; n < N; n++) {//2번째줄부터 수행함
                pascal.add(1); //앞의 숫자 1
                for(int i = 1; i < n; i++) {//두 번째 줄은 0번, 세 번째 줄은 1번 ...
                    int idx = (n * (n - 1)) / 2 + i;
                    pascal.add(pascal.get(idx - 1) + pascal.get(idx)); //중간에 끼는 숫자
                }
                pascal.add(1); //뒤의 숫자 1
            }
             
            //출력
            System.out.printf("#%d\n",tc);
            int num = 0;
            for(int i = 0; i < N; i++) {//n줄동안 출력함
                for(int j = 0; j <= i; j++) {
                    System.out.print(pascal.get(num++)+" ");
                }
                System.out.println();
            }
             
        }
    }
}
