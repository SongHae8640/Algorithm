package level3;


public class 스티커모으기2 {

    public static void main(String[] args) {
        스티커모으기2 t = new 스티커모으기2();
        System.out.println(t.solution(new int []{14, 6, 5, 11, 3, 9, 2, 10}));  // 36
        System.out.println(t.solution(new int []{1, 3, 2, 5, 4}));  //8

    }

    public int solution(int sticker[]) {
        if(sticker.length == 1){
            return sticker[0];
        }

        int pickOne = sumPickOne(sticker);
        int pickNotOne = sumPickNotOne(sticker);

        return Math.max(pickOne, pickNotOne);
    }

    private int sumPickNotOne(int[] sticker) {
        int[] dp = new int[sticker.length];
        dp[0] = 0;
        dp[1] = sticker[1];
        for(int i = 2 ; i < sticker.length; i++){
            dp[i] = Math.max(dp[i-1], dp[i-2] + sticker[i]);
        }
        return dp[sticker.length-1];
    }

    private int sumPickOne(int[] sticker) {
        int[] dp = new int[sticker.length];
        dp[0] = sticker[0];
        dp[1] = sticker[0];
        for(int i = 2 ; i < sticker.length-1; i++){
            dp[i] = Math.max(dp[i-1], dp[i-2] + sticker[i]);
        }
        return dp[sticker.length-2];
    }


}
/*
https://school.programmers.co.kr/learn/courses/30/lessons/12971
dp

정확성  테스트
테스트 1 〉	통과 (0.03ms, 85.2MB)
테스트 2 〉	통과 (0.03ms, 89.2MB)
테스트 3 〉	통과 (0.04ms, 86.3MB)
테스트 4 〉	통과 (0.04ms, 85.6MB)
테스트 5 〉	통과 (0.04ms, 85MB)
테스트 6 〉	통과 (0.05ms, 78.8MB)
테스트 7 〉	통과 (0.23ms, 86.6MB)
테스트 8 〉	통과 (0.13ms, 89MB)
테스트 9 〉	통과 (0.12ms, 68.4MB)
테스트 10 〉	통과 (0.19ms, 75.9MB)
테스트 11 〉	통과 (0.15ms, 88.2MB)
테스트 12 〉	통과 (0.19ms, 90.7MB)
테스트 13 〉	통과 (0.18ms, 75.7MB)
테스트 14 〉	통과 (0.13ms, 74.7MB)
테스트 15 〉	통과 (0.19ms, 79.3MB)
테스트 16 〉	통과 (0.12ms, 88.2MB)
테스트 17 〉	통과 (0.20ms, 81.2MB)
테스트 18 〉	통과 (0.12ms, 77.3MB)
테스트 19 〉	통과 (0.12ms, 75.4MB)
테스트 20 〉	통과 (0.14ms, 74.7MB)
테스트 21 〉	통과 (0.12ms, 82.6MB)
테스트 22 〉	통과 (0.12ms, 88.4MB)
테스트 23 〉	통과 (0.12ms, 80.7MB)
테스트 24 〉	통과 (0.12ms, 85.6MB)
테스트 25 〉	통과 (0.12ms, 84.6MB)
테스트 26 〉	통과 (0.13ms, 86.3MB)
테스트 27 〉	통과 (0.19ms, 88.4MB)
테스트 28 〉	통과 (0.18ms, 90.5MB)
테스트 29 〉	통과 (0.13ms, 83.8MB)
테스트 30 〉	통과 (0.11ms, 80.6MB)
테스트 31 〉	통과 (0.15ms, 78.4MB)
테스트 32 〉	통과 (0.18ms, 94MB)
테스트 33 〉	통과 (0.02ms, 78.6MB)
효율성  테스트
테스트 1 〉	통과 (7.10ms, 57.9MB)
테스트 2 〉	통과 (10.12ms, 74.9MB)
테스트 3 〉	통과 (7.70ms, 58.7MB)
테스트 4 〉	통과 (6.59ms, 57.9MB)
채점 결과
정확성: 49.7
효율성: 50.3
합계: 100.0 / 100.0
 */
