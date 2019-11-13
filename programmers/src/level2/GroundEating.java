package level2;

public class GroundEating {

	public static void main(String[] args) {
		int[][] land  = {{9, 5, 2, 3}, {9, 8, 6, 7}, {8, 9, 7, 1}, {100, 9, 8, 1}};
		System.out.println(solution(land));

	}
	
	
    public static int solution(int[][] land) {

        for(int row = 0 ; row < land.length-1 ; row ++) {
        	land[row+1][0] += Math.max(land[row][1], Math.max(land[row][2], land[row][3]));
        	land[row+1][1] += Math.max(land[row][0], Math.max(land[row][2], land[row][3]));
        	land[row+1][2] += Math.max(land[row][0], Math.max(land[row][1], land[row][3]));
        	land[row+1][3] += Math.max(land[row][0], Math.max(land[row][1], land[row][2]));
        }
        return Math.max(Math.max(land[land.length-1][0], land[land.length-1][1]), Math.max(land[land.length-1][2], land[land.length-1][3]));
    }
        
}
