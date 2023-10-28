public class FizzBuzz {
    public String fizzBuzz(int number) {
        if (number % 3 == 0) {
            return "Fizz";
        }
        if (number == 5) {
            return "Buzz";
        }
        return number + "";
    }
}
