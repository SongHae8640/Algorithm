package level3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class DoublePriorityQueue {

	public static void main(String[] args) {
        //solution(new String[] {"I 16","D 1"});
        //solution(new String[] {"I 7","I 5","I -5","D -1"});
        solution(new String[] {"I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"});

	}
	
    public static int[] solution(String[] operations) {
    	int[] answer = {};
    	ArrayList<Integer> aList = new ArrayList<Integer>();
    	for (int i = 0; i < operations.length; i++) {
			if(operations[i].contains("I")) {
				aList.add(new Integer(operations[i].split(" ")[1]));
			}else {
				//정렬
				aList.sort(new Comparator<Integer>() {
					@Override
					public int compare(Integer o1, Integer o2) {
						// TODO Auto-generated method stub
						return o1-o2;
					}
				});
				System.out.println(aList.toString());
				
				//삭제
				if(new Integer(operations[i].split(" ")[1]) ==1) {
					aList.remove(aList.size()-1);
				}else {
					aList.remove(0);
				}
				
			}
		}
    	
    	
    	if(aList.size()==0) {
    		return new int[] {0,0};
    	}else if(aList.size()==1) {
    		return new int[] {aList.get(0), aList.get(0)};
    	}
        return new int[] {aList.get(aList.size()-1), aList.get(0)};
    }

}
