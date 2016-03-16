package ar.fiuba.tdd.template.tp0;

import java.util.*;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

public class RegExGenerator {
    // TODO: Uncomment this field
    private int maxLength;
    private Map<String, String> specialsCharacters = null;

    public RegExGenerator(int maxLength) {
        this.maxLength = maxLength;
        specialsCharacters = new HashMap<String,String>();
        specialsCharacters.put(".",".");
        specialsCharacters.put("[","[");
        specialsCharacters.put("]","]");
        specialsCharacters.put("?","?");
        specialsCharacters.put(Constant.ASTERISK,"*");
        specialsCharacters.put(Constant.PLUS,"+");
        specialsCharacters.put(Constant.BAR,"\\");

    }

    // TODO: Uncomment parameters
    public List<String> generate(String regEx, int numberOfResults) throws PatternSyntaxException {

        int accountant = 1;
        String fullRegEx = "^" + regEx + "$";
        String stringMatch ="";
        RandomCustom random = new RandomCustom();
        List<String> generated = new ArrayList<String>();

        validateRegEx(fullRegEx);

        String[] characters  = regEx.split("");
        while (accountant < numberOfResults) {
            accountant++;
            String previousChar = "$";
            for (String character : characters) {
                if(!previousChar.equals(Constant.BAR) && specialsCharacters.get(character) != null){
                    //aca van las estrategias de cada caracter especial.
                    if(character.equals(".")) {
                        stringMatch = stringMatch + random.getAlphanumericCharacter(1);
                    }
                }else{
                    stringMatch = stringMatch + character;
                }
                previousChar = character;
            }
            generated.add(stringMatch);
        }

        return generated;
    }

    private void validateRegEx(String regEx) throws PatternSyntaxException{
        Pattern.compile(regEx);
    }
}