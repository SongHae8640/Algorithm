package level2;

import java.util.*;

public class 기능개발 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new 기능개발().solution2(new int[]{93, 30, 55}, new int[]{1, 30, 5}))); //[2,1]
        System.out.println(Arrays.toString(new 기능개발().solution2(new int[]{95, 90, 99, 99, 80, 99}, new int[]{1, 1, 1, 1, 1, 1}))); //[1,3,2]


    }
    public int[] solution2(int[] progresses, int[] speeds) {
        List<Integer> deployCounts = new ArrayList<>();

        int day = getCompleteDay(progresses[0], speeds[0]);
        int count = 0;

        for (int i = 1; i < progresses.length; i++) {
            count++;
            int completeDay = getCompleteDay(progresses[i], speeds[i]);
            if(day < completeDay){
                deployCounts.add(count);
                count = 0;
                day = completeDay;
            }
        }

        if(count > 0){
            deployCounts.add(count+1);
        }else{
            deployCounts.add(1);
        }

        return deployCounts.stream().mapToInt(Integer::intValue).toArray();
    }

    public int getCompleteDay(int progress, int speed){
        if((100 - progress) % speed == 0){
            return (100 - progress) / speed;
        }else{
            return (100 - progress) / speed + 1;
        }
    }


    public int[] solution(int[] progresses, int[] speeds) {
        int[] completeDays = new int[progresses.length];
        for (int i = 0; i < progresses.length; i++) {
            if((100 - progresses[i]) % speeds[i] == 0){
                completeDays[i] = (100 - progresses[i]) / speeds[i];
            }else{
                completeDays[i] = (100 - progresses[i]) / speeds[i] + 1;
            }
        }

        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());
        List<Integer> deployCounts = new ArrayList<>();
        queue.add(completeDays[0]);
        for (int i = 1; i < completeDays.length; i++) {
            if((queue.peek() != null) && queue.peek() < completeDays[i]){
                deployCounts.add(queue.size());
                queue.clear();
            }
            queue.add(completeDays[i]);
        }

        if(!queue.isEmpty()){
            deployCounts.add(queue.size());
        }

        return deployCounts.stream().mapToInt(Integer::intValue).toArray();
    }
}
/*

https://programmers.co.kr/learn/courses/30/lessons/42586

정확성  테스트
테스트 1 〉	통과 (3.55ms, 85.1MB)
테스트 2 〉	통과 (3.58ms, 80.6MB)
테스트 3 〉	통과 (3.36ms, 73.9MB)
테스트 4 〉	통과 (3.69ms, 75.1MB)
테스트 5 〉	통과 (4.61ms, 79.6MB)
테스트 6 〉	통과 (2.29ms, 83.4MB)
테스트 7 〉	통과 (2.25ms, 85.4MB)
테스트 8 〉	통과 (2.37ms, 87.8MB)
테스트 9 〉	통과 (2.44ms, 85.8MB)
테스트 10 〉	통과 (2.25ms, 84.1MB)
테스트 11 〉	통과 (2.22ms, 94.6MB)
채점 결과
정확성: 100.0
합계: 100.0 / 100.0


solution2
정확성  테스트
테스트 1 〉	통과 (2.66ms, 86.7MB)
테스트 2 〉	통과 (2.54ms, 76.8MB)
테스트 3 〉	통과 (1.90ms, 81.4MB)
테스트 4 〉	통과 (3.68ms, 97.4MB)
테스트 5 〉	통과 (1.93ms, 82MB)
테스트 6 〉	통과 (2.10ms, 80MB)
테스트 7 〉	통과 (1.92ms, 73.6MB)
테스트 8 〉	통과 (1.82ms, 89.5MB)
테스트 9 〉	통과 (1.81ms, 86.7MB)
테스트 10 〉	통과 (1.83ms, 85.1MB)
테스트 11 〉	통과 (1.92ms, 80MB)
채점 결과
정확성: 100.0
합계: 100.0 / 100.0
 */
