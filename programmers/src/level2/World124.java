package level2;
/*
 * 3진법의 약간 업글 버전인듯
 * 10진법	:	1	2	3	4	5	6	7	8	9	10	11	12	13	14
 * 3진법 	: 	1	2	10	11	12	20	21	22	100	101	102	110	111	112
 * 123W	:	1	2	3	11	12	13	21	22	23	31	32	33	111	112
 * 124W	:	1	2	3	11	12	14	21	22	24	41	42	44	111	112
 * 
 * 위와 같이 123W는 3진법 보다 자릿수 늘어나는게 1 늦게 일어 나타 난다.
 * n(10진법)에 1을 빼주고 그 나머지를 이용해 계산
 * n은 n-1을 3으로 나눈 몫
 * 
 * 위 과정을 반복
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
