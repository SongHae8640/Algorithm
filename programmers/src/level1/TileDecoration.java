package level1;

public class TileDecoration {

	public static void main(String[] args) {
		System.out.println(solution(5));
		System.out.println(solution(6));

	}
	
	public static long solution(int N) {
		long width = 1;
		long height = 1;
		
		for(int i = 1 ; i < N ; i ++) {
			if(i%2==0) {
				height = height + width;
			}else {
				width = width + height;
			}
		}
		
		return (width + height)*2;
	}

}


/*
 * 출처 : https://programmers.co.kr/learn/courses/30/lessons/43104
 * 
테스트 1 〉	통과 (0.86ms, 52.6MB)
테스트 2 〉	통과 (0.84ms, 52.5MB)
테스트 3 〉	통과 (0.79ms, 52.8MB)
테스트 4 〉	통과 (0.76ms, 52.7MB)
테스트 5 〉	통과 (0.81ms, 52.6MB)
테스트 6 〉	통과 (0.82ms, 52.5MB)
테스트 7 〉	통과 (0.87ms, 52.1MB)
테스트 8 〉	통과 (0.83ms, 50.4MB)
효율성  테스트
테스트 1 〉	통과 (0.52ms, 52.4MB)
테스트 2 〉	통과 (0.80ms, 52.4MB)
테스트 3 〉	통과 (0.55ms, 50.8MB)
테스트 4 〉	통과 (0.58ms, 51.2MB)
 * 
 * */