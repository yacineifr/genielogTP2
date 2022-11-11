import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.approvaltests.Approvals.verify;

public class StatementPrinterTests {

    @Test
    void exampleStatement() {
        Map<String, Play> plays = Map.of(
                "hamlet",  new Play("Hamlet", PlayType.TRAGEDY),
                "as-like", new Play("As You Like It", PlayType.COMEDY),
                "othello", new Play("Othello", PlayType.TRAGEDY));

        Invoice invoice = new Invoice("BigCo", List.of(
                new Performance("hamlet", 55),
                new Performance("as-like", 35),
                new Performance("othello", 40)));

        IPrinter statementPrinter = new StatementPrinter();
        var result = statementPrinter.print(invoice, plays);

        verify(result);
    }

    @Test
    void statementWithNewPlayTypes() {
        Map<String, Play> plays = Map.of(
                "henry-v",  new Play("Henry V", PlayType.HISTORY),
                "as-like", new Play("As You Like It", PlayType.PASTORAL));

        Invoice invoice = new Invoice("BigCo", List.of(
                new Performance("henry-v", 53),
                new Performance("as-like", 55)));

        IPrinter statementPrinter = new StatementPrinter();
        var result = statementPrinter.print(invoice, plays);

        verify(result);

        // No more exception assertion because now we support History and Pastoral
        /*Assertions.assertThrows(Error.class, () -> {
            statementPrinter.print(invoice, plays);
        });*/
    }
}
