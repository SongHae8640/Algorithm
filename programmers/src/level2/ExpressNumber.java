package level2;

public class ExpressNumber {

	public static void main(String[] args) {
		System.out.println(solution(15));

	}
	
	
	public static int solution(int n) {
		//표현 방법의 개수
		//n = n 으로 표현 할 수 있기 때문에  1부터시작
		int wayNum = 1;	
		
		// 연속한 자연수의 첫번째 값은 1부터 n/2까지 진행
		//n을 제외하고 n을 표현할 수 있는 가장 큰 수는 n/2+1
		//하지만 가장 큰수를 포함하는 표현 방법 중 가장 작은 수는 n/2
		// ex) 15 = 7+8 (가장 큰수는 15/2+1 = 8, 가장 큰수를 포함 하는 표현 법중 가장 작은 수는 15/2 =7
		for(int firstSequenceNum = 1 ; firstSequenceNum <= n/2 ; firstSequenceNum++) {
			//firstSequenceNum으로 시작하는 연속한 자연수가 
			//표현가능하면 +1, 불가능이면 +0
			wayNum += expressibleNum(firstSequenceNum,n);
		}
		
		return wayNum;
	}

	//firstSequenceNum부터 시작하는 연속된 자연수로 n을 표현할 수 있는지 알 수 있는 메서드
	//표현 가능하면 1, 불가능하면 0을 return 한다.
	private static int expressibleNum(int firstSequenceNum, int n) {
		//연속된 자연수를 누적할 변수 
		//n이 10,000이사의 자연수여서 누적값도 10,000과 가깝기 때문에 int형으로 선언
		int sumOfSequenceNum = 0;
		
		//n 보다 누적값이 작을때 까지 반복
		while( sumOfSequenceNum < n) {
			//시작값을 누적 값에 더해준다
			sumOfSequenceNum +=firstSequenceNum;
			
			//시작값을 +1시켜준다.
			firstSequenceNum++;
			
		}//누적값이 n과 같거나 클때 while문 탈출

		//누적값이 n과 같으면 1, 아니면 0 반환
		if(sumOfSequenceNum == n) return 1;
		else return 0;
	}

}
