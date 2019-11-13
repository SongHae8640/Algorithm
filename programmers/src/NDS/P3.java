package NDS;

import java.util.ArrayList;

public class P3 {
	public static void main(String[] args) {
		System.out.println(solution(3,	5,	7,	1)); //4
		System.out.println(solution(3,	6,	9,	4)); //-1
	}
	
	static int answer = Integer.MAX_VALUE;
	static int globalD;
	
	public static int solution(int a, int b, int c, int d) {
		//답이 있는지 없는지 확인
		if(!isAnswer(a, b, c, d)) return -1;
//		globalD =d;		
//		
//        ArrayList<Beaker> beakers = new ArrayList<Beaker>();
//        beakers.add(new Beaker(a));
//        beakers.add(new Beaker(b));
//        beakers.add(new Beaker(c));
//        
//        dfs(beakers, 0);
//        
//        if(answer == Integer.MAX_VALUE) return -1;
        return answer;
    }

	//틀린가정
	private static boolean isAnswer(int a, int b, int c, int d) {
		int[] multiplyCase = new int[] {-1,0,1};
		
		for (int i = 0; i < multiplyCase.length; i++) {
			for (int j = 0; j < multiplyCase.length; j++) {
				for (int k = 0; k < multiplyCase.length; k++) {
					try {
						if(d%(multiplyCase[i]*a + multiplyCase[j]*b + multiplyCase[k]*c) ==0) return true;
					} catch (Exception e) {
						// TODO: handle exception
					}
					
				}
			}
		}
		return false;
	}

	private static void dfs(ArrayList<Beaker> beakers, int actionCount) {
		checkComplete(beakers,actionCount);
		
		//행동 한다!
		actionCount++;
		
		for (int i = 0; i < 3; i++) {
			if(beakers.get(i).isFull()) {
				
			}
			
			if(beakers.get(i).isEmpty()) {
				
			}
		}
		
		
		
	}

	private static void checkComplete(ArrayList<Beaker> beakers, int actionCount) {
		for (int i = 0; i < beakers.size(); i++) {
			if(beakers.get(i).amount == globalD && answer > actionCount) {
				answer = actionCount;
			}
		}
		
	}

}

class Beaker{
	int size;
	int amount;
	
	public Beaker(int size) {
		this.size = size;
		amount = 0;
	}
	
	public void fillUp() {
		this.amount = this.size;
	}
	
	public void empty() {
		this.amount = 0;
	}
	
	public void pure(Beaker otherBeaker) {
		//가득 채워진 경우 
		if(this.amount + otherBeaker.amount > this.size) {
			otherBeaker.amount -= this.size - this.amount;
			this.amount = this.size;
		}
		
		//다른 비커의 물을 다 사용한 경우
		else {
			this.amount += otherBeaker.amount;
			otherBeaker.amount = 0;
		}
	}
	
	public boolean isFull() {
		if(this.size == this.amount) return true;
		return false;
	}
	
	public boolean isEmpty() {
		if(this.amount ==0) return true;
		return false;
	}
}


/*
 * 
 * 테스트 11, 15,16,17 은 -1
 * */