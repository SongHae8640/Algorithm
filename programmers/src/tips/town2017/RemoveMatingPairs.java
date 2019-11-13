package tips.town2017;

class RemoveMatingPairs {

	public static void main(String[] args) {
		System.out.println(solution("baabaaa"));
		System.out.println(solution("cdcd"));

	}

    public static int solution(String s){
        String[] pairString = new String[] {"aa","bb","cc","dd","ee","ff","gg","hh","ii","jj","kk","ll","mm","nn","oo","pp","qq","rr","ss","tt","uu","vv","ww","xx","yy","zz"};
        int idx = 0;
        while(true) {
        	String[] arr = s.split(pairString[idx]);
        	if(arr.length ==2) {
        		
        		s = arr[0]+arr[1];
        		idx = 0;
        	}else if(arr.length ==0) return 1;
        	else {
        		if(idx == 25) return 0;
        		idx++;
        	}
        }
    }
}
