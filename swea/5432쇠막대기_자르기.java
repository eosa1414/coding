import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Solution {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		
		for(int test_case = 1; test_case <= T; test_case++)
		{			
			Stack<Character> stack = new Stack<>();
			String Case = br.readLine();
			
			int total = 0;
			
			for(int i = 0; i < Case.length(); i++) {
				if(Case.charAt(i) == '(') {
					stack.push(Case.charAt(i));
				}else {// )인 경우
					stack.pop();
					if(Case.charAt(i-1) == '(') {//만약 이전 것이 (였다면 레이저이므로
						total += stack.size(); //잘린 개수를 더해주고
					}else {
						total += 1; //그렇지 않다면 막대가 끝난 것이므로 마지막 막대값을 더해준다
					}
				}
			}
            
			//출력
			System.out.printf("#%d %d\n", test_case, total);
		}
		
		br.close();
		
	}

}
