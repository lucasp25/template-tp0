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

    public String getAlphanumericCharacter(int length){
        String alphanumeric = "abcdefghijklmnopqrstuvwxyz0123456789";
        return Character.toString(alphanumeric.charAt(this.random.nextInt(length)));
    }
}
