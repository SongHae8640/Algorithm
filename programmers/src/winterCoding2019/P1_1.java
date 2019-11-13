package winterCoding2019;

public class P1_1 {
	public static void main(String[] args) {
		System.out.println(solution(8, 12));
		System.out.println(solution(2, 12));
		System.out.println(solution(9, 6));
		System.out.println(solution(11, 3));
		

	}
	
	public static long solution(int w,int h) {
		
		//���ΰ� ��� ���ΰ� ª��
		long width = Long.max(w, h);
		long height = Integer.min(w, h);
		
		long answer = (width*height);
		
		double crossNum = 1.0*width/height;
		
		double crossSum = 0;
		long end;
		long start;
		for (int i = 0; i < height; i++) {
			end = (int) Math.ceil(crossSum +crossNum);
			start = (int) Math.floor(crossSum);
			
			answer -=(end-start);
			
			crossSum +=crossNum;		
		}
		
		
		return answer;
	}

}

/*
���� ���̰� Wcm, ���� ���̰� Hcm�� ���簢�� ���̰� �ֽ��ϴ�. ���̿��� ����, ���� ����� �����ϰ� ���� ���·� ���� �׾��� ������, ��� ����ĭ�� 1cm x 1cm ũ���Դϴ�. �� ���̸� ���� ���� ���� 1cm �� 1cm�� ���簢������ �߶� ����� �����̾��µ�, �������� �� ���̸� �밢�� ������ 2���� �մ� �������� �߶� ���ҽ��ϴ�. �׷��Ƿ� ���� ���簢�� ���̴� ũ�Ⱑ ���� �����ﰢ�� 2���� �������� �����Դϴ�. ���ο� ���̸� ���� �� ���� �����̱� ������, �� ���̿��� ���� ������ ����, ���� ����� �����ϰ� 1cm �� 1cm�� �߶� ����� �� �ִ� ��ŭ�� ����ϱ�� �Ͽ����ϴ�. ������ ���� W�� ������ ���� H�� �־��� ��, ����� �� �ִ� ���簢���� ������ ���ϴ� solution �Լ��� �ϼ��� �ּ���.

���ѻ���
W, H : 1�� ������ �ڿ���
����� ��
W	H	result
8	12	80
����� �� ����
����� �� #1
���ΰ� 8, ���ΰ� 12�� ���簢���� �밢�� �������� �ڸ��� �� 16�� ���簢���� ����� �� ���� �˴ϴ�. ���� ���簢�������� 96���� ���簢���� ���� �� �־����Ƿ�, 96 - 16 = 80 �� ��ȯ�մϴ�.

572957326.92.png
 * */
