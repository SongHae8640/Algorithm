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
 * ���� : https://programmers.co.kr/learn/courses/30/lessons/42576
 * ��Ȯ��  �׽�Ʈ
�׽�Ʈ 1 ��	��� (0.82ms, 53.9MB)
�׽�Ʈ 2 ��	��� (1.02ms, 53.7MB)
�׽�Ʈ 3 ��	��� (7.13ms, 54MB)
�׽�Ʈ 4 ��	��� (10.34ms, 52.3MB)
�׽�Ʈ 5 ��	��� (11.49ms, 56.4MB)
ȿ����  �׽�Ʈ
�׽�Ʈ 1 ��	��� (104.70ms, 90.3MB)
�׽�Ʈ 2 ��	��� (149.38ms, 98.5MB)
�׽�Ʈ 3 ��	��� (310.67ms, 102MB)
�׽�Ʈ 4 ��	��� (322.21ms, 112MB)
�׽�Ʈ 5 ��	��� (276.96ms, 103MB)
 * 
 * 
 * */
