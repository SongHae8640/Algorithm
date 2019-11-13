package level2;

import java.util.HashMap;
import java.util.HashSet;

public class NumberBaseball2 {

	public static void main(String[] args) {
		solution(new int[][] {{123, 1, 1}, {356, 1, 0}, {327, 2, 0}, {489, 0, 1}});

	}
	
	public static int solution(int[][] baseball) {
		int answer = 0;
		for (int i = 111; i < 999; i++) {
			if(i%10 !=0) {
				boolean isPossible = true;
				for (int j = 0; j < baseball.length; j++) {
					isPossible &=checkRight(baseball[i] , j);
				}
				
				if(isPossible) answer++;
			}
		}
		
		return answer;
    }

	private static boolean checkRight(int[] is , int j) {
		int computeNum = is[0];
		
		return false;
	}

}
