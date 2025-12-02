package level3;

import java.util.HashSet;
import java.util.Set;

public class N으로표현 {
    public static void main(String[] args) {
        System.out.println(new N으로표현().solution(5, 12 )); // 4
        System.out.println(new N으로표현().solution(2, 11 )); // 3
    }

    public int solution(int N, int number) {
        if(N == number) {
            return 1;
        }

        Set<Integer>[] dp = new HashSet[9];
        for (int i = 1; i < dp.length; i++) {
            dp[i] = new HashSet<>();
            dp[i].add(Integer.valueOf(String.valueOf(N).repeat(i)));

            for (int j = 1; j < i; j++) {
                int k = i - j;

                for (int a : dp[j]){
                    for(int b : dp[k]){
                        dp[i].add(a + b);
                        dp[i].add(a - b);
                        dp[i].add(a * b);
                        if(b != 0) dp[i].add(a / b);
                    }
                }

            }

            if(dp[i].contains(number)){
                return i;
            }
        }

        return -1;
    }
}
/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/42895
 * 정확성  테스트
 * 테스트 1 〉	통과 (1.98ms, 82.4MB)
 * 테스트 2 〉	통과 (0.13ms, 90.5MB)
 * 테스트 3 〉	통과 (0.12ms, 67.8MB)
 * 테스트 4 〉	통과 (19.27ms, 96.1MB)
 * 테스트 5 〉	통과 (15.34ms, 85.7MB)
 * 테스트 6 〉	통과 (0.71ms, 73.7MB)
 * 테스트 7 〉	통과 (0.98ms, 71.5MB)
 * 테스트 8 〉	통과 (27.70ms, 90.7MB)
 * 테스트 9 〉	통과 (0.02ms, 82MB)
 * 채점 결과
 * 정확성: 100.0
 * 합계: 100.0 / 100.0
 *
 * TODO 다시 풀어볼것.
 */
