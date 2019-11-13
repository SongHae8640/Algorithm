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
        
        //�� �������� �̵��ϴµ� �ɸ��� ��� ���
        for(int i = 1 ; i < areaNum+1 ; i++) {
        	minCost = Integer.MAX_VALUE;
        	
        	//i-1 area���� i �� �̵��ϴµ� �ɸ��� �ּ� ��ٸ� ����� ã�ƶ�
        	findMinCost(i, land);
        	
        	answer +=minCost;
        }
        
        return answer;
    }

	private static void findMinCost(int areaNum, int[][] land) {
		for (int i = 0; i < area.length; i++) {
			for (int j = 0; j < area[i].length; j++) {
				if(area[i][j]==areaNum-1) {
					//��������
					
					//��
					if(j+1 < area[i].length &&  area[i][j+1] == areaNum) {
						if(Math.abs(land[i][j+1] - land[i][j]) < minCost) {
							minCost = Math.abs(land[i][j+1] - land[i][j]);
						} 
					}
					
					//��
					if(j-1 >=0 &&  area[i][j-1] == areaNum) {
						if(Math.abs(land[i][j-1] - land[i][j]) < minCost) {
							minCost = Math.abs(land[i][j-1] - land[i][j]);
						} 
					}
					
					//��
					if(i-1 >=0 &&  area[i-1][j] == areaNum) {
						if(Math.abs(land[i-1][j] - land[i][j]) < minCost) {
							minCost = Math.abs(land[i-1][j] - land[i][j]);
						} 
					}
			
					
					//��
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
		//4�������� �̵�
		//��
		if(y-1 >=0 && !isVisit[y-1][x] && Math.abs(land[y-1][x] - land[y][x]) <=gHeight) {
			dfs(y-1, x, land);
		}
		
		//��
		if(x+1 < isVisit[0].length && !isVisit[y][x+1] && Math.abs(land[y][x+1] - land[y][x]) <=gHeight) {
			dfs(y, x+1, land);
		}

		//��
		if(x-1>=0 && !isVisit[y][x-1] && Math.abs(land[y][x-1] - land[y][x]) <=gHeight) {
			dfs(y, x-1, land);
		}

		//��
		if(y+1 <isVisit.length && !isVisit[y+1][x] && Math.abs(land[y+1][x] - land[y][x]) <=gHeight) {
			System.out.println(land[y+1][x] - land[y][x]);
			dfs(y+1, x, land);
		}
		
		
	}
	

}


/*
N x N ũ���� ���簢 ���� ������ ������ �ֽ��ϴ�. �� ���� ĭ�� 1 x 1 ũ���̸�, ���ڰ� �ϳ��� �����ֽ��ϴ�. ���� ĭ�� ���� ���ڴ� �� ĭ�� ���̸� ��Ÿ���ϴ�.

�� ������ �ƹ� ĭ������ ����� ��� ĭ�� �湮�ϴ� Ž���� ������ �մϴ�. ĭ�� �̵��� ���� ��, ��, ��, ��� �� ĭ�� �̵��� �� �ִµ�, ���� ĭ�� �̵��Ϸ��� ĭ�� ���� ���� height ���Ͽ��� �մϴ�. ���� ���� height ���� ���� ���� ��쿡�� ��ٸ��� ��ġ�ؼ� �̵��� �� �ֽ��ϴ�. �̶�, ��ٸ��� ��ġ�ϴµ� �� ���� ĭ�� ��������ŭ ����� ��ϴ�. ����, �ִ��� ���� ����� �鵵�� ��ٸ��� ��ġ�ؼ� ��� ĭ���� �̵� �����ϵ��� �ؾ� �մϴ�. ��ġ�� �� �ִ� ��ٸ� ������ ������ ������, ��ġ�� ��ٸ��� ö������ �ʽ��ϴ�.

�� ����ĭ�� ���̰� ��� 2���� �迭 land�� �̵� ������ �ִ� ������ height�� �Ű������� �־��� ��, ��� ĭ�� �湮�ϱ� ���� �ʿ��� ��ٸ� ��ġ ����� �ּڰ��� return �ϵ��� solution �Լ��� �ϼ����ּ���.

���ѻ���
land�� N x Nũ���� 2���� �迭�Դϴ�.
land�� �ּ� ũ��� 4 x 4, �ִ� ũ��� 300 x 300�Դϴ�.
land�� ���Ҵ� �� ���� ĭ�� ���̸� ��Ÿ���ϴ�.
���� ĭ�� ���̴� 1 �̻� 10,000 ������ �ڿ����Դϴ�.
height�� 1 �̻� 10,000 ������ �ڿ����Դϴ�.
����� ��
land	height	result
[[1, 4, 8, 10], [5, 5, 5, 5], [10, 10, 10, 10], [10, 10, 10, 20]]	3	15
[[10, 11, 10, 11], [2, 21, 20, 10], [1, 20, 21, 11], [2, 1, 2, 1]]	1	18
����� �� ����
����� �� #1

�� ĭ�� ���̴� ������ ������, �������� 3 ������ ��� ��ٸ� ���� �̵��� �����մϴ�.

land_ladder_5.png

�� �׸����� ��ٸ��� �̿����� �ʰ� �̵� ������ ������ ���� ������ ĥ���� �ֽ��ϴ�. ���� ��� (1�� 2��) ���� 4�� ĭ���� (1�� 3��) ���� 8�� ĭ���� ���� �̵��� ���� ������, ���̰� 5�� ĭ�� �̿��ϸ� ��ٸ��� ������� �ʰ� �̵��� �� �ֽ��ϴ�.

���� ������ ���� ��ٸ� �� ���� ��ġ�ϸ� ��� ĭ�� �湮�� �� �ְ� �ּ� ����� 15�� �˴ϴ�.

���� 5�� ĭ �� ���� 10�� ĭ : ��� 5
���� 10�� ĭ �� ���� 20�� ĭ : ��� 10
����� �� #2

�� ĭ�� ���̴� ������ ������, �������� 1 ������ ��� ��ٸ� ���� �̵��� �����մϴ�.

land_ladder3.png

�� �׸��� ���� (2�� 1��) �� (1�� 1��), (1�� 2��) �� (2�� 2��) �� ���� ��ٸ��� ��ġ�ϸ� ��ġ����� 18�� �ּҰ� �˴ϴ�.
 * */