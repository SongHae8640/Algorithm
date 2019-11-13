package level1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;


//�ؽ� ���� ���� �ξ� ����
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
 *  * ���� : https://programmers.co.kr/learn/courses/30/lessons/42576
��Ȯ��  �׽�Ʈ
�׽�Ʈ 1 ��	��� (0.92ms, 50.6MB)
�׽�Ʈ 2 ��	��� (0.96ms, 52.5MB)
�׽�Ʈ 3 ��	��� (1.44ms, 51MB)
�׽�Ʈ 4 ��	��� (2.60ms, 54.8MB)
�׽�Ʈ 5 ��	��� (5.84ms, 54.9MB)
ȿ����  �׽�Ʈ
�׽�Ʈ 1 ��	��� (50.12ms, 92.3MB)
�׽�Ʈ 2 ��	��� (61.83ms, 97.2MB)
�׽�Ʈ 3 ��	��� (66.53ms, 102MB)
�׽�Ʈ 4 ��	��� (95.20ms, 113MB)
�׽�Ʈ 5 ��	��� (86.51ms, 116MB)
 * */