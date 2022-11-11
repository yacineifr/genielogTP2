public class ComedyPlayStrategy implements PlayStrategy {

    @Override
    public PlayType type() {
        return PlayType.COMEDY;
    }

    @Override
    public int calculateAmount(Performance perf) {
        int thisAmount = 30000;
        if (perf.getAudience() > 20) {
            thisAmount += 10000 + 500 * (perf.getAudience() - 20);
        }
        thisAmount += 300 * perf.getAudience();

        return thisAmount;
    }
}
