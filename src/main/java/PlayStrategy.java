public interface PlayStrategy {

    PlayType type();

    int calculateAmount(Performance perf);
}
