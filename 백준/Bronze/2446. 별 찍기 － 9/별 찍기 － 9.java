import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	public static void main(String[] args) {
	
		try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in));){
			
		int line = Integer.parseInt(br.readLine());
		
		for(int i = 2 * line - 1; i > 2; i -= 2) {
			System.out.print(" ".repeat((line*2 - i)/2));
			System.out.print("*".repeat(i));
			System.out.println();
		}
		for(int i = 1; i < 2 * line; i += 2) {
			System.out.print(" ".repeat((line*2 - i)/2));
			System.out.print("*".repeat(i));
			System.out.println();
		}
		
		}catch(NumberFormatException | IOException e) {
			System.out.println("예외 발생. 입력값이 잘못되었습니다.");
		}
		
	}
}