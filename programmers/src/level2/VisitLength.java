package level2;

public class VisitLength {

    public int solution(String dirs) {
        int answer = 0;

        //격자판 - xy 축이 모두 짝수이면 점, 둘중 하나만 짝수이면 선
        //지나간 선은 1, 지나가지 않은 선은 0
        int [][] gridPlate = new int[21][21];

        int xAxis = 10;
        int yAxis = 10;

        String[] commands = dirs.split("");

        for (String command :commands) {


            if(command.equals("U") && yAxis + 2 <= 20){ //위로 이동
                gridPlate[xAxis][yAxis+1] = 1;
                yAxis+=2;

            }else if(command.equals("D") && yAxis -2 >= 0){ //아래로 이동
                gridPlate[xAxis][yAxis-1] = 1;
                yAxis-=2;

            }else if(command.equals("R") && xAxis +2 <= 20){    //오른쪽으로 이동
                gridPlate[xAxis+1][yAxis] = 1;
                xAxis+=2;

            }else if (command.equals("L") && xAxis -2 >= 0){    //왼쪽으로 이동
                gridPlate[xAxis-1][yAxis] = 1;
                xAxis-=2;

            }
        }


        return getLineCount(gridPlate);
    }

    private int getLineCount(int[][] gridPlate) {
        int lineCount = 0;
        for (int x = 0 ; x < gridPlate.length ; x++){
            for(int y = 0 ; y < gridPlate[x].length ; y++ ){
                lineCount += gridPlate[x][y];
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
 * 테스트 1 〉	통과 (0.20ms, 78.4MB)
 * 테스트 2 〉	통과 (0.19ms, 68.1MB)
 * 테스트 3 〉	통과 (0.17ms, 76.6MB)
 * 테스트 4 〉	통과 (0.33ms, 77MB)
 * 테스트 5 〉	통과 (0.51ms, 77.8MB)
 * 테스트 6 〉	통과 (0.24ms, 74MB)
 * 테스트 7 〉	통과 (0.24ms, 79.4MB)
 * 테스트 8 〉	통과 (0.31ms, 74.7MB)
 * 테스트 9 〉	통과 (0.20ms, 72.3MB)
 * 테스트 10 〉	통과 (0.20ms, 74.9MB)
 * 테스트 11 〉	통과 (0.21ms, 74.2MB)
 * 테스트 12 〉	통과 (0.51ms, 90.6MB)
 * 테스트 13 〉	통과 (0.51ms, 75.7MB)
 * 테스트 14 〉	통과 (0.29ms, 76.8MB)
 * 테스트 15 〉	통과 (0.29ms, 74MB)
 * 테스트 16 〉	통과 (1.10ms, 77.8MB)
 * 테스트 17 〉	통과 (1.01ms, 78MB)
 * 테스트 18 〉	통과 (1.48ms, 76.2MB)
 * 테스트 19 〉	통과 (1.30ms, 77.4MB)
 * 테스트 20 〉	통과 (1.43ms, 78.1MB)
 * 채점 결과
 * 정확성: 100.0
 * 합계: 100.0 / 100.0
 *
 * */