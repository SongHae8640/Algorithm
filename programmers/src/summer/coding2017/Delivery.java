package summer.coding2017;
/*
 *2017 서머 코딩 - 배달 
 *https://programmers.co.kr/learn/courses/30/lessons/12978
 * 
 * */

public class Delivery {

	public static void main(String[] args) {
		int[][] road = new int[][] {{1, 2, 1}, {2, 3, 3}, {5, 2, 2}, {1, 4, 2}, {5, 3, 1}, {5, 4, 2}};
		System.out.println(solution(5, road, 3));

	}
	
	//N은 마을의 개수, road는 각 마을을 연결하는 도로의 정보, K는 읍식 배달이 가능한 시간
	//음식 주문을 받을 수 있는 마을의 개수를 return
    public static int solution(int N, int[][] road, int K) {
        int answer = 0;

        int[][] oneToNDistance = new int[N-1][];
        for (int i = 0; i < road.length; i++) {
        	//road[i][0]에 더 낮은 수를 둔다.
			if (road[i][0] > road[i][1]) {
				road[i][0] +=road[i][1];
				road[i][1] = road[i][0]-road[i][1];
				road[i][0]-=road[i][1];
				
			}
		}

        return answer;
    }


}
