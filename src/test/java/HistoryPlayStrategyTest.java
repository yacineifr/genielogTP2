import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class HistoryPlayStrategyTest {

    @Test
    void calculateAmount() {
        PlayStrategy historyPlayStrategy = new HistoryPlayStrategy();
        int amount = historyPlayStrategy.calculateAmount(new Performance("as-like", 35));

        assertEquals(0, amount);
    }
}