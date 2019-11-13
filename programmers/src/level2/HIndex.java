package level2;

import java.util.Arrays;

public class HIndex {

	public static void main(String[] args) {
		System.out.println(solution(new int[] {3,0,6,1,5}));

	}

    public static int solution(int[] citations) {
        int answer = 0;
        Arrays.sort(citations);
        int hIdx = citations[citations.length-1];
        while(hIdx >0) {
        	for (int i = citations.length ;  i >=0 ; i--) {
        		System.out.println("hIdx" +": "+hIdx+", "+(citations.length -(i))+", " +(i));
        		if((citations.length -(i)) >=hIdx && (i) <= hIdx) {
        			return hIdx;
        		}
        	}
        	hIdx--;
        	System.out.println();
        }
        
        return 0;
    }
}
