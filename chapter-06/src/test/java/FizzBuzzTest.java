import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class FizzBuzzTest {

    @Test
    @DisplayName("input 1 should return 1")
    void input1ShouldReturn1() {
        FizzBuzz fizzBuzz = new FizzBuzz();

        String actualResult = fizzBuzz.fizzBuzz(1);

        assertEquals("1", actualResult);
    }
}
