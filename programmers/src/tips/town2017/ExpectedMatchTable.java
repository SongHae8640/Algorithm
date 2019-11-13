package tips.town2017;

public class ExpectedMatchTable {

	public static void main(String[] args) {
		System.out.println(solution(8, 4, 7));
		

	}
	
	//N명이 참가, 참가자 번호 a , b
    public static int solution(int n, int a, int b)
    {
        int answer = 0;

        while(a!=b) {
        	a = ++a/2;
        	b = ++b/2;
        	
        	answer++;
        }
        

        return answer;
    }

}
