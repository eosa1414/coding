import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
//import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int[][] grid = new int[9][9]; //9x9 고정 격자판
        int max = -1;
        int maxR = -1;
        int maxC = -1;

        for(int r = 0; r < 9; r++){
            StringTokenizer numbers = new StringTokenizer(br.readLine());
            for(int c = 0; c < 9; c++){
                grid[r][c] = Integer.parseInt(numbers.nextToken());
                if(max < grid[r][c]) {//최댓값이 2개 이상이라면 아무 곳이나 출력 - 신경 쓰지 않아도 ok
                    max = grid[r][c];
                    maxR = r;
                    maxC = c;
                }
            }
        }
//        System.out.println(Arrays.deepToString(grid)); //배열 확인용 - 정상적으로 입력됨

        System.out.println(max);
//        System.out.println((maxR+1)+" "+(maxC+1));
//        ㄴ학습 포인트: 괄호를 하지 않으면 중간 문자열로 인해 maxC+1이 문자열처럼 결합해서 출력되는 문제가 생김
        System.out.printf("%d %d%n",maxR+1, maxC+1); //printf를 쓰면 실수를 줄일 수 있음, 단, \n를 빼먹지 않도록 주의

    }
}