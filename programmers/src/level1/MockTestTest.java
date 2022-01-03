package level1;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class MockTestTest {

    public static void main(String[] args) {
        MockTest2 mockTest2 = new MockTest2();

        assertArrayEquals(new int[]{1} , mockTest2.solution(new int[]{1, 2, 3, 4, 5}));
        assertArrayEquals(new int[]{1,2,3} , mockTest2.solution(new int[]{1,3,2,4,2}));

    }

}