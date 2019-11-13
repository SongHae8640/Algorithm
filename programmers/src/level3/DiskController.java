package level3;

/*
 * ��ũ ��Ʈ�ѷ�
 * https://programmers.co.kr/learn/courses/30/lessons/42627
 * 
 * 
 * ������ ���� �������� �����ϸ� ���� �� �˾Ҵµ� ���� �ƴϿ���.
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
        
        //������ �ð� �������� ����
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
