import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

//새로이 알게 된 점
//1) 재귀에서 확인을 할 때 새로 복사한 배열을 만들 필요 없이, tmp에 저장해둔 다음, 다음 검사를 위해 되돌려주기만 하면 된다.
//2) 좌표를 위해서 Point 클래스를 사용할 수 있다.

public class Solution{
	
	static int N, K;
	static int[][] map;
	static boolean[][] visited;
	//상하좌우
	static final int[] dx = {-1,1,0,0};
	static final int[] dy = {0,0,-1,1};
	
	static int ans;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int T = Integer.parseInt(br.readLine());
		StringTokenizer st;
		
		// 등산로를 위한 N * N 크기의 부지에 긴 등산로를 만들 계획.
		// 등산로를 만드는 규칙
		// 1) 등산로는 가장 높은 봉우리에서 시작해야 함
		// 2) 등산로는 산으로 올라갈 수 있도록 반드시 높은 지형에서 낮은 지형으로,
		//	  또는 가로 또는 세로 방향으로 연결돼 있어야 한다.
		//	  ->높이가 같거나 작은 지형 및 대각선 방향의 연결은 불가능
		// 3) 긴 등산로를 만들기 위해 딱 한 곳을 최대 K 깊이만큼 깎는 공사를 할 수 있다.
		
		for(int t = 1; t <= T; t++) {
			st = new StringTokenizer(br.readLine());
			
			N = Integer.parseInt(st.nextToken()); //지도 한 변의 길이
			K = Integer.parseInt(st.nextToken()); //최대 공사 가능 깊이
			
			map = new int[N][N];
			int maxHigh = 0;
			for(int x = 0; x < N; x++) {
				st = new StringTokenizer(br.readLine());
				for(int y = 0; y < N; y++) {
					//각 숫자는 지형의 높이를 뜻한다.
					int high = Integer.parseInt(st.nextToken());
					map[x][y] = high;
					maxHigh = Math.max(maxHigh, high);
				}
			}
			
			List<Point> highestRC = new ArrayList<>();
			for(int x = 0; x < N; x++) {
				for(int y = 0; y < N; y++) {
					if(map[x][y] != maxHigh) continue;
					highestRC.add(new Point(x,y));
				}
			}
			
			ans = 0;
			for(int i = 0; i < highestRC.size(); i++) {
				int x = highestRC.get(i).x;
				int y = highestRC.get(i).y;
				visited = new boolean[N][N];
				DFS(x,y,1,false);
			}
			
			//만들 수 있는 가장 긴 등산로를 찾아서 그 길이를 출력.
			System.out.printf("#%d %s\n",t,ans);
		}
		br.close();
	}
	
	static void DFS(int x, int y, int length, boolean use) {
		
		if(ans < length) ans = length;
		
		visited[x][y] = true;
		
		for(int d = 0; d < 4; d++) {
			int nx = x + dx[d];
			int ny = y + dy[d];
			
			if(nx < 0 || nx >= N || ny < 0 || ny >= N || visited[nx][ny] || (map[nx][ny] >= map[x][y] && use)) {
				continue;
			}
			if(map[nx][ny] >= map[x][y] && !use) {//아직 사용하지 않았음
				if(map[nx][ny] - map[x][y] < K) {
					int tmp = map[nx][ny];
					map[nx][ny] = map[x][y] - 1;
					DFS(nx,ny,length + 1, true);
					map[nx][ny] = tmp;					
				}
			}else {//문제없이 이동 가능한 경우
				DFS(nx,ny,length + 1,use);
			}
		}
		
		visited[x][y] = false;
		
	}
}
