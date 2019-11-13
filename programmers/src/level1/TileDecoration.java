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
 * ��ó : https://programmers.co.kr/learn/courses/30/lessons/43104
 * 
�׽�Ʈ 1 ��	��� (0.86ms, 52.6MB)
�׽�Ʈ 2 ��	��� (0.84ms, 52.5MB)
�׽�Ʈ 3 ��	��� (0.79ms, 52.8MB)
�׽�Ʈ 4 ��	��� (0.76ms, 52.7MB)
�׽�Ʈ 5 ��	��� (0.81ms, 52.6MB)
�׽�Ʈ 6 ��	��� (0.82ms, 52.5MB)
�׽�Ʈ 7 ��	��� (0.87ms, 52.1MB)
�׽�Ʈ 8 ��	��� (0.83ms, 50.4MB)
ȿ����  �׽�Ʈ
�׽�Ʈ 1 ��	��� (0.52ms, 52.4MB)
�׽�Ʈ 2 ��	��� (0.80ms, 52.4MB)
�׽�Ʈ 3 ��	��� (0.55ms, 50.8MB)
�׽�Ʈ 4 ��	��� (0.58ms, 51.2MB)
 * 
 * */