package level1;


import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * 다음 큰 숫자
 * https://school.programmers.co.kr/courses/13207/lessons/90303
 * */
public class NextBigNumber {

    public static void main(String[] args) {
        NextBigNumber nextBigNumber = new NextBigNumber();
        assertEquals(83,nextBigNumber.solution(78));
        assertEquals(23,nextBigNumber.solution(15));

    }

    public int solution(int n) {
        // 조건 1. n보다 큰 자연수
        int answer = n+1;

        final int nOneCount = getBinaryOneCount(n);

        // 조건 2. 2진수로 변환했을때 1의 갯수가 같다
        // 조건 3. 조건1,2중 가장 작은 수
        while (nOneCount != getBinaryOneCount(answer)){
            answer++;
        }

        return answer;
    }

    // 2진수 일때 1의 갯수를 구함
    private int getBinaryOneCount(int n) {
        int oneCount = 0;

        while (n != 0){
            oneCount += n%2;
            n /= 2;
        }

        return oneCount;
    }


    //라이브러리를 이용한 풀이
    //효율은 1과 비슷함
    private int getBinaryOneCount2(int n) {
        return Integer.bitCount(n);
    }

    //문자열을 이용한 풀이
    //형변환이 있어 1번보다 오래 걸림
    private int getBinaryOneCount3(int n) {
        int oneCount = 0;

        char[] chars = Integer.toBinaryString(n).toCharArray();
        for(char c : chars){
            if(c == '1') oneCount++;
        }

        return oneCount;
    }

    //필터를 이용한 풀이
    //필터를 사용하니 메모리 사용량이 크고, 효율성에서 시간초과
    private int getBinaryOneCount4(int n) {
        return (int)Integer.toBinaryString(n).chars().filter(ch -> ch =='1').count();
    }


    //비트연산자를 이용한 풀이
    //1번과 비슷한 수준
    private int getBinaryOneCount5(int n) {
        int count = 0;

        while (n > 0){
            if((n & 1) == 1) count++;
            n >>=1;
        }
        return count;
    }

}
