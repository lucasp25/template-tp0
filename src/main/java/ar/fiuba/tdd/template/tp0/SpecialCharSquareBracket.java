package ar.fiuba.tdd.template.tp0;

public class SpecialCharSquareBracket extends GeneratedRandomString {

  @Override
  public ResultString generatedParcialString(ResultString result,
                                             RandomCustom randomCustom) {

    result.setIndexLastChar(result.getReGex().indexOf(Constant.END_SQUARE_BRACKET));
    result.setLastRandomString(randomCustom.getAlphanumericStringByValues(result.getReGex().substring(result.getIterator().getPosition(), result.getIndexLastChar() + 1).replace("[", "").replace("]", ""), 1));
    result.concantLastRandomStringToMatchResult();
    result.setPreviousCharGenerated(result.getLastRandomString());
    result.getIterator().setPositionString((result.getIndexLastChar() + 1));

    return result;
  }

}
