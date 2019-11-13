package Kakao2020;

import java.util.Arrays;

/*
 * 
 * [�� ������ ��Ȯ���� ȿ���� �׽�Ʈ ���� ������ �ִ� �����Դϴ�.]

ģ����κ��� õ�� ���α׷��ӷ� �Ҹ��� ���ε��� ������ �ϴ� ģ���κ��� �ڽ��� �����ϴ� �뷡 ���翡 ���� �ܾ�� �߿� Ư�� Ű���尡 �� �� ���ԵǾ� �ִ��� �ñ��ϴ� ���α׷����� ������ �޶�� ������ �޾ҽ��ϴ�.
�� ���� ���� ��, Ű����� ���ϵ�ī�� ������ �ϳ��� '?'�� ���Ե� ���� ������ ���ڿ��� ���մϴ�. ���ϵ�ī�� ������ '?'�� ���� �ϳ��� �ǹ��ϸ�, � ���ڿ��� ��ġ�ȴٰ� �����մϴ�. ���� ��� "fro??"�� "frodo", "front", "frost" � ��ġ������ "frame", "frozen"���� ��ġ���� �ʽ��ϴ�.

���翡 ���� ��� �ܾ���� ��� �迭 words�� ã���� �ϴ� Ű���尡 ��� �迭 queries�� �־��� ��, �� Ű���� ���� ��ġ�� �ܾ �� ������ ������� �迭�� ��� ��ȯ�ϵ��� solution �Լ��� �ϼ��� �ּ���.

���� �ܾ� ���ѻ���
words�� ����(���� �ܾ��� ����)�� 2 �̻� 100,000 �����Դϴ�.
�� ���� �ܾ��� ���̴� 1 �̻� 10,000 ���Ϸ� �� ���ڿ��� ���� �����ϴ�.
��ü ���� �ܾ� ������ ���� 2 �̻� 1,000,000 �����Դϴ�.
���翡 ���� �ܾ ���� �� ���� ��� �ߺ��� �����ϰ� words���� �ϳ��θ� �����˴ϴ�.
�� ���� �ܾ�� ���� ���ĺ� �ҹ��ڷθ� �����Ǿ� ������, Ư�����ڳ� ���ڴ� �������� �ʴ� ������ �����մϴ�.
�˻� Ű���� ���ѻ���
queries�� ����(�˻� Ű���� ����)�� 2 �̻� 100,000 �����Դϴ�.
�� �˻� Ű������ ���̴� 1 �̻� 10,000 ���Ϸ� �� ���ڿ��� ���� �����ϴ�.
��ü �˻� Ű���� ������ ���� 2 �̻� 1,000,000 �����Դϴ�.
�˻� Ű����� �ߺ��� ���� �ֽ��ϴ�.
�� �˻� Ű����� ���� ���ĺ� �ҹ��ڿ� ���ϵ�ī�� ������ '?' �θ� �����Ǿ� ������, Ư�����ڳ� ���ڴ� �������� �ʴ� ������ �����մϴ�.
�˻� Ű����� ���ϵ�ī�� ������ '?'�� �ϳ� �̻� ���Ե� ������, '?'�� �� �˻� Ű������ ���λ� �ƴϸ� ���̻� �� �ϳ��θ� �־����ϴ�.
���� ��� "??odo", "fro??", "?????"�� ������ Ű�����Դϴ�.
�ݸ鿡 "frodo"('?'�� ����), "fr?do"('?'�� �߰��� ����), "?ro??"('?'�� ���ʿ� ����)�� �Ұ����� Ű�����Դϴ�.
����� ��
words	queries	result
["frodo", "front", "frost", "frozen", "frame", "kakao"]	["fro??", "????o", "fr???", "fro???", "pro?"]	[3, 2, 4, 1, 0]
����� ���� ���� ����
"fro??"�� "frodo", "front", "frost"�� ��ġ�ǹǷ� 3�Դϴ�.
"????o"�� "frodo", "kakao"�� ��ġ�ǹǷ� 2�Դϴ�.
"fr???"�� "frodo", "front", "frost", "frame"�� ��ġ�ǹǷ� 4�Դϴ�.
"fro???"�� "frozen"�� ��ġ�ǹǷ� 1�Դϴ�.
"pro?"�� ��ġ�Ǵ� ���� �ܾ �����Ƿ� 0 �Դϴ�.
*/
public class KeyWordMatching {

	public static void main(String[] args) {
		solution(new String[] {"frodo", "front", "frost", "frozen", "frame", "kakao"}, new String[] {"fro??", "????o", "fr???", "fro???", "pro?"});

	}
	
    public static int[] solution(String[] words, String[] queries) {
        int[] answer = new int[queries.length];

        for (int queryIdx =0 ; queryIdx < queries.length ; queryIdx++) {
  
        	for(String word : words) {
        		if(isKeyword(word, queries[queryIdx])) {
        			answer[queryIdx]++;        			
        		}
        	}
        	
		}
        
        System.out.println();
        System.out.println(Arrays.toString(answer));
        return answer;
    }

	private static boolean isKeyword(String word, String query) {
		System.out.print(word +", "+query +"/ ");
		boolean isKeyword = true;
		char[] wordChar = word.toCharArray();
		char[] queryChar = query.toCharArray();
		if(wordChar.length == queryChar.length) {
			for (int i = 0; i < queryChar.length; i++) {
				if((wordChar[i] == queryChar[i]) || (queryChar[i] =='?')) {
					isKeyword &=true; 
				}else {
					isKeyword &=false;
				}
			}
			System.out.println(isKeyword);
			return isKeyword;
		}
		return false;
	}

}
