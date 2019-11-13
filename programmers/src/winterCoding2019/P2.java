package winterCoding2019;

import java.util.ArrayList;
import java.util.Arrays;

public class P2 {
	public static void main(String[] args) {
		solution(3);

	}
	
	public static int[] solution(int n) {
		int[] answer = new int[(int) (Math.pow(2, n)-1)];
		ArrayList<Integer> paper = new ArrayList<Integer>();
		paper.add(0);
		if(n==1) {
			
		}else {
			for (int i = 0; i < n; i++) {
				int paperSize = paper.size();
				paper.add(0);
				for (int j = paperSize-1; j >= 0; j--) {
					if(paper.get(j) ==0) {
						paper.add(1);
					}else {
						paper.add(0);
					}
				}
			}
		}
		
		
		for (int i = 0; i < answer.length; i++) {
			answer[i] = paper.get(i);
		}
		System.out.println(Arrays.toString(answer));
		
		return answer;
	}
}


/*
 * 
 * 
���簢�� ���̸� n�� �������� �մϴ�. �̶�, �׻� ������ ������ �������� ���� �����ϴ�. ������ n = 2�� ����� �����Դϴ�.

image

���� ������ ������ �������� �����ϴ�.

image

�ٽ� ������ ������ �������� �����ϴ�.

image

���̸� ��� ���� �Ŀ��� ���̸� ���� ��Ĩ�ϴ�. ���̸� ��ĥ ���� ���̸� ���� ����� �������� ���ļ� ó�� �����ִ� ���� ���� ���°� �ǵ��� �մϴ�. ���� ���� �� �� ���� �� ���̸� ��ġ�� �Ʒ� �׸��� ���� ���̿� ���� ������ ����� �˴ϴ�.

image

�� �׸����� �� ����� ���� �κ��� ����(0)����, �� ����� ���� �κ��� �Ǽ�(1)���� ǥ���߽��ϴ�.

���̸� ���� Ƚ�� n�� �Ű������� �־��� ��, ���̸� ���ݾ� n�� ���� �� ��� ������ �� ����� ���� �κ��� ����� �迭�� ��� return �ϵ��� solution �Լ��� �ϼ����ּ���.

���ѻ���
���̸� ���� Ƚ�� n�� 1 �̻� 20 ������ �ڿ����Դϴ�.
���̸� ������ �� �� ���� ������ �� ����̸� 0, �� ����̸� 1�� ��Ÿ���ϴ�.
���� ������ ���� ������ ������� �迭�� ��� return ���ּ���.
����� ��
n	result
1	[0]
2	[0,0,1]
3	[0,0,1,0,0,1,1]
����� �� ����
����� �� #1
������ ������ ������ �������� �ѹ� ������ ��� �Ʒ� �׸��� ���� ������ ����ϴ�.

image

���� [0]�� return �ϸ� �˴ϴ�.

����� �� #2
������ ���ÿ� �����ϴ�.

����� �� #3
���̸� ���ݾ� �� �� ���� �� �ٽ� ��ġ�� �Ʒ� �׸��� ���� ������ ����ϴ�.

image

���� [0,0,1,0,0,1,1]�� return �ϸ� �˴ϴ�.
 * */
