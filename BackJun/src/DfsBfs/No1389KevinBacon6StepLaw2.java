package DfsBfs;

import java.util.*;

public class No1389KevinBacon6StepLaw2 {

    static int n, m, min;

    public static int findKevinBacon(int root, boolean[][] status) {
        int num = 0;
        int depth = 1;
        boolean[] c = new boolean[n+1];
        Queue<Integer> queue = new LinkedList<>();

        queue.add(root);
        c[root] = true;

        while(!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0 ; i < size ; i++) {

                int v = queue.poll();

                for (int j = 1 ; j <= n; j++) {
                    if (!c[j] && status[v][j]) {
                        queue.add(j);
                        c[j] = true;
                        num += depth;
                    }
                }
            }

            depth++;
        }

        return num;
    }

    public static void main(String[] args) {
		////////////////////////
		//입력 
    	////////////////////////
    	
        Scanner sc = new Scanner(System.in);

        min = Integer.MAX_VALUE; //케빈 베이컨의 결과 값
        n = sc.nextInt();	//유저 수
        m = sc.nextInt();	//친구 관계 수

        //유저 번호에 맞는 친구 관계를 참 거짓으로 (true면 친구, false면 친구x)
        boolean[][] status = new boolean[n+1][n+1];

        //친구 관계 만큼 반복
        for (int i = 0 ; i < m ; i++) {
            int v1 = sc.nextInt();
            int v2 = sc.nextInt();

            //친구 관계는 쌍방향이기 때문에 
            status[v1][v2] = status[v2][v1] =true;
        }

        
        
        
        ////////////////////////
        //최소인 유저 찾기
        ////////////////////////
        
        int minUserNum = 0;
        for (int userNum = 1 ; userNum <= n ; userNum++) {
        	
            int tempMinUserNum = findKevinBacon(userNum, status);
            
            //번호가 가장 작은 사람을 출력하기 때문에 >= 이 아니고 > 
            if (min > tempMinUserNum) {
                min = tempMinUserNum;
                minUserNum = userNum;
            }
        }

        System.out.println(minUserNum);
    }
}