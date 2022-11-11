import java.util.Map;

public interface IPrinter {

    String print(Invoice invoice, Map<String, Play> plays);
}
