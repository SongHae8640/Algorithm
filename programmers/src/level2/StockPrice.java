package level2;

import java.util.ArrayList;

public class StockPrice {
    public int[] solution(int[] prices) {
        ArrayList<Integer> arrayList = new ArrayList<>();

        for (int i = 0 ; i < prices.length ; i++) {
            arrayList.add(getNotDownSecond(i, prices));

            
        }

        int[] answer = new int[arrayList.size()];
        for (int i = 0 ; i < answer.length; i++) {
            answer[i] = arrayList.get(i);
        }

        return answer;
    }

    private int getNotDownSecond(int startIndex, int[] prices) {
        int second = 0;
        int price = prices[startIndex];

        for (int i = startIndex+1; i < prices.length ; i++){
            second++;
            if(price > prices[i]) break;
        }

        return second;
    }
}


/**
 *
 * 주식가격
 * https://programmers.co.kr/learn/courses/30/lessons/42584
 *
 * 정확성  테스트
 * 테스트 1 〉	통과 (0.03ms, 73.4MB)
 * 테스트 2 〉	통과 (0.07ms, 76MB)
 * 테스트 3 〉	통과 (0.39ms, 76.5MB)
 * 테스트 4 〉	통과 (0.45ms, 73.6MB)
 * 테스트 5 〉	통과 (0.49ms, 78.1MB)
 * 테스트 6 〉	통과 (0.07ms, 77.7MB)
 * 테스트 7 〉	통과 (0.26ms, 66.5MB)
 * 테스트 8 〉	통과 (0.45ms, 76.6MB)
 * 테스트 9 〉	통과 (0.08ms, 77MB)
 * 테스트 10 〉	통과 (0.43ms, 82.3MB)
 * 효율성  테스트
 * 테스트 1 〉	통과 (17.79ms, 73MB)
 * 테스트 2 〉	통과 (15.54ms, 66.5MB)
 * 테스트 3 〉	통과 (14.86ms, 73.7MB)
 * 테스트 4 〉	통과 (17.00ms, 70.2MB)
 * 테스트 5 〉	통과 (16.31ms, 64.1MB)
 * 채점 결과
 * 정확성: 66.7
 * 효율성: 33.3
 * 합계: 100.0 / 100.0
 * */