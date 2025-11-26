package level1;

import java.util.Arrays;
import java.util.Stack;

public class 주식가격 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new 주식가격().solution(new int[] {1, 2, 3, 2, 3}))); // 4, 3, 1, 1, 0

    }

    public int[] solution2(int[] prices) {
        int[] answer = new int[prices.length];
        for (int i = 0; i < prices.length -1; i++) {
            for (int j = i+1; j < prices.length ; j++) {
                answer[i]++;
                if(prices[i] > prices[j]){
                    break;
                }
            }
        }
        return answer;
    }


    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        Stack<Stock> stack = new Stack<>();
        stack.add(new Stock(0, prices[0]));
        for (int i = 1; i < prices.length; i++) {
            if(prices[i] >= stack.peek().price){
                stack.add(new Stock(i, prices[i]));
            }else{
                while (!stack.isEmpty() && prices[i] < stack.peek().price){
                    Stock stock = stack.pop();
                    answer[stock.index] = i-stock.index;
                }
                stack.add(new Stock(i, prices[i]));

            }
        }
        while (!stack.isEmpty()){
            int i = stack.pop().index;
            answer[i] = prices.length-i-1;
        }

        return answer;
    }

    public class Stock {
        public final int index;
        public final int price;

        public Stock(int index, int price){
            this.index = index;
            this.price = price;
        }
    }

}
/**
 *
 * solution Stack
 * 정확성  테스트
 * 테스트 1 〉	통과 (0.46ms, 75.4MB)
 * 테스트 2 〉	통과 (0.83ms, 90.9MB)
 * 테스트 3 〉	통과 (2.31ms, 77.5MB)
 * 테스트 4 〉	통과 (1.48ms, 76MB)
 * 테스트 5 〉	통과 (1.93ms, 81.6MB)
 * 테스트 6 〉	통과 (0.55ms, 79.4MB)
 * 테스트 7 〉	통과 (1.75ms, 72.5MB)
 * 테스트 8 〉	통과 (1.60ms, 82.3MB)
 * 테스트 9 〉	통과 (0.64ms, 72.1MB)
 * 테스트 10 〉	통과 (1.33ms, 90.2MB)
 * 효율성  테스트
 * 테스트 1 〉	통과 (34.34ms, 75.7MB)
 * 테스트 2 〉	통과 (27.42ms, 73.5MB)
 * 테스트 3 〉	통과 (48.69ms, 76.7MB)
 * 테스트 4 〉	통과 (34.64ms, 71.1MB)
 * 테스트 5 〉	통과 (29.86ms, 70.3MB)
 * 채점 결과
 * 정확성: 66.7
 * 효율성: 33.3
 * 합계: 100.0 / 100.0
 *
 *
 * solution for2
 * 정확성  테스트
 * 테스트 1 〉	통과 (0.01ms, 73.7MB)
 * 테스트 2 〉	통과 (0.03ms, 88.7MB)
 * 테스트 3 〉	통과 (0.14ms, 82.8MB)
 * 테스트 4 〉	통과 (0.15ms, 72.9MB)
 * 테스트 5 〉	통과 (0.31ms, 92.4MB)
 * 테스트 6 〉	통과 (0.02ms, 99.3MB)
 * 테스트 7 〉	통과 (0.10ms, 74.9MB)
 * 테스트 8 〉	통과 (0.13ms, 79.2MB)
 * 테스트 9 〉	통과 (0.01ms, 72.6MB)
 * 테스트 10 〉	통과 (0.19ms, 91.3MB)
 * 효율성  테스트
 * 테스트 1 〉	통과 (20.54ms, 73.8MB)
 * 테스트 2 〉	통과 (15.82ms, 70.6MB)
 * 테스트 3 〉	통과 (24.25ms, 75.3MB)
 * 테스트 4 〉	통과 (17.88ms, 69.4MB)
 * 테스트 5 〉	통과 (11.49ms, 63.5MB)
 * 채점 결과
 * 정확성: 66.7
 * 효율성: 33.3
 * 합계: 100.0 / 100.0
 */