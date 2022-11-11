import java.text.NumberFormat;
import java.util.*;

public class StatementPrinter extends AbstractPlayStategyContext implements IPrinter  {

  @Override
  public String print(Invoice invoice, Map<String, Play> plays) {
    int totalAmount = 0;
    int volumeCredits = 0;
    String result = String.format("Statement for %s\n", invoice.getCustomer());

    NumberFormat frmt = NumberFormat.getCurrencyInstance(Locale.US);

    for (Performance perf : invoice.getPerformances()) {
      Play play = plays.get(perf.getPlayID());
       int thisAmount = amoutByPlayType(play.getType(), perf);
      // add volume credits
      volumeCredits += Math.max(perf.getAudience() - 30, 0);
      // add extra credit for every ten comedy attendees
      if (PlayType.COMEDY.equals(play.getType())) volumeCredits += Math.floor(perf.getAudience() / 5);

      // print line for this order
      result += String.format("  %s: %s (%s seats)\n", play.getName(), frmt.format(thisAmount / 100), perf.getAudience());
      totalAmount += thisAmount;
    }
    result += String.format("Amount owed is %s\n", frmt.format(totalAmount / 100));
    result += String.format("You earned %s credits\n", volumeCredits);
    return result;
  }

}
