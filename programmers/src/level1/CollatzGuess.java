package level1;

public class CollatzGuess {

	public static void main(String[] args) {
		System.out.println(solution(626331));

	}
	
	public static int solution(int num) {
		int maxCount = 500;
		int i = 0;
		double tempNum = num;
		while(i <= 500) {
			if(tempNum ==1) {
				return i;
			}
			else if(tempNum%2 == 0) {
				tempNum = tempNum/2;
			}else {
				tempNum = tempNum*3 +1;
			}
			i++;
			
		}
		return -1;
		
	}

}
