package level2;

import java.util.Arrays;

public class KthNumber {

	public static void main(String[] args) {
		System.out.println(solution(new int[] {1, 5, 2, 6, 3, 7, 4}, new int[][] {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}}));

	}
	
	public static int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];	//commands의 행의 길이 만큼 answer를 만들어 준다
        for (int commandsIdx = 0; commandsIdx < commands.length; commandsIdx++) {	//command의 한 행 씩 꺼낸다
        	//array를 i(commands[commandsIdx][0])번째 부터 j(commands[commandsIdx][1])번째 숫자까지 자른다
        	//Arrays.copyOfRange(original, from, to)
			int[] cuttedArray = Arrays.copyOfRange(array, commands[commandsIdx][0]-1, commands[commandsIdx][1]);
			Arrays.sort(cuttedArray);	//오름차순 정렬
        	answer[commandsIdx] = cuttedArray[commands[commandsIdx][2]-1];	//k(commands[commandsIdx][2])번째 수를 answer에 저장
		}
        return answer;
    }

}
