package level2;

import java.util.Arrays;

public class 구명보트 {

    public static void main(String[] args) {
        구명보트 t = new 구명보트();
        System.out.println(t.solution(new int[] {70, 50, 80, 50}, 100)); // 3
        System.out.println(t.solution(new int[] {70, 80, 50}, 100)); // 3
    }

    public int solution(int[] people, int limit) {
        Arrays.sort(people);
        int maxIndex = people.length - 1;
        int minIndex = 0;
        int answer = 0;
        while(maxIndex>=minIndex){
            if(people[maxIndex] + people[minIndex] <= limit){
                minIndex++;
            }
            maxIndex--;
            answer++;
        }

        return answer;
    }



}
/*
https://school.programmers.co.kr/learn/courses/30/lessons/42885

정확성  테스트
테스트 1 〉	통과 (1.30ms, 94.7MB)
테스트 2 〉	통과 (0.89ms, 90.3MB)
테스트 3 〉	통과 (1.14ms, 90.2MB)
테스트 4 〉	통과 (1.18ms, 91.5MB)
테스트 5 〉	통과 (1.26ms, 88.1MB)
테스트 6 〉	통과 (0.61ms, 88.2MB)
테스트 7 〉	통과 (0.71ms, 87.8MB)
테스트 8 〉	통과 (0.47ms, 72.4MB)
테스트 9 〉	통과 (0.54ms, 89.3MB)
테스트 10 〉	통과 (1.06ms, 74MB)
테스트 11 〉	통과 (1.11ms, 86.2MB)
테스트 12 〉	통과 (0.96ms, 86.8MB)
테스트 13 〉	통과 (1.04ms, 76.2MB)
테스트 14 〉	통과 (0.88ms, 90.7MB)
테스트 15 〉	통과 (0.41ms, 71.5MB)
테스트 16 〉	통과 (0.37ms, 85.2MB)
테스트 17 〉	통과 (0.50ms, 88.5MB)
테스트 18 〉	통과 (0.34ms, 77.6MB)
테스트 19 〉	통과 (0.40ms, 79MB)
테스트 20 〉	통과 (0.55ms, 87.7MB)
테스트 21 〉	통과 (0.36ms, 70.5MB)
테스트 22 〉	통과 (0.34ms, 87.8MB)
효율성  테스트
테스트 1 〉	통과 (11.09ms, 57.4MB)
테스트 2 〉	통과 (9.78ms, 57.7MB)
테스트 3 〉	통과 (10.12ms, 56.6MB)
테스트 4 〉	통과 (7.95ms, 55.9MB)
테스트 5 〉	통과 (9.63ms, 55.7MB)
채점 결과
정확성: 81.5
효율성: 18.5
합계: 100.0 / 100.0
 */
