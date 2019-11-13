package webJobFair;

public class AvoidBishop {

	public static void main(String[] args) {
		solution(new String[] {"D5"});
		solution(new String[] {"D5", "E8", "G2"});

	}
	
	//0�̸� ������ �ʴ� ĭ, 1�̸� ������ ĭ
	static int[][] chessboard = new int[8][8];
	
    public static int solution(String[] bishops) {
        int answer = 0;
        
        
        for (int i = 0; i < bishops.length; i++) {
			//��� ��ġ
        	int xPosition = (int)(bishops[i].charAt(0)-'A');
        	int yPosition = new Integer(bishops[i].charAt(1)+"")-1;
        	
        	putBishop(xPosition,yPosition);
		}
        
        //������ �ʴ� ĭ ��
        for (int i = 0; i < chessboard.length; i++) {
			for (int j = 0; j < chessboard[i].length; j++) {
				if(chessboard[i][j] ==0) answer++;
			}
		}
        
        System.out.println(answer);
        return answer;
    }
	private static void putBishop(int xPosition, int yPosition) {
		//����� �ִ� ��ġ
		chessboard[xPosition][yPosition] =1;
		
		//����� ������ �� �ִ� ��ġ
		int xMovePosition;
		int yMovePosition;
		
		//4�������� ����
		//���� ���� ����
		xMovePosition = xPosition+1;
		yMovePosition = yPosition+1;
		while(xMovePosition<8 && yMovePosition <8) {
			chessboard[xMovePosition][yMovePosition]=1;
			xMovePosition++;
			yMovePosition++;
		}
		
		//���� ���� ����
		xMovePosition = xPosition+1;
		yMovePosition = yPosition-1;
		while(xMovePosition<8 && yMovePosition >=0) {
			chessboard[xMovePosition][yMovePosition]=1;
			xMovePosition++;
			yMovePosition--;
		}
		
		//���� ���� ����
		xMovePosition = xPosition-1;
		yMovePosition = yPosition+1;
		while(xMovePosition>=0 && yMovePosition <8) {
			chessboard[xMovePosition][yMovePosition]=1;
			xMovePosition--;
			yMovePosition++;
		}
		
		//���� ���� ����
		xMovePosition = xPosition-1;
		yMovePosition = yPosition-1;
		while(xMovePosition>=0 && yMovePosition >=0) {
			chessboard[xMovePosition][yMovePosition]=1;
			xMovePosition--;
			yMovePosition--;
		}
		
		
		
	}
}

/*
 * 
 * ü������ ���(Bishop)�� �Ʒ� �׸��� ���� �밢�� �������� �� ĭ�̵� �� ���� �̵��� �� �ֽ��ϴ�. ����, �� ���� �̵� ������ ĭ�� ü�� ���� �����ִٸ� �� ü�� ���� ���� �� �ֽ��ϴ�.

bishop1.png

8 x 8 ũ���� ü���� ���� ���� ���� ���(Bishop)�� �����ֽ��ϴ�. �̶�, ���(Bishop)�鿡�� �� ���� ������ �ʵ��� ���ο� ���� ���� �� �ִ� ��ĭ�� ������ ���Ϸ��� �մϴ�.

�� �׸����� ���� �׷��� ĭ�� ��󿡰� �� ���� ������ ĭ���̸�, ���� ü�� ���� ���� �� �ִ� ��ĭ ������ 50���Դϴ�.

8 x 8 ü���ǿ� ���� ����� ��ġ bishops�� �Ű������� �־��� ��, ��󿡰� �� ���� ������ �ʵ��� ���ο� ü�� ���� ���� �� �ִ� ��ĭ ������ return �ϵ��� solution �Լ��� �ϼ����ּ���.

���� ����
ü���ǿ� ���� ����� ��ġ bishops�� solution �Լ��� �Ű������� �־����ϴ�.

bishops�� ����� ��ġ�� ���ڿ� ���·� ����ִ� �迭�Դϴ�.
bishops�� ���̴� 1 �̻� 64 �����Դϴ�.
����� ���� ��ġ�� ���ĺ� �빮�ڿ� ���ڷ� ǥ���մϴ�.
���ĺ� �빮�ڴ� ���� ����, ���ڴ� ���� ���� ��ǥ�� ��Ÿ���ϴ�.
���� ��� �� �׸����� ����� �ִ� ĭ�� D5��� ǥ���մϴ�.
�� ĭ�� ���� ����� ���̰ų�, �߸��� ��ġ�� �־����� ���� �����ϴ�.
����� ��
bishops	return
[D5]	50
[D5, E8, G2]	42
*/
