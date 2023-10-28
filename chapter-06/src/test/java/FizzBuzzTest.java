import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FizzBuzzTest {

    @Test
    @DisplayName("input 1 should return 1")
    void input1ShouldReturn1() {
        FizzBuzz fizzBuzz = new FizzBuzz();

        String actual = fizzBuzz.fizzBuzz(1);

        assertEquals("1", actual);
    }

    @Test
    @DisplayName("input 2 should return 2")
    void input2ShouldReturn2() {
        FizzBuzz fizzBuzz = new FizzBuzz();

        String actual = fizzBuzz.fizzBuzz(2);

        assertEquals("2", actual);
    }

    @Test
    @DisplayName("input 3 should return Fizz")
    void input3ShouldReturnFizz() {
        FizzBuzz fizzBuzz = new FizzBuzz();

        String actual = fizzBuzz.fizzBuzz(3);

        assertEquals("Fizz", actual);
    }

    @Test
    @DisplayName("input 4 should return 4")
    void input4ShouldReturn4() {
        FizzBuzz fizzBuzz = new FizzBuzz();

        String actual = fizzBuzz.fizzBuzz(4);

        assertEquals("4", actual);
    }

    @Test
    @DisplayName("input 5 should return Buzz")
    void input5ShouldReturnBuzz() {
        FizzBuzz fizzBuzz = new FizzBuzz();

        String actual = fizzBuzz.fizzBuzz(5);

        assertEquals("Buzz", actual);
    }

    @Test
    @DisplayName("input 6 should return Fizz")
    void input6ShouldReturnFizz() {
        FizzBuzz fizzBuzz = new FizzBuzz();

        String actual = fizzBuzz.fizzBuzz(6);

        assertEquals("Fizz", actual);
    }

    @Test
    @DisplayName("input 7 should return 7")
    void input7ShouldReturn7() {
        FizzBuzz fizzBuzz = new FizzBuzz();

        String actual = fizzBuzz.fizzBuzz(7);

        assertEquals("7", actual);
    }

    @Test
    @DisplayName("input 9 should return Fizz")
    void input9ShouldReturnFizz() {
        FizzBuzz fizzBuzz = new FizzBuzz();

        String actual = fizzBuzz.fizzBuzz(9);

        assertEquals("Fizz", actual);
    }
}
