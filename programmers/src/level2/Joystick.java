package level2;

public class Joystick {

	public static void main(String[] args) {
		//System.out.println(solution("JEROEN"));
		System.out.println(solution("AZAAAZ"));

	}
	
	public static int solution(String name) {
		
		int[] moveCount = {0,1,2,3,4,5,6,7,8,9,10,11,12,13,12,11,10,9,8,7,6,5,4,3,2,1};
		char[] nameArr = name.toCharArray();
		
		//모든 칸을 다 갈때 커서 이동 횠수
		int answer = nameArr.length-1;
		
		//모든 칸을 다 갔을때 알파벳 이동 횟수
		for(int i = 0 ; i < nameArr.length ; i++) {
			answer +=moveCount[nameArr[i]-'A'];
		}
		
		//좌측에 A가 많은 경우 -> 오른쪽에서 왼쪽으로 이동하는게 나은 경우
		int minus1 =0;
		for(int i =1 ; i < nameArr.length ; i++) {
			if(moveCount[nameArr[i]-'A'] ==0) {
				minus1++;
			}else {
				break;
			}
		}
		
		//우측에 A가 많은 경우 -> 왼쪽에서 오른쪽으로 이동하는게 나은 경우
		int minus2 =0;
		for(int i =nameArr.length-1 ; i > 0 ; i--) {
			if(moveCount[nameArr[i]-'A'] ==0) {
				minus2++;
			}else {
				break;
			}
		}
		
		//중간에 A가 많은 경우

        
        return answer -Integer.max(minus1, minus2);
    }

}
