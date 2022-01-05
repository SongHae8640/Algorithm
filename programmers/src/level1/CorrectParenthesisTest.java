package level1;

import org.hamcrest.MatcherAssert;

import static org.junit.jupiter.api.Assertions.*;

class CorrectParenthesisTest {

    public static void main(String[] args) {
        CorrectParenthesis correctParenthesis = new CorrectParenthesis();

        assertEquals(true , correctParenthesis.solution("()()"));
        assertEquals(true , correctParenthesis.solution("(())()"));
        assertEquals(false , correctParenthesis.solution(")()("));
        assertEquals(false , correctParenthesis.solution("(()("));


    }

}