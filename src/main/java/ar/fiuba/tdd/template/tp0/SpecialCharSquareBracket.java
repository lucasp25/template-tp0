package ar.fiuba.tdd.template.tp0;

public class SpecialCharSquareBracket extends GeneratedRandomString {

  @Override
  public void generatedPartialString(ResultString result,
                                             RandomCustom randomCustom) {
    int startPosition = result.getIterator().getPosition();

    this.findEndSquareBracket(result);

    int endPosition = result.getIterator().getPosition() - 1;
    result.setIndexLastChar(endPosition);
    result.setLastRandomString(randomCustom.getAlphanumericStringByValues(result.getReGex().substring(startPosition, endPosition), 1));
    result.concantLastRandomStringToMatchResult();
    result.setPreviousCharGenerated(result.getLastRandomString());
    result.getIterator().setPositionString((result.getIndexLastChar() + 1));
  }

  private void findEndSquareBracket(ResultString result) {
    String actualChar = "";
    while(result.getIterator().hasNext() && !actualChar.equals(Constant.END_SQUARE_BRACKET)) {
      actualChar = result.getIterator().next();
    }
  }

}
