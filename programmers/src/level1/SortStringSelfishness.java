package level1;

public class SortStringSelfishness {
	public static void main (String[] args) {
		
		//solution(new String[]{"sun", "bed", "car"}, 1);
		solution(new String[]{"abce", "abcd", "cdx"}, 2);
		
		
	}
	
	public static  String[] solution(String[] strings, int n) {
		String[] answer = {};
		String[][] matrix = new String[2][strings.length];
			
		for (int i = 0; i < matrix[0].length; i++) {
			matrix[0][i] =  strings[i].substring(n, n+1);
			matrix[1][i] = strings[i];
		}			
		
		return sortMatrix(matrix);
	}

	public static String[] sortMatrix(String[][] matrix) {
		String temp1, temp2 ;
		for (int i = 0; i < matrix[0].length-1; i++) {
			for (int j = i+1; j < matrix[0].length; j++) {
				if(matrix[0][i].charAt(0) > matrix[0][j].charAt(0)) {
					temp1 = matrix[0][i];
					matrix[0][i] = matrix[0][j];
					matrix[0][j] = temp1;
					
					temp2 = matrix[1][i];
					matrix[1][i] = matrix[1][j];
					matrix[1][j] = temp2;
				}
			}
		}
		
		return matrix[1];
	}

}

