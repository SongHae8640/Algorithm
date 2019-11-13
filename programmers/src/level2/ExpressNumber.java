package level2;

public class ExpressNumber {

	public static void main(String[] args) {
		System.out.println(solution(15));

	}
	
	
	public static int solution(int n) {
		//ǥ�� ����� ����
		//n = n ���� ǥ�� �� �� �ֱ� ������  1���ͽ���
		int wayNum = 1;	
		
		// ������ �ڿ����� ù��° ���� 1���� n/2���� ����
		//n�� �����ϰ� n�� ǥ���� �� �ִ� ���� ū ���� n/2+1
		//������ ���� ū���� �����ϴ� ǥ�� ��� �� ���� ���� ���� n/2
		// ex) 15 = 7+8 (���� ū���� 15/2+1 = 8, ���� ū���� ���� �ϴ� ǥ�� ���� ���� ���� ���� 15/2 =7
		for(int firstSequenceNum = 1 ; firstSequenceNum <= n/2 ; firstSequenceNum++) {
			//firstSequenceNum���� �����ϴ� ������ �ڿ����� 
			//ǥ�������ϸ� +1, �Ұ����̸� +0
			wayNum += expressibleNum(firstSequenceNum,n);
		}
		
		return wayNum;
	}

	//firstSequenceNum���� �����ϴ� ���ӵ� �ڿ����� n�� ǥ���� �� �ִ��� �� �� �ִ� �޼���
	//ǥ�� �����ϸ� 1, �Ұ����ϸ� 0�� return �Ѵ�.
	private static int expressibleNum(int firstSequenceNum, int n) {
		//���ӵ� �ڿ����� ������ ���� 
		//n�� 10,000�̻��� �ڿ������� �������� 10,000�� ������ ������ int������ ����
		int sumOfSequenceNum = 0;
		
		//n ���� �������� ������ ���� �ݺ�
		while( sumOfSequenceNum < n) {
			//���۰��� ���� ���� �����ش�
			sumOfSequenceNum +=firstSequenceNum;
			
			//���۰��� +1�����ش�.
			firstSequenceNum++;
			
		}//�������� n�� ���ų� Ŭ�� while�� Ż��

		//�������� n�� ������ 1, �ƴϸ� 0 ��ȯ
		if(sumOfSequenceNum == n) return 1;
		else return 0;
	}

}
