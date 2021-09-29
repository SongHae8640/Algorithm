package level1;

import java.util.ArrayList;
import java.util.List;

public class KthNumber {
    public static void main(String[] args) {
        solution(new int[] {1, 5, 2, 6, 3, 7, 4},new int[][] {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}} );	//[5, 6, 3]
    }

    public static int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];


        for (int i = 0; i < commands.length; i++) {
            List<Integer> list = new ArrayList();
            for (int j = commands[i][0]; j <= commands[i][1] ; j++) {
                list.add(array[j-1]);

            }
            list.sort( (a, b) -> a.compareTo( b ) );


            answer[i] = list.get(commands[i][2] -1);
        }

        return answer;
    }
}
/**
 * K번째 수
 * https://programmers.co.kr/learn/courses/30/lessons/42748
 *
 * 정확성  테스트
 * 테스트 1 〉	통과 (0.50ms, 72.4MB)
 * 테스트 2 〉	통과 (0.72ms, 76.2MB)
 * 테스트 3 〉	통과 (0.62ms, 72MB)
 * 테스트 4 〉	통과 (0.52ms, 73.3MB)
 * 테스트 5 〉	통과 (0.67ms, 72MB)
 * 테스트 6 〉	통과 (0.57ms, 74.1MB)
 * 테스트 7 〉	통과 (0.56ms, 72.5MB)
 * 채점 결과
 * 정확성: 100.0
 * 합계: 100.0 / 100.0
 * */

