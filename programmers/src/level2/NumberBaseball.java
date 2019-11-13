package level2;

import java.util.HashMap;
import java.util.HashSet;

public class NumberBaseball {

	public static void main(String[] args) {
		solution(new int[][] {{123, 1, 1}, {356, 1, 0}, {327, 2, 0}, {489, 0, 1}});

	}
	
	public static int solution(int[][] baseball) {
        HashSet<Integer> candidate = new HashSet<Integer>();
        //1~9에 해당하는 숫자만 넣기
        for(int i =111 ; i <1000 ; i++) { 
        	if(i %10 !=0) {
        		candidate.add(i);        		
        	}
        }
        
        for (int i = 0; i < baseball.length; i++) {
        	for (Integer integer : candidate) {
        		int ballCount = 0;
        		int strikeCount = 0;
        		
        		char[] candidateArr = Integer.toString(integer).toCharArray();
        		char[] computerArr = Integer.toString(baseball[i][0]).toCharArray();
        		
        		for(int candiIdx=0 ; candiIdx < 3 ; candiIdx++) {
        			for(int comIdx = 0; comIdx < 3 ; comIdx ++) {
        				if(candidateArr[candiIdx] == computerArr[comIdx]) {
        					if(candiIdx== comIdx) {
        						strikeCount++;
        					}else {
        						ballCount++;
        					}
        				} 
        			}
        		}
				
        		if(strikeCount !=baseball[i][1] || ballCount != baseball[i][2]) candidate.remove((int)integer);
        	}
		}
        
        return candidate.size();
    }

}
