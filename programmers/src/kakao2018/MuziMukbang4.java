package kakao2018;

import java.util.*;

public class MuziMukbang4 {
	public static void main(String[] args) { 
        System.out.println(solution(new int[]{3, 1, 2}, 5));
    } 
	
	Comparator<Food> compTime = new Comparator<Food>() {
		public int compare(Food food1, Food food2) {
			return food1.foodTime-food2.foodTime;
		}
	};
	
	Comparator<Food> compIdx= new Comparator<Food>() {
		public int compare(Food food1, Food food2) {
			return food1.foodIdx-food2.foodIdx;
		}
	};

    public static int solution(int[] food_times, long k) { 
    	List<Food> foodSet = new LinkedList<Food>();
        for (int i = 0; i < food_times.length; i++) {
			foodSet.add(new Food(i,food_times[i]));
		}
        //foodSet.sort(compTime);
       return -1;
    }  
}
