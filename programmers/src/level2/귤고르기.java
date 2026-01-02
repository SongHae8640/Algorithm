package level2;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class 귤고르기 {

    public static void main(String[] args) {
        귤고르기 t = new 귤고르기();
        System.out.println(t.solution(6, new int[]{1, 3, 2, 5, 4, 5, 2, 3})); // 3
        System.out.println(t.solution(4, new int[]{1, 3, 2, 5, 4, 5, 2, 3})); // 2
        System.out.println(t.solution(2, new int[]{1, 1, 1, 1, 2, 2, 2, 3})); // 1

    }

    public int solution(int k, int[] tangerine) {
        Map<Integer, Integer> sizeCount = new HashMap<>();
        for(int size : tangerine){
            sizeCount.merge(size, 1, Integer::sum);
        }

        List<TangerineType> list = sizeCount.entrySet().stream()
                .map(e -> new TangerineType(e.getKey(), e.getValue()))
                .sorted((a, b) -> b.count - a.count)
                .collect(Collectors.toUnmodifiableList());


        int typeCount = 0;
        for (TangerineType tangerineType : list){
            k -= tangerineType.count;
            typeCount++;
            if(k <= 0){
                return typeCount;
            }

        }

        return typeCount;
    }

    public class TangerineType{
        final int size;
        final int count;

        public TangerineType(int size, int count){
            this.size = size;
            this.count = count;
        }
    }



}
/*
https://school.programmers.co.kr/learn/courses/30/lessons/138476

정확성  테스트
테스트 1 〉	통과 (19.02ms, 99.9MB)
테스트 2 〉	통과 (18.73ms, 95.9MB)
테스트 3 〉	통과 (24.24ms, 102MB)
테스트 4 〉	통과 (19.63ms, 84.4MB)
테스트 5 〉	통과 (16.76ms, 79.5MB)
테스트 6 〉	통과 (17.95ms, 96MB)
테스트 7 〉	통과 (24.06ms, 89.9MB)
테스트 8 〉	통과 (25.80ms, 102MB)
테스트 9 〉	통과 (21.01ms, 97.8MB)
테스트 10 〉	통과 (24.38ms, 84.6MB)
테스트 11 〉	통과 (3.92ms, 81.7MB)
테스트 12 〉	통과 (2.95ms, 72.7MB)
테스트 13 〉	통과 (3.49ms, 80MB)
테스트 14 〉	통과 (2.97ms, 72.6MB)
테스트 15 〉	통과 (2.83ms, 85.2MB)
테스트 16 〉	통과 (2.67ms, 87.6MB)
테스트 17 〉	통과 (4.00ms, 76.1MB)
테스트 18 〉	통과 (3.32ms, 84.1MB)
테스트 19 〉	통과 (2.88ms, 72MB)
테스트 20 〉	통과 (2.71ms, 76.9MB)
테스트 21 〉	통과 (4.06ms, 77.2MB)
테스트 22 〉	통과 (4.78ms, 95.8MB)
테스트 23 〉	통과 (6.11ms, 85.4MB)
테스트 24 〉	통과 (4.75ms, 83.4MB)
테스트 25 〉	통과 (18.48ms, 99.1MB)
테스트 26 〉	통과 (24.15ms, 102MB)
테스트 27 〉	통과 (73.57ms, 118MB)
테스트 28 〉	통과 (42.58ms, 118MB)
테스트 29 〉	통과 (57.83ms, 102MB)
테스트 30 〉	통과 (48.36ms, 98.2MB)
테스트 31 〉	통과 (17.73ms, 94.7MB)
테스트 32 〉	통과 (19.58ms, 101MB)
테스트 33 〉	통과 (52.16ms, 91.2MB)
테스트 34 〉	통과 (43.90ms, 89.9MB)
채점 결과
정확성: 100.0
합계: 100.0 / 100.0
 */
