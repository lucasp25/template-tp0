package ar.fiuba.tdd.template.tp0;

import java.util.Iterator;

public class RegExIterator implements Iterator<String> {

	private String regEx;
	private int index;
	private String previousChar;

	public RegExIterator(String regEx) {
		this.regEx = regEx;
		this.index = 0;
		this.previousChar = Constant.STARTS_REGEX_MARK;
	}

	@Override
	public boolean hasNext() {
		if (index < regEx.length()) {
			return true;
		}
		return false;
	}

	@Override
	public String next() {
		if (index > 0) this.previousChar = String.valueOf(regEx.charAt(index - 1));
		return String.valueOf(regEx.charAt(index++));
	}

	@Override
	public void remove() {
		this.index = 0;
		this.regEx = "";
	}

	public void setPositionString(int index) {
		this.index = index;
	}

	public int getPosition() {
		return this.index;
	}

	public String getPreviousChar() {
		return this.previousChar;
	}

}
