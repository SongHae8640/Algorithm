package level1;

import static org.junit.jupiter.api.Assertions.*;

class NextBigNumberTest {

    public static void main(String[] args) {
        NextBigNumber nextBigNumber = new NextBigNumber();
        assertEquals(83,nextBigNumber.solution(78));
        assertEquals(23,nextBigNumber.solution(15));

    }

}