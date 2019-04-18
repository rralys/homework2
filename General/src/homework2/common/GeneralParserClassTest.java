package homework2.common;
import org.testng.annotations.Test;

import static org.testng.Assert.assertFalse;


public class GeneralParserClassTest {

    @Test
    public void testIsKeywordReturnsTrueForActualKeyword() {
        assert (GeneralParserClass.isKeyword("else") == true);
    }

    @Test
    public void testIsKeywordReturnsFalseForNonKeyword() {
        assertFalse (GeneralParserClass.isKeyword("someString"));
        assertFalse(GeneralParserClass.isKeyword("whileI"));
        assertFalse(GeneralParserClass.isKeyword("non-volatile"));
    }

    @Test
    public void testIsSeparatorReturnsTrueForSeparator() {
        assert (GeneralParserClass.isSeparator("<") == true);
    }

    @Test
    public void testIsSeparatorReturnsFalseForNonSeparator() {
        assertFalse (GeneralParserClass.isSeparator("non-sep") );
        assertFalse (GeneralParserClass.isSeparator("\\") );
    }

}
