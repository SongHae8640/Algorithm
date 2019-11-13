package NDS;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class P3_1 {
	public static void main(String[] args) {
		//System.out.println(solution(3,	5,	7,	1)); //4
		System.out.println(solution(3,	6,	9,	4)); //-1
	}
	
	static ArrayList<Case> cases = new ArrayList<Case>();
	static int answer = Integer.MAX_VALUE;
	static int globalD;
	
	public static int solution(int a, int b, int c, int d) {
		
		findCase(a,b,c,d);
		
		for (int i = 0; i < cases.size(); i++) {
			System.out.println((d/cases.get(i).sum)*cases.get(i).actionCount);
			if((d/cases.get(i).sum)*cases.get(i).actionCount < answer) {
				answer = (d/cases.get(i).sum)*cases.get(i).actionCount;
			}
		}
		
		if(answer == Integer.MAX_VALUE) return -1;
        return answer;
    }


	//틀린가정
		private static boolean findCase(int a, int b, int c, int d) {
			int[] multiplyCase = new int[] {-1,0,1};
			
			for (int i = 0; i < multiplyCase.length; i++) {
				for (int j = 0; j < multiplyCase.length; j++) {
					for (int k = 0; k < multiplyCase.length; k++) {
						int sum =multiplyCase[i]*a + multiplyCase[j]*b + multiplyCase[k]*c;
						if(sum > 0 && d >= sum &&  d%sum ==0) {
							cases.add(new Case(multiplyCase[i], multiplyCase[j], multiplyCase[k] ,sum));							
						}
						
					}
				}
			}
			return false;
		}

	

}

class Case{
	int[] multiplyNum;
	int actionCount =0;
	int sum;
	
	public Case(int a, int b, int c, int sum) {
		this.multiplyNum = new int[] {a,b,c};
		this.sum = sum;
		for (int i = 0; i < multiplyNum.length; i++) {
			if(multiplyNum[i] ==1) {
				actionCount +=1;
			}else if(multiplyNum[i] ==-1) {
				actionCount +=2;
			}
		}
	}
}


/*
 * 
 * 테스트 11, 15,16,17 은 -1
 * */