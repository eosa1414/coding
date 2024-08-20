import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int X = Integer.parseInt(br.readLine());
		
		int leftNum = 1;
		int rightNum = 1;
		int Xtimes = 1;
		int cnt = 0;
		final int right = 0;
		final int down = 1;
		int direction = right;
		
		//1이면 아무것도 하지 않고 그대로 출력한다, 2부터 시작한다
		for(int i = 1; i < X; i++) {
			if(cnt == 0) {
				if(direction == right) {
					rightNum++;
					direction = down;
				}else {
					leftNum++;
					direction = right;
				}
				cnt = Xtimes;
				Xtimes++;
			}else{
				if(direction == down) {
					leftNum++;
					rightNum--;
				}else {
					leftNum--;
					rightNum++;
				}
				cnt--;
			}
			
		}
		
		System.out.printf("%d/%d",leftNum,rightNum);
		System.out.println();
	}

}
