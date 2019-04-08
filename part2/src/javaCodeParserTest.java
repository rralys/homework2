import org.junit.Before;
import org.junit.Test;

import java.io.IOException;

public class javaCodeParserTest {
    javaCodeParser data;

    @Before
    public void prepareData() throws IOException {
        data = new javaCodeParser();
        data.collectKeywords("C:\\GIT\\RRalys\\homework2\\part2\\src\\javaCodeParser.java");
    }

    @Test
    public void testIsKeywordReturnsTrueForActualKeyword() {
        assert(javaCodeParser.isKeyword("else") == true);
    }

    @Test
    public void testIsKeywordReturnsFalseForNonKeyword() {
        assert(javaCodeParser.isKeyword("someString") == false);
    }

    @Test
    public void testIsSeparatorReturnsTrueForSeparator() {
        assert(javaCodeParser.isSeparator("<") == true);
    }

    @Test
    public void testIsSeparatorReturnsFalseForNonSeparator() {
        assert(javaCodeParser.isSeparator("non-sep") == false);
        assert(javaCodeParser.isSeparator("\\") == false);
    }

    @Test
    public void testCollectKeywordsReturnsTrueForJavaFile() throws IOException {
        assert(javaCodeParser.collectKeywords("C:\\GIT\\RRalys\\homework2\\part2\\src\\javaCodeParser.java") == true);
    }

    @Test
    public void testSaveParsedKeywordsReturnsTrueForJavaFile() throws IOException {
        assert(data.saveParsedKeywords("C:\\GIT\\RRalys\\homework2\\part2\\src\\testFile.txt"));
    }

    @Test
    public void testReturnCounterReturnsCorrectCounterForExistingKeyword() {
        assert(data.returnCounter("else") == 2);
    }

    @Test
    public void testReturnCounterReturnsNullForNonExistingKeyword() {
        assert(data.returnCounter("volitile") == null);
    }

}
