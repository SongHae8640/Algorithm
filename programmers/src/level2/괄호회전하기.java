package level2;


import java.util.Stack;

public class 괄호회전하기 {

    public static void main(String[] args) {
        괄호회전하기 t = new 괄호회전하기();
        System.out.println(t.solution("[](){}")); //3
        System.out.println(t.solution("}]()[{")); //2
        System.out.println(t.solution("[)(]")); //0
        System.out.println(t.solution("}}}")); //0


    }

    public int solution(String s) {
        if(s.length()%2 == 1) {
            return 0;
        }

        char[] charArray = s.toCharArray();
        char[] extendArray = new char[charArray.length*2];
        for (int i = 0; i < charArray.length; i++) {
            extendArray[i] = charArray[i];
            extendArray[i+charArray.length] = charArray[i];
        }

        int answer = 0;
        for (int i = 0; i < charArray.length; i++) {
            int limit = i + charArray.length;
            if(isCorrect(extendArray, i, limit)){
                answer++;
            }
        }

        return answer;
    }

    private boolean isCorrect(char[] charArray, int start, int end){
        Stack<Character> stack = new Stack<>();
        for (int i = start; i < end; i++) {
            char c = charArray[i];
            if (inCase(c)) {
                stack.add(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                char c2 = stack.pop();
                if (!inCase(c2)) {
                    return false;
                }
                if (!isMatched(c2, c)) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean inCase(char c){
        return c == '{' || c == '[' || c =='(';
    }

    private boolean isMatched(char c1 , char c2){
        if(c1 == '{'){
            return c2 == '}';
        } else if (c1 == '[') {
            return c2 == ']';
        }else if (c1 == '('){
            return c2 == ')';
        }
        return false;
    }

}
/*
https://school.programmers.co.kr/learn/courses/30/lessons/76502

정확성  테스트
테스트 1 〉	통과 (7.54ms, 73.5MB)
테스트 2 〉	통과 (5.18ms, 74.2MB)
테스트 3 〉	통과 (3.76ms, 71.9MB)
테스트 4 〉	통과 (5.49ms, 87.7MB)
테스트 5 〉	통과 (9.43ms, 77.5MB)
테스트 6 〉	통과 (6.75ms, 74.1MB)
테스트 7 〉	통과 (9.97ms, 90.3MB)
테스트 8 〉	통과 (8.26ms, 87.1MB)
테스트 9 〉	통과 (20.65ms, 93.6MB)
테스트 10 〉	통과 (18.54ms, 90.5MB)
테스트 11 〉	통과 (29.45ms, 78MB)
테스트 12 〉	통과 (0.02ms, 90.8MB)
테스트 13 〉	통과 (0.03ms, 89.4MB)
테스트 14 〉	통과 (0.20ms, 81.9MB)
채점 결과
정확성: 100.0
합계: 100.0 / 100.0

 */
