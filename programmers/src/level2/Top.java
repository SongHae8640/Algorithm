package level2;

import java.util.Arrays;

public class Top {

	public static void main(String[] args) {
        //solution(new int[] {6,9,5,7,4});
        solution(new int[] {3,9,9,3,5,7,2});
        //solution(new int[] {1,5,3,6,7,6,5});

	}
	
    public static int[] solution(int[] heights) {
        int[] answer = new int[heights.length];
        int getIdx;
        for (int sendIdx = heights.length-1; sendIdx >=0 ; sendIdx--) {
			getIdx = sendIdx -1;
			while(getIdx >=0) {
				if(heights[sendIdx] < heights[getIdx]) {
					answer[sendIdx] = getIdx+1;
					break;
				}else {
					getIdx--;
				}
			}
		}
        return answer;
    }

}
