import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

//V미터를 올라간다
//낮 동안 A미터 올라가고, 밤 동안 B미터 내려간다(단, 정상에 올라가면 안 미끄러진다)
//문제: 나무 막대를 모두 올라가기까지 며칠이 걸릴까?
public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        //범위 check
//        System.out.println(Integer.MAX_VALUE); //int의 최대값은 2147483647이므로 A, B, V는 long이어야 함
//        System.out.println(Long.MAX_VALUE); //9223372036854775807
        StringTokenizer st = new StringTokenizer(br.readLine());

        long A = Long.parseLong(st.nextToken());
        long B = Long.parseLong(st.nextToken());
        long V = Long.parseLong(st.nextToken());

        //시간 초과 - 예상됨
//        long snail = 0;
//        long day = 0;
//
//        while(snail < V){
//            day++;
//            snail = snail + A;
//            if(snail>=V) break;
//            snail = snail - B;
//        }

        //수학적 고려
        long day = (V-A)/(A-B)+1; //마지막 날은 +1로 처리하고, 목표에서 A수치를 뺀 만큼
        if((V-A) % (A-B) != 0) day++; //아직 더 가야 하는 거리가 있지만, 나아가는 숫자가 더 클 때가 있음

        System.out.println(day);

    }
}