package skillCheck;

public class Fibonacci {

	public static void main(String[] args) {
		System.out.println(solution(4));

	}
	
	public static int solution(int n) {
		 n--;
	      long originalN = n+1;
	        long[][] matrix = { {1, 1}, {1, 0} };
	        long[][] ansMatrix = { {1, 0}, {0, 1} };

	        while(n>0){
	            if(n%2==1) ansMatrix = matrixMultiply(ansMatrix, matrix);
	            matrix = matrixMultiply(matrix, matrix);
	            n/=2;
	        }
	        if(originalN<3){
	            return 1;
	        }else{
	            return (int) ((ansMatrix[1][0]+ansMatrix[1][1])%1234567);
	        }

	    }

	    public static long[][] matrixMultiply(long[][] matrix1, long[][] matrix2){
	        int m1 = matrix1.length;
	        int n1 = matrix1[0].length;
	        int m2 = matrix2.length;
	        int n2 = matrix2[0].length;
	        long[][] temp = new long[m1][n2];

	        for(int i=0; i<m1; i++){
	            for(int j=0; j<n2; j++){
	                for(int k=0; k<n1; k++){
	                    temp[i][j] += matrix1[i][k]*matrix2[k][j];
	                }
	                temp[i][j]%=1234567;
	            }
	        }
	        return temp;
	    }
}
