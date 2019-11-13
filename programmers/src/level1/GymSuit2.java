package level1;

import java.util.Arrays;

/* Ž���
* https://programmers.co.kr/learn/courses/30/lessons/42862
* 
* ü������ �ִ� �л� 0, ���� �л� -1, �������� �ִ� �л� 1�� ��� 
* */

import java.util.HashSet;

public class GymSuit2 {

	public static void main(String[] args) {

		System.out.println(solution(5, new int[]{2, 4}, new int[] {1, 3, 5}));
		System.out.println(solution(5, new int[]{2, 4}, new int[] {3}));
		System.out.println(solution(3, new int[]{3}, new int[] {1}));
		
	}
	
    public static int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        
        //0�� n+1 ���� �������� ����
        int[] student = new int[n+2];
       

        //������ �� �ִ� �л��� ǥ��
        for(int idx = 0 ; idx < reserve.length ; idx++){
        	student[reserve[idx]] +=1;
        }
        
        //�Ҿ� ���� �л��߿� ������ �ִ� �л��� ���
        for(int idx = 0; idx < lost.length; idx++){
			student[lost[idx]] -=1;
        }        
        
        //�Ҿ� ���� �л��� ������
        for(int idx=1 ; idx <student.length-1; idx++) {
        	
        	if(student[idx] ==-1) {
        		if(student[idx-1] ==1) {
        			student[idx-1] -=1;
        			student[idx] +=1;
        		}else if(student[idx+1] ==1) {
        			student[idx+1] -=1;
        			student[idx] +=1;
        		}   		
        	}
        }
        
        //ü�� ���� �ִ� �л� �� ���
        for(int idx=1 ; idx <student.length-1; idx++) {
        	if(student[idx]!=-1) {
        		answer++;        		
        	}
        }
        
        return answer;
    }
}

