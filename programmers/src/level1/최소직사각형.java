package level1;

public class 최소직사각형 {
    public static void main(String[] args) {
        //System.out.println(new Temp().solution(new int[][]{{60, 50}, {30, 70}, {60, 30}, {80, 40}})); // 4000
        System.out.println(new 최소직사각형().solution(new int[][] {{10, 7}, {12, 3}, {8, 15}, {14, 7}, {5, 15}})); // 120
        System.out.println(new 최소직사각형().solution(new int[][] {{14, 4}, {19, 6}, {6, 16}, {18, 7}, {7, 11}})); // 133
    }

    public int solution(int[][] sizes) {
        int widthMax = 0;
        int lengthMax = 0;
        for (int[] size : sizes){
            Card card = new Card(size[0], size[1]);
            widthMax = Math.max(widthMax, card.width);
            lengthMax = Math.max(lengthMax, card.length);
        }
        return widthMax*lengthMax;
    }

    public class Card {
        final int width;
        final int length;

        public Card(int s1, int s2){
            if(s1>s2){
                this.width = s1;
                this.length = s2;
            }else{
                this.length = s1;
                this.width = s2;
            }
        }
    }
}
/**
 *
 * https://school.programmers.co.kr/learn/courses/30/lessons/86491
 *정확성  테스트
 * 테스트 1 〉	통과 (0.39ms, 87.4MB)
 * 테스트 2 〉	통과 (0.28ms, 77.3MB)
 * 테스트 3 〉	통과 (0.37ms, 79.6MB)
 * 테스트 4 〉	통과 (0.28ms, 73.5MB)
 * 테스트 5 〉	통과 (0.27ms, 73.8MB)
 * 테스트 6 〉	통과 (0.31ms, 76.7MB)
 * 테스트 7 〉	통과 (0.37ms, 84.2MB)
 * 테스트 8 〉	통과 (0.29ms, 77MB)
 * 테스트 9 〉	통과 (0.27ms, 80.8MB)
 * 테스트 10 〉	통과 (0.34ms, 78.4MB)
 * 테스트 11 〉	통과 (0.46ms, 90.6MB)
 * 테스트 12 〉	통과 (0.33ms, 83.1MB)
 * 테스트 13 〉	통과 (0.60ms, 73.9MB)
 * 테스트 14 〉	통과 (0.64ms, 89.7MB)
 * 테스트 15 〉	통과 (0.87ms, 89.4MB)
 * 테스트 16 〉	통과 (1.08ms, 77MB)
 * 테스트 17 〉	통과 (1.71ms, 105MB)
 * 테스트 18 〉	통과 (2.40ms, 89.1MB)
 * 테스트 19 〉	통과 (1.84ms, 92.9MB)
 * 테스트 20 〉	통과 (2.47ms, 101MB)
 * 채점 결과
 * 정확성: 100.0
 * 합계: 100.0 / 100.0
 *
 */
