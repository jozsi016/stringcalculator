package hu.jnagy;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


public class StringCalculatorTest {
    StringCalculator underTest;

    @Before
    public void setUp() {
        underTest = new StringCalculator();
    }

    @Test
    public void shouldReturnZeroForEmpty() {
        //Given
        String emptyString = "";
        //When
        int actual = underTest.add(emptyString);
        //Actual
        assertThat(actual, is(0));
    }

    @Test
    public void shouldReturnTheInput() {
        //Given
        String number = "5";
        //When
        int actual = underTest.add(number);
        //Then
        assertThat(actual, is(5));
    }

    @Test
    public void shouldReturnTheSumOfTwoNumber() {
        //Given
        String numbers = "5,6";
        //When
        int actual = underTest.add(numbers);
        //Actual
        assertThat(actual, is(11));
    }

    @Test
    public void shouldReturnTheSumOfAnyNumbers() {
        //Given
        String numbers = "5,6,7,8";
        //When
        int actual = underTest.add(numbers);
        //Actual
        assertThat(actual, is(26));
    }

    @Test
    public void shouldAcceptLineSeparator() {
        //Given
        String numbers = "5,6,7\n8";
        //When
        int actual = underTest.add(numbers);
        //Actual
        assertThat(actual, is(26));
    }

    @Test
    public void shouldChangeTheSeparatorDynamically() {
        //Given
        String basicNumbers = "5,6,7,8";
        String numbersWithSemiColon = "//;\n1;2";

        //When
        int actualBasic = underTest.add(basicNumbers);
        int actualWithSemiColon = underTest.add(numbersWithSemiColon);

        //Actual
        assertThat(actualBasic, is(26));
        assertThat(actualWithSemiColon, is(3));
    }

    @Test
    public void shouldThrowExceptionIfNegativeNumberOccur() {
        try {
            //Given
            // String numbers = "//;\n-2,3,-4,5,-6,7";
            // String numbers = "-2,3,-4,5,-6,7";
            String numbers = "-1";
            //When
            int actual = underTest.add(numbers);
        } catch (IllegalArgumentException ex) {
            //Then
            assertThat("negatives not allowed -1 ", is(ex.getMessage()));
        }
    }

    @Test
    public void shouldIgnoreBigNumbers() {
        //Given
        String numbers = "//;\n2;3;4;5;6;7;1001";
        // String numbers = "1,2,1001,3";
        //When
        int actual = underTest.add(numbers);
        //Then
        assertThat(actual, is(27));
    }

    @Test
    public void shouldAcceptLongSeparator() {
        //Given
        String numbers = "//[eee]\n2eee3eee4";
        //When
        int actual = underTest.add(numbers);
        //Then
        assertThat(actual, is(9));
    }

    @Test
    public void shouldHandleMultipleDelimiter() {
        //Given
        String numbers = "//[,][%][!]\n2,3%4!6";
        //When
        //  int actual = underTest.add(numbers);
        //Then
        //assertThat(actual,is(15));
    }
}
