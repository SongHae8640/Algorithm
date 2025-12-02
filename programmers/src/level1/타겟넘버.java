package level1;

import java.util.Arrays;

public class 타겟넘버 {
    public static void main(String[] args) {
        System.out.println(new 타겟넘버().solution3(new int []{1, 1, 1, 1, 1}, 3 )); // 5
        System.out.println(new 타겟넘버().solution3(new int[]{4, 1, 2, 1}, 4 )); // 2
    }

    private int count;
    public int solution(int[] numbers, int target) {
        count = 0;

        dfs(0, numbers, target);
        return count;
    }

    public void dfs(int i, int[] numbers, int target){
        if(i == numbers.length){
            if(target == Arrays.stream(numbers).sum()){
                count++;
            }
            return;
        }

        numbers[i] = numbers[i]*-1;
        dfs(i+1, numbers, target);

        numbers[i] = numbers[i]*-1;
        dfs(i+1, numbers, target);
    }

    public int solution2(int[] numbers, int target) {
        count = 0;

        dfs2(numbers, 0, 0, target);
        return count;
    }

    public void dfs2(int[] numbers, int i, int sum, int target){
        if(i == numbers.length){
            if(target == sum){
                count++;
            }
            return;
        }

        dfs2(numbers,i+1,  sum + numbers[i], target);
        dfs2(numbers,i+1,  sum - numbers[i], target);
    }

    public int solution3(int[] numbers, int target) {
        return dfs3(numbers, 0, 0, target);
    }

    public int dfs3(int[] numbers, int i, int sum, int target){
        if(i == numbers.length){
            if(target == sum){
                return 1;
            }
            return 0;
        }

        return  dfs3(numbers,i+1,  sum + numbers[i], target) + dfs3(numbers,i+1,  sum - numbers[i], target);
    }
}
/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/43165
 *
 * solution
 * 정확성  테스트
 * 테스트 1 〉	통과 (143.56ms, 134MB)
 * 테스트 2 〉	통과 (88.63ms, 137MB)
 * 테스트 3 〉	통과 (4.70ms, 75MB)
 * 테스트 4 〉	통과 (6.86ms, 77.8MB)
 * 테스트 5 〉	통과 (20.17ms, 88.1MB)
 * 테스트 6 〉	통과 (7.21ms, 85.4MB)
 * 테스트 7 〉	통과 (3.74ms, 80.2MB)
 * 테스트 8 〉	통과 (7.19ms, 94.2MB)
 * 채점 결과
 * 정확성: 100.0
 * 합계: 100.0 / 100.0
 *
 *
 * solution2
 * 정확성  테스트
 * 테스트 1 〉	통과 (4.25ms, 83.7MB)
 * 테스트 2 〉	통과 (4.60ms, 82.9MB)
 * 테스트 3 〉	통과 (0.23ms, 78.8MB)
 * 테스트 4 〉	통과 (0.34ms, 77.2MB)
 * 테스트 5 〉	통과 (0.66ms, 72.4MB)
 * 테스트 6 〉	통과 (0.26ms, 88.2MB)
 * 테스트 7 〉	통과 (0.18ms, 75.1MB)
 * 테스트 8 〉	통과 (0.38ms, 69.3MB)
 * 채점 결과
 * 정확성: 100.0
 * 합계: 100.0 / 100.0
 *
 * solution3
 * 정확성  테스트
 * 테스트 1 〉	통과 (4.48ms, 85.9MB)
 * 테스트 2 〉	통과 (5.73ms, 76.8MB)
 * 테스트 3 〉	통과 (0.20ms, 73.8MB)
 * 테스트 4 〉	통과 (0.29ms, 79.5MB)
 * 테스트 5 〉	통과 (0.76ms, 78.2MB)
 * 테스트 6 〉	통과 (0.25ms, 69MB)
 * 테스트 7 〉	통과 (0.19ms, 72.2MB)
 * 테스트 8 〉	통과 (0.29ms, 75.5MB)
 * 채점 결과
 * 정확성: 100.0
 * 합계: 100.0 / 100.0
 */
