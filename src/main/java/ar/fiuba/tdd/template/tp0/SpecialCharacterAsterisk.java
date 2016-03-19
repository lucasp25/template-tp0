package ar.fiuba.tdd.template.tp0;

public class SpecialCharacterAsterisk extends GeneratedRandomString {

	@Override
	public ResultString generatedParcialString(ResultString result,
																						 RandomCustom randomCustom) {

		int randomLength = randomCustom.getRandomIntegerByMinAndMax(0, Constant.MAX_LENGTH_RANDOM_ASTERISK);

		if (randomLength == 0) {
			result.deleteLastCharInMatachResult();
		} else {
			result.setLastRandomString(buildString(result.getPreviousCharGenerated(), randomLength));
			result.concantLastRandomStringToMatchResult();
			result.setPreviousCharGenerated(result.getLastRandomString());
		}
		return null;
	}


}
