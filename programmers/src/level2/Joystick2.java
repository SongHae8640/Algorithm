package level2;

public class Joystick2 {

	public static void main(String[] args) {
		//System.out.println(solution("JEROEN"));
		System.out.println(solution("AAABAAA"));

	}
	
	public static int solution(String name) {
		int answer = 0;
		int[] moveCount = {0,1,2,3,4,5,6,7,8,9,10,11,12,13,12,11,10,9,8,7,6,5,4,3,2,1};
		char[] nameArr = name.toCharArray();
		for(int i = 0 ; i < nameArr.length ; i++) {
			answer +=moveCount[nameArr[i]-'A'];
			//System.out.println(moveCount[nameArr[i]-'A']);
		}
		
		//오른쪽으로 이동했을때 빼야할 숫자
		int rightMinus =0;
		for(int i =nameArr.length-1 ; i > 0 ; i--) {
			if(moveCount[nameArr[i]-'A'] ==0) {
				rightMinus++;
			}else {
				break;
			}
		}
		
		//왼쪽으로 이동했을때 빼야할 숫자
		int leftMinus =0;
		for(int i =1 ; i < nameArr.length ; i++) {
			if(moveCount[nameArr[i]-'A'] ==0) {
				leftMinus++;
			}else {
				break;
			}
		}
		
		//중간에 하나빼고 다 A인 경우
		int minus3 =0;
		System.out.println(rightMinus+","+ rightMinus);
		if((rightMinus == rightMinus-1)){
			return answer +nameArr.length-1-rightMinus*2+1;
		}
		

        
        return answer +nameArr.length-1-Integer.max(rightMinus, rightMinus);
    }

}
