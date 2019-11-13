package skillCheck;
import java.util.*;

public class PhonebookPrefix {
	

	public static void main(String[] args) {
		System.out.println(solution(new String[]{"12232332", "12", "222222"}));

	}
	public static boolean solution(String[] phone_book) {
		Arrays.sort(phone_book, new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				// TODO Auto-generated method stub
				return o1.length() - o2.length();
			}
		});
		
		for (int i = 0; i < phone_book.length-1; i++) {
			for(int j = i+1 ; j < phone_book.length; j++) {
				if(phone_book[j].indexOf(phone_book[i])==0) {
					return false;
				}
			}
		}
        return true;
    }

}
