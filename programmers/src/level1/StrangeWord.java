package level1;

public class StrangeWord {
	public static void main(String[] args) {
		solution("");
	}

	public static String solution(String s) {
		String answer = "";
		char tempChar;
		int wordIdx = 0;
		for (int i = 0; i < s.length(); i++) {
			tempChar = s.charAt(i);
            
            //공백이 나온경우 이후 문자는 새로운 단어
			if(tempChar ==' '){
				answer +=" ";
				wordIdx = 0;
			}else if(wordIdx %2 ==0){   //해당 단어의 index가 짝수인 경우
				answer +=Character.toUpperCase(tempChar);
				wordIdx++;
			}else{  //해당 단어의 index가 홀수인 경우
				answer +=Character.toLowerCase(tempChar);
				wordIdx++;
			}
		}
		return answer;
	}

}
/*
테스트 1 〉	통과 (36.32ms, 55.2MB)
테스트 2 〉	통과 (25.69ms, 51.2MB)
테스트 3 〉	통과 (32.60ms, 55.1MB)
테스트 4 〉	통과 (42.23ms, 55.2MB)
테스트 5 〉	통과 (41.58ms, 53.2MB)
테스트 6 〉	통과 (39.03ms, 52.6MB)
테스트 7 〉	통과 (39.92ms, 55.6MB)
테스트 8 〉	통과 (45.53ms, 53.3MB)
테스트 9 〉	통과 (35.30ms, 55.3MB)
테스트 10 〉통과 (49.47ms, 54.8MB)
테스트 11 〉통과 (38.33ms, 53MB)
테스트 12 〉통과 (41.23ms, 53.5MB)
테스트 13 〉통과 (37.37ms, 55.6MB)
테스트 14 〉통과 (34.61ms, 55.4MB)
테스트 15 〉통과 (46.38ms, 55.5MB)
테스트 16 〉통과 (36.84ms, 53MB)
 * */