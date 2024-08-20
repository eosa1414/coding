import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int X = Integer.parseInt(br.readLine());
		
		int leftNum = 1;
		int rightNum = 1;
		int Xtimes = 0;
		
		//1이면 아무것도 하지 않고 그대로 출력한다, 2부터 시작한다
		for(int i = 1; i < X; i++) {
			if(leftNum == 1 && rightNum % 2 != 0) {
					rightNum++;
					Xtimes++;
			}else if(rightNum == 1 && leftNum % 2 == 0) {
					leftNum++;
					Xtimes++;
			} else if(Xtimes % 2 == 0){
				leftNum--;
				rightNum++;
			}else {
				leftNum++;
				rightNum--;
			}
		}
		
		System.out.printf("%d/%d",leftNum,rightNum);
		System.out.println();
	}

}
