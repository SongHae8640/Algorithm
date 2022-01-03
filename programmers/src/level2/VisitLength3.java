package level2;

public class VisitLength3 {

    public int solution(String dirs) {
        //격자판 - xy 축이 모두 짝수이면 점, 둘중 하나만 짝수이면 선
        //지나간 선은 1, 지나가지 않은 선은 0
        boolean [][] gridPlate = new boolean[21][21];

        int xAxis = 10;
        int yAxis = 10;


        for (int i = 0 ; i <dirs.length() ; i++){
            char command = dirs.charAt(i);


            if((command =='U') && (yAxis + 2 <= 20)){ //위로 이동
                gridPlate[xAxis][yAxis+1] = true;
                yAxis+=2;

            }else if((command =='D') && (yAxis -2 >= 0)){ //아래로 이동
                gridPlate[xAxis][yAxis-1] = true;
                yAxis-=2;

            }else if((command =='R') && (xAxis +2 <= 20)){    //오른쪽으로 이동
                gridPlate[xAxis+1][yAxis] = true;
                xAxis+=2;

            }else if ((command =='L') && (xAxis -2 >= 0)){    //왼쪽으로 이동
                gridPlate[xAxis-1][yAxis] = true;
                xAxis-=2;

            }
        }


        return getLineCount(gridPlate);
    }

    private int getLineCount(boolean[][] gridPlate) {
        int lineCount = 0;
        for (int x = 0 ; x < gridPlate.length ; x++){
            for(int y = 0 ; y < gridPlate[x].length ; y++ ){
                if(gridPlate[x][y]){
                    lineCount++;
                }
            }
        }

        return lineCount;
    }
}
/**
 *
 * 방문 길이
 * https://programmers.co.kr/learn/courses/30/lessons/49994
 *
 * 정확성  테스트
 * 테스트 1 〉	통과 (0.05ms, 74MB)
 * 테스트 2 〉	통과 (0.06ms, 73.9MB)
 * 테스트 3 〉	통과 (0.04ms, 71.5MB)
 * 테스트 4 〉	통과 (0.05ms, 75.9MB)
 * 테스트 5 〉	통과 (0.04ms, 76.8MB)
 * 테스트 6 〉	통과 (0.04ms, 79.3MB)
 * 테스트 7 〉	통과 (0.06ms, 86.6MB)
 * 테스트 8 〉	통과 (0.04ms, 74.8MB)
 * 테스트 9 〉	통과 (0.03ms, 74.6MB)
 * 테스트 10 〉	통과 (0.04ms, 82.3MB)
 * 테스트 11 〉	통과 (0.04ms, 73.9MB)
 * 테스트 12 〉	통과 (0.04ms, 73.7MB)
 * 테스트 13 〉	통과 (0.05ms, 77.4MB)
 * 테스트 14 〉	통과 (0.05ms, 69.1MB)
 * 테스트 15 〉	통과 (0.05ms, 77.7MB)
 * 테스트 16 〉	통과 (0.07ms, 77MB)
 * 테스트 17 〉	통과 (0.11ms, 78.7MB)
 * 테스트 18 〉	통과 (0.07ms, 77.1MB)
 * 테스트 19 〉	통과 (0.08ms, 77.5MB)
 * 테스트 20 〉	통과 (0.07ms, 78.5MB)
 * 채점 결과
 * 정확성: 100.0
 * 합계: 100.0 / 100.0
 *
 * */