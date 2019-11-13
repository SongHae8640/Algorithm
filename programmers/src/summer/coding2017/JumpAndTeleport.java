package summer.coding2017;
/*
 * �������� �ʹ� ���� Ǯ�� ���ȳ�?
 * ������ Ǯ�� �ǰڴ� �;��µ� ������ �ǹ��ȴ�.
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
