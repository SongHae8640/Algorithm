package level1;

import java.util.Arrays;

public class KthNumber {
    public static void main(String[] args) {
        solution(new int[] {1, 5, 2, 6, 3, 7, 4},new int[][] {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}} );	//[5, 6, 3]
    }

    public static int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];


        for (int i = 0; i < commands.length; i++) {
            int[] cutArray = Arrays.copyOfRange(array, commands[i][0]-1, commands[i][1]);
            Arrays.sort(cutArray);
            answer[i] = cutArray[commands[i][2] -1];
        }

        return answer;
    }
}
/**
 * K번째 수
 * https://programmers.co.kr/learn/courses/30/lessons/42748
 *
 * 정확성  테스트
 * 테스트 1 〉	통과 (0.50ms, 73.1MB)
 * 테스트 2 〉	통과 (0.32ms, 73.1MB)
 * 테스트 3 〉	통과 (0.43ms, 75.8MB)
 * 테스트 4 〉	통과 (0.34ms, 71.9MB)
 * 테스트 5 〉	통과 (0.50ms, 75.9MB)
 * 테스트 6 〉	통과 (0.32ms, 75.4MB)
 * 테스트 7 〉	통과 (0.35ms, 70.8MB)
 * 채점 결과
 * 정확성: 100.0
 * 합계: 100.0 / 100.0
 * */

