package level3;

import java.util.TreeSet;

/*
 * 힙(Heap)
 * https://programmers.co.kr/learn/courses/30/lessons/42628
 *
 * I 숫자: 큐에 주어진 숫자를 삽입
 * D 1: 큐에서 최댓값 삭제
 * D -1: 큐에서 최솟값 삭제
 */
public class DoublePriorityQueue {
    public static void main(String[] args) {
        // ["I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1"] => [0, 0]
        String[] operations = new String[]{"I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1"};
        int[] solution = new DoublePriorityQueue().solution(operations);
        display(solution);

        // ["I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"] => [333, -45]
        operations = new String[]{"I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"};
        solution = new DoublePriorityQueue().solution(operations);
        display(solution);
    }

    private static void display(int[] solution) {
        for (int i : solution) {
            System.out.print(i + " ");
        }
        System.out.println();
    }


    public int[] solution(String[] operations) {
        TreeSet<Integer> treeSet = new TreeSet<>();
        for (String operation : operations){
            if(isInsertOperation(operation)){
                String [] split = operation.split(" ");
                treeSet.add(Integer.parseInt(split[1]));
            } else if(isDeleteMaxOperation(operation)) {
                treeSet.pollLast();
            } else if(isDeleteMinOperation(operation)) {
                treeSet.pollFirst();
            }
        }
        return new int[]{treeSet.isEmpty() ? 0 : treeSet.last(), treeSet.isEmpty() ? 0 : treeSet.first()};
    }

    private boolean isInsertOperation(String operation) {
        return operation.startsWith("I");
    }

    private boolean isDeleteMaxOperation(String operation) {
        return operation.equals("D 1");
    }

    private boolean isDeleteMinOperation(String operation) {
        return operation.equals("D -1");
    }
}
