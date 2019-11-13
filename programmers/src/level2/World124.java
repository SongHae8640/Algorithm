package level2;
/*
 * 3������ �ణ ���� �����ε�
 * 10����	:	1	2	3	4	5	6	7	8	9	10	11	12	13	14
 * 3���� 	: 	1	2	10	11	12	20	21	22	100	101	102	110	111	112
 * 123W	:	1	2	3	11	12	13	21	22	23	31	32	33	111	112
 * 124W	:	1	2	3	11	12	14	21	22	24	41	42	44	111	112
 * 
 * ���� ���� 123W�� 3���� ���� �ڸ��� �þ�°� 1 �ʰ� �Ͼ� ��Ÿ ����.
 * n(10����)�� 1�� ���ְ� �� �������� �̿��� ���
 * n�� n-1�� 3���� ���� ��
 * 
 * �� ������ �ݺ�
 * 
 * */

public class World124 {

	public static void main(String[] args) {
		for (int i = 1; i < 12; i++) {
			solution(i);
		}
		

	}
	
	
	public static  String solution(int n) {
		String answer = "";
		String[] oneTwoFour = new String[] {"1","2","4"};
		while(n>0) {
			answer = oneTwoFour[(n-1)%3] + answer;
			n = (n-1)/3;			
		}
		
		System.out.println(answer);
		return answer;
	}

}
