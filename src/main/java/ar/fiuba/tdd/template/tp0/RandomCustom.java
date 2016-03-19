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
        String alphanumeric = "abcdefghijklmnopqrstuvwxyz0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
        return getStringRandom(alphanumeric, length);
    }
    
    public String getAlphanumericStringByValues(String values,int length){
    	return getStringRandom(values, length);
    }

	private String getStringRandom(String values, int length) {
		int index = 0;
    	StringBuffer out = new StringBuffer ("");
    	while(index < length){    	
    		out.append(Character.toString(values.charAt(getRandomInteger(values.length()))));
    		index++;
    	}
		return out.toString();
	}
    
    public int getRandomIntegerByMinAndMax(int minimum, int maximum) {
    	int number = maximum - minimum + 1;
    	int index = random.nextInt() % number;
    	int randomNum =  minimum + index;
    	return randomNum;
    }
    
    public int getRandomInteger(int length){
    	return (int) Math.round(Math.random() * (length-1));
    }
}
