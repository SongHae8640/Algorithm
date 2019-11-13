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
투썸플레이스 OO 지점에서는 사은 이벤트로 매일 고객 한 명을 임의로 선정해 커피 무료 쿠폰을 발송합니다. 배열 arr에는 고객들의 ID가 이벤트에 당첨된 순서대로 들어있으며, 각 고객의 ID는 자연수입니다. 쿠폰에 당첨된 고객 중, 가장 빨리 중복으로 당첨된 고객은 며칠 만에 중복 당첨됐는지를 return 하도록 solution 함수를 작성하세요.
단, 중복으로 당첨된 고객이 없는 경우 -1을 return 하세요.

제한사항
배열의 길이는 1 이상 100,000 이하입니다.
배열의 원소는 1 이상 1,000,000,000 이하의 자연수입니다.
입출력 예
arr	result
[2, 1, 3, 1, 4, 2, 1, 3]	2
[1, 2, 3]	-1
입출력 예 설명
입출력 예 #1
배열이 [2, 1, 3, 1, 4, 2, 1, 3]이라면 (arr[1], arr[3], arr[6])에서 1번 고객이 중복해서 나타나서 2일만에 중복으로 당첨된 기록이 있고, (arr[0], arr[5])에서 2번 고객이 5일만에 중복해서 당첨된 기록이 있습니다. 또 (arr[2], arr[7])에서 3번 고객이 5일만에 당첨되었습니다.
이 중, 1번 고객이 가장 짧은 2일만에 중복 당첨되었으므로 2를 return합니다.

입출력 예 #2
배열이 [1, 2, 3]일때 중복해서 나타나는 수가 없으므로 -1을 return합니다.

테스트 1 〉	통과 (1.16ms, 50.9MB)
테스트 2 〉	통과 (0.83ms, 52.4MB)
테스트 3 〉	통과 (1.55ms, 52.4MB)
테스트 4 〉	통과 (1.44ms, 50.5MB)
테스트 5 〉	통과 (1.27ms, 52.6MB)
테스트 6 〉	통과 (1.30ms, 50.4MB)
테스트 7 〉	통과 (1.62ms, 52.4MB)
테스트 8 〉	통과 (1.57ms, 52.9MB)
테스트 9 〉	통과 (2.83ms, 50.8MB)
테스트 10 〉	통과 (2.91ms, 52.7MB)
테스트 11 〉	통과 (3.19ms, 52.5MB)
테스트 12 〉	통과 (3.20ms, 52.4MB)
테스트 13 〉	통과 (3.10ms, 52.3MB)
테스트 14 〉	통과 (4.23ms, 54.2MB)
테스트 15 〉	통과 (11.19ms, 53MB)
테스트 16 〉	통과 (5.89ms, 52.3MB)
테스트 17 〉	통과 (15.59ms, 54.3MB)
테스트 18 〉	통과 (20.31ms, 51.7MB)
테스트 19 〉	통과 (3.05ms, 50.4MB)
효율성  테스트
테스트 1 〉	통과 (48.26ms, 70.4MB)
테스트 2 〉	통과 (96.63ms, 72.8MB)
테스트 3 〉	통과 (95.68ms, 71MB)
테스트 4 〉	통과 (44.37ms, 68.7MB)
테스트 5 〉	통과 (48.92ms, 68.6MB)
테스트 6 〉	통과 (56.73ms, 70.8MB)
테스트 7 〉	통과 (43.43ms, 70.8MB)
테스트 8 〉	통과 (45.67ms, 66.7MB)
 * */
