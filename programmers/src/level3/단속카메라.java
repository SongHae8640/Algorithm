package level3;

import java.util.Arrays;
import java.util.Comparator;

public class 단속카메라 {

    public static void main(String[] args) {
        단속카메라 t = new 단속카메라();
        System.out.println(t.solution(new int[][]{{-20,-15}, {-14,-5}, {-18,-13}, {-5,-3}})); // 2
        System.out.println(t.solution(new int[][]{{0,5}, {1,10}, {2,3}})); // 1

    }

    public int solution(int[][] routes) {
        Arrays.sort(routes, Comparator.comparingInt(a -> a[1]));
        int count = 0;
        boolean[] visits = new boolean[routes.length];
        for (int i = 0; i < routes.length; i++) {
            if(!visits[i]){
                visits[i] = true;
                count++;
                for (int j = i + 1; j < routes.length; j++) {
                    if(visits[j]) continue;
                    if (routes[i][1] >= routes[j][0] && routes[i][1] <= routes[j][1] ){
                         visits[j] = true;
                    }
                }
            }

        }
        return count;
    }

}
/*
https://school.programmers.co.kr/learn/courses/30/lessons/42884

정확성  테스트
테스트 1 〉	통과 (1.69ms, 90.2MB)
테스트 2 〉	통과 (1.66ms, 74.2MB)
테스트 3 〉	통과 (1.90ms, 88.9MB)
테스트 4 〉	통과 (2.04ms, 72.9MB)
테스트 5 〉	통과 (2.54ms, 94MB)
효율성  테스트
테스트 1 〉	통과 (8.82ms, 55.3MB)
테스트 2 〉	통과 (5.01ms, 55.7MB)
테스트 3 〉	통과 (16.32ms, 55.2MB)
테스트 4 〉	통과 (3.01ms, 54.2MB)
테스트 5 〉	통과 (18.50ms, 58.4MB)
채점 결과
정확성: 50.0
효율성: 50.0
합계: 100.0 / 100.0

 */
