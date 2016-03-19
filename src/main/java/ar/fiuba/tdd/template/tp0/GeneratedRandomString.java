package ar.fiuba.tdd.template.tp0;

public abstract class GeneratedRandomString {

	public abstract void generatedPartialString(ResultString result, RandomCustom randomCustom);

	protected String buildString(String previousChar, int randomLength) {
		int index = 0;
		StringBuffer out = new StringBuffer(previousChar);
		while (index < randomLength) {
			out.append(previousChar);
			index++;
		}
		return out.toString();
	}

}
