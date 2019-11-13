package level1;

public class StrangeWord {
	public static void main(String[] args) {
		solution("");
	}

	public static String solution(String s) {
		String answer = "";
		char tempChar;
		int wordIdx = 0;
		for (int i = 0; i < s.length(); i++) {
			tempChar = s.charAt(i);
            
            //������ ���°�� ���� ���ڴ� ���ο� �ܾ�
			if(tempChar ==' '){
				answer +=" ";
				wordIdx = 0;
			}else if(wordIdx %2 ==0){   //�ش� �ܾ��� index�� ¦���� ���
				answer +=Character.toUpperCase(tempChar);
				wordIdx++;
			}else{  //�ش� �ܾ��� index�� Ȧ���� ���
				answer +=Character.toLowerCase(tempChar);
				wordIdx++;
			}
		}
		return answer;
	}

}
/*
�׽�Ʈ 1 ��	��� (36.32ms, 55.2MB)
�׽�Ʈ 2 ��	��� (25.69ms, 51.2MB)
�׽�Ʈ 3 ��	��� (32.60ms, 55.1MB)
�׽�Ʈ 4 ��	��� (42.23ms, 55.2MB)
�׽�Ʈ 5 ��	��� (41.58ms, 53.2MB)
�׽�Ʈ 6 ��	��� (39.03ms, 52.6MB)
�׽�Ʈ 7 ��	��� (39.92ms, 55.6MB)
�׽�Ʈ 8 ��	��� (45.53ms, 53.3MB)
�׽�Ʈ 9 ��	��� (35.30ms, 55.3MB)
�׽�Ʈ 10 ����� (49.47ms, 54.8MB)
�׽�Ʈ 11 ����� (38.33ms, 53MB)
�׽�Ʈ 12 ����� (41.23ms, 53.5MB)
�׽�Ʈ 13 ����� (37.37ms, 55.6MB)
�׽�Ʈ 14 ����� (34.61ms, 55.4MB)
�׽�Ʈ 15 ����� (46.38ms, 55.5MB)
�׽�Ʈ 16 ����� (36.84ms, 53MB)
 * */