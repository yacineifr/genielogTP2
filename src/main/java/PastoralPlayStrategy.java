public class PastoralPlayStrategy implements PlayStrategy {


    @Override
    public PlayType type() {
        return PlayType.PASTORAL;
    }

    @Override
    public int calculateAmount(Performance perf) {
        // add business logic for amount calculation
        return 0;
    }
}
