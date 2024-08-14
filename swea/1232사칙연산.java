import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;
 
 
class Math{
    int math;
    boolean Isnum;
    int leftid;
    int rightid;
     
    public Math() {
         
    }
     
    public Math(int math) {//숫자인 경우
        this.math = math;
        Isnum = true;
    }
     
    public Math(int math, int leftid, int rightid) {//연산자인 경우
        this.math = math;
        this.leftid = leftid;
        this.rightid = rightid;
    }
 
    @Override
    public String toString() {
        return "Math [math=" + math + ", num=" + Isnum + ", leftid=" + leftid + ", rightid=" + rightid + "]";
    }
}
 
public class Solution {
                 
    public static void main(String[] args) throws IOException {
//      //파일 입력용
//      System.setIn(new FileInputStream("input.txt"));
//      boolean answer_check = true;
//      BufferedReader checktxt = new BufferedReader(new FileReader("output.txt"));
 
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = 10;
 
        for (int tc = 1; tc <= T; tc++) {
             
            int N = Integer.parseInt(br.readLine());
             
            List<Math> list = new LinkedList<>();
             
            list.add(new Math());//0번 인덱스
             
            for(int i = 0; i < N; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                // int deep = Integer.parseInt(
                st.nextToken();
                //); //사용하지 않음
                String math = st.nextToken();
                char option = math.charAt(0);
                if('0' <= option && option <= '9') {//숫자라면
                    list.add(new Math(Integer.parseInt(math)));
                }else {//연산자라면
                    list.add(new Math(option, Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
                }
            }
             
            int result = Calc(list, 1); //1번 부터 계산한다
     
            String print = "#" + tc + " " + result + "\n";
            System.out.print(print);
 
//              //이하 정답 체크
//              String checktxt_now = checktxt.readLine().strip(); //swea는 뒤쪽 공백 유무 정도는 무시한다
//              if(!(print.strip().equals(checktxt_now))) {
//                  answer_check = false;
//              }
 
        }
 
//          String check_correct = answer_check ? ">> 맞았습니다" : ">> 틀렸습니다";
//          System.out.println(check_correct);
 
    }
     
    static int Calc(List<Math> list, int i) {
        Math math = list.get(i); //0번 인덱스는 1비어 있다 1번 인덱스를 먼저 받는다
        if(math.Isnum) {//본인이 숫자라면 본인 return
            return math.math;
        }else if(math.math == '-') {
            return Calc(list, math.leftid) - Calc(list, math.rightid);
        }else if(math.math == '*') {
            return Calc(list, math.leftid) * Calc(list, math.rightid);
        }else if(math.math == '/') {
            return Calc(list, math.leftid) / Calc(list, math.rightid);
        }else {
            return Calc(list, math.leftid) + Calc(list, math.rightid); //+인 경우
        }
    }
     
}
