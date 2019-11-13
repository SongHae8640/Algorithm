package summer.coding2017;
/*
 * 생각보다 너무 쉽게 풀어 버렸네?
 * 역으로 풀면 되겠다 싶었는데 스르륵 되버렸다.
 * */

public class JumpAndTeleport {
	public static void main(String[] args){
		
		System.out.println(solution(5));
		System.out.println(solution(6));
		System.out.println(solution(500));
		
	}
	
	
    public static int solution(int n) {
        int moveCnt =0;
        while(n >0) {
        	if(n%2==0) {
        		n /=2;
        	}else {
        		n--;
        		moveCnt++;
        	}
        }

        return moveCnt;
    }
}
