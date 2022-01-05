package level1;

public class CorrectParenthesis {

	boolean solution(String s) {

		//괄호가 열리면 +1, 닫히면 -1
		int openCloseCount = 0;

		for(int i = 0 ; i < s.length(); i++){
			if(s.charAt(i) == '('){
				openCloseCount++;
			}else{
				openCloseCount--;
			}

			//앞에 열린것 보다 닫힌게 많아지면 false
			if(openCloseCount < 0){
				return false;
			}
		}

		return openCloseCount == 0;
	}



}

/**
 *
 * 올바른 괄호
 * https://programmers.co.kr/learn/courses/30/lessons/12909
 *
 * 정확성  테스트
 * 테스트 1 〉	통과 (0.01ms, 73MB)
 * 테스트 2 〉	통과 (0.03ms, 73.2MB)
 * 테스트 3 〉	통과 (0.02ms, 77.2MB)
 * 테스트 4 〉	통과 (0.02ms, 77.8MB)
 * 테스트 5 〉	통과 (0.02ms, 74.6MB)
 * 테스트 6 〉	통과 (0.01ms, 73MB)
 * 테스트 7 〉	통과 (0.02ms, 71.1MB)
 * 테스트 8 〉	통과 (0.03ms, 78.5MB)
 * 테스트 9 〉	통과 (0.01ms, 67.9MB)
 * 테스트 10 〉	통과 (0.02ms, 73.5MB)
 * 테스트 11 〉	통과 (0.02ms, 78.1MB)
 * 테스트 12 〉	통과 (0.03ms, 74.8MB)
 * 테스트 13 〉	통과 (0.02ms, 74.1MB)
 * 테스트 14 〉	통과 (0.03ms, 77.5MB)
 * 테스트 15 〉	통과 (0.03ms, 73.5MB)
 * 테스트 16 〉	통과 (0.02ms, 73.4MB)
 * 테스트 17 〉	통과 (0.04ms, 78.6MB)
 * 테스트 18 〉	통과 (0.02ms, 72.4MB)
 * 효율성  테스트
 * 테스트 1 〉	통과 (6.51ms, 52.6MB)
 * 테스트 2 〉	통과 (4.63ms, 53MB)
 * 채점 결과
 * 정확성: 69.5
 * 효율성: 30.5
 * 합계: 100.0 / 100.0
 *
 * */
