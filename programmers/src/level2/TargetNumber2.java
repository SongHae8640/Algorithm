package level2;
/*
 * ����/�ʺ� �켱 Ž��(DFS/BFS)
 * https://programmers.co.kr/learn/courses/30/lessons/43165
 * 
 * 
 * ��͸� �̿��� �� ���� �ξ� ������.
�׽�Ʈ 1 ��	��� (93.99ms, 53.7MB)
�׽�Ʈ 2 ��	��� (94.76ms, 54.7MB)
�׽�Ʈ 3 ��	��� (1.57ms, 54MB)
�׽�Ʈ 4 ��	��� (3.01ms, 52.1MB)
�׽�Ʈ 5 ��	��� (15.36ms, 51.9MB)
�׽�Ʈ 6 ��	��� (1.89ms, 54.2MB)
�׽�Ʈ 7 ��	��� (1.59ms, 54.2MB)
�׽�Ʈ 8 ��	��� (4.90ms, 53.8MB)
 * */

import java.util.Arrays;

public class TargetNumber2 {
	static int answer = 0;
	public static void main(String[] args) {
		System.out.println(solution(new int[]{1, 1, 1, 1, 1}, 3));

	}
	
    public static int solution(int[] numbers, int target) {
    	int sum;
    	int tempI;
        for(int i=0; i<Math.pow(2,numbers.length); i++) {
        	sum = 0;
        	tempI =i;
        	for(int j =0; j <numbers.length; j++) {
        		if(tempI%2==0) {
        			System.out.print(numbers[j] +", ");
        			sum +=numbers[j];
        		} else {
        			System.out.print((numbers[j]*-1) +", ");
        			sum -=numbers[j];
        		}
        		tempI/=2;
        	}
        	
        	System.out.println(sum);
        	if(sum == target) {
        		answer++;
        	}
        }
		return answer;
    }
    

}
