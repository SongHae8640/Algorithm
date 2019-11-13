package level3;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Printer4 {
	public static void main(String[] args) {
		
		System.out.println(solution(new int[] {2,1,3,2},2));
		System.out.println(solution(new int[] {1, 1, 9, 1, 1, 1},0));

	}
	public static int solution(int[] priorities, int location) {
		int answer = 0;

        PriorityQueue<Integer> pri_queue = new PriorityQueue<Integer>(Collections.reverseOrder());
        Queue<Print> queue = new LinkedList<Print>();

        for (int i = 0; i < priorities.length; i++) {
           pri_queue.offer(priorities[i]);
           queue.offer(new Print(i, priorities[i]));
        }
        while (!queue.isEmpty()) {
           Print curPrint = queue.poll();

           if (curPrint.priority >= pri_queue.peek()) {
              answer++;
              pri_queue.poll();
              if (curPrint.location == location)
                 break;
           }
           else
              queue.offer(curPrint);
        }
        return answer;
    }

	class Print {
	   int location;
	   int priority;
	
	   public Print(int location, int priority) {
	      this.location = location; this.priority = priority;
	   }
	}
}



/*
 * 출처 : https://programmers.co.kr/learn/courses/30/lessons/42587
 * 
 * 우선순위 큐 
 * 

 * 
 */