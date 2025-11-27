package level1;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class 프로세스 {
    public static void main(String[] args) {
        System.out.println(new 프로세스().solution2(new int[] {2, 1, 3, 2}, 2)); // 1
        System.out.println(new 프로세스().solution2(new int[] {1, 1, 9, 1, 1, 1}, 0)); // 5


    }

    public int solution(int[] priorities, int location) {
        Queue<Process> priorityQueue = new PriorityQueue<>();
        Queue<Process> queue = new LinkedList<>();
        for (int i = 0 ; i < priorities.length ; i ++){
            priorityQueue.add(new Process(i, priorities[i]));
            queue.add(new Process(i, priorities[i]));
        }


        int[] answer = new int[priorities.length];
        int count = 0;
        while (!priorityQueue.isEmpty()) {
            Process process = queue.poll();
            if(process.priority == priorityQueue.peek().priority){
                count++;
                priorityQueue.poll();
                answer[process.location] = count;
            }else {
                queue.add(process);
            }
        }

        return answer[location];
    }

    public class Process implements Comparable<Process>{

        final int location;
        final int priority;
        public Process(int location, int priority) {
            this.location = location;
            this.priority = priority;
        }

        @Override
        public int compareTo(Process o) {
            return o.priority- this.priority;
        }

    }


    public int solution2(int[] priorities, int location) {
        Queue<Process> queue = new LinkedList<>();
        for (int i = 0 ; i < priorities.length ; i ++){
            queue.add(new Process(i, priorities[i]));
        }

        Arrays.sort(priorities);
        int priorityIndex = priorities.length-1;

        while(!queue.isEmpty()){
            Process process = queue.poll();
            if(process.priority == priorities[priorityIndex]){
                if(process.location == location){
                    return priorities.length - priorityIndex;
                }
                priorityIndex--;

            }else {
                queue.add(process);
            }

        }

        return 0;
    }

}
/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/42587
 *
 *
 * solution
 * 정확성  테스트
 * 테스트 1 〉	통과 (0.80ms, 85MB)
 * 테스트 2 〉	통과 (1.41ms, 77.7MB)
 * 테스트 3 〉	통과 (1.18ms, 91MB)
 * 테스트 4 〉	통과 (0.86ms, 83.9MB)
 * 테스트 5 〉	통과 (0.64ms, 82.7MB)
 * 테스트 6 〉	통과 (0.84ms, 77.9MB)
 * 테스트 7 〉	통과 (1.56ms, 80.4MB)
 * 테스트 8 〉	통과 (1.22ms, 86.8MB)
 * 테스트 9 〉	통과 (0.65ms, 78.6MB)
 * 테스트 10 〉	통과 (1.12ms, 76.3MB)
 * 테스트 11 〉	통과 (1.12ms, 82.9MB)
 * 테스트 12 〉	통과 (0.78ms, 79.5MB)
 * 테스트 13 〉	통과 (1.31ms, 87.6MB)
 * 테스트 14 〉	통과 (0.95ms, 72.7MB)
 * 테스트 15 〉	통과 (0.80ms, 90.4MB)
 * 테스트 16 〉	통과 (0.77ms, 77.7MB)
 * 테스트 17 〉	통과 (1.65ms, 73.3MB)
 * 테스트 18 〉	통과 (0.66ms, 85.9MB)
 * 테스트 19 〉	통과 (1.64ms, 87.7MB)
 * 테스트 20 〉	통과 (1.39ms, 74.3MB)
 * 채점 결과
 * 정확성: 100.0
 * 합계: 100.0 / 100.0
 *
 *
 *
 * solution2
 * 정확성  테스트
 * 테스트 1 〉	통과 (0.73ms, 87.6MB)
 * 테스트 2 〉	통과 (1.21ms, 82.4MB)
 * 테스트 3 〉	통과 (0.79ms, 85.6MB)
 * 테스트 4 〉	통과 (1.09ms, 73.4MB)
 * 테스트 5 〉	통과 (0.92ms, 90.8MB)
 * 테스트 6 〉	통과 (0.95ms, 75.9MB)
 * 테스트 7 〉	통과 (0.80ms, 80.2MB)
 * 테스트 8 〉	통과 (1.09ms, 85MB)
 * 테스트 9 〉	통과 (0.66ms, 77MB)
 * 테스트 10 〉	통과 (0.80ms, 84.5MB)
 * 테스트 11 〉	통과 (1.46ms, 76.3MB)
 * 테스트 12 〉	통과 (0.70ms, 88.8MB)
 * 테스트 13 〉	통과 (1.03ms, 87.4MB)
 * 테스트 14 〉	통과 (0.65ms, 70.2MB)
 * 테스트 15 〉	통과 (0.65ms, 85MB)
 * 테스트 16 〉	통과 (0.74ms, 88MB)
 * 테스트 17 〉	통과 (1.07ms, 89.9MB)
 * 테스트 18 〉	통과 (0.70ms, 85.8MB)
 * 테스트 19 〉	통과 (1.05ms, 74.7MB)
 * 테스트 20 〉	통과 (0.70ms, 70.6MB)
 * 채점 결과
 * 정확성: 100.0
 * 합계: 100.0 / 100.0
 */