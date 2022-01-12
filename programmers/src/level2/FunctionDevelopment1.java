package level2;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;


/**
 * 기능개발
 * https://programmers.co.kr/learn/courses/30/lessons/42586
 * */
public class FunctionDevelopment1 {

	public static void main(String[] args) {

		FunctionDevelopment1 development = new FunctionDevelopment1();
		assertArrayEquals(new int[]{2,1}, development.solution(new int[] {93, 30, 55},new int[] {1, 30, 5} ));
		assertArrayEquals(new int[]{1, 3, 2}, development.solution(new int[] {95, 90, 99, 99, 80, 99},new int[] {1, 1, 1, 1, 1, 1} ));

	}


	public int[] solution(int[] progresses, int[] speeds) {
		PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());
		ArrayList<Integer> deployDays = new ArrayList<>();

		for (int i = 0; i < progresses.length; i++) {
			int developmentCompleteDay = (int) Math.ceil ((double) (100 - progresses[i]) / speeds[i]);

			if(queue.peek() == null || queue.peek() >= developmentCompleteDay){
				queue.offer(developmentCompleteDay);
				continue;
			}

			deployDays.add(queue.size());
			queue.clear();
			queue.offer(developmentCompleteDay);
		}


		if(!queue.isEmpty()) deployDays.add(queue.size());


		int[] deployCounts = new int[deployDays.size()];
		for (int i = 0; i < deployCounts.length; i++) {
			deployCounts[i] = deployDays.get(i);
		}

		return deployCounts;
	}

}
