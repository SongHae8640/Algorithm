package level3;

public class IntegerTriangle {

	public static void main(String[] args) {
		int[][] triangle = {{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}};
		System.out.println(solution(triangle));

	}
	
    public static int solution(int[][] triangle) {
    	if(triangle.length ==1) {
    		return triangle[0][0];
    	}
        for (int row = 1; row < triangle.length; row++) {
			for(int col = 0 ; col < triangle[row].length; col ++){
				if(col ==0) {
					triangle[row][col] += triangle[row-1][col];
				}else if(col == triangle[row].length-1) {
					triangle[row][col] += triangle[row-1][col-1];
				}else {
					triangle[row][col] += Math.max(triangle[row-1][col-1], triangle[row-1][col]);
				}
				 
			}
		}
        
        int maxNum = 0;
        for(int col = 0; col < triangle[triangle.length-1].length ; col++) {
        	maxNum = Math.max(maxNum, triangle[triangle.length-1][col]);
        }
        return maxNum;
    }
}
