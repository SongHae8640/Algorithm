package level2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class 전력망을둘로나누기 {

    public static void main(String[] args) {
        전력망을둘로나누기 t = new 전력망을둘로나누기();
        System.out.println(t.solution(9, new int[][]{{1,3},{2,3},{3,4},{4,5},{4,6},{4,7},{7,8},{7,9}})); // 3
        System.out.println(t.solution(4, new int[][]{{1,2},{2,3},{3,4}})); // 0
        System.out.println(t.solution(7, new int[][]{{1,2},{2,7},{3,7},{3,4},{4,5},{6,7}})); // 1
    }

    public int solution(int n, int[][] wires) {
        Node[] nodes = new Node[n+1];
        for (int i = 1; i <= n ; i++) {
            nodes[i] = new Node(i);
        }

        for (int[] wire : wires){
            nodes[wire[0]].link(nodes[wire[1]]);
        }

        int answer = Integer.MAX_VALUE;
        for (int i = 1; i <= n; i++) {
            for(Node o : new ArrayList<>(nodes[i].likedNodes)){
                nodes[i].unlink(o);

                answer = Math.min(answer ,Math.abs(nodes[i].getLinkedNodes().size() - o.getLinkedNodes().size()));

                nodes[i].link(o);
                for (int j = 1; j <= n ; j++) {
                    nodes[j].isCounted = false;
                }
            }
        }


        return answer;
    }

    class Node{
        final int num;
        Set<Node> likedNodes;
        boolean isCounted;


        public Node(int num){
            this.num = num;
            this.likedNodes = new HashSet<>();
            this.isCounted = false;
        }

        public void link(Node o){
            likedNodes.add(o);
            o.likedNodes.add(this);
        }

        public void unlink(Node o){
            likedNodes.remove(o);
            o.likedNodes.remove(this);
        }

        public Set<Node> getLinkedNodes(){
            Set<Node> allLinkedNodes = new HashSet<>();
            this.isCounted = true;
            allLinkedNodes.add(this);
            for (Node node : likedNodes){
                if(!node.isCounted){
                    allLinkedNodes.addAll(node.getLinkedNodes());
                }
            }
            return allLinkedNodes;
        }
    }
}
/*
전력망을 둘로 나누기
https://school.programmers.co.kr/learn/courses/30/lessons/86971

정확성  테스트
테스트 1 〉	통과 (20.88ms, 98.8MB)
테스트 2 〉	통과 (65.95ms, 107MB)
테스트 3 〉	통과 (38.28ms, 111MB)
테스트 4 〉	통과 (25.78ms, 88.5MB)
테스트 5 〉	통과 (32.45ms, 90.2MB)
테스트 6 〉	통과 (0.44ms, 93.4MB)
테스트 7 〉	통과 (0.64ms, 90.5MB)
테스트 8 〉	통과 (1.38ms, 76.3MB)
테스트 9 〉	통과 (1.82ms, 83.6MB)
테스트 10 〉	통과 (19.63ms, 94.2MB)
테스트 11 〉	통과 (22.46ms, 109MB)
테스트 12 〉	통과 (21.20ms, 91.2MB)
테스트 13 〉	통과 (20.72ms, 108MB)
채점 결과
정확성: 100.0
합계: 100.0 / 100.0
 */
