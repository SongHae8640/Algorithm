package level1;

public class ShahadNumber {

    boolean solution(int x) {

        int digitSum = 0;
        int xDividedByTen = x;

        while(xDividedByTen != 0){
            digitSum += xDividedByTen % 10;
            xDividedByTen /=10;

        }


        //각 자릿수의 합이 입력 값으로 나누어지는지 확인
        return (x % digitSum) == 0;
    }

}

/**
 *
 * 샤하드 수
 * https://school.programmers.co.kr/courses/13207/lessons/90302
 *
 * 정확성  테스트
 * 테스트 1 〉	통과 (0.02ms, 74.9MB)
 * 테스트 2 〉	통과 (0.02ms, 70.4MB)
 * 테스트 3 〉	통과 (0.02ms, 75.8MB)
 * 테스트 4 〉	통과 (0.02ms, 77.1MB)
 * 테스트 5 〉	통과 (0.03ms, 69.5MB)
 * 테스트 6 〉	통과 (0.03ms, 72.5MB)
 * 테스트 7 〉	통과 (0.02ms, 74.9MB)
 * 테스트 8 〉	통과 (0.03ms, 74.8MB)
 * 테스트 9 〉	통과 (0.02ms, 79MB)
 * 테스트 10 〉	통과 (0.02ms, 75.3MB)
 * 테스트 11 〉	통과 (0.02ms, 71.3MB)
 * 테스트 12 〉	통과 (0.02ms, 73.8MB)
 * 테스트 13 〉	통과 (0.03ms, 72.6MB)
 * 테스트 14 〉	통과 (0.02ms, 76.5MB)
 * 테스트 15 〉	통과 (0.01ms, 69.3MB)
 * 테스트 16 〉	통과 (0.02ms, 74.6MB)
 * 테스트 17 〉	통과 (0.02ms, 72.3MB)
 * 채점 결과
 * 정확성: 100.0
 * 합계: 100.0 / 100.0
 * */
