package level2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.EmptyStackException;
import java.util.Stack;

public class FunctionDevelopment2 {

	public static void main(String[] args) {
		//solution(new int[] {93, 30, 55},new int[] {1, 30, 5} );
		solution(new int[] {95, 90, 99, 99, 80, 99},new int[] {1, 1, 1, 1, 1, 1} );	//[1, 3, 2]
	}
	
	
    public static int[] solution(int[] progresses, int[] speeds) {
    	
        for (int i = 0; i < speeds.length; i++) {
			progresses[i] = (int) Math.ceil(1.0*(100-progresses[i])/speeds[i]);
			System.out.print(progresses[i]+", ");
		}
        System.out.println();
        
        ArrayList<Integer> aList = new ArrayList<Integer>();
        
        int releaseCount = 1;
        int pivotNum = progresses[0];
        for (int i = 1; i < progresses.length; i++) {
			if(pivotNum >=progresses[i]) {
				releaseCount++;
			}else {
				pivotNum= progresses[i];
				aList.add(releaseCount);
				releaseCount=1;
			}
		}
        aList.add(releaseCount);
        int[] answer = new int[aList.size()];
        for (int i = 0; i < aList.size(); i++) {
        	answer[i] = aList.get(i);	
        	System.out.print(answer[i]+", ");
		}
        return answer;
    }

}
/**
 * 기능개발
 * https://programmers.co.kr/learn/courses/30/lessons/42586
 *
 * 정확성  테스트
 * 테스트 1 〉	통과 (0.35ms, 83.1MB)
 * 테스트 2 〉	통과 (0.36ms, 77.7MB)
 * 테스트 3 〉	통과 (0.43ms, 71.2MB)
 * 테스트 4 〉	통과 (0.25ms, 71.8MB)
 * 테스트 5 〉	통과 (0.21ms, 73.3MB)
 * 테스트 6 〉	통과 (0.22ms, 79.2MB)
 * 테스트 7 〉	통과 (0.28ms, 78.3MB)
 * 테스트 8 〉	통과 (0.20ms, 70.7MB)
 * 테스트 9 〉	통과 (0.25ms, 77.2MB)
 * 테스트 10 〉	통과 (0.43ms, 71.2MB)
 * 테스트 11 〉	통과 (0.21ms, 77.8MB)
 * 채점 결과
 * 정확성: 100.0
 * 합계: 100.0 / 100.0
 * */