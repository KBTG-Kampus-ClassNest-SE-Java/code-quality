import java.time.LocalDate;

public class DataClump {
    void invoiceIn(LocalDate start, LocalDate end) {
    }

    void receivedIn(LocalDate start, LocalDate end) {
    }

    void overdueIn(LocalDate start, LocalDate end) {
    }
}

class Refactored {
    void invoiceIn(DateRange range) {
    }

    void receivedIn(DateRange range) {
    }

    void overdueIn(DateRange range) {
    }
}

record DateRange(LocalDate start, LocalDate end) {
}