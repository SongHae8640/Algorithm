package DfsBfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;

public class No2583FindArea2 {

	static int M, N, K;
	static boolean[][] area; 
	static ArrayList<Integer> areaCounts = new ArrayList<Integer>();
	static int tempAreaCount;
	
	static int[] dx = new int[] {1,-1,0,0};
	static int[] dy = new int[] {0,0,1,-1};
	
	public static void main(String[] args) throws IOException {
		
		//M, N, K입력
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		//테두리를 만들어서 dx dy에서 따로 체크를 안해도 되게 한다.
		area = new boolean [M+2][N+2];
		
		for (int i = 0; i < K; i++) {
			//직사각형 그리기
			st = new StringTokenizer(br.readLine());	
			drawRectangle(Integer.parseInt(st.nextToken())+1, Integer.parseInt(st.nextToken())+1, Integer.parseInt(st.nextToken())+1, Integer.parseInt(st.nextToken())+1);
		}
		
		//태두리 칠하기
		drawEdge();
		
		
		//영역 수 구하기
		for (int i = 0; i < area.length; i++) {
			for (int j = 0; j < area[i].length; j++) {
				//직사각형에 포함되어 있지 않을 때
				if(!area[i][j]) {
					tempAreaCount = 0;
					findArea(i, j);
					areaCounts.add(tempAreaCount);
				}
			}
		}
		
		
		//출력
		System.out.println(areaCounts.size());
		Collections.sort(areaCounts);
		for (int i = 0; i < areaCounts.size(); i++) {
			System.out.print(areaCounts.get(i) +" ");
		}

	}

	private static void drawEdge() {
		//위 아래 테두리 true로
		for(int j=0; j < area[0].length;j++) {
			area[0][j] = true;
			area[area.length-1][j] = true;
		}
		
		//좌 우 테두리 true로
		for(int i = 1 ; i < area.length-1 ; i++) {
			area[i][0] = true;
			area[i][area[0].length-1] = true;
		}
		
	}

	private static void findArea(int i, int j) {
		tempAreaCount++;
		area[i][j] = true;
		for(int d=0; d<4 ; d++) {
			if(!area[i+dx[d]][j+dy[d]]) {
				findArea(i+dx[d], j+dy[d]);
			}
		}
		
	}


	//직사각형이 있는곳 색칠 하기
	private static void drawRectangle(int y1, int x1, int y2, int x2) {
		for(int x = x1 ; x < x2 ; x++) {
			for(int y = y1 ; y < y2 ; y++) {
				area[x][y] = true;
			}
		}
		
	}

}

/*
 * 출처 : https://www.acmicpc.net/problem/2583
 * 기존 방법에서 area를 확장하여 isInXY 메서드를 사용하지 않게 함
 * 메모리 : 13264 KB -> 13456 KB, 시간 88ms -> 84ms 
 * 메모리는 오히려 늘고 시간은 약간 짧아짐
 * */
