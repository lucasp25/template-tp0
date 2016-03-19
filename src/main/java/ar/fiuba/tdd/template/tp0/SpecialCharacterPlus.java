package ar.fiuba.tdd.template.tp0;

public class SpecialCharacterPlus extends GeneratedRandomString {

	@Override
	public void generatedPartialString(ResultString result,
											   RandomCustom randomCustom) {
		result.setLastRandomString(this.getStringSpecialPlus(result.getPreviousCharGenerated(), Constant.MAX_LENGTH_RANDOM_PLUS, randomCustom));
		result.concantLastRandomStringToMatchResult();
		result.setPreviousChar(result.getLastRandomString());
	}

	private String getStringSpecialPlus(String previousChar, int maxLength, RandomCustom randomCustom) {
		int randomLength = randomCustom.getRandomIntegerByMinAndMax(0, maxLength);
		String out = buildString(previousChar, randomLength);
		return out;
	}
}
