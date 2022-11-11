import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

class ComedyPlayStrategyTest {

    @Test
    void calculateAmount() {
        PlayStrategy comedyPlayStrategy = new ComedyPlayStrategy();
        int amount = comedyPlayStrategy.calculateAmount(new Performance("as-like", 35));

        assertEquals(58000, amount);
    }
}