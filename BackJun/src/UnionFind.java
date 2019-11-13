
public class UnionFind {
	
	static int n;
	static int[] parents;
	

	public static void main(String[] args) {
		n= 10;
		parents = new int[n+1];
		
		System.out.println("연결절");
		
		for (int i = 1; i <= n; i++) {
			parents[i] = i;
			System.out.print(parents[i] +" ");
		}
		System.out.println();
		
		unionParent(parents, 1, 2);
		unionParent(parents, 2, 3);
		unionParent(parents, 3, 4);
		unionParent(parents, 4, 5);
		unionParent(parents, 5, 6);
		unionParent(parents, 6, 7);
		unionParent(parents, 7, 8);
		unionParent(parents, 9, 10);
		
		System.out.println("연결 후");
		for (int i = 1; i <= n; i++) {
			parents[i] = i;
			System.out.print(parents[i] +" ");
		}
			
		

	}
	
	public static int getParent(int[] parents, int x) {
		if(parents[x] == x) return x;
		return getParent(parents, parents[x]);
	}
	
	public static void unionParent(int[] parents, int x, int y) {
		x = getParent(parents, x);
		y = getParent(parents, y);
		
		//더 작은 값으로 부모 노드 설정
		if(x < y) {
			parents[y] = x;
		}else {
			parents[x] = y;
		}
	}
	
	public static boolean isSameParent(int[] parents, int x, int y) {
		if(parents[x] == parents[y]) return true;
		return false;
	}

	

}
