package level3;

/*
 * 디스크 컨트롤러
 * https://programmers.co.kr/learn/courses/30/lessons/42627
 * 
 * 
 * 끝나는 시점 기준으로 정렬하면 끝날 줄 알았는데 전혀 아니였다.
 * */

import java.util.Arrays;
import java.util.Comparator;

public class DiskController {

	public static void main(String[] args) {
		//System.out.println(solution(new int[][] {{0,3}, {1,9}, {2,6}}));
		
		System.out.println(solution(new int[][] {{0, 9}, {0, 4}, {0, 5}, {0, 7}, {0, 3}}));

	}
	
    public static int solution(int[][] jobs) {
        int answer = 0;
        
        //끝나는 시간 기준으로 정렬
        Arrays.sort(jobs, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[1] - o2[1];
			}
		});

        
        for(int i =0 ; i < jobs.length-1 ; i++) {
        	jobs[i+1][1] +=jobs[i][1];
        }
       
        
        for(int i =0 ; i < jobs.length ; i++) {
        	answer += jobs[i][1] - jobs[i][0];
        }
        
        return answer/jobs.length;
    }

}
