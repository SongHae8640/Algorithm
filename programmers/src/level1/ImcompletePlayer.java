package level1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;


//해쉬 맵을 쓰면 훨씬 빠름
public class ImcompletePlayer {

	public static void main(String[] args) {
		String[] a = {"leo", "kiki", "eden"};
		String[] b = {"leo", "kiki", "eden"};
		System.out.println(solution(a, b));

	}

	
	public static String solution(String[] participant, String[] completion) {
		String answer = null;
		HashMap<String, Integer> hm = new HashMap<>();
        for (String player : participant) {
        	hm.put(player, hm.getOrDefault(player, 0) + 1);

        }

       for (String player : completion) {
    	   hm.put(player, hm.get(player) - 1);

        }

        for (String key : hm.keySet()) {
	        if (hm.get(key) != 0){
	        	answer = key;
	        }
        }
        
        return answer;
    }

}

/*
 *  * 문제 : https://programmers.co.kr/learn/courses/30/lessons/42576
정확성  테스트
테스트 1 〉	통과 (0.92ms, 50.6MB)
테스트 2 〉	통과 (0.96ms, 52.5MB)
테스트 3 〉	통과 (1.44ms, 51MB)
테스트 4 〉	통과 (2.60ms, 54.8MB)
테스트 5 〉	통과 (5.84ms, 54.9MB)
효율성  테스트
테스트 1 〉	통과 (50.12ms, 92.3MB)
테스트 2 〉	통과 (61.83ms, 97.2MB)
테스트 3 〉	통과 (66.53ms, 102MB)
테스트 4 〉	통과 (95.20ms, 113MB)
테스트 5 〉	통과 (86.51ms, 116MB)
 * */