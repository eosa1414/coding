import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int NumOfstudent = Integer.parseInt(br.readLine());
		StringTokenizer pickNums = new StringTokenizer(br.readLine());
		
		List<Integer> studentLine = new LinkedList<>();
		
		int pickNum;
		for(int seq = 1; seq <= NumOfstudent; seq++) {
			pickNum = Integer.parseInt(pickNums.nextToken());
			studentLine.add(seq - 1 - pickNum, seq);
		}
		
		//출력
		for(int i = 0; i < NumOfstudent - 1; i++) {
			System.out.print(studentLine.get(i) + " ");
		}
		System.out.println(studentLine.get(NumOfstudent - 1));
		
	}
}
