package DfsBfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class No3830ProfessorNotWaiting {

	static BufferedReader br;
	static StringTokenizer st;
	static int[][] weightDiffs;
	static int weightDiff;
	static boolean[][] isWeightDiffs;
	static boolean isFindAns;
	
	public static void main(String[] args) throws IOException {
		br = new BufferedReader(new InputStreamReader(System.in));
		
		while(true) {
			st = new StringTokenizer(br.readLine());
			
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			if(N == 0 && M == 0) {
				break;
			} 
			
			work(N , M);
			
		}
		

	}
	private static void work(int N, int M) throws IOException {
		
		weightDiffs = new int[N+1][N+1];
		isWeightDiffs = new boolean[N+1][N+1];
		int a, b, w;
		boolean isQuestion;
		for (int workCount = 0; workCount < M; workCount++) {
			st = new StringTokenizer(br.readLine());
			isQuestion = st.nextToken().equals("?");
			a = Integer.parseInt(st.nextToken());
			b = Integer.parseInt(st.nextToken());
			
			//교수님 질문일때 > 계산
			if(isQuestion) {
				isFindAns = false;
				weightDiff =0;
				findDiff(a,b,0);
				
				if(isFindAns) System.out.println(weightDiff);
				else System.out.println("UNKNOWN");
			}
			
			//학생 측정일때 > 차이 입력
			else {
				w = Integer.parseInt(st.nextToken());
				weightDiffs[a][b] = w;
				weightDiffs[b][a] = -w;
				isWeightDiffs[a][b] = isWeightDiffs[b][a] = true;
			}
			
		}
	}
	
	//현재 지점(a)에서 목표 지점(b)으로 가는데 걸리는 거리 라고 생각 
	private static void findDiff(int a, int b, int diff) {
		if(a==b) {
			isFindAns = true;
			weightDiff = diff;
		}else {
			if(isFindAns) return;
			for (int i = 0; i < isWeightDiffs.length; i++) {
				if(isWeightDiffs[a][i]) {
					diff+=weightDiffs[a][i];
					isWeightDiffs[a][i] = false;
					findDiff(i, b, diff);
					diff-=weightDiffs[a][i];
					isWeightDiffs[a][i] = true;
				}
			}
		}
		
	}

}

/*
 * 출처 : https://www.acmicpc.net/problem/3830
 * dfs를 통해서 하니 시간 초과 됨. 요즘  dfs 만 써서 문제 사고 회로가 dfs로 갖힌듯
 * UNKNOWN 의 경우 dfs의 깊이가 굉장이 깊어지고 그과정도 많기 때문에 이런것 같다
 * 새로운 방법을 알아내야 겠다
 * */

