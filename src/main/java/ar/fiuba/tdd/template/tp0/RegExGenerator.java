package ar.fiuba.tdd.template.tp0;

import java.util.*;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public class RegExGenerator {
	// TODO: Uncomment this field
	private int maxLength;
	private Map<String, GeneratedRandomString> specialsCharacters = null;

	public RegExGenerator(int maxLength) {
		this.maxLength = maxLength;
		specialsCharacters = new HashMap<String, GeneratedRandomString>();
		specialsCharacters.put(Constant.POINT, new SpecialCharPoint());
		specialsCharacters.put(Constant.START_SQUARE_BRACKET,
				new SpecialCharSquareBracket());
		specialsCharacters.put(Constant.QUESTION_MARK,
				new SpecialCharQuestionMark());
		specialsCharacters.put(Constant.ASTERISK,
				new SpecialCharacterAsterisk());
		specialsCharacters.put(Constant.PLUS, new SpecialCharacterPlus());

	}

	// TODO: Uncomment parameters
	public List<String> generate(String regEx, int numberOfResults)
			throws PatternSyntaxException {

		int accountant = 0;
		String fullRegEx = "^" + regEx + "$";
		List<String> generated = new ArrayList<String>();

		validateRegEx(fullRegEx);

		while (accountant < numberOfResults) {
			ResultString resultString = new ResultString(regEx);
			while (resultString.getIterator().hasNext()) {
				RandomCustom randomCustom = new RandomCustom();
				String actualChar = resultString.getIterator().next();
				if (!resultString.getIterator().getPreviousChar()
						.equals(Constant.BAR)
						&& specialsCharacters.get(actualChar) != null) {
					specialsCharacters.get(actualChar).generatedParcialString(
							resultString, randomCustom);
				} else if (!actualChar.equals(Constant.BAR)
						|| (actualChar.equals(Constant.BAR) && resultString
						.getIterator().getPreviousChar()
						.equals(Constant.BAR))) {
					resultString.setLastRandomString(actualChar);
					resultString.concantLastRandomStringToMatchResult();
					resultString.setPreviousCharGenerated(actualChar);
				}
			}
			if (resultString.getMatchResult().length() < this.maxLength) {
				System.out.println(resultString.getMatchResult());
				generated.add(resultString.getMatchResult());
				accountant++;
			}
		}

		return generated;
	}

	private void validateRegEx(String regEx) throws PatternSyntaxException {
		Pattern.compile(regEx);
	}

}