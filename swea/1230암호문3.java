import java.io.BufferedReader;
//import java.io.FileInputStream;
//import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
	public static void main(String[] args) {
//		//파일 입력용
//		try {
//			System.setIn(new FileInputStream("input.txt"));
//		} catch (FileNotFoundException e) {
//			e.printStackTrace();
//		}
//		boolean answer_check = true;
		try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			/*BufferedReader checktxt = new BufferedReader(new FileReader("output.txt"));*/) {
			
			int T = 10;
			for (int tc = 1; tc <= T; tc++) {
				int N = Integer.parseInt(br.readLine());
				StringTokenizer secretCode_st = new StringTokenizer(br.readLine());
				
				List<Integer> secretCode = new LinkedList<>();
				for(int i = 0; i < N; i++) {
					secretCode.add(Integer.parseInt(secretCode_st.nextToken()));
				}

				//암호문을 처리함
				int commandsNum = Integer.parseInt(br.readLine());
				StringTokenizer commands = new StringTokenizer(br.readLine());
				for(int i = 0; i < commandsNum; i++) {
					char option = commands.nextToken().charAt(0); //I(삽입)인지 D(삭제) A(추가)인지- equals 쓰기 싫어서 char로 넣어줌
					if(option == 'I') {//삽입
						int commandIdx = Integer.parseInt(commands.nextToken());
						int commandcnt = Integer.parseInt(commands.nextToken());
						for(int c = commandIdx; c < commandcnt + commandIdx; c++) {
							secretCode.add(c, Integer.parseInt(commands.nextToken()));
						}
					}else if(option == 'D'){//삭제
						int commandIdx = Integer.parseInt(commands.nextToken());
						int commandcnt = Integer.parseInt(commands.nextToken());
						for(int c = 0; c < commandcnt; c++) {
							secretCode.remove(commandIdx);
						}
					}else {//추가
						int commandcnt = Integer.parseInt(commands.nextToken());
						for(int c = 0; c < commandcnt; c++) {
							secretCode.add(Integer.parseInt(commands.nextToken())); //끝에 추가함
						}
					}
				}
				
				//10개만 출력할 것임 - 반드시 10개가 출력된다고 가정하고 작성하였고, 미만인 경우는 고려하지 않음
				StringBuilder resultCode = new StringBuilder();
				for(int i = 0; i < 9; i++) {
					resultCode.append(secretCode.get(i)).append(" ");
				}
				resultCode.append(secretCode.get(9));
				
				String print = "#" + tc + " " + resultCode + "\n";
				System.out.print(print);
				
//				//이하 정답 체크
//				String checktxt_now = checktxt.readLine().strip(); //swea는 뒤쪽 공백 유무 정도는 무시한다
//				if(!(print.strip().equals(checktxt_now))) {
//					answer_check = false;
//				}
				
				
			}
			
//			String check_correct = answer_check ? ">> 맞았습니다" : ">> 틀렸습니다";
//			System.out.println(check_correct);
			
		} catch (NumberFormatException | IOException e) {
			e.printStackTrace();
		}

	}
}
