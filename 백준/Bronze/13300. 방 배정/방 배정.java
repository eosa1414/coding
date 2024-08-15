import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		//방 배정에 필요한 최소 방 개수를 구하는 프로그램 작성
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] NK = br.readLine().split(" ");
		int N = Integer.parseInt(NK[0]); //수학여행 참가 학생 수 (1~1000)
		double K = Double.parseDouble(NK[1]); //최대 인원 수 K (1~1000)
		
		int[][] cnt = new int[7][2]; //6개 학년, 성별은 2개
		
		for(int n = 0; n < N; n++) { //N줄에 걸쳐 학생 성별 S(여학생0, 남학생1)와 Y(1~6)가 주어진다.
			StringTokenizer sy = new StringTokenizer(br.readLine());
			int S = Integer.parseInt(sy.nextToken());
			int Y = Integer.parseInt(sy.nextToken());
			cnt[Y][S]++; //해당하는 학생 수를 세준다.
		}
		
		int cntRoom = 0;
		for(int grade = 1; grade<=6; grade++) {
			for(int sex = 0; sex <= 1; sex++) {
				cntRoom += Math.ceil((cnt[grade][sex]) / K);
			}
		}
		
		System.out.println(cntRoom);
	}
}
