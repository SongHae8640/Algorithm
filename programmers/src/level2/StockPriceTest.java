package level2;

import level1.ShahadNumber;

import static org.junit.jupiter.api.Assertions.*;

class StockPriceTest {

    public static void main(String[] args) {
        StockPrice stockPrice = new StockPrice();
        assertArrayEquals(new int[]{4, 3, 1, 1, 0},stockPrice.solution(new int[]{1, 2, 3, 2, 3}));

    }

}