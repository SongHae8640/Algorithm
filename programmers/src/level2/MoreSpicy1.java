package level2;

import java.util.PriorityQueue;

public class MoreSpicy1 {
    public static void main(String[] args) {

        solution(new int[] {1, 2, 3, 9, 10, 12}, 200 );	// return = 2

    }

    public static int solution(int[] scoville, int K) {

        int answer = 0 ;

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

        for (int i = 0 ; i < scoville.length ; i ++){
            priorityQueue.offer(scoville[i]);
        }


        int firstNotSpicy;
        while(true){
            firstNotSpicy = priorityQueue.poll();
            if(firstNotSpicy >= K){
                break;
            }else if(priorityQueue.isEmpty()){
                return -1;
            }
            priorityQueue.add(firstNotSpicy + priorityQueue.poll()*2);
            answer++;
        }
        return answer;
    }
}
/**
 * 더 맵게
 * https://programmers.co.kr/learn/courses/30/lessons/42626
 *
 * 정확성  테스트
 * 테스트 1 〉	통과 (0.30ms, 72.9MB)
 * 테스트 2 〉	통과 (0.31ms, 74.9MB)
 * 테스트 3 〉	통과 (0.31ms, 74.8MB)
 * 테스트 4 〉	통과 (0.31ms, 76.7MB)
 * 테스트 5 〉	통과 (0.31ms, 73.1MB)
 * 테스트 6 〉	통과 (2.38ms, 74.9MB)
 * 테스트 7 〉	통과 (1.48ms, 74.4MB)
 * 테스트 8 〉	통과 (0.72ms, 73.4MB)
 * 테스트 9 〉	통과 (0.65ms, 76.3MB)
 * 테스트 10 〉	통과 (1.57ms, 74.7MB)
 * 테스트 11 〉	통과 (1.31ms, 72.8MB)
 * 테스트 12 〉	통과 (2.62ms, 75.8MB)
 * 테스트 13 〉	통과 (1.97ms, 79.2MB)
 * 테스트 14 〉	통과 (0.36ms, 68.4MB)
 * 테스트 15 〉	통과 (1.71ms, 76.4MB)
 * 테스트 16 〉	통과 (0.32ms, 76.3MB)
 *
 * 효율성  테스트
 * 테스트 1 〉	통과 (164.79ms, 67.5MB)
 * 테스트 2 〉	통과 (267.99ms, 87MB)
 * 테스트 3 〉	통과 (1520.47ms, 122MB)
 * 테스트 4 〉	통과 (110.83ms, 63.9MB)
 * 테스트 5 〉	통과 (1833.77ms, 123MB)
 * 채점 결과
 * 정확성: 76.2
 * 효율성: 23.8
 * 합계: 100.0 / 100.0
 * */