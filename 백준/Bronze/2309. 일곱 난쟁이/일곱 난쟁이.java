import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		//키의 합이 100이 되는 조합을 찾는다
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		List<Integer> dwarfs = new LinkedList<>();
		int total = 0;
		for(int num = 1; num < 10; num++) {//9명
			int height = Integer.parseInt(br.readLine());
			dwarfs.add(height);
			total += height;
		}
		
		int cf = total - 100;
		out:for(int i = 0; i < 8; i++) {
			for(int j = i + 1; j < 9; j++) {
				if(cf == dwarfs.get(i) + dwarfs.get(j)) {
					dwarfs.remove(j);
					dwarfs.remove(i);
					break out; // 가능한 정답이 여러 개라면 아무거나 출력한다
				}
			}
		}
		
		Collections.sort(dwarfs);
		
		for(int height : dwarfs) {
			System.out.println(height);
		}
		
	}
}
