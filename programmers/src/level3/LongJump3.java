package level3;
/*
 * f(n+2) = f(n+1) + f(n)
 * f(n+1) = f(n+1)
 * 
 *	{{1,1},{1,0}}^(n-2) * {1,2}
 *
 * https://www.nayuki.io/page/fast-fibonacci-algorithms
 */

public class LongJump3 {

	public static void main(String[] args) {
		System.out.println(solution(20));

	}
	
	public static long solution(int n) {
		if(n <= 1) return 1;
		if(n==2) return 2;
		
		long[][] matrix = {{1,1},{1,0}};
		long[] twoOne = {2,1};
		
		long[][] matrixN = matrix;
		for (int i = 1; i < n-2; i++) {
			matrixN = productMatrix(matrixN, matrix);
			
		}
		long answer = (matrixN[0][0]*2+matrixN[0][1])%1234567;
		return answer;
	}
	
	public static long[][] productMatrix(long[][] a,long[][] b){
		long[][] answer = new long[2][2];
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < 2; j++) {
				for (int k = 0; k < 2; k++) {
					answer[i][j] +=a[i][k]*b[k][j];	
				}
				answer[i][j]%=1234567;
			}	
		}
		return answer;
	}

}
