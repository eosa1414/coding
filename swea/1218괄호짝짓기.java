import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Stack;

public class Solution {

	public static void main(String[] args) throws Exception {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int test_case = 1; test_case <= 10; test_case++)
		{			
			
			Stack<Character> case_stack = new Stack<>();
			
			int L = Integer.parseInt(br.readLine());
			
			String _case = br.readLine();
			
			for(int i = 0; i < L; i++) {//문자열을 stack에 담아줌
				case_stack.push(_case.charAt(i));
			}
			
			int cnt = 0;
			
			out: while(!case_stack.isEmpty()) {
				
				if(cnt > 0) {break;}
				
				char pop = case_stack.pop();
				
				if(pop == ')') {
					for(int i = case_stack.size() - 1; i>=0; i--) {
						if(case_stack.get(i)=='(') {
							case_stack.remove(i);
							continue out;
						}
					}
				} else if(pop == '}') {
					for(int i = case_stack.size() - 1; i>=0; i--) {
						if(case_stack.get(i)=='{') {
							case_stack.remove(i);
							continue out;
						}
					}
				} else if(pop == ']') {
					for(int i = case_stack.size() - 1; i>=0; i--) {
						if(case_stack.get(i)=='[') {
							case_stack.remove(i);
							continue out;
						}
					}
				} else if(pop == '>') {
					for(int i = case_stack.size() - 1; i>=0; i--) {
						if(case_stack.get(i)=='<') {
							case_stack.remove(i);
							continue out;
						}
					}
				}
				
				cnt++;
				
				
			}
			
			int result = case_stack.isEmpty() && cnt==0 ? 1 : 0;
			
			//출력
			System.out.printf("#%d %d\n",test_case,result);
			
		}
		
		br.close();
		
	}

}
