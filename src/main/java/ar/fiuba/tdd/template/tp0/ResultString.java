package ar.fiuba.tdd.template.tp0;

public class ResultString {

	private String reGex;
	private int indexLastChar;
	private String lastRandomString;
	private String previousChar;
	private String previousCharGenerated;
	private String matchResult;
	private int maxLength;
	private RegExIterator iterator;

	public ResultString() {
		super();
	}

	public ResultString(String reGex) {
		super();
		this.reGex = reGex;
		this.previousChar = Constant.END_REGEX_MARK;
		this.previousCharGenerated = Constant.END_REGEX_MARK;
		this.iterator = new RegExIterator(reGex);
		this.matchResult = "";
	}

	public String getReGex() {
		return reGex;
	}

	public int getIndexLastChar() {
		return indexLastChar;
	}

	public void setIndexLastChar(int indexLastChar) {
		this.indexLastChar = indexLastChar;
	}

	public String getLastRandomString() {
		return lastRandomString;
	}

	public void setLastRandomString(String lastRandomString) {
		this.lastRandomString = lastRandomString;
	}

	public String getPreviousChar() {
		return previousChar;
	}

	public void setPreviousChar(String previousChar) {
		this.previousChar = previousChar;
	}

	public String getPreviousCharGenerated() {
		return previousCharGenerated;
	}

	public void setPreviousCharGenerated(String previousCharGenerated) {
		this.previousCharGenerated = previousCharGenerated;
	}

	public String getMatchResult() {
		return matchResult;
	}

	public void setMatchResult(String matchResult) {
		this.matchResult = matchResult;
	}

	public int getMaxLength() {
		return maxLength;
	}

	public void setMaxLength(int maxLength) {
		this.maxLength = maxLength;
	}

	public void concantLastRandomStringToMatchResult() {
		matchResult = matchResult + lastRandomString;
	}

	public void deleteLastCharInMatachResult() {
		matchResult = matchResult.substring(0, matchResult.length() - 1);
	}

	public RegExIterator getIterator() {
		return iterator;
	}
}
