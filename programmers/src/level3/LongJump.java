package level3;
/*
 * n���� 					1,1,...1,1 ����
 * Math.ceil(n/2.0)���� 	2,2,...2,2 ���� �ִ�(n%2 ==1 �̸� �ϳ��� 1
 * 
 * */
public class LongJump {

	public static void main(String[] args) {
		System.out.println(solution(5));

	}
	
	public static long solution(int n) {
		long answer = 0;
		int oneCount=n;
		int twoCount=0;
		for(int jumpCount=n;jumpCount >=Math.ceil(n/2.0); jumpCount--) {
			answer+=combination(oneCount+twoCount, twoCount);
			oneCount -=2;
			twoCount++;
		}
		return answer;
	}
	
	public static long combination(int n, int r) {
		return (long)(factorial(n)/(factorial(n-r)*factorial(r)));
	}
	
	public static long factorial(int number) {
	    long fact = 1;
	    for (int i = 2; i <= number; i++) {
	        fact *= i;
	    }
	    return fact;
	}

}
