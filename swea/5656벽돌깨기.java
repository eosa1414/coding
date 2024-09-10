
import java.util.*;
import java.io.*;

class Solution
{
    // 구슬로 벽돌을 깨는 게임
    // 구슬은 N번만 쏠 수 있다
    // 가로 W, 세로 H의 공간에서 0은 빈 칸, 그외의 숫자는 벽돌을 의미한다
    // 구슬은 좌우로만 움직일 수 있고, 항상 맨 위의 벽돌을 깨트린다
    // 벽돌은 숫자 1~9로 표현되며, 구슬이 명중한 벽돌은 상하좌우로 (벽돌에 적힌 숫자 - 1) 칸 만큼 같이 제거된다
    // (즉, 2~부터는 十자 모양으로 제거된다)
    // ㄴ연쇄적으로 제거된다
    // 빈 공간이 생기면 벽돌은 밑으로 떨어진다
    // N개의 벽돌을 떨어트려 최대한 많은 벽돌을 제거하고자 한다
    // 남은 벽돌의 개수를 구하라

    // W의 공간에서 순서가 있게 원하는 개수 N을 뽑음
    // ->즉, 순열

    // 고른 것에 따라 벽돌을 부수고(Queue?) -> 벽돌을 내려주고 부수고 내려주고를 N번만큼 반복함

    // 가장 많이 부숴져서, 남은 벽돌의 개수가 적은(min) 것을 최종 출력
	static int N, W, H;
	static int[][] brick, newBrick;
	static boolean[][] breaking;
	
	static boolean[] visited;
	static int[] select;
	
	//상하좌우
	static final int[] DR = {-1,1,0,0};
	static final int[] DC = {0,0,-1,1};
	
	static int cnt, min;
	
	public static void main(String args[]) throws Exception
	{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
		int T = Integer.parseInt(br.readLine());

		for(int test_case = 1; test_case <= T; test_case++)
		{
			st =  new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            W = Integer.parseInt(st.nextToken());
            H = Integer.parseInt(st.nextToken());
            
            cnt = 0;
            brick = new int[H][W];
            for(int r = 0; r < H; r++){
                st =  new StringTokenizer(br.readLine());
                for(int c = 0; c < W; c++){
                	int b = Integer.parseInt(st.nextToken());
                    brick[r][c] = b;
                    if(b > 0) cnt++;
            	}
            }
            
            visited = new boolean[W];
            select = new int[N];
            
            min = Integer.MAX_VALUE;
            
            중복순열(0);
      
            System.out.printf("#%d %d\n",test_case,min);
            
            
            
		
		}
        br.close();
	}
	
	static void 중복순열(int idx) {
		if(idx == N) {
			play();
			return;
		}
		
		for(int i = 0; i < W; i++) {
				select[idx] = i;
				중복순열(idx + 1);
		}
	}
	
	static void play() {
		
		int count = cnt;
		
		newBrick = new int[H][];
		for(int r = 0; r < H; r++) {
			newBrick[r] = Arrays.copyOf(brick[r],brick[r].length);
		}
		
		for(int i = 0; i < N; i++) {

			breaking = new boolean[H][W];
			
			int c = select[i];
			int r = 0;
			while (newBrick[r][c] == 0) {
				if(r == H - 1) {
					break;
				}
				r++;
			}
      
			breaking[r][c] = true;
			
			if(newBrick[r][c] > 1) {
				breakbrick(r,c);				
			}
			
			
			int j; 
			
			//breaking표시된 것들을 부숴야 한다
			for(int cc = 0; cc < W; cc++) {
				j = H - 1;
				for(int rr = H - 1; rr >= 0; rr--) {
					if(!breaking[rr][cc]) {
						newBrick[j--][cc] = newBrick[rr][cc];
					}else if(newBrick[rr][cc] != 0){
						count--;
					}
				}
				while(j >= 0) {
					newBrick[j--][cc] = 0;
				}
			}
			
			if(count == 0) break;
		}
		
		if(count < min) {
			min = count;
		}
		
		if(count == 0) return;
		
		
	}
	
	static void breakbrick(int r, int c) {
		for(int d = 0; d < 4; d++) {//상하좌우
			for(int i = 1; i < newBrick[r][c]; i++) {
				int nr = r + DR[d] * i;
				int nc = c + DC[d] * i;
				if(nr < 0 || nr >= H || nc < 0 || nc >= W || newBrick[nr][nc] == 0 || breaking[nr][nc]) continue;
				
				breaking[nr][nc] = true;
				if(newBrick[nr][nc] > 1) {
					breakbrick(nr,nc);
				}
			}
		}
	}
}
