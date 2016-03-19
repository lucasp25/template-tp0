package ar.fiuba.tdd.template.tp0;

public class SpecialCharPoint extends GeneratedRandomString {

	@Override
	public void generatedPartialString(ResultString result,
											   RandomCustom randomCustom) {
		result.setLastRandomString(this.getStringSpecialPoint(1, randomCustom));
		result.concantLastRandomStringToMatchResult();
		result.setPreviousCharGenerated(result.getLastRandomString());
	}

	private String getStringSpecialPoint(int maxLength, RandomCustom randomCustom) {
		return randomCustom.getAlphanumericString(maxLength);
	}

}
