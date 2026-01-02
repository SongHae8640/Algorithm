package level1;

public class 자릿수더하기 {

    public static void main(String[] args) {
        자릿수더하기 t = new 자릿수더하기();
        System.out.println(t.solution(123)); // 6
        System.out.println(t.solution(987)); // 24
    }

    public int solution(int n) {
        int answer = 0;

        while(n > 0){
            answer += n%10;
            n /=10;
        }

        return answer;
    }



}
/*
https://school.programmers.co.kr/learn/courses/30/lessons/12931

정확성  테스트
테스트 1 〉	통과 (0.01ms, 80.9MB)
테스트 2 〉	통과 (0.01ms, 77.1MB)
테스트 3 〉	통과 (0.03ms, 80.7MB)
테스트 4 〉	통과 (0.01ms, 90.3MB)
테스트 5 〉	통과 (0.02ms, 78.2MB)
테스트 6 〉	통과 (0.02ms, 87.3MB)
테스트 7 〉	통과 (0.02ms, 79.4MB)
테스트 8 〉	통과 (0.01ms, 74.6MB)
테스트 9 〉	통과 (0.02ms, 82.7MB)
테스트 10 〉	통과 (0.01ms, 84.3MB)
테스트 11 〉	통과 (0.01ms, 73.4MB)
테스트 12 〉	통과 (0.01ms, 75.7MB)
테스트 13 〉	통과 (0.01ms, 80MB)
테스트 14 〉	통과 (0.01ms, 86.6MB)
테스트 15 〉	통과 (0.02ms, 91.6MB)
테스트 16 〉	통과 (0.02ms, 86.4MB)
테스트 17 〉	통과 (0.02ms, 78.5MB)
테스트 18 〉	통과 (0.01ms, 90.6MB)
테스트 19 〉	통과 (0.02ms, 83.4MB)
테스트 20 〉	통과 (0.01ms, 76.7MB)
테스트 21 〉	통과 (0.01ms, 82.2MB)
채점 결과
정확성: 100.0
합계: 100.0 / 100.0
 */
