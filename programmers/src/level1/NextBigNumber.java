package level1;

public class NextBigNumber {

    public int solution(int n) {
        // 조건 1. n보다 큰 자연수
        int answer = n+1;

        int nOneCount = getBinaryOneCount(n);

        // 조건 2. 2진수로 변환했을때 1의 갯수가 같다
        // 조건 3. 조건1,2중 가장 작은 수
        while (nOneCount != getBinaryOneCount(answer)){
            answer++;
        }

        return answer;
    }

    // 2진수 일때 1의 갯수를 구함
    private int getBinaryOneCount(int n) {
        int oneCount = 0;

        while (n != 0){
            oneCount += n%2;
            n /= 2;
        }

        return oneCount;
    }


}

/**
 *
 * 다음 큰 숫자
 * https://school.programmers.co.kr/courses/13207/lessons/90303
 *
 * 정확성  테스트
 * 테스트 1 〉	통과 (0.01ms, 74.4MB)
 * 테스트 2 〉	통과 (0.02ms, 74.3MB)
 * 테스트 3 〉	통과 (0.02ms, 73.8MB)
 * 테스트 4 〉	통과 (0.02ms, 77.4MB)
 * 테스트 5 〉	통과 (0.01ms, 74.7MB)
 * 테스트 6 〉	통과 (0.02ms, 78.9MB)
 * 테스트 7 〉	통과 (0.02ms, 77.2MB)
 * 테스트 8 〉	통과 (0.03ms, 74.8MB)
 * 테스트 9 〉	통과 (0.02ms, 75MB)
 * 테스트 10 〉	통과 (0.02ms, 77.1MB)
 * 테스트 11 〉	통과 (0.02ms, 76.7MB)
 * 테스트 12 〉	통과 (0.01ms, 79.1MB)
 * 테스트 13 〉	통과 (0.02ms, 74.3MB)
 * 테스트 14 〉	통과 (0.02ms, 81.1MB)
 * 효율성  테스트
 * 테스트 1 〉	통과 (0.02ms, 67.4MB)
 * 테스트 2 〉	통과 (0.01ms, 52.3MB)
 * 테스트 3 〉	통과 (0.02ms, 52.5MB)
 * 테스트 4 〉	통과 (0.02ms, 52MB)
 * 테스트 5 〉	통과 (0.03ms, 52.4MB)
 * 테스트 6 〉	통과 (0.02ms, 52MB)
 * 채점 결과
 * 정확성: 70.0
 * 효율성: 30.0
 * 합계: 100.0 / 100.0
 *
 * */
