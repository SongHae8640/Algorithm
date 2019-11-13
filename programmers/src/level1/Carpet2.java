package level1;

import java.util.ArrayList;

public class Carpet2 {
	public static void main(String[] args) {
		solution(10,2);
		solution(8,1);
		solution(24, 24);

	}
	public static int[] solution(int brown, int red) {
		int[] answer = {0,0};

		//xy=brown+red
		//2x+2y-4=brown����
		int sum=brown+red;

  for(int i=1;i<brown;i++){
      for(int j=1;j<=i;j++){
          if(i*j==sum && (2*i)+(2*j)-4==brown){
              answer[0]=i;
              answer[1]=j;
              return answer;
          }
      }
  }

      return answer;
	}
	
	
	
}

/*
 *���� ��ó : https://programmers.co.kr/learn/courses/30/lessons/42842 
 *
 *red�� 1�϶��� �ؾ������� �׳� �о�!
 *
�׽�Ʈ 1 ��	��� (1.68ms, 53.3MB)
�׽�Ʈ 2 ��	��� (1.52ms, 52MB)
�׽�Ʈ 3 ��	��� (9.68ms, 52.2MB)
�׽�Ʈ 4 ��	��� (1.65ms, 52.8MB)
�׽�Ʈ 5 ��	��� (1.61ms, 50.4MB)
�׽�Ʈ 6 ��	��� (5.06ms, 52.3MB)
�׽�Ʈ 7 ��	��� (12.06ms, 50.3MB)
�׽�Ʈ 8 ��	��� (10.39ms, 50.2MB)
�׽�Ʈ 9 ��	��� (11.89ms, 53.1MB)
�׽�Ʈ 10 ����� (12.83ms, 52.7MB)
 */