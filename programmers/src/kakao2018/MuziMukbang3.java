package kakao2018;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
/*
 * ��ü ���� �Ϸ��� �õ� ������ �ʾҴ�
 * ������ ������� ȥ�� �� �� �غ���
 * */

public class MuziMukbang3 {
	public static void main(String[] args) { 

        System.out.println(solution(new int[]{3, 1, 2}, 5));

    } 

    public static int solution(int[] food_times, long k) { 
        //������ �� ���� ��� 
        if(allEatCheck(food_times,k)) return -1; 
        HashSet<Food> foodSet = new HashSet<Food>();
        for (int i = 0; i < food_times.length; i++) {
			foodSet.add(new Food(i,food_times[i]));
		}
        Integer tempIdx, tempFoodTime;
        Food tempFood;
        
        Iterator<Food> iter = foodSet.iterator();
        while(iter.hasNext()) {
        	k--;
        
        	tempFood = iter.next();
        	//tempIdx.fo
        }

       return -1;
    } 

    public static boolean allEatCheck(int[] food_times, long k) { 
        for (int i = 0; i < food_times.length; i++) { 
            k -=food_times[i]; 
        } 
        if(k >=0) return true; 
        return false; 
    } 
}

class Food{
	int foodIdx;
	int foodTime;
	
	Food(int foodIdx, int foodTime){
		this.foodIdx = foodIdx;
		this.foodTime = foodTime;
	}
}