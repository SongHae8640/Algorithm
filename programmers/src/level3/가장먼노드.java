package level3;

import java.util.*;

public class 가장먼노드 {
    public static void main(String[] args) {
        System.out.println(new 가장먼노드().solution(6, new int [][]{{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}})); //3
    }

    public int solution(int n, int[][] edge) {
        Node[] nodes = new Node[n+1];
        for (int i = 1; i <= n ; i++) {
            nodes[i] = new Node(i);
        }
        for (int[] e : edge) {
            nodes[e[0]].link(nodes[e[1]]);
        }

        Queue<Node> queue = new LinkedList<>();
        nodes[1].distance = 0;
        queue.add(nodes[1]);

        while(!queue.isEmpty()){
            Node node = queue.poll();
            for(Node likedNode : node.linkedNodeList){
                if(likedNode.isVisit()) continue;
                likedNode.visit(node.distance);
                queue.add(likedNode);
            }
        }

        int maxDistance = Arrays.stream(nodes, 1, n+1)
                .mapToInt(node -> node.distance)
                .max()
                .getAsInt();

        return (int) Arrays.stream(nodes, 1, n+1)
                .filter(node -> node.distance == maxDistance)
                .count();
    }

    class Node{
        final int number;
        List<Node> linkedNodeList;
        int distance;

        public Node(int number){
            this.number = number;
            this.linkedNodeList = new ArrayList<>();
            this.distance = -1;
        }

        public void link(Node node){
            this.linkedNodeList.add(node);
            node.linkedNodeList.add(this);
        }

        public boolean isVisit(){
            return this.distance != -1;
        }

        public void visit(int distance){
            this.distance = distance + 1;
        }
    }
}
/*

  https://school.programmers.co.kr/learn/courses/30/lessons/49189
  정확성  테스트
  테스트 1 〉	통과 (2.05ms, 86.4MB)
  테스트 2 〉	통과 (2.86ms, 89.8MB)
  테스트 3 〉	통과 (2.54ms, 68.8MB)
  테스트 4 〉	통과 (3.00ms, 93.2MB)
  테스트 5 〉	통과 (5.47ms, 88.2MB)
  테스트 6 〉	통과 (6.08ms, 96MB)
  테스트 7 〉	통과 (21.75ms, 102MB)
  테스트 8 〉	통과 (30.04ms, 114MB)
  테스트 9 〉	통과 (25.46ms, 116MB)
  채점 결과
  정확성: 100.0
  합계: 100.0 / 100.0

  TODO 다시 풀어볼것
 */
