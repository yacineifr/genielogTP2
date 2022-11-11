import java.text.NumberFormat;
import java.util.Locale;
import java.util.Map;

public class HtmlPrinter extends AbstractPlayStategyContext implements IPrinter {

  @Override
  public String print(Invoice invoice, Map<String, Play> plays) {
    int totalAmount = 0;
    int volumeCredits = 0;
    String result = String.format("<h3>Statement for %s </h3>\n<ul>", invoice.getCustomer());

    NumberFormat frmt = NumberFormat.getCurrencyInstance(Locale.US);

    for (Performance perf : invoice.getPerformances()) {
      Play play = plays.get(perf.getPlayID());

      int thisAmount = amoutByPlayType(play.getType(), perf);

      // add volume credits
      volumeCredits += Math.max(perf.getAudience() - 30, 0);
      // add extra credit for every ten comedy attendees
      if (PlayType.COMEDY.equals(play.getType())) volumeCredits += Math.floor(perf.getAudience() / 5);

      // print line for this order
      result += String.format("  <li> <h5>%s: %s (%s seats)</h5></li>\n", play.getName(), frmt.format(thisAmount / 100), perf.getAudience());
      totalAmount += thisAmount;
    }
    result += String.format("</ul><h4>Amount owed is %s</h4>\n", frmt.format(totalAmount / 100));
    result += String.format("<h4>You earned %s credits</h4>\n", volumeCredits);
    return result;
  }

}
