package ar.fiuba.tdd.template.tp0;

import java.util.Random;

/**
 * Created by lucas on 15/03/16.
 */
public class RandomCustom {

	Random random = null;

	public RandomCustom() {
		this.random = new Random();
	}

	public String getAlphanumericString(int length) {
		return getStringRandom(Constant.ALPHANUMERIC_STRING, length);
	}

	public String getAlphanumericStringByValues(String values, int length) {
		return getStringRandom(values, length);
	}

	public int getRandomIntegerByMinAndMax(int min, int max) {
		return random.nextInt((max - min) + 1) + min;
	}

	private String getStringRandom(String values, int length) {
		int index = 0;
		StringBuffer out = new StringBuffer("");
		while (index < length) {
			out.append(Character.toString(values.charAt(getRandomIntegerByMinAndMax(0, values.length() - 1))));
			index++;
		}
		return out.toString();
	}
}
