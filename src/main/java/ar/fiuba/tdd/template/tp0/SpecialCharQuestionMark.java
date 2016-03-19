package ar.fiuba.tdd.template.tp0;

public class SpecialCharQuestionMark extends GeneratedRandomString {

	@Override
	public void generatedPartialString(ResultString result,
											   RandomCustom randomCustom) {
		int randomLength = randomCustom.getRandomIntegerByMinAndMax(0, 1);
		if (randomLength == 0) {
			result.deleteLastCharInMatachResult();
		}
	}
}
