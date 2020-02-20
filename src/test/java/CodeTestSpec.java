import org.junit.Test;

import java.util.function.Function;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

/*
 *   Please code the tests in the format of reverseArray_returnsExpectedResult. This is an example of how we write our tests at Cardano.
 *
 *   Test 1-4 tests are easy as the function returns a result that can be asserted. Tests 5-7 are more difficult to assert as they are
 *   void, use your knowledge to write a meaningful test.
 *
 *   Feel free to use the internet to help you with you answers but make sure you understand the answer as we will ask you questions.
 */

public class CodeTestSpec {
    @Test
    public void reverseArray_returnsExpectedResult() {
        // arrange
        final String[] EXPECTED = {"x", "y", "z", null};

        // act
        final String[] actual = CodeTest.reverseArray(new String[] {null, "z", "y", "x"});

        // assert
        assertArrayEquals(EXPECTED, actual);
    }

    @Test
    public void reverseArray_emptyArray() {
        assertThat(CodeTest.reverseArray(new String[0]), equalTo(new String[0]));
    }

    @Test
    public void uppercaseArray_returnsExpectedResult() {
        final String[] EXPECTED = {"AAA", "BBB", "CCC", "DDD", null};

        final String[] actual = CodeTest.uppercaseArray(new String[] {"aaA", "Bbb", "CCC", "ddd", null});

        assertArrayEquals(EXPECTED, actual);
    }

    @Test
    public void uppercaseArray_emptyArray() {
        assertThat(CodeTest.uppercaseArray(new String[0]), equalTo(new String[0]));
    }

    @Test
    public void findWordCount_returnsExpectedResult() {
        final int EXPECTED = 2;

        final int actual = CodeTest.findWordCount("Scala, Java, JavaScript. 'java-8'", "Java");

        assertEquals(EXPECTED, actual);
    }

    @Test
    public void findWordCount_emptyWord() {
        assertThat(CodeTest.findWordCount("Scala, Java, JavaScript. 'java'", " "), equalTo(0));
    }

    @Test
    public void composeU_returnsExpectedResult() {
        Function<Integer, Integer> times2 = x -> x * 2;
        Function<Integer, Integer> squared = y -> y * y;
        Function<Integer, Integer> composedFunc = CodeTest.composeU(times2, squared);

        assertThat(composedFunc.apply(4), equalTo(32));
    }

    @Test
    public void writeContentsToConsole_returnsExpectedResult() {
    }

    @Test
    public void handleInvalidArgument_returnsExpectedResult() {
    }

    @Test
    public void puzzle_returnsExpectedResult() {
        CodeTest.main(new String[] {"1","3","5","5","7","8","8","8","9"});
    }

}
