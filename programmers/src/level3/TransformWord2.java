package level3;

import java.util.ArrayList;
import java.util.List;

public class TransformWord2 {

	public static void main(String[] args) {
		//System.out.println(solution("hit", "cog", new String[] {"hot", "dot", "dog", "lot", "log", "cog"}));
		System.out.println(solution("hit", "cog", new String[] {"hot", "dot", "dog", "lot", "log"}));

	}
	
	
	public static int solution(String begin, String target, String[] words) {
        int answer = 0;
 
        List<String> wordsList = new ArrayList<String>();
        for(int i=0;i<words.length;i++){
            wordsList.add(words[i]);
        }
        answer = trans(begin,target,wordsList,0);
        return answer;
       }
    
	public static int trans(String  begin, String target, List<String> wordsList, int count1){
        char[] begin_word = begin.toCharArray();
        char[] target_word = target.toCharArray();

        for(int i=0;i<wordsList.size();i++){
            int count=0;
            int target_count = 0;

            char[] list_word = wordsList.get(i).toCharArray();
            for(int j=0;j<begin_word.length;j++){
                if(begin_word[j]==list_word[j]){
                    count++;
                }
                if(begin_word[j]==target_word[j]){
                    target_count++;
                }//3
            }
            //1 compare
            if(target_count==begin_word.length-1){
                //System.out.println(target_count);
            	//System.out.println(begin_word.length-1);
                count1++;
                return count1;
            }
            if(count==begin_word.length-1){
                begin = wordsList.get(i);
                count1++;
                wordsList.remove(i);
                return trans(begin, target, wordsList, count1);
            }
        }
        return 0;
    } 
	

}


/*
 * ÃâÃ³ : https://programmers.co.kr/learn/courses/30/lessons/43163
 *

 * */