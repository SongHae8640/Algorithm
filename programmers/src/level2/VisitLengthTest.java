package level2;

import level1.MockTest2;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class VisitLengthTest {

    public static void main(String[] args) {
        VisitLength2 visitLength = new VisitLength2();

        assertEquals(7, visitLength.solution("ULURRDLLU"));
        assertEquals(7, visitLength.solution("LULLLLLLU"));
        assertEquals(1, visitLength.solution("UDU"));


    }

}