import java.awt.Point;
import java.io.*;
import java.util.*;

/**주어진 미로의 출발점으로부터 도착지점까지 갈 수 있는 길이 있는지 판단하는 프로그램 작성*/
public class Solution {
	
	static int size;
	static int[][] labyrinth;
	static boolean[][] visited;
	static int startR = 0, startC = 0, endR = 0, endC = 0;
	
	//상하좌우
	static final int[] DR = {-1,1,0,0};
	static final int[] DC = {0,0,-1,1};
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = 10;
		
		for(int t = 1; t <= T; t++) {
			int tc = Integer.parseInt(br.readLine());
			
			//초기화
			size = 16;
			labyrinth = new int[size][size];
			
			for(int r = 0; r < size; r++) {
				String line = br.readLine();
				for(int c = 0; c < size; c++) {
					labyrinth[r][c] = line.charAt(c) - '0';
					if(labyrinth[r][c] == 2) {//출발점
						startR = r;
						startC = c;
					}else if(labyrinth[r][c] == 3) {//도착점
						endR = r;
						endC = c;
					}
				}
			}
			
			//확인용
//			System.out.println(Arrays.deepToString(labyrinth));
//			System.out.println(startR+" "+startC+" "+endR+" "+endC);
			
			visited = new boolean[size][size];

			Queue<Point> queue = new LinkedList<>();
			
			//시작점 넣기
			queue.add(new Point(startR, startC));
			visited[startR][startC] = true;

			boolean possible = false;
			
			while(!queue.isEmpty() && !possible) {//전부 탐색할 때까지, 아직 찾지 못했을 때까지
				Point p = queue.poll();
				
				for(int d = 0; d < 4; d++) {
					int nr = p.x + DR[d];
					int nc = p.y + DC[d];
					//흰색 바탕(0)은 길, 노란 바탕(1)은 벽
					if(nr < 0 || nr >= size || nc < 0 || nc >= size || labyrinth[nr][nc] == 1 || visited[nr][nc]) continue;
					queue.add(new Point(nr, nc));
					visited[nr][nc] = true;
					if(labyrinth[nr][nc] == 3) {
						possible = true;
						break;
					}
				}
				
			}
			
			int result = possible ? 1 : 0;
			
			//가능하면 1, 불가능하면 0 출력
			System.out.printf("#%d %d\n",tc,result);
		}
		
		br.close();
	}
}
