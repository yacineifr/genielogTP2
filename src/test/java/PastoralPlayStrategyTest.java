import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PastoralPlayStrategyTest {

    @Test
    void calculateAmount() {
        PlayStrategy pastoralPlayStrategy = new PastoralPlayStrategy();
        int amount = pastoralPlayStrategy.calculateAmount(new Performance("as-like", 35));

        assertEquals(0, amount);
    }
}