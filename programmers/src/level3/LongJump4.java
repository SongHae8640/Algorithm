package level3;

public class LongJump4 {

	public static void main(String[] args) {
		System.out.println(solution(1));

	}
	
	public static long solution(int n) {
		if(n<=2) return n;
		long n1 = 1;
		long n2 = 2;
		long answer =1;
		for(int i = 0 ; i <n-2 ; i++) {
			answer = n1+n2;
			n1=n2;
			n2 = answer%1234567;
		}
		
		return answer%1234567;
	}

}
