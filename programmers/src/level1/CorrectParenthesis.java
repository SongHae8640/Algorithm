package level1;

public class CorrectParenthesis {

	boolean solution(String s) {

		//��ȣ�� ������ +1, ������ -1
		int openCloseCount = 0;

		for(int i = 0 ; i < s.length(); i++){
			if(s.charAt(i) == '('){
				openCloseCount++;
			}else{
				openCloseCount--;
			}

			//�տ� ������ ���� ������ �������� false
			if(openCloseCount < 0){
				return false;
			}
		}

		return openCloseCount == 0;
	}



}

/**
 *
 * �ùٸ� ��ȣ
 * https://programmers.co.kr/learn/courses/30/lessons/12909
 *
 * ��Ȯ��  �׽�Ʈ
 * �׽�Ʈ 1 ��	��� (0.01ms, 73MB)
 * �׽�Ʈ 2 ��	��� (0.03ms, 73.2MB)
 * �׽�Ʈ 3 ��	��� (0.02ms, 77.2MB)
 * �׽�Ʈ 4 ��	��� (0.02ms, 77.8MB)
 * �׽�Ʈ 5 ��	��� (0.02ms, 74.6MB)
 * �׽�Ʈ 6 ��	��� (0.01ms, 73MB)
 * �׽�Ʈ 7 ��	��� (0.02ms, 71.1MB)
 * �׽�Ʈ 8 ��	��� (0.03ms, 78.5MB)
 * �׽�Ʈ 9 ��	��� (0.01ms, 67.9MB)
 * �׽�Ʈ 10 ��	��� (0.02ms, 73.5MB)
 * �׽�Ʈ 11 ��	��� (0.02ms, 78.1MB)
 * �׽�Ʈ 12 ��	��� (0.03ms, 74.8MB)
 * �׽�Ʈ 13 ��	��� (0.02ms, 74.1MB)
 * �׽�Ʈ 14 ��	��� (0.03ms, 77.5MB)
 * �׽�Ʈ 15 ��	��� (0.03ms, 73.5MB)
 * �׽�Ʈ 16 ��	��� (0.02ms, 73.4MB)
 * �׽�Ʈ 17 ��	��� (0.04ms, 78.6MB)
 * �׽�Ʈ 18 ��	��� (0.02ms, 72.4MB)
 * ȿ����  �׽�Ʈ
 * �׽�Ʈ 1 ��	��� (6.51ms, 52.6MB)
 * �׽�Ʈ 2 ��	��� (4.63ms, 53MB)
 * ä�� ���
 * ��Ȯ��: 69.5
 * ȿ����: 30.5
 * �հ�: 100.0 / 100.0
 *
 * */