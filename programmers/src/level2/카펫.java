package level2;

import java.util.*;

public class 카펫 {

  public static void main(String[] args) {
    카펫 t = new 카펫();
    System.out.println(Arrays.toString(t.solution2(10, 2))); // [4, 3]
    System.out.println(Arrays.toString(t.solution2(8, 1))); // [3, 3]
    System.out.println(Arrays.toString(t.solution2(24, 24))); //[8, 6]
  }

  public int[] solution2(int brown, int yellow) {
    int count = brown + yellow;
    for (int width = 3; width < count / 2; width++) {
      if (count % width == 0) {
        int length = count / width;
        if((width-2) * (length-2) == yellow){
          return new int[]{length, width};
        }
      }
    }
    return new int[]{};
  }

  public int[] solution(int brown, int yellow) {
    List<Integer> widthList = new ArrayList<>();
    int count = brown + yellow;
    for (int i = 3; i < count/2; i++) {
      if(count%i==0){
        widthList.add(i);
      }
    }
    int mid = widthList.size()/2;
    if (widthList.size()%2==0){
      return new int[]{widthList.get(mid), widthList.get(mid-1)};
    }else{
      return new int[]{widthList.get(mid),widthList.get(mid)};
    }
  }
}
/*

https://school.programmers.co.kr/learn/courses/30/lessons/42842

solution
정확성  테스트
테스트 1 〉	통과 (0.02ms, 71.2MB)
테스트 2 〉	통과 (0.02ms, 75.5MB)
테스트 3 〉	통과 (7.20ms, 85.4MB)
테스트 4 〉	실패 (0.09ms, 89MB)
테스트 5 〉	통과 (0.23ms, 71.8MB)
테스트 6 〉	실패 (3.21ms, 101MB)
테스트 7 〉	실패 (9.81ms, 77.6MB)
테스트 8 〉	통과 (8.57ms, 84.5MB)
테스트 9 〉	통과 (6.40ms, 89.8MB)
테스트 10 〉	통과 (9.15ms, 83.4MB)
테스트 11 〉	통과 (0.02ms, 87.9MB)
테스트 12 〉	통과 (0.03ms, 79.2MB)
테스트 13 〉	통과 (0.02ms, 82.5MB)
채점 결과
정확성: 76.9
합계: 76.9 / 100.0

solution2
정확성  테스트
테스트 1 〉	통과 (0.02ms, 79.5MB)
테스트 2 〉	통과 (0.02ms, 74.7MB)
테스트 3 〉	통과 (0.04ms, 71.3MB)
테스트 4 〉	통과 (0.02ms, 88.8MB)
테스트 5 〉	통과 (0.02ms, 93.1MB)
테스트 6 〉	통과 (0.02ms, 77.5MB)
테스트 7 〉	통과 (0.02ms, 86.4MB)
테스트 8 〉	통과 (0.03ms, 76.7MB)
테스트 9 〉	통과 (0.03ms, 78.2MB)
테스트 10 〉	통과 (0.04ms, 81.1MB)
테스트 11 〉	통과 (0.01ms, 77.7MB)
테스트 12 〉	통과 (0.02ms, 90.2MB)
테스트 13 〉	통과 (0.01ms, 77MB)
채점 결과
정확성: 100.0
합계: 100.0 / 100.0
 */