package level2;

public class 피로도 {
    public static void main(String[] args) {
        System.out.println(new 피로도().solution(80, new int[][] 	{{80,20},{50,40},{30,10}} )); // 3
    }

    private int maxDepth;

    public int solution(int k, int[][] dungeons) {
        maxDepth = 0;
        Dungeon[] dungeonArr = new Dungeon[dungeons.length];
        for (int i = 0; i < dungeons.length; i++) {
            dungeonArr[i] = new Dungeon(dungeons[i][0], dungeons[i][1]);
        }

        dfs(k,0,dungeonArr);
        return maxDepth;
    }

    public void dfs(int hp, int depth, Dungeon[] dungeonArr){
        maxDepth = Math.max(maxDepth , depth);

        for (Dungeon dungeon : dungeonArr) {
            if (dungeon.canExplore(hp)) {
                dfs(dungeon.explore(hp), depth + 1, dungeonArr);
                dungeon.back();
            }
        }
    }

    public class Dungeon{
        final int requiredHp;
        final int consumedHp;
        public boolean isVisit;

        public Dungeon(int requiredHp, int consumedHp){
            this.requiredHp = requiredHp;
            this.consumedHp = consumedHp;
        }

        public int explore(int hp){
            isVisit = true;
            return hp - consumedHp;
        }

        public void back(){
            isVisit = false;
        }

        public boolean canExplore(int hp){
            return !isVisit && hp >= requiredHp;
        }
    }
}
/**
 *
 * 정확성  테스트
 * 테스트 1 〉	통과 (0.44ms, 72.7MB)
 * 테스트 2 〉	통과 (0.32ms, 86.6MB)
 * 테스트 3 〉	통과 (0.39ms, 80.7MB)
 * 테스트 4 〉	통과 (0.55ms, 76.7MB)
 * 테스트 5 〉	통과 (0.85ms, 85.8MB)
 * 테스트 6 〉	통과 (1.10ms, 74.7MB)
 * 테스트 7 〉	통과 (2.31ms, 90.2MB)
 * 테스트 8 〉	통과 (3.54ms, 73.2MB)
 * 테스트 9 〉	통과 (0.42ms, 75.3MB)
 * 테스트 10 〉	통과 (0.86ms, 88.1MB)
 * 테스트 11 〉	통과 (0.29ms, 84.9MB)
 * 테스트 12 〉	통과 (0.98ms, 83.9MB)
 * 테스트 13 〉	통과 (0.56ms, 84.5MB)
 * 테스트 14 〉	통과 (0.51ms, 70.4MB)
 * 테스트 15 〉	통과 (0.39ms, 76.1MB)
 * 테스트 16 〉	통과 (0.34ms, 81.1MB)
 * 테스트 17 〉	통과 (0.52ms, 86.9MB)
 * 테스트 18 〉	통과 (0.38ms, 73.3MB)
 * 테스트 19 〉	통과 (0.50ms, 74.8MB)
 * 채점 결과
 * 정확성: 100.0
 * 합계: 100.0 / 100.0
 */
