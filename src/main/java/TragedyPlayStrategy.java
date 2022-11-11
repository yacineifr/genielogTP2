public class TragedyPlayStrategy implements PlayStrategy {


    @Override
    public PlayType type() {
        return PlayType.TRAGEDY;
    }

    @Override
    public int calculateAmount(Performance perf) {
        int thisAmount = 40000;
        if (perf.getAudience() > 30) {
            thisAmount += 1000 * (perf.getAudience() - 30);
        }
        return thisAmount;
    }
}
