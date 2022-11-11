public class HistoryPlayStrategy implements PlayStrategy {


    @Override
    public PlayType type() {
        return PlayType.HISTORY;
    }

    @Override
    public int calculateAmount(Performance perf) {
        // add business logic for amount calculation
        return 0;
    }
}
