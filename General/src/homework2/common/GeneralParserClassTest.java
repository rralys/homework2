package homework2.common;
import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;


public class GeneralParserClassTest {

    @Test
    public void testIsKeywordReturnsTrueForActualKeyword() {
        assertTrue(GeneralParserClass.isKeyword("else"));
    }

    @Test
    public void testIsKeywordReturnsFalseForNonKeyword() {
        assertFalse(GeneralParserClass.isKeyword("someString"));
        assertFalse(GeneralParserClass.isKeyword("whileI"));
        assertFalse(GeneralParserClass.isKeyword("non-volatile"));
    }

    @Test
    public void testIsSeparatorReturnsTrueForSeparator() {
        assertTrue(GeneralParserClass.isSeparator("<"));
    }

    @Test
    public void testIsSeparatorReturnsFalseForNonSeparator() {
        assertFalse(GeneralParserClass.isSeparator("non-sep") );
        assertFalse(GeneralParserClass.isSeparator("\\") );
    }

}
