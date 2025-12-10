package level1;

import java.util.*;

public class 폰켓몬 {
  public static void main(String[] args) {
    폰켓몬 t = new 폰켓몬();
    System.out.println(t.solution(new int[]{3,1,2,3}));
    System.out.println(t.solution(new int[]{3,3,3,2,2,4}));
    System.out.println(t.solution(new int[]{3,3,3,2,2,2}));
  }

  public int solution(int[] nums) {
    int pickCount = nums.length/2;
    Set<Integer> set = new HashSet<>();
    for(int num : nums){
      set.add(num);
    }
    return Math.min(pickCount, set.size());
  }
}
/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/1845
 *
 * 정확성  테스트
 * 테스트 1 〉	통과 (0.05ms, 82.7MB)
 * 테스트 2 〉	통과 (0.09ms, 75.5MB)
 * 테스트 3 〉	통과 (0.05ms, 88.9MB)
 * 테스트 4 〉	통과 (0.12ms, 83.2MB)
 * 테스트 5 〉	통과 (0.11ms, 86.1MB)
 * 테스트 6 〉	통과 (0.11ms, 87.4MB)
 * 테스트 7 〉	통과 (0.29ms, 84.2MB)
 * 테스트 8 〉	통과 (0.26ms, 70.4MB)
 * 테스트 9 〉	통과 (0.47ms, 89.5MB)
 * 테스트 10 〉	통과 (0.17ms, 86.1MB)
 * 테스트 11 〉	통과 (0.34ms, 87.6MB)
 * 테스트 12 〉	통과 (0.32ms, 79.4MB)
 * 테스트 13 〉	통과 (0.54ms, 83.9MB)
 * 테스트 14 〉	통과 (0.79ms, 85.1MB)
 * 테스트 15 〉	통과 (0.81ms, 88.6MB)
 * 테스트 16 〉	통과 (3.12ms, 93.7MB)
 * 테스트 17 〉	통과 (5.92ms, 90.8MB)
 * 테스트 18 〉	통과 (3.63ms, 86.5MB)
 * 테스트 19 〉	통과 (3.41ms, 81.8MB)
 * 테스트 20 〉	통과 (3.49ms, 86.9MB)
 * 채점 결과
 * 정확성: 100.0
 * 합계: 100.0 / 100.0
 */