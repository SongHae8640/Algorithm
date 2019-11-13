package kakao2017;

/**
 * �÷������� 2������ ������ ó���Ѵ�. �̸� �����ϱ� ���� 1���� ������ ó���ϴ� �����
 * ���� �� �̸� �������� 2���� ������ ó���غ����� �Ѵ�.
 */

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;

public class ColoringLine {

	
	public static void main(String[] args) {
		int[] testArr = new int[]{0,1, 1, 1, 0,1,1,2,3,2,1,0};
		solution(testArr.length, testArr);

	}
	
	public static int[] solution(int n, int[] line) {
		//������ ���̸� ���� ����Ʈ
		List<Integer> landAreas = new LinkedList<Integer>();
		
		int colorNum = -1;	//�÷��� ����
		int x = 0;		//�÷��������� idx
		int tempArea =0;
		
		
		while(x < n) {
			//�÷��� �ٸ���
			if(line[x] != colorNum){
				if(tempArea !=0) {
					landAreas.add(tempArea);	//���� ������ ũ�⸦ ����Ʈ�� �ְ�
					tempArea =0;				//���� �ʱ�ȭ	
				}
				colorNum = line[x];			//�÷��� �ٲ��ְ�
										
			}
			
			if(line[x]!=0){
				tempArea++;
			}
			x++;							//��ġ �̵�
		}
			
		//������ ���� ������ �������� ����
		landAreas.sort(compAreaDesc);
		
		System.out.println(landAreas.toString());
		
		//����Ʈ�� ������(������ ����), ����Ʈ�� ù��° ��(���� ���� ������ ����)�� ��ȯ
		return new int[]{landAreas.size() , landAreas.get(0)}; 
	 }
	  
	//������ ���̼����� ����(��������)
	static Comparator<Integer> compAreaDesc = new Comparator<Integer>() {
		public int compare(Integer a, Integer b){
			return b- a;
		}
	};
}
