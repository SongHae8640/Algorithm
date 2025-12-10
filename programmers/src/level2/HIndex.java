package level2;

import java.util.Arrays;

public class HIndex {
    public static void main(String[] args) {
        System.out.println(new HIndex().solution(new int[]{3, 0, 6, 1, 5})); //3
        System.out.println(new HIndex().solution(new int[]{0, 0, 0})); //0
        System.out.println(new HIndex().solution(new int[]{10, 10, 10})); //3
        System.out.println(new HIndex().solution(new int[]{1, 1, 1})); //3
        System.out.println(new HIndex().solution(new int[]{1, 2, 3})); //2
    }
    public int solution(int[] citations) {
        Arrays.sort(citations);
        int answer = 0;
        for (int i = 0; i < citations.length; i++) {
            int citation = citations[i];
            int count = citations.length -i;
            answer = Math.max(answer, Math.min(citation, count));
        }
        return answer;
    }
}
/*
https://school.programmers.co.kr/learn/courses/30/lessons/42747
정확성  테스트
테스트 1 〉	통과 (0.56ms, 86.1MB)
테스트 2 〉	통과 (0.72ms, 86.8MB)
테스트 3 〉	통과 (0.64ms, 87.7MB)
테스트 4 〉	통과 (0.59ms, 76.1MB)
테스트 5 〉	통과 (0.69ms, 70.1MB)
테스트 6 〉	통과 (0.72ms, 85.7MB)
테스트 7 〉	통과 (0.46ms, 75.1MB)
테스트 8 〉	통과 (0.39ms, 79.6MB)
테스트 9 〉	통과 (0.39ms, 87.1MB)
테스트 10 〉	통과 (0.48ms, 78.2MB)
테스트 11 〉	통과 (0.96ms, 73.5MB)
테스트 12 〉	통과 (0.38ms, 73.6MB)
테스트 13 〉	통과 (0.66ms, 77.3MB)
테스트 14 〉	통과 (0.67ms, 82.9MB)
테스트 15 〉	통과 (0.68ms, 75.1MB)
테스트 16 〉	통과 (0.35ms, 88.2MB)
채점 결과
정확성: 100.0
합계: 100.0 / 100.0
 */
