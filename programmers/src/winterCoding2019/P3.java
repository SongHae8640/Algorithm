package winterCoding2019;


public class P3 {

	public static void main(String[] args) {
		solution(new int[][] {{1, 4, 8, 10}, {5, 5, 5, 5}, {10, 10, 10, 10}, {10, 10, 10, 20}}, 3);
		//solution(new int[][] {{10, 11, 10, 11}, {2, 21, 20, 10}, {1, 20, 21, 11}, {2, 1, 2, 1}}, 3);
		

	}
	
	static boolean isVisit[][]; 
	static int[][] area;
	
	static int gHeight;
	static int areaNum=1;
	static int minCost;
	public static int solution(int[][] land, int height) {
		int answer = 0;
        gHeight =height;
        isVisit = new boolean[land.length][land[0].length];
        area = new int[land.length][land[0].length];
        
        for (int i = 0; i < land.length; i++) {
			for (int j = 0; j < land[i].length; j++) {
				if(!isVisit[i][j]) {
					dfs(i,j, land);
					areaNum++;
				}
				
			}
		}
        
        //각 영역으로 이동하는데 걸리는 비용 계산
        for(int i = 1 ; i < areaNum+1 ; i++) {
        	minCost = Integer.MAX_VALUE;
        	
        	//i-1 area에서 i 로 이동하는데 걸리는 최소 사다리 비용을 찾아라
        	findMinCost(i, land);
        	
        	answer +=minCost;
        }
        
        return answer;
    }

	private static void findMinCost(int areaNum, int[][] land) {
		for (int i = 0; i < area.length; i++) {
			for (int j = 0; j < area[i].length; j++) {
				if(area[i][j]==areaNum-1) {
					//동서남북
					
					//동
					if(j+1 < area[i].length &&  area[i][j+1] == areaNum) {
						if(Math.abs(land[i][j+1] - land[i][j]) < minCost) {
							minCost = Math.abs(land[i][j+1] - land[i][j]);
						} 
					}
					
					//서
					if(j-1 >=0 &&  area[i][j-1] == areaNum) {
						if(Math.abs(land[i][j-1] - land[i][j]) < minCost) {
							minCost = Math.abs(land[i][j-1] - land[i][j]);
						} 
					}
					
					//남
					if(i-1 >=0 &&  area[i-1][j] == areaNum) {
						if(Math.abs(land[i-1][j] - land[i][j]) < minCost) {
							minCost = Math.abs(land[i-1][j] - land[i][j]);
						} 
					}
			
					
					//북
					if(i+1 < area.length &&  area[i+1][j] == areaNum) {
						if(Math.abs(land[i+1][j] - land[i][j]) < minCost) {
							minCost = Math.abs(land[i+1][j] - land[i][j]);
						} 
					}
				}
			}
		}
		
	}

	private static void dfs(int y, int x, int[][] land) {
		isVisit[y][x] = true;
		area[y][x] = areaNum;
		//4방향으로 이동
		//남
		if(y-1 >=0 && !isVisit[y-1][x] && Math.abs(land[y-1][x] - land[y][x]) <=gHeight) {
			dfs(y-1, x, land);
		}
		
		//동
		if(x+1 < isVisit[0].length && !isVisit[y][x+1] && Math.abs(land[y][x+1] - land[y][x]) <=gHeight) {
			dfs(y, x+1, land);
		}

		//서
		if(x-1>=0 && !isVisit[y][x-1] && Math.abs(land[y][x-1] - land[y][x]) <=gHeight) {
			dfs(y, x-1, land);
		}

		//북
		if(y+1 <isVisit.length && !isVisit[y+1][x] && Math.abs(land[y+1][x] - land[y][x]) <=gHeight) {
			System.out.println(land[y+1][x] - land[y][x]);
			dfs(y+1, x, land);
		}
		
		
	}
	

}


/*
N x N 크기인 정사각 격자 형태의 지형이 있습니다. 각 격자 칸은 1 x 1 크기이며, 숫자가 하나씩 적혀있습니다. 격자 칸에 적힌 숫자는 그 칸의 높이를 나타냅니다.

이 지형의 아무 칸에서나 출발해 모든 칸을 방문하는 탐험을 떠나려 합니다. 칸을 이동할 때는 상, 하, 좌, 우로 한 칸씩 이동할 수 있는데, 현재 칸과 이동하려는 칸의 높이 차가 height 이하여야 합니다. 높이 차가 height 보다 많이 나는 경우에는 사다리를 설치해서 이동할 수 있습니다. 이때, 사다리를 설치하는데 두 격자 칸의 높이차만큼 비용이 듭니다. 따라서, 최대한 적은 비용이 들도록 사다리를 설치해서 모든 칸으로 이동 가능하도록 해야 합니다. 설치할 수 있는 사다리 개수에 제한은 없으며, 설치한 사다리는 철거하지 않습니다.

각 격자칸의 높이가 담긴 2차원 배열 land와 이동 가능한 최대 높이차 height가 매개변수로 주어질 때, 모든 칸을 방문하기 위해 필요한 사다리 설치 비용의 최솟값을 return 하도록 solution 함수를 완성해주세요.

제한사항
land는 N x N크기인 2차원 배열입니다.
land의 최소 크기는 4 x 4, 최대 크기는 300 x 300입니다.
land의 원소는 각 격자 칸의 높이를 나타냅니다.
격자 칸의 높이는 1 이상 10,000 이하인 자연수입니다.
height는 1 이상 10,000 이하인 자연수입니다.
입출력 예
land	height	result
[[1, 4, 8, 10], [5, 5, 5, 5], [10, 10, 10, 10], [10, 10, 10, 20]]	3	15
[[10, 11, 10, 11], [2, 21, 20, 10], [1, 20, 21, 11], [2, 1, 2, 1]]	1	18
입출력 예 설명
입출력 예 #1

각 칸의 높이는 다음과 같으며, 높이차가 3 이하인 경우 사다리 없이 이동이 가능합니다.

land_ladder_5.png

위 그림에서 사다리를 이용하지 않고 이동 가능한 범위는 같은 색으로 칠해져 있습니다. 예를 들어 (1행 2열) 높이 4인 칸에서 (1행 3열) 높이 8인 칸으로 직접 이동할 수는 없지만, 높이가 5인 칸을 이용하면 사다리를 사용하지 않고 이동할 수 있습니다.

따라서 다음과 같이 사다리 두 개만 설치하면 모든 칸을 방문할 수 있고 최소 비용은 15가 됩니다.

높이 5인 칸 → 높이 10인 칸 : 비용 5
높이 10인 칸 → 높이 20인 칸 : 비용 10
입출력 예 #2

각 칸의 높이는 다음과 같으며, 높이차가 1 이하인 경우 사다리 없이 이동이 가능합니다.

land_ladder3.png

위 그림과 같이 (2행 1열) → (1행 1열), (1행 2열) → (2행 2열) 두 곳에 사다리를 설치하면 설치비용이 18로 최소가 됩니다.
 * */