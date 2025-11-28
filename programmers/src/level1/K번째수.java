package level1;

import java.util.Arrays;

public class K번째수 {
    public static void main(String[] args) {
        System.out.println(new K번째수().solution(new int[]{1, 5, 2, 6, 3, 7, 4}, new int[][]{{2, 5, 3}, {4, 4, 1}, {1, 7, 3}})); // 5,6,3


    }

    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        for (int i = 0; i < commands.length; i++) {
            int[] cutted = Arrays.copyOfRange(array, commands[i][0] - 1, commands[i][1]);
            Arrays.sort(cutted);
            answer[i] = cutted[commands[i][2]-1];
        }
        return answer;
    }


}
/**
 *https://school.programmers.co.kr/learn/courses/30/lessons/42748
 *정확성  테스트
 * 테스트 1 〉	통과 (1.17ms, 73.1MB)
 * 테스트 2 〉	통과 (0.49ms, 78.3MB)
 * 테스트 3 〉	통과 (0.44ms, 78.6MB)
 * 테스트 4 〉	통과 (0.33ms, 73.8MB)
 * 테스트 5 〉	통과 (1.15ms, 78.9MB)
 * 테스트 6 〉	통과 (0.47ms, 75.9MB)
 * 테스트 7 〉	통과 (1.07ms, 88.6MB)
 * 채점 결과
 * 정확성: 100.0
 * 합계: 100.0 / 100.0
 */
