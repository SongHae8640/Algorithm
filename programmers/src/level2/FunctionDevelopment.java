package level2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.EmptyStackException;
import java.util.Stack;

public class FunctionDevelopment {

	public static void main(String[] args) {
		solution(new int[] {93, 30, 55},new int[] {1, 30, 5} );

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
