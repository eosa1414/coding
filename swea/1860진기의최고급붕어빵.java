import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) {
		
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));) {
			int T = Integer.parseInt(br.readLine());
			
			for (int tc = 1; tc <= T; tc++) {
				
				StringTokenizer nmk = new StringTokenizer(br.readLine());
				int N = Integer.parseInt(nmk.nextToken());
				int M = Integer.parseInt(nmk.nextToken());
				int K = Integer.parseInt(nmk.nextToken());
				
				//각 정수는 각 사람이 언제 도착하는지를 초 단위로 나타낸다
				StringTokenizer arrives = new StringTokenizer(br.readLine());
				int[] arrive = new int[N];
				for(int i = 0; i < N; i++) {
					arrive[i] = Integer.parseInt(arrives.nextToken());
				}
				
				//진기는 0초부터 붕어빵을 만들기 시작한다.
				int time;
				int bbang;
				
				//M명의 손님에게 기다리는 시간 없이 붕어빵을 제공할 수 있는지 판별하라
				boolean possible = true;
				
				//시간순으로 정렬한다
				Arrays.sort(arrive);
				
				for(int i = 0; i < arrive.length; i++) {
					//M초의 시간을 들이면 K개의 붕어빵을 만들 수 있다. 반드시 M초에 완성되는 방식으로 만들기 때문에 괄호로 묶어줘야 한다
					time = arrive[i];
					bbang = (time / M) * K - i;
					if(bbang < 1) {
						possible = false;
						break;
					}
				}
				String result = possible ? "Possible" : "Impossible";
				System.out.printf("#%d %s\n", tc, result);

			}
			
		} catch (NumberFormatException | IOException e) {
			e.printStackTrace();
		}

	}
}
