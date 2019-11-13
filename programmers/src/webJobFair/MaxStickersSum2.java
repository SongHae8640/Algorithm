package webJobFair;

import java.util.ArrayList;
import java.util.Collections;

public class MaxStickersSum2 {

	public static void main(String[] args) {
		solution(new int[] {12, 12, 12, 12, 12});
		solution(new int[] {12, 80, 14, 22, 100});
	}
	
    public static int solution(int[] sticker) {
    	ArrayList<Integer> maxList = new ArrayList<Integer>();

        int answer = 0;
        int index = 0;
        while(index!=sticker.length){
            for(int j=2; j<sticker.length; j++){
                answer = 0;
                int psum = 0;
                for (int i = index; i < sticker.length; i+=j)
                {
                    psum = Math.max(psum, 0) + sticker[i];
                    answer = Math.max(psum, answer);
                }
                maxList.add(answer);
            }
            index++;
        }
        Collections.sort(maxList);

        for(int i=0; i<maxList.size(); i++){
            System.out.println(maxList.get(i)+"answer");
        }


        System.out.println(maxList.get(maxList.size()-1));
        return maxList.get(maxList.size()-1);
    }

    public static void dfs(int i, int[] sticker){

    }
}