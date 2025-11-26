package level1;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class 같은숫자는싫어 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new 같은숫자는싫어().solution(new int[] {1,1,3,3,0,1,1})));
        System.out.println(Arrays.toString(new 같은숫자는싫어().solution(new int[] {4,4,4,3,3})));

    }

    public int[] solution(int []arr) {
        Queue<Integer> queue = new LinkedList<>();
        int prevNum = -1;
        for(int i : arr){
            if(i != prevNum){
                queue.add(i);
                prevNum = i;
            }
        }
        return queue.stream().mapToInt(Integer::intValue).toArray();
    }
}
/**
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/12906?language=java
 *
 * 정확성  테스트
 * 테스트 1 〉	통과 (1.97ms, 72MB)
 * 테스트 2 〉	통과 (2.04ms, 78.2MB)
 * 테스트 3 〉	통과 (2.02ms, 70.9MB)
 * 테스트 4 〉	통과 (2.69ms, 86MB)
 * 테스트 5 〉	통과 (2.89ms, 78.5MB)
 * 테스트 6 〉	통과 (2.54ms, 83.9MB)
 * 테스트 7 〉	통과 (2.80ms, 78.2MB)
 * 테스트 8 〉	통과 (4.95ms, 87MB)
 * 테스트 9 〉	통과 (2.31ms, 91.7MB)
 * 테스트 10 〉	통과 (2.88ms, 80.4MB)
 * 테스트 11 〉	통과 (2.94ms, 78.4MB)
 * 테스트 12 〉	통과 (2.14ms, 77MB)
 * 테스트 13 〉	통과 (2.33ms, 87MB)
 * 테스트 14 〉	통과 (2.73ms, 85.7MB)
 * 테스트 15 〉	통과 (1.90ms, 82.1MB)
 * 테스트 16 〉	통과 (1.98ms, 69MB)
 * 테스트 17 〉	통과 (1.92ms, 86.7MB)
 * 효율성  테스트
 * 테스트 1 〉	통과 (31.17ms, 114MB)
 * 테스트 2 〉	통과 (34.25ms, 114MB)
 * 테스트 3 〉	통과 (33.77ms, 114MB)
 * 테스트 4 〉	통과 (34.71ms, 114MB)
 * 채점 결과
 * 정확성: 71.9
 * 효율성: 28.1
 * 합계: 100.0 / 100.0
 */
