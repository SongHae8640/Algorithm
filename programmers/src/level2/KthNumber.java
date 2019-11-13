package level2;

import java.util.Arrays;

public class KthNumber {

	public static void main(String[] args) {
		System.out.println(solution(new int[] {1, 5, 2, 6, 3, 7, 4}, new int[][] {{2, 5, 3}, {4, 4, 1}, {1, 7, 3}}));

	}
	
	public static int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];	//commands�� ���� ���� ��ŭ answer�� ����� �ش�
        for (int commandsIdx = 0; commandsIdx < commands.length; commandsIdx++) {	//command�� �� �� �� ������
        	//array�� i(commands[commandsIdx][0])��° ���� j(commands[commandsIdx][1])��° ���ڱ��� �ڸ���
        	//Arrays.copyOfRange(original, from, to)
			int[] cuttedArray = Arrays.copyOfRange(array, commands[commandsIdx][0]-1, commands[commandsIdx][1]);
			Arrays.sort(cuttedArray);	//�������� ����
        	answer[commandsIdx] = cuttedArray[commands[commandsIdx][2]-1];	//k(commands[commandsIdx][2])��° ���� answer�� ����
		}
        return answer;
    }

}
