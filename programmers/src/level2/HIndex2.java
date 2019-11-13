package level2;

import java.util.Arrays;
import java.util.Collections;

public class HIndex2 {

	public static void main(String[] args) {
		System.out.println(solution(new int[] {3,0,6,1,5}));
		System.out.println(solution(new int[] {20,19,18,1}));
	}

    public static int solution(int[] citations) {
        Arrays.sort(citations);
    	for (int i = 0; i < citations.length; i++) {
			if(citations[i] >= citations.length-i) {
				return citations.length-i;
			}
		}
        
        return 0;
    }
}

/**
 * ¼º°ø
 */
