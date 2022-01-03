package level1;

import static org.junit.jupiter.api.Assertions.*;

class ShahadNumberTest {

    public static void main(String[] args) {
        ShahadNumber shahadNumber = new ShahadNumber();
        assertEquals(true,shahadNumber.solution(10));
        assertEquals(true,shahadNumber.solution(12));
        assertEquals(false,shahadNumber.solution(11));
        assertEquals(false,shahadNumber.solution(13));

    }

}