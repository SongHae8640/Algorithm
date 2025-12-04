package level3;

import java.util.Arrays;

public class 입국심사 {
    public static void main(String[] args) {
        System.out.println(new 입국심사().solution(6, new int []{7,10})); //28
    }

    public long solution(int n, int[] times) {
        long maxTime = (long) n * Arrays.stream(times).max().getAsInt();
        long minTime = 1;

        long midTIme = 0;
        while (minTime <= maxTime){
            midTIme = (maxTime + minTime) / 2;
            long inspectionCount = geInspectionCount(midTIme, times);
            if(n <= inspectionCount){
                maxTime = midTIme -1;
            }else {
                minTime = midTIme + 1;
            }

        }
        return minTime;
    }

    public long geInspectionCount(long midTIme, int[] times){
        long count = 0;
        for(int time : times){
           count += midTIme / time;
        }
        return count;
    }
}
/**
 *
 *https://school.programmers.co.kr/learn/courses/30/lessons/43238
 * 정확성  테스트
 * 테스트 1 〉	통과 (1.38ms, 87.3MB)
 * 테스트 2 〉	통과 (1.46ms, 75.4MB)
 * 테스트 3 〉	통과 (2.07ms, 82.2MB)
 * 테스트 4 〉	통과 (43.35ms, 92.3MB)
 * 테스트 5 〉	통과 (47.88ms, 103MB)
 * 테스트 6 〉	통과 (39.73ms, 84.4MB)
 * 테스트 7 〉	통과 (54.36ms, 101MB)
 * 테스트 8 〉	통과 (51.68ms, 86.9MB)
 * 테스트 9 〉	통과 (0.73ms, 81.8MB)
 * 채점 결과
 * 정확성: 100.0
 * 합계: 100.0 / 100.0
 *
 * TODO 다시 풀어볼것
 */
