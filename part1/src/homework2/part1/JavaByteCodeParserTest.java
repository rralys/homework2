package homework2.part1;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.Map;

import static org.junit.Assert.*;


public class JavaByteCodeParserTest {
    JavaByteCodeParser data;
    JavaByteCodeParser data1;
    Map<String, Integer> savedMap;
    Map<String, Integer> savedMap1;

    @Before
    public void prepareData() throws IOException {
        data = new JavaByteCodeParser();
        savedMap = data.collectKeywords("C:\\GIT\\RRalys\\homework2\\part1\\src\\homework2\\part1\\JavaByteCodeParser.java");
        data1 = new JavaByteCodeParser();
        savedMap1 = data1.collectKeywords("C:\\GIT\\RRalys\\homework2\\part1\\src\\homework2\\part1\\nonJavaFile.txt");
    }

    @Test
    public void testCollectKeywordsReturnsTrueForJavaFile() throws IOException {
        assertTrue (!JavaByteCodeParser.collectKeywords("C:\\GIT\\RRalys\\homework2\\part1\\src\\homework2\\part1\\JavaByteCodeParser.java").isEmpty());
    }

    @Test
    public void testSaveParsedKeywordsReturnsTrueForJavaFile() throws IOException {
        assertTrue (data.saveParsedKeywords("C:\\GIT\\RRalys\\homework2\\part1\\src\\homework2\\part1\\testFile.txt", savedMap));
    }

    @Test
    public void testReturnCounterReturnsCorrectCounterForExistingKeyword() {
        assert (data.returnCounter("static", savedMap) == 4);
    }

    @Test
    public void testReturnCounterReturnsNullForNonExistingKeyword() {
        assertNull (data.returnCounter("volitile",savedMap1));
    }

    @Test
    public void testCollectKeywordsReturnsFalseForNonJavaFile() throws IOException {
        assertFalse(!JavaByteCodeParser.collectKeywords("C:\\GIT\\RRalys\\homework2\\part1\\src\\homework2\\part1\\nonJavaFile.txt").isEmpty());
    }

    @Test
    public void testSaveParsedKeywordsReturnsFalseForNonJavaFile() throws IOException {
        assertFalse(data1.saveParsedKeywords("C:\\GIT\\RRalys\\homework2\\part1\\src\\homework2\\part1\\testFile_02.txt",savedMap1));
    }
}