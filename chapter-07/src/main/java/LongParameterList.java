public class LongParameterList {
    void print(
            String documentToPrint,
            String paperSize,
            String orientation,
            boolean grayScales,
            int pageFrom,
            int pageTo,
            int copies,
            float marginLeft,
            float marginRight,
            float marginTop,
            float marginBottom) {
    }

    void refactoredPrint(
            PaperSize papersize,
            PrintOrientation orientation,
            ColorConfiguration color,
            PrintRange range,
            PrintMargins margins,
            int copiesCount
    ) {
    }
}


final class PaperSize {
}

final class Document {
}

final class PrintMargins {
}

final class PrintRange {
}

final class ColorConfiguration {
}

final class PrintOrientation {
}