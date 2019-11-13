package webJobFair;

public class AvoidBishop {

	public static void main(String[] args) {
		solution(new String[] {"D5"});
		solution(new String[] {"D5", "E8", "G2"});

	}
	
	//0이면 잡히지 않는 칸, 1이면 잡히는 칸
	static int[][] chessboard = new int[8][8];
	
    public static int solution(String[] bishops) {
        int answer = 0;
        
        
        for (int i = 0; i < bishops.length; i++) {
			//비숍 위치
        	int xPosition = (int)(bishops[i].charAt(0)-'A');
        	int yPosition = new Integer(bishops[i].charAt(1)+"")-1;
        	
        	putBishop(xPosition,yPosition);
		}
        
        //잡히지 않는 칸 수
        for (int i = 0; i < chessboard.length; i++) {
			for (int j = 0; j < chessboard[i].length; j++) {
				if(chessboard[i][j] ==0) answer++;
			}
		}
        
        System.out.println(answer);
        return answer;
    }
	private static void putBishop(int xPosition, int yPosition) {
		//비숍이 있는 위치
		chessboard[xPosition][yPosition] =1;
		
		//비숍이 움직일 수 있는 위치
		int xMovePosition;
		int yMovePosition;
		
		//4방향으로 제거
		//동북 방향 제거
		xMovePosition = xPosition+1;
		yMovePosition = yPosition+1;
		while(xMovePosition<8 && yMovePosition <8) {
			chessboard[xMovePosition][yMovePosition]=1;
			xMovePosition++;
			yMovePosition++;
		}
		
		//동남 방향 제거
		xMovePosition = xPosition+1;
		yMovePosition = yPosition-1;
		while(xMovePosition<8 && yMovePosition >=0) {
			chessboard[xMovePosition][yMovePosition]=1;
			xMovePosition++;
			yMovePosition--;
		}
		
		//서북 방향 제거
		xMovePosition = xPosition-1;
		yMovePosition = yPosition+1;
		while(xMovePosition>=0 && yMovePosition <8) {
			chessboard[xMovePosition][yMovePosition]=1;
			xMovePosition--;
			yMovePosition++;
		}
		
		//서남 방향 제거
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
 * 체스에서 비숍(Bishop)은 아래 그림과 같이 대각선 방향으로 몇 칸이든 한 번에 이동할 수 있습니다. 만약, 한 번에 이동 가능한 칸에 체스 말이 놓여있다면 그 체스 말을 잡을 수 있습니다.

bishop1.png

8 x 8 크기의 체스판 위에 여러 개의 비숍(Bishop)이 놓여있습니다. 이때, 비숍(Bishop)들에게 한 번에 잡히지 않도록 새로운 말을 놓을 수 있는 빈칸의 개수를 구하려고 합니다.

위 그림에서 원이 그려진 칸은 비숍에게 한 번에 잡히는 칸들이며, 따라서 체스 말을 놓을 수 있는 빈칸 개수는 50개입니다.

8 x 8 체스판에 놓인 비숍의 위치 bishops가 매개변수로 주어질 때, 비숍에게 한 번에 잡히지 않도록 새로운 체스 말을 놓을 수 있는 빈칸 개수를 return 하도록 solution 함수를 완성해주세요.

제한 조건
체스판에 놓인 비숍의 위치 bishops가 solution 함수의 매개변수로 주어집니다.

bishops는 비숍의 위치가 문자열 형태로 들어있는 배열입니다.
bishops의 길이는 1 이상 64 이하입니다.
비숍이 놓인 위치는 알파벳 대문자와 숫자로 표기합니다.
알파벳 대문자는 가로 방향, 숫자는 세로 방향 좌표를 나타냅니다.
예를 들어 위 그림에서 비숍이 있는 칸은 D5라고 표현합니다.
한 칸에 여러 비숍이 놓이거나, 잘못된 위치가 주어지는 경우는 없습니다.
입출력 예
bishops	return
[D5]	50
[D5, E8, G2]	42
*/
