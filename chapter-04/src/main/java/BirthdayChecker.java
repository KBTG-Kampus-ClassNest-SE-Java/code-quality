import java.time.LocalDateTime;

public class BirthdayChecker {
	boolean isBirthday() {
		LocalDateTime today = LocalDateTime.now();
		return today.getDayOfMonth() == 1 && today.getMonthValue() == 1;
	}
}
