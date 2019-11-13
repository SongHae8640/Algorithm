package NDS;

import java.util.Arrays;

public class P1 {
	public static void main(String[] args) {
		System.out.println(solution(new int[] {3, 1, 2, 4}));
		System.out.println(solution(new int[] {2, 2, 2, 2}));
	}
	
	public static int solution(int[] bombs) {
        int removeBombCount=1;
        
        Arrays.sort(bombs);
        for (int i = 0; i < bombs.length; i++) {
			if(bombs[i] >=removeBombCount) {
				removeBombCount++;
			}else {
				break;
			}
		}
        
        return removeBombCount-1;
    }
}

/*
 *
 * 
배열 bombs에는 시한폭탄이 몇 초 후에 터지는지가 기록되어 있습니다. 폭탄 한 개를 제거하는 데 1초가 걸리며, 폭탄이 터지는 시간과 폭탄 제거를 완료한 시간이 같더라도 폭탄은 터지지 않습니다.
또 폭탄이 하나라도 터지면, 나머지 폭탄의 제거도 모두 실패한 것으로 간주합니다.
예를들어

bombs가 [3, 1, 2, 4]라면 bombs[1], bombs[2], bombs[0], bombs[3]순으로 제거해서 4개의 폭탄을 제거할 수 있습니다.
bombs가 [2, 2, 2, 2]라면 어떤 순서로 제거하더라도 2개의 폭탄을 제거(2초 소요)한 후에는 나머지 2개의 폭탄은 터집니다.
각 시한폭탄이 터지는 시간이 들어있는 배열 bombs가 매개변수로 주어질 때, 제거할 수 있는 폭탄 개수의 최댓값을 return 하도록 solution 함수를 완성해 주세요.

제한사항
시한폭탄의 개수는 1 이상, 100,000 이하입니다.
시한폭탄이 터지는 시간은 1 이상, 200,000이하인 자연수입니다.
입출력 예
bombs	result
[3, 1, 2, 4]	4
[2, 2, 2, 2]	2
입출력 예 설명
입출력 예 #1
bombs[1], bombs[2], bombs[0], bombs[3] 순으로 제거하면 4개를 모두 제거할 수 있습니다.

입출력 예 #2
어떤 순서로 제거하더라도 2개보다 많이 제거할 수는 없습니다.

테스트 1 〉	통과 (0.98ms, 51.9MB)
테스트 2 〉	통과 (0.98ms, 52.3MB)
테스트 3 〉	통과 (0.98ms, 52.6MB)
테스트 4 〉	통과 (1.00ms, 53.2MB)
테스트 5 〉	통과 (0.97ms, 52.6MB)
테스트 6 〉	통과 (0.96ms, 52.1MB)
테스트 7 〉	통과 (0.98ms, 52.4MB)
테스트 8 〉	통과 (1.00ms, 53.9MB)
테스트 9 〉	통과 (1.01ms, 52.2MB)
테스트 10 〉	통과 (1.05ms, 52.8MB)
테스트 11 〉	통과 (1.05ms, 51.1MB)
테스트 12 〉	통과 (1.46ms, 50.5MB)
효율성  테스트
테스트 1 〉	통과 (24.64ms, 58.7MB)
테스트 2 〉	통과 (25.80ms, 58.9MB)
테스트 3 〉	통과 (7.16ms, 59.1MB)
테스트 4 〉	통과 (23.54ms, 59.1MB)
테스트 5 〉	통과 (4.15ms, 58.4MB)

 * */
