package NDS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;

public class P2 {
	public static void main(String[] args) {
		System.out.println(solution(new int[] {2, 1, 3, 1, 4, 2, 1, 3}));
		System.out.println(solution(new int[] {1,2,3}));
	}
	
	public static int solution(int[] arr) {
        
        HashMap<Integer, Integer> couponBox = new HashMap<Integer, Integer>();
        
        ArrayList<Record> records = new ArrayList<Record>();
        
        
        for (int i = 0; i < arr.length; i++) {
        	if(couponBox.containsKey(arr[i])) {
        		records.add( new Record(arr[i], i-couponBox.get(arr[i])) );
        	}
        	
			couponBox.put(arr[i], i);
		}
        
        if(couponBox.size() == arr.length) return -1;
        
        Collections.sort(records, new Comparator<Record>() {

			@Override
			public int compare(Record o1, Record o2) {
				return o1.dateDiff - o2.dateDiff;
			}
		});
        
        return records.get(0).dateDiff;
    }
}

class Record{
	int customerNum;
	int dateDiff;
	
	
	public Record(int customerNum, int dateDiff) {
		super();
		this.customerNum = customerNum;
		this.dateDiff = dateDiff;
	}
	
	
}

/*
�����÷��̽� OO ���������� ���� �̺�Ʈ�� ���� �� �� ���� ���Ƿ� ������ Ŀ�� ���� ������ �߼��մϴ�. �迭 arr���� ������ ID�� �̺�Ʈ�� ��÷�� ������� ���������, �� ���� ID�� �ڿ����Դϴ�. ������ ��÷�� �� ��, ���� ���� �ߺ����� ��÷�� ���� ��ĥ ���� �ߺ� ��÷�ƴ����� return �ϵ��� solution �Լ��� �ۼ��ϼ���.
��, �ߺ����� ��÷�� ���� ���� ��� -1�� return �ϼ���.

���ѻ���
�迭�� ���̴� 1 �̻� 100,000 �����Դϴ�.
�迭�� ���Ҵ� 1 �̻� 1,000,000,000 ������ �ڿ����Դϴ�.
����� ��
arr	result
[2, 1, 3, 1, 4, 2, 1, 3]	2
[1, 2, 3]	-1
����� �� ����
����� �� #1
�迭�� [2, 1, 3, 1, 4, 2, 1, 3]�̶�� (arr[1], arr[3], arr[6])���� 1�� ���� �ߺ��ؼ� ��Ÿ���� 2�ϸ��� �ߺ����� ��÷�� ����� �ְ�, (arr[0], arr[5])���� 2�� ���� 5�ϸ��� �ߺ��ؼ� ��÷�� ����� �ֽ��ϴ�. �� (arr[2], arr[7])���� 3�� ���� 5�ϸ��� ��÷�Ǿ����ϴ�.
�� ��, 1�� ���� ���� ª�� 2�ϸ��� �ߺ� ��÷�Ǿ����Ƿ� 2�� return�մϴ�.

����� �� #2
�迭�� [1, 2, 3]�϶� �ߺ��ؼ� ��Ÿ���� ���� �����Ƿ� -1�� return�մϴ�.

�׽�Ʈ 1 ��	��� (1.16ms, 50.9MB)
�׽�Ʈ 2 ��	��� (0.83ms, 52.4MB)
�׽�Ʈ 3 ��	��� (1.55ms, 52.4MB)
�׽�Ʈ 4 ��	��� (1.44ms, 50.5MB)
�׽�Ʈ 5 ��	��� (1.27ms, 52.6MB)
�׽�Ʈ 6 ��	��� (1.30ms, 50.4MB)
�׽�Ʈ 7 ��	��� (1.62ms, 52.4MB)
�׽�Ʈ 8 ��	��� (1.57ms, 52.9MB)
�׽�Ʈ 9 ��	��� (2.83ms, 50.8MB)
�׽�Ʈ 10 ��	��� (2.91ms, 52.7MB)
�׽�Ʈ 11 ��	��� (3.19ms, 52.5MB)
�׽�Ʈ 12 ��	��� (3.20ms, 52.4MB)
�׽�Ʈ 13 ��	��� (3.10ms, 52.3MB)
�׽�Ʈ 14 ��	��� (4.23ms, 54.2MB)
�׽�Ʈ 15 ��	��� (11.19ms, 53MB)
�׽�Ʈ 16 ��	��� (5.89ms, 52.3MB)
�׽�Ʈ 17 ��	��� (15.59ms, 54.3MB)
�׽�Ʈ 18 ��	��� (20.31ms, 51.7MB)
�׽�Ʈ 19 ��	��� (3.05ms, 50.4MB)
ȿ����  �׽�Ʈ
�׽�Ʈ 1 ��	��� (48.26ms, 70.4MB)
�׽�Ʈ 2 ��	��� (96.63ms, 72.8MB)
�׽�Ʈ 3 ��	��� (95.68ms, 71MB)
�׽�Ʈ 4 ��	��� (44.37ms, 68.7MB)
�׽�Ʈ 5 ��	��� (48.92ms, 68.6MB)
�׽�Ʈ 6 ��	��� (56.73ms, 70.8MB)
�׽�Ʈ 7 ��	��� (43.43ms, 70.8MB)
�׽�Ʈ 8 ��	��� (45.67ms, 66.7MB)
 * */
