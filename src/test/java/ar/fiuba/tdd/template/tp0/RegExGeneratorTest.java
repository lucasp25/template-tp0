package ar.fiuba.tdd.template.tp0;

import org.junit.Test;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

import static org.junit.Assert.assertTrue;

public class RegExGeneratorTest {

    private static Integer MAX_LENGTH = 100;

    private boolean validate(String regEx, int numberOfResults) {
        RegExGenerator generator = new RegExGenerator(MAX_LENGTH);

        List<String> results = generator.generate(regEx, numberOfResults);
        // force matching the beginning and the end of the strings
        Pattern pattern = Pattern.compile("^" + regEx + "$");
        return results
                .stream()
                .reduce(true,
                        (acc, item) -> {
                        Matcher matcher = pattern.matcher(item);
                        return acc && matcher.find();
                    },
                        (item1, item2) -> item1 && item2);
    }

    @Test
    public void testAnyCharacter() {
        assertTrue(validate(".", 1));
    }

    @Test
    public void testMultipleCharacters() {
        assertTrue(validate("...", 1));
    }

    @Test
    public void testLiteral() {
        assertTrue(validate("\\@", 1));
    }

    @Test
    public void testLiteralDotCharacter() {
        assertTrue(validate("\\@..", 1));
    }

    @Test
    public void testZeroOrOneCharacter() {
        assertTrue(validate("\\@.h?", 1));
    }

    @Test
    public void testCharacterSet() {
        assertTrue(validate("[abc]", 1));
    }

    @Test
    public void testCharacterSetWithQuantifiers() {
        assertTrue(validate("[abc]+", 1));
    }

    @Test
    public void testCharacterSetWithQuantifiersAndLiterals() {
        assertTrue(validate(".a[.*]+.e", 10));
    }

    @Test
    public void testCharacterPointAndAsterisk() {
        assertTrue(validate(".*.*.*.*.*", 10));
    }

    @Test
    public void testCharacterPointAndAsteriskAndPlus() {
        assertTrue(validate(".*.*.*.*.*+", 5));
    }

    @Test
    public void testCharacterLiteralsPlus() {
        assertTrue(validate("\\+++", 5));
    }

    @Test
    public void testCharacterLiteralsAndPlus() {
        assertTrue(validate("ab+c", 5));
    }

    @Test
    public void testExamplePdfTp0() {
        assertTrue(validate("..+[ab]*d?c", 5));
    }

    @Test
    public void testDoubleCharacterSet() {
        assertTrue(validate("[cdf123jui][hg@5657klj]", 6));
    }

    @Test
    public void testTripleCharacterSet() {
        assertTrue(validate("[0123456789.][cdf123jui][hg@5657klj]", 5));
    }

    @Test
    public void testCharacterSetLiteralsQualifiers() {
        assertTrue(validate("[.*?+.]", 2));
    }

    @Test
    public void testCharacterQualifiers() {
        assertTrue(validate(".*.?.+", 5));
    }

    @Test
    public void testCharacterLiteralSquareBracket() {
        assertTrue(validate(".*\\]abc\\]", 2));
    }

    @Test(expected = PatternSyntaxException.class)
    public void testPatternSyntaxException() {
        validate("[abc+", 1);
    }

    @Test(expected = PatternSyntaxException.class)
    public void testPattersSyntaxExceptionOnlyQuantifiers() {
        assertTrue(validate("+*?", 8));
    }

    @Test(expected = PatternSyntaxException.class)
    public void testDoubleCharacterSetSyntaxException() {
        assertTrue(validate("[cdf123jui][hg@5657klj", 6));
    }

}
