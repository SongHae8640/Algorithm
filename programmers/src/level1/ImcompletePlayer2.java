package level1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;


public class ImcompletePlayer2 {

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

/*
 * 문제 : https://programmers.co.kr/learn/courses/30/lessons/42576
 * 정확성  테스트
테스트 1 〉	통과 (0.82ms, 53.9MB)
테스트 2 〉	통과 (1.02ms, 53.7MB)
테스트 3 〉	통과 (7.13ms, 54MB)
테스트 4 〉	통과 (10.34ms, 52.3MB)
테스트 5 〉	통과 (11.49ms, 56.4MB)
효율성  테스트
테스트 1 〉	통과 (104.70ms, 90.3MB)
테스트 2 〉	통과 (149.38ms, 98.5MB)
테스트 3 〉	통과 (310.67ms, 102MB)
테스트 4 〉	통과 (322.21ms, 112MB)
테스트 5 〉	통과 (276.96ms, 103MB)
 * 
 * 
 * */
