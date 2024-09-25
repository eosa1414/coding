import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
 
public class Solution {
    static int[] plan, dp;
    static int day, month, tmonth, year;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
         
        int T = Integer.parseInt(br.readLine());
        for(int tc = 1; tc <= T; tc++) {
            StringTokenizer prices = new StringTokenizer(br.readLine());
            day = Integer.parseInt(prices.nextToken());
            month = Integer.parseInt(prices.nextToken());
            tmonth = Integer.parseInt(prices.nextToken());
            year = Integer.parseInt(prices.nextToken());
             
            StringTokenizer plans = new StringTokenizer(br.readLine());
            plan = new int[13];
            for(int i = 1; i < plan.length; i++) {
                plan[i] = Integer.parseInt(plans.nextToken());
            }
             
            dp = new int[13];
            for(int i = 1; i < dp.length; i++) {
                //1일과 1달 중 더 작은 것으로 저장
                dp[i] = Math.min(day * plan[i], month) + dp[i - 1];
                 
                if(i >= 3) {
                    dp[i] = Math.min(dp[i-3] + tmonth, dp[i]);
                }
            }
            //가장 적은 비용으로 수영장을 이용할 수 있는 방법을 찾고,
            // 그 비용을 정답으로 출력
            System.out.printf("#%d ",tc);
            System.out.println(Math.min(dp[12],year));
        }
        br.close();
    }
}
