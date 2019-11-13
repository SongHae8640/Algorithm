package level1;

import java.util.Arrays;

/* 탐욕법
* https://programmers.co.kr/learn/courses/30/lessons/42862
* 
* 체육복이 있는 학생 0, 없는 학생 -1, 여분으로 있는 학생 1로 계산 
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
        
        //0번 n+1 번을 가상으로 만듬
        int[] student = new int[n+2];
       

        //빌려줄 수 있는 학생을 표시
        for(int idx = 0 ; idx < reserve.length ; idx++){
        	student[reserve[idx]] +=1;
        }
        
        //잃어 버린 학생중에 여분이 있는 학생의 경우
        for(int idx = 0; idx < lost.length; idx++){
			student[lost[idx]] -=1;
        }        
        
        //잃어 버린 학생이 빌리기
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
        
        //체육 복이 있는 학생 수 계산
        for(int idx=1 ; idx <student.length-1; idx++) {
        	if(student[idx]!=-1) {
        		answer++;        		
        	}
        }
        
        return answer;
    }
}

