import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.assertEquals;

class CalculatorTest {

	private Calculator calculator;

	@BeforeEach
	void setUp() {
		calculator = new Calculator();
	}

	@Test
	@DisplayName("1 + 1 = 2")
	void addShouldReturn2() {
		int result = calculator.add(1, 1);

		assertEquals(2, result);
	}

	@ParameterizedTest
	@CsvSource({"2, 1, 1", "2, 2, 0", "3, 3, 0"})
	void subtract(int leftOperand, int rightOperand, int expected) {
		int result = calculator.subtract(leftOperand, rightOperand);

		assertEquals(expected, result);
	}

}
