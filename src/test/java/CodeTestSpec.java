import org.junit.Test;
import static org.junit.Assert.assertArrayEquals;

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
        final String[] EXPECTED = {"x", "y", "z"};

        // act
        final String[] actual = CodeTest.reverseArray(new String[] {"z", "y", "x"});

        // assert
        assertArrayEquals(EXPECTED, actual);
    }

    @Test
    public void uppercaseArray_returnsExpectedResult() {

    }

    @Test
    public void findWordCount_returnsExpectedResult() {

    }

    @Test
    public void composeU_returnsExpectedResult() {

    }

    @Test
    public void writeContentsToConsole_returnsExpectedResult() {

    }

    @Test
    public void handleInvalidArgument_returnsExpectedResult() {

    }

    @Test
    public void puzzle_returnsExpectedResult() {

    }
}
