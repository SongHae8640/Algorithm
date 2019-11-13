package level3;

public class LongJump2 {

	public static void main(String[] args) {
		System.out.println(solution(20));

	}
	
	public static long solution(int n) {
		if(n <= 2) return n;
		return (solution(n-2) + solution(n-1))%1234567;
	}

}
