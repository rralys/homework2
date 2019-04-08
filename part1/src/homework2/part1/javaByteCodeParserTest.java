package homework2.part1;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;


public class javaByteCodeParserTest {
    javaByteCodeParser data;

    @Before
    public void prepareData() throws IOException {
    data = new javaByteCodeParser();
    data.collectKeywords("C:\\GIT\\RRalys\\homework2\\part1\\src\\homework2\\part1\\javaByteCodeParser.java");
}

@Test
    public void testIsKeywordReturnsTrueForActualKeyword() {
    assert(javaByteCodeParser.isKeyword("else") == true);
}

@Test
    public void testIsKeywordReturnsFalseForNonKeyword() {
    assert(javaByteCodeParser.isKeyword("someString") == false);
}

@Test
    public void testIsSeparatorReturnsTrueForSeparator() {
    assert(javaByteCodeParser.isSeparator("<") == true);
}

@Test
    public void testIsSeparatorReturnsFalseForNonSeparator() {
    assert(javaByteCodeParser.isSeparator("non-sep") == false);
    assert(javaByteCodeParser.isSeparator("\\") == false);
}

@Test
    public void testCollectKeywordsReturnsTrueForJavaFile() throws IOException {
    assert(javaByteCodeParser.collectKeywords("C:\\GIT\\RRalys\\homework2\\part1\\src\\homework2\\part1\\javaByteCodeParser.java") == true);
}

@Test
    public void testSaveParsedKeywordsReturnsTrueForJavaFile() throws IOException {
    assert(data.saveParsedKeywords("C:\\GIT\\RRalys\\homework2\\part1\\src\\homework2\\part1\\testFile.txt"));
}

@Test
    public void testReturnCounterReturnsCorrectCounterForExistingKeyword() {
        assert(data.returnCounter("static") == 9);
}

@Test
    public void testReturnCounterReturnsNullForNonExistingKeyword() {
        assert(data.returnCounter("volitile") == null);
}
}