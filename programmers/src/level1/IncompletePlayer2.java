package level1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;


public class IncompletePlayer2 {

	public static void main(String[] args) {
		String[] a = {"leo", "kiki", "eden"};
		String[] b = {"leo", "kiki", "eden"};
		System.out.println(solution(a, b));

	}


	public static String solution(String[] participant, String[] completion) {
		Arrays.sort(participant);
		Arrays.sort(completion);

		for (int i = 0; i < completion.length; i++) {
			if(!participant[i].equals(completion[i])) {
				return participant[i];
			}
		}
		return participant[participant.length-1];
	}

}

/**
 * 완주하지 못한 선수
 * https://programmers.co.kr/learn/courses/30/lessons/42576
 *
 * 정확성  테스트
 * 테스트 1 〉	통과 (0.30ms, 71.9MB)
 * 테스트 2 〉	통과 (0.36ms, 62.3MB)
 * 테스트 3 〉	통과 (2.09ms, 79.8MB)
 * 테스트 4 〉	통과 (3.69ms, 76MB)
 * 테스트 5 〉	통과 (3.82ms, 74.4MB)
 * 효율성  테스트
 * 테스트 1 〉	통과 (142.38ms, 83.4MB)
 * 테스트 2 〉	통과 (208.91ms, 88.5MB)
 * 테스트 3 〉	통과 (357.48ms, 94.5MB)
 * 테스트 4 〉	통과 (389.07ms, 95.2MB)
 * 테스트 5 〉	통과 (331.86ms, 96MB)
 * 채점 결과
 * 정확성: 50.0
 * 효율성: 50.0
 * 합계: 100.0 / 100.0
 * */