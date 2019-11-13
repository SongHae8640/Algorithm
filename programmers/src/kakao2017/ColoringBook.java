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
		int x;		//컬러링북의 x좌표
		int y;		//컬러링북의 y좌표
		
		int maxLandArea=-1;
		int landAreaSize=0;
		
		
		for(y = 0 ; y < m ; y++) {
			for(x = 0 ; x < n ; x ++) {
				if(picture[y][x] != 0) {
					landAreaSize++;
					tempLandArea = 0;	//면적을 0으로 초기화
					findSameColor(y,x, picture, picture[y][x]);
					if(maxLandArea < tempLandArea) maxLandArea = tempLandArea;
				}
			}
		}
		
		System.out.println(landAreaSize +", "+ maxLandArea);
		
		//리스트의 사이즈(영역의 개수), 리스트의 첫번째 값(가장 넓은 영역의 넓이)를 반환
		return new int[]{landAreaSize , maxLandArea}; 
	 }
	  
	private static void findSameColor(int tempY, int tempX, int[][] picture, int thisPointcolorNum) {
		tempLandArea++;
		picture[tempY][tempX] =0;
		
		//상하좌우로 같은 컬러가 있는지 확인하고 있다면 그 점에서도 같은 점을 확인
		
		//위쪽 확인
		if((tempY-1>=0)&&picture[tempY-1][tempX] == thisPointcolorNum) {
			findSameColor(tempY-1, tempX,picture , thisPointcolorNum);
		}	
		
		//아래쪽 확인
		if((tempY+1<picture.length)&&picture[tempY+1][tempX] == thisPointcolorNum) {
			findSameColor(tempY+1, tempX,picture, thisPointcolorNum);
		}	
		
		//오른쪽 확인
		if((tempX+1<picture[0].length)&&picture[tempY][tempX+1] == thisPointcolorNum) {
			findSameColor(tempY, tempX+1,picture, thisPointcolorNum);
		}	
		
		//왼쪽 확인
		if((tempX-1>=0)&&picture[tempY][tempX-1] == thisPointcolorNum) {
			findSameColor(tempY, tempX-1,picture, thisPointcolorNum);
		}		
	}

//	//면적의 넓이순으로 정렬(내림차순)
//	static Comparator<Integer> compAreaDesc = new Comparator<Integer>() {
//		public int compare(Integer a, Integer b){
//			return b-a;
//		}
//	};	
}
