package level2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class FunctionDevelopment1 {

	public static void main(String[] args) {
		solution(new int[] {93, 30, 55},new int[] {1, 30, 5} );	//[2, 1]
		System.out.println();
		solution(new int[] {95, 90, 99, 99, 80, 99},new int[] {1, 1, 1, 1, 1, 1} );	//[1, 3, 2]

	}
	
	
    public static int[] solution(int[] progresses, int[] speeds) {
		int developPeriod;
		Queue<Integer> queue = new LinkedList<>();
		List<Integer> answerList = new ArrayList<>();

		for (int i = 0; i < progresses.length; i++) {
			developPeriod = (int) Math.ceil ( ((double) (100 - progresses[i])) / speeds[i]);
			if(queue.isEmpty() || queue.peek() >= developPeriod){
				queue.offer(developPeriod);
			}else{
				answerList.add(queue.size());
				queue.clear();
				queue.offer(developPeriod);
			}
		}

		if(!queue.isEmpty()) answerList.add(queue.size());



		int[] answer = new int[answerList.size()];
		for (int i = 0; i < answer.length; i++) {
			answer[i] = answerList.get(i);
		}
		System.out.println(answerList.toString());


        return answer;
    }

}
/**
 * 기능개발
 * https://programmers.co.kr/learn/courses/30/lessons/42586
 *
 * 정확성  테스트
 * 테스트 1 〉	통과 (0.31ms, 77.8MB)
 * 테스트 2 〉	통과 (0.42ms, 70.4MB)
 * 테스트 3 〉	통과 (0.37ms, 78.9MB)
 * 테스트 4 〉	통과 (0.55ms, 75.6MB)
 * 테스트 5 〉	통과 (0.36ms, 75.9MB)
 * 테스트 6 〉	통과 (0.56ms, 88.7MB)
 * 테스트 7 〉	통과 (0.42ms, 75.1MB)
 * 테스트 8 〉	통과 (0.47ms, 84.2MB)
 * 테스트 9 〉	통과 (0.48ms, 74.8MB)
 * 테스트 10 〉	통과 (0.39ms, 83MB)
 * 테스트 11 〉	통과 (0.32ms, 74.5MB)
 * 채점 결과
 * 정확성: 100.0
 * 합계: 100.0 / 100.0
 * */