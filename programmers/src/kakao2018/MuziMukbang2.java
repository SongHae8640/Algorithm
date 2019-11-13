package kakao2018; 

  

import java.util.HashMap; 

import java.util.Iterator; 

  

public class MuziMukbang2 { 

    public static void main(String[] args) { 

        System.out.println(solution(new int[]{3, 1, 2}, 5));

    } 

    public static int solution(int[] food_times, long k) { 
        //음식을 다 먹은 경우 
        if(allEatCheck(food_times,k)) return -1; 

        //해시맵으로 넣기 
        HashMap<Integer, Integer> foodHashMap = new HashMap<Integer, Integer>(); 
        for (int i = 0; i < food_times.length; i++) { 
            foodHashMap.put(i, food_times[i]); 
        } 
        
        int tempValue; 
        while(true){ 
            Iterator<Integer> keySetIterator = foodHashMap.keySet().iterator(); 
            while (keySetIterator.hasNext()) { 
                Integer key = keySetIterator.next(); 
                tempValue = foodHashMap.get(key); 
                k--; 
                if(tempValue ==1){ 
                    foodHashMap.remove(key);      
                }else{ 
                    foodHashMap.put(key, tempValue-1); 
                }   
                if(k ==0){ 
                    return key+1; 
                } 
            } 
        } 
    } 

    public static boolean allEatCheck(int[] food_times, long k) { 
        for (int i = 0; i < food_times.length; i++) { 
            k -=food_times[i]; 
        } 
        if(k >=0) return true; 
        return false; 
    } 
} 