package level3;

import java.util.Arrays;
import java.util.Comparator;

public class DiskController2 {

	public static void main(String[] args) {
		//System.out.println(solution(new int[][] {{0,3}, {1,9}, {2,6}}));
		
		//System.out.println(solution(new int[][] {{0, 9}, {0, 4}, {0, 5}, {0, 7}, {0, 3}}));

		System.out.println(solution(new int[][] {{1, 9}, {1, 4}, {1, 5}, {1, 7}, {1, 3}}));
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
        
        println(jobs);
        
        return requestTime(jobs);
    }

	private static int requestTime(int[][] jobsEnd) {
		int time =0;
		for(int i=0 ; i <jobsEnd.length-1 ; i++) {
			jobsEnd[i+1][0] += jobsEnd[i][1];
			jobsEnd[i+1][1] += jobsEnd[i][1];
			time += jobsEnd[i][1] - jobsEnd[i][0];
		}
		time += jobsEnd[jobsEnd.length-1][1] - jobsEnd[jobsEnd.length-1][0];
		return time/jobsEnd.length;
	}

	private static void println(int[][] jobs) {
		for(int i=0 ; i<jobs.length ; i++) {
			System.out.print(Arrays.toString(jobs[i]) +", ");
		}
		System.out.println();
	}

}
