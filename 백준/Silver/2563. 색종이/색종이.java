import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int[][] paper = new int[100][100];
		
		// 색종이를 한 장 또는 여러 장 붙인 후 색종이가 붙은 검은 영역의 넓이를 구하는 프로그램 작성
		// 첫째 줄에 색종이의 수가 주어진다
		int quantity = Integer.parseInt(br.readLine());
		
		// 색종이를 붙인 위치가 주어진다.
		// 색종이의 왼쪽 변과 도화지의 왼쪽 변 사이의 거리 | 색종이의 아래쪽 변과 도화지의 아래쪽 변 사이의 거리
		// 색종이의 수는 100이하임, 색종이가 도화지 밖으로 나가는 경우는 없음
		
		for(int q = 0; q < quantity; q++) { // 색종이의 수만큼 반복함
			StringTokenizer distance = new StringTokenizer(br.readLine());
			int distanceX = Integer.parseInt(distance.nextToken());
			int distanceY = Integer.parseInt(distance.nextToken());
			
			for(int r = 99 - distanceY; r >= 90 - distanceY; r--) {
				for(int c = distanceX; c < 10 + distanceX; c++) {
					paper[r][c]++;
				}
			}
		}
		
		int count = 0;
		for(int r = 0; r < 100; r++) {
			for(int c = 0; c < 100; c++) {
				if(paper[r][c] == 0) continue;
				count++;
			}
		}
		
		System.out.println(count);
	}

}
