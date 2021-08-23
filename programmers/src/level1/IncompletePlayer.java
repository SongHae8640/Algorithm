package level1;

import java.util.HashMap;


public class IncompletePlayer {
	public static void main(String[] args) {
		String[] a = {"mislav", "stanko", "mislav", "ana"};
		String[] b = {"stanko", "ana", "mislav"};
		System.out.println(solution(a, b));

	}

	public static String solution(String[] participant, String[] completion) {
		String answer = "없음";

		HashMap<String, Integer> hashMap = new HashMap<>();

		for (String  player : participant ) {
			hashMap.put(player, hashMap.getOrDefault(player, 0)+1);
		}


		for (String player : completion) {
			hashMap.put(player, hashMap.get(player) -1);
		}


		for (String player : hashMap.keySet()){
			if(!hashMap.get(player).equals(0)){
				return player;
			}
		}

		return answer;
	}

/**
 * 완주하지 못한 선수
 * https://programmers.co.kr/learn/courses/30/lessons/42576
 *
 * 정확성  테스트
 * 테스트 1 〉	통과 (0.05ms, 58.3MB)
 * 테스트 2 〉	통과 (0.06ms, 60.9MB)
 * 테스트 3 〉	통과 (0.44ms, 61.8MB)
 * 테스트 4 〉	통과 (0.73ms, 68.6MB)
 * 테스트 5 〉	통과 (0.74ms, 59.1MB)
 * 효율성  테스트
 * 테스트 1 〉	통과 (36.49ms, 81.5MB)
 * 테스트 2 〉	통과 (63.47ms, 89.5MB)
 * 테스트 3 〉	통과 (64.78ms, 95.7MB)
 * 테스트 4 〉	통과 (111.93ms, 96.5MB)
 * 테스트 5 〉	통과 (69.20ms, 95.3MB)
 * 채점 결과
 * 정확성: 50.0
 * 효율성: 50.0
 * 합계: 100.0 / 100.0
 * */

}

