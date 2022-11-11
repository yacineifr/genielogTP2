import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TragedyPlayStrategyTest {

    @Test
    void calculateAmount() {
        Performance hamlet = new Performance("hamlet", 55);
        Performance othello = new Performance("othello", 40);

        PlayStrategy playStrategy = new TragedyPlayStrategy();
        int hamletAmount = playStrategy.calculateAmount(hamlet);
        int othelloAmount = playStrategy.calculateAmount(othello);

        assertEquals(65000, hamletAmount);
        assertEquals(50000, othelloAmount);

    }
}