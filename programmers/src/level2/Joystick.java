package level2;

public class Joystick {

	public static void main(String[] args) {
		//System.out.println(solution("JEROEN"));
		System.out.println(solution("AZAAAZ"));

	}
	
	public static int solution(String name) {
		
		int[] moveCount = {0,1,2,3,4,5,6,7,8,9,10,11,12,13,12,11,10,9,8,7,6,5,4,3,2,1};
		char[] nameArr = name.toCharArray();
		
		//��� ĭ�� �� ���� Ŀ�� �̵� Ø��
		int answer = nameArr.length-1;
		
		//��� ĭ�� �� ������ ���ĺ� �̵� Ƚ��
		for(int i = 0 ; i < nameArr.length ; i++) {
			answer +=moveCount[nameArr[i]-'A'];
		}
		
		//������ A�� ���� ��� -> �����ʿ��� �������� �̵��ϴ°� ���� ���
		int minus1 =0;
		for(int i =1 ; i < nameArr.length ; i++) {
			if(moveCount[nameArr[i]-'A'] ==0) {
				minus1++;
			}else {
				break;
			}
		}
		
		//������ A�� ���� ��� -> ���ʿ��� ���������� �̵��ϴ°� ���� ���
		int minus2 =0;
		for(int i =nameArr.length-1 ; i > 0 ; i--) {
			if(moveCount[nameArr[i]-'A'] ==0) {
				minus2++;
			}else {
				break;
			}
		}
		
		//�߰��� A�� ���� ���

        
        return answer -Integer.max(minus1, minus2);
    }

}
