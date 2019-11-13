package kakao2017;


public class ColoringBook {

	static int tempLandArea;
	public static void main(String[] args) {
		//solution(6, 4, new int[][]{{1, 1, 1, 0}, {1, 2, 2, 0}, {1, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 3}, {0, 0, 0, 3}});
		
		
		int[][] apech = new int[][] {	{0,0,0,0,0,0,0,1,1,0,0,0,0,0,0,0},
										{0,0,0,0,0,0,1,1,1,1,0,0,0,0,0,0},
										{0,0,0,0,1,1,1,1,1,1,1,1,0,0,0,0},
										{0,0,0,1,1,1,1,1,1,1,1,1,1,0,0,0},
										{0,0,1,1,1,1,1,1,1,1,1,1,1,1,0,0},
										{0,1,1,1,1,2,1,1,1,1,2,1,1,1,1,0},
										{0,1,1,1,2,1,2,1,1,2,1,2,1,1,1,0},
										{0,1,1,1,1,1,1,1,1,1,1,1,1,1,1,0},
										{0,1,3,3,3,1,1,1,1,1,1,3,3,3,1,0},
										{0,1,1,1,1,1,2,1,1,2,1,1,1,1,1,0},
										{0,0,1,1,1,1,1,2,2,1,1,1,1,1,0,0},
										{0,0,0,1,1,1,1,1,1,1,1,1,1,0,0,0},
										{0,0,0,0,1,1,1,1,1,1,1,1,0,0,0,0},};
		solution(apech.length, apech[0].length, apech);
	}
	
	public static int[] solution(int m, int n, int[][] picture) {
		int x;		//�÷������� x��ǥ
		int y;		//�÷������� y��ǥ
		
		int maxLandArea=-1;
		int landAreaSize=0;
		
		
		for(y = 0 ; y < m ; y++) {
			for(x = 0 ; x < n ; x ++) {
				if(picture[y][x] != 0) {
					landAreaSize++;
					tempLandArea = 0;	//������ 0���� �ʱ�ȭ
					findSameColor(y,x, picture, picture[y][x]);
					if(maxLandArea < tempLandArea) maxLandArea = tempLandArea;
				}
			}
		}
		
		System.out.println(landAreaSize +", "+ maxLandArea);
		
		//����Ʈ�� ������(������ ����), ����Ʈ�� ù��° ��(���� ���� ������ ����)�� ��ȯ
		return new int[]{landAreaSize , maxLandArea}; 
	 }
	  
	private static void findSameColor(int tempY, int tempX, int[][] picture, int thisPointcolorNum) {
		tempLandArea++;
		picture[tempY][tempX] =0;
		
		//�����¿�� ���� �÷��� �ִ��� Ȯ���ϰ� �ִٸ� �� �������� ���� ���� Ȯ��
		
		//���� Ȯ��
		if((tempY-1>=0)&&picture[tempY-1][tempX] == thisPointcolorNum) {
			findSameColor(tempY-1, tempX,picture , thisPointcolorNum);
		}	
		
		//�Ʒ��� Ȯ��
		if((tempY+1<picture.length)&&picture[tempY+1][tempX] == thisPointcolorNum) {
			findSameColor(tempY+1, tempX,picture, thisPointcolorNum);
		}	
		
		//������ Ȯ��
		if((tempX+1<picture[0].length)&&picture[tempY][tempX+1] == thisPointcolorNum) {
			findSameColor(tempY, tempX+1,picture, thisPointcolorNum);
		}	
		
		//���� Ȯ��
		if((tempX-1>=0)&&picture[tempY][tempX-1] == thisPointcolorNum) {
			findSameColor(tempY, tempX-1,picture, thisPointcolorNum);
		}		
	}

//	//������ ���̼����� ����(��������)
//	static Comparator<Integer> compAreaDesc = new Comparator<Integer>() {
//		public int compare(Integer a, Integer b){
//			return b-a;
//		}
//	};	
}
