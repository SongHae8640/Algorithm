package level2;
/*
 * 깊이/너비 우선 탐색(DFS/BFS)
 * https://programmers.co.kr/learn/courses/30/lessons/43165
 * 
 * 
 * 재귀를 이용할 때 보다 훨씬 느리다.
테스트 1 〉	통과 (93.99ms, 53.7MB)
테스트 2 〉	통과 (94.76ms, 54.7MB)
테스트 3 〉	통과 (1.57ms, 54MB)
테스트 4 〉	통과 (3.01ms, 52.1MB)
테스트 5 〉	통과 (15.36ms, 51.9MB)
테스트 6 〉	통과 (1.89ms, 54.2MB)
테스트 7 〉	통과 (1.59ms, 54.2MB)
테스트 8 〉	통과 (4.90ms, 53.8MB)
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
