package level2;

import java.util.Arrays;
import java.util.TreeSet;

public class 전화번호목록 {
    public static void main(String[] args) {
        System.out.println(new 전화번호목록().solution2(new String[]{"119", "97674223", "1195524421"})); //false
        System.out.println(new 전화번호목록().solution2(new String[]{"123","456","789"})); //true
        System.out.println(new 전화번호목록().solution2(new String[]{"12","123","1235","567","88"})); //false

    }

    public boolean solution(String[] phone_book) {
        TreeSet<PhoneNumber> set = new TreeSet<>();
        for (String number : phone_book){
            set.add(new PhoneNumber(number));
        }

        for (PhoneNumber current : set){
            for (PhoneNumber next : set.tailSet(current, false)){
                if(current.length == next.length) continue;
                if(next.number.startsWith(current.number)) return false;
            }
        }
        return true;
    }

    public class PhoneNumber implements Comparable<PhoneNumber> {
        final String number;
        final int length;

        public PhoneNumber(String number){
            this.number = number;
            this.length = number.length();
        }

        @Override
        public int compareTo(PhoneNumber o) {
            int comp = this.length - o.length;
            if(comp == 0) {
                return this.number.compareTo(o.number);
            }
            return comp;
        }
    }


    public boolean solution2(String[] phone_book) {
        Arrays.sort(phone_book);

        for (int i = 0; i < phone_book.length-1; i++) {
            if (phone_book[i+1].startsWith(phone_book[i])){
                return false;
            }
        }
        return true;
    }
}
/*


정확성  테스트
테스트 1 〉	통과 (1.85ms, 80.1MB)
테스트 2 〉	통과 (1.94ms, 87MB)
테스트 3 〉	통과 (1.31ms, 87MB)
테스트 4 〉	통과 (2.07ms, 85.1MB)
테스트 5 〉	통과 (1.84ms, 80.8MB)
테스트 6 〉	통과 (2.05ms, 85.2MB)
테스트 7 〉	통과 (2.93ms, 75.3MB)
테스트 8 〉	통과 (1.80ms, 79.6MB)
테스트 9 〉	통과 (1.97ms, 92.1MB)
테스트 10 〉	통과 (1.20ms, 77.6MB)
테스트 11 〉	통과 (1.89ms, 87.4MB)
테스트 12 〉	통과 (1.29ms, 79.8MB)
테스트 13 〉	통과 (1.25ms, 72MB)
테스트 14 〉	통과 (25.77ms, 94.1MB)
테스트 15 〉	통과 (30.47ms, 93.8MB)
테스트 16 〉	통과 (26.34ms, 86MB)
테스트 17 〉	통과 (31.09ms, 78.8MB)
테스트 18 〉	통과 (63.56ms, 101MB)
테스트 19 〉	통과 (44.71ms, 91.3MB)
테스트 20 〉	통과 (73.44ms, 82MB)
효율성  테스트
테스트 1 〉	통과 (13.14ms, 59.1MB)
테스트 2 〉	통과 (17.36ms, 61MB)
테스트 3 〉	실패 (시간 초과)
테스트 4 〉	실패 (시간 초과)
채점 결과
정확성: 83.3
효율성: 8.3
합계: 91.7 / 100.0


solution2
정확성  테스트
테스트 1 〉	통과 (0.38ms, 87.5MB)
테스트 2 〉	통과 (0.43ms, 78.2MB)
테스트 3 〉	통과 (0.37ms, 90MB)
테스트 4 〉	통과 (0.51ms, 89MB)
테스트 5 〉	통과 (0.37ms, 79.5MB)
테스트 6 〉	통과 (0.59ms, 86.9MB)
테스트 7 〉	통과 (0.33ms, 75.5MB)
테스트 8 〉	실패 (0.35ms, 73.4MB)
테스트 9 〉	실패 (0.35ms, 77.2MB)
테스트 10 〉	통과 (0.34ms, 84MB)
테스트 11 〉	통과 (0.39ms, 76.7MB)
테스트 12 〉	통과 (0.35ms, 78.1MB)
테스트 13 〉	통과 (0.32ms, 86.6MB)
테스트 14 〉	통과 (2.22ms, 73.8MB)
테스트 15 〉	통과 (3.69ms, 80.8MB)
테스트 16 〉	통과 (2.78ms, 82.4MB)
테스트 17 〉	통과 (4.27ms, 92.2MB)
테스트 18 〉	통과 (4.15ms, 84.6MB)
테스트 19 〉	실패 (4.38ms, 76MB)
테스트 20 〉	통과 (4.53ms, 74.1MB)
효율성  테스트
테스트 1 〉	통과 (20.73ms, 59.5MB)
테스트 2 〉	통과 (18.87ms, 59.1MB)
테스트 3 〉	통과 (440.77ms, 116MB)
테스트 4 〉	통과 (282.13ms, 98.8MB)
채점 결과
정확성: 70.8
효율성: 16.7
합계: 87.5 / 100.0

 */
