package level2;

public class 큰수만들기 {
    public static void main(String[] args) {
        System.out.println(new 큰수만들기().solution3("1924", 2)); // 94
        System.out.println(new 큰수만들기().solution3("1231234", 3)); // 3234
        System.out.println(new 큰수만들기().solution3("4177252841", 4)); // 775841
        System.out.println(new 큰수만들기().solution3("54321", 2)); // 543


    }

    public String solution(String number, int k) {
        String answer = "";
        while (k > 0){
            String subStr = number.substring(0,k+1);
            char max = getMaxChar(subStr);
            int i = subStr.indexOf(max);
            k = k - i;
            answer = answer + max;
            number = number.substring(i+1, number.length());
        }

        return answer+number;
    }

    public String solution2(String number, int k) {
        String answer = "";
        int targetLength = number.length() - k;
        while (answer.length() != targetLength){
            String subStr = number.substring(0,k+1);
            char max = getMaxChar(subStr);
            int i = subStr.indexOf(max);
            k = k - i;
            answer = answer + max;
            number = number.substring(i+1);
        }

        return answer;
    }

    public String solution3(String number, int k) {
        StringBuilder answer = new StringBuilder();
        int targetLength = number.length() - k;
        while (answer.length() != targetLength){
            String subStr = number.substring(0,k+1);
            char max = getMaxChar(subStr);
            int i = subStr.indexOf(max);
            k = k - i;
            answer.append(max);
            number = number.substring(i+1);
        }

        return answer.toString();
    }

    public char getMaxChar(String str){
        char[] charArray = str.toCharArray();
        char max = charArray[0];
        for (int i = 1; i < charArray.length; i++) {
            if(max < charArray[i]){
                max= charArray[i];
            }
        }
        return max;
    }


}
/**
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/42883
 * 
 *  solution
 * 정확성  테스트
 * 테스트 1 〉	통과 (11.35ms, 75.8MB)
 * 테스트 2 〉	통과 (12.14ms, 93.6MB)
 * 테스트 3 〉	통과 (10.57ms, 73.9MB)
 * 테스트 4 〉	통과 (12.06ms, 88.7MB)
 * 테스트 5 〉	통과 (12.94ms, 71.1MB)
 * 테스트 6 〉	통과 (41.47ms, 104MB)
 * 테스트 7 〉	통과 (92.06ms, 141MB)
 * 테스트 8 〉	통과 (438.71ms, 395MB)
 * 테스트 9 〉	통과 (30.23ms, 95.5MB)
 * 테스트 10 〉	통과 (5916.76ms, 499MB)
 * 테스트 11 〉	통과 (11.66ms, 90.7MB)
 * 테스트 12 〉	실패 (런타임 에러)
 * 채점 결과
 * 정확성: 91.7
 * 합계: 91.7 / 100.0
 *
 *
 * solution2
 * 정확성  테스트
 * 테스트 1 〉	통과 (8.62ms, 87.3MB)
 * 테스트 2 〉	통과 (8.76ms, 84.6MB)
 * 테스트 3 〉	통과 (13.17ms, 90.7MB)
 * 테스트 4 〉	통과 (14.76ms, 76MB)
 * 테스트 5 〉	통과 (14.89ms, 88.1MB)
 * 테스트 6 〉	통과 (45.95ms, 98.1MB)
 * 테스트 7 〉	통과 (385.10ms, 377MB)
 * 테스트 8 〉	통과 (891.87ms, 386MB)
 * 테스트 9 〉	실패 (시간 초과)
 * 테스트 10 〉	실패 (시간 초과)
 * 테스트 11 〉	통과 (9.75ms, 90.1MB)
 * 테스트 12 〉	통과 (8.60ms, 74.7MB)
 * 채점 결과
 * 정확성: 83.3
 * 합계: 83.3 / 100.0
 *
 *
 * solution3
 * 정확성  테스트
 * 테스트 1 〉	통과 (0.05ms, 83.3MB)
 * 테스트 2 〉	통과 (0.07ms, 69.9MB)
 * 테스트 3 〉	통과 (0.16ms, 73.8MB)
 * 테스트 4 〉	통과 (0.58ms, 81MB)
 * 테스트 5 〉	통과 (0.71ms, 70.8MB)
 * 테스트 6 〉	통과 (22.21ms, 108MB)
 * 테스트 7 〉	통과 (254.80ms, 379MB)
 * 테스트 8 〉	통과 (489.32ms, 380MB)
 * 테스트 9 〉	통과 (6983.40ms, 387MB)
 * 테스트 10 〉	통과 (7138.77ms, 495MB)
 * 테스트 11 〉	통과 (0.04ms, 80.6MB)
 * 테스트 12 〉	통과 (0.06ms, 86.1MB)
 * 채점 결과
 * 정확성: 100.0
 * 합계: 100.0 / 100.0
 */