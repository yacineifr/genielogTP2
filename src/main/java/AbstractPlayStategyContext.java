public abstract class AbstractPlayStategyContext {

    protected int amoutByPlayType(PlayType playType, Performance perf){
        int thisAmount = 0;
        switch (playType) {
            case TRAGEDY:
                thisAmount = new TragedyPlayStrategy().calculateAmount(perf);
                break;
            case COMEDY:
                thisAmount = new ComedyPlayStrategy().calculateAmount(perf);
                break;
            case HISTORY:
                thisAmount = new HistoryPlayStrategy().calculateAmount(perf);
                break;
            case PASTORAL:
                thisAmount = new PastoralPlayStrategy().calculateAmount(perf);
                break;
            default:
                throw new Error("unknown type: ${play.getType()}");
        }

        return thisAmount;
    }
}
