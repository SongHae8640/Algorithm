package level3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Printer3 {
	public static void main(String[] args) {
		
		System.out.println(solution(new int[] {2,1,3,2},2));
		System.out.println(solution(new int[] {1, 1, 9, 1, 1, 1},0));

	}
	public static int solution(int[] priorities, int location) {

        int count=0;
        ArrayList<Integer> orderList=new ArrayList<Integer>();
        ArrayList<Integer> loactionList=new ArrayList<Integer>();

        for(int i=0;i<priorities.length;i++){
            orderList.add(priorities[i]);
            if(i==location){
                loactionList.add(1);
            }else{
                loactionList.add(0);
            }
        }
        boolean loop=true;

        while(loop){
            int num=orderList.get(0);
            orderList.remove(0);

            int check=loactionList.get(0);
            loactionList.remove(0);

            if(orderList.size()==0){
                count++;
                loop=false;
            }

            for(int j=0;j<orderList.size();j++){
                if(num<orderList.get(j)){
                    orderList.add(num);
                    loactionList.add(check);
                    break;
                }

                if(j==orderList.size()-1){
                    count++;

                    if(check==1){
                        loop=false;
                        break;
                    }
                }
            }
        }
        return count;
    }
	
	
	
	
}


/*
 * ÃâÃ³ : https://programmers.co.kr/learn/courses/30/lessons/42587
 * 

 * 
 */