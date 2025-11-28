package level2;

import java.util.Arrays;

public class 가장큰수 {
    public static void main(String[] args) {
        System.out.println(new 가장큰수().solution2(new int[]{6, 10, 2})); // 6210
        System.out.println(new 가장큰수().solution2(new int[]{3, 30, 34, 5, 9})); // 9534330
        System.out.println(new 가장큰수().solution2(new int[]{0,0,0})); // 0
    }

    public String solution2(int[] numbers) {
        String[] strNumbers = new String[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            strNumbers[i] = String.valueOf(numbers[i]);
        }
        Arrays.sort(strNumbers, (a, b) -> (b+a).compareTo(a+b));

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < strNumbers.length; i++) {
            sb.append(strNumbers[i]);
        }

        String result = sb.toString();
        if(result.charAt(0) == '0'){
            return "0";
        }

        return sb.toString();
    }

    public String solution(int[] numbers) {
        Num[] sortNumbers = new Num[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            sortNumbers[i] = new Num(numbers[i]);
        }
        Arrays.sort(sortNumbers);


        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < sortNumbers.length; i++) {
            sb.append(sortNumbers[i].num);
        }

        String result = sb.toString();
        if(result.charAt(0) == '0'){
            return "0";
        }

        return sb.toString();
    }


    public class Num implements Comparable<Num> {
        final int num;

        public Num(int num){
            this.num = num;
        }

        @Override
        public int compareTo(Num o) {
            String thisNum = String.valueOf(num);
            String oNum = String.valueOf(o.num);
            return (oNum+thisNum).compareTo(thisNum+oNum);
        }
    }


}
/**
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/42746
 * solution
 * 정확성  테스트
 * 테스트 1 〉	통과 (165.31ms, 135MB)
 * 테스트 2 〉	통과 (109.53ms, 140MB)
 * 테스트 3 〉	통과 (187.09ms, 152MB)
 * 테스트 4 〉	통과 (19.03ms, 96.3MB)
 * 테스트 5 〉	통과 (163.01ms, 125MB)
 * 테스트 6 〉	통과 (155.38ms, 124MB)
 * 테스트 7 〉	통과 (2.58ms, 83MB)
 * 테스트 8 〉	통과 (1.58ms, 81.5MB)
 * 테스트 9 〉	통과 (2.42ms, 89.2MB)
 * 테스트 10 〉	통과 (2.44ms, 79.3MB)
 * 테스트 11 〉	통과 (2.34ms, 89.2MB)
 * 테스트 12 〉	통과 (1.41ms, 79.3MB)
 * 테스트 13 〉	통과 (1.82ms, 88.4MB)
 * 테스트 14 〉	통과 (2.22ms, 84.1MB)
 * 테스트 15 〉	통과 (1.90ms, 90.5MB)
 * 채점 결과
 * 정확성: 100.0
 * 합계: 100.0 / 100.0
 *
 *
 * solution2
 * 정확성  테스트
 * 테스트 1 〉	통과 (188.43ms, 142MB)
 * 테스트 2 〉	통과 (100.55ms, 112MB)
 * 테스트 3 〉	통과 (206.99ms, 137MB)
 * 테스트 4 〉	통과 (11.78ms, 77.3MB)
 * 테스트 5 〉	통과 (125.15ms, 120MB)
 * 테스트 6 〉	통과 (161.60ms, 109MB)
 * 테스트 7 〉	통과 (4.09ms, 85.6MB)
 * 테스트 8 〉	통과 (1.77ms, 88.3MB)
 * 테스트 9 〉	통과 (2.75ms, 72.7MB)
 * 테스트 10 〉	통과 (2.15ms, 81MB)
 * 테스트 11 〉	통과 (1.59ms, 81.9MB)
 * 테스트 12 〉	통과 (1.52ms, 70.4MB)
 * 테스트 13 〉	통과 (1.83ms, 91.5MB)
 * 테스트 14 〉	통과 (2.38ms, 92.2MB)
 * 테스트 15 〉	통과 (1.78ms, 84.8MB)
 * 채점 결과
 * 정확성: 100.0
 * 합계: 100.0 / 100.0
 */
