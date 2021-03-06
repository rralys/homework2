package homework2.part2;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.Map;

import static junit.framework.TestCase.*;

public class JavaCodeParserTest {
    JavaCodeParser data;
    JavaCodeParser data1;
    Map<String, Integer> savedMap;
    Map<String, Integer> savedMap1;

    @Before
    public void prepareData() throws IOException {
        data = new JavaCodeParser();
        savedMap = data.collectKeywords("C:\\GIT\\RRalys\\homework2\\part2\\src\\homework2\\part2\\JavaCodeParser.java");
        data1 = new JavaCodeParser();
        savedMap1 = data1.collectKeywords("C:\\GIT\\RRalys\\homework2\\part2\\src\\homework2\\part2\\nonJavaFile.txt");
    }

    @Test
    public void testCollectKeywordsReturnsTrueForJavaFile() throws IOException {
        assertFalse(savedMap.isEmpty());
    }

    @Test
    public void testSaveParsedKeywordsReturnsTrueForJavaFile() throws IOException {
        assertTrue(data.saveParsedKeywords("C:\\GIT\\RRalys\\homework2\\part2\\src\\homework2\\part2\\testFile.txt",savedMap));
    }

    @Test
    public void testReturnCounterReturnsCorrectCounterForExistingKeyword() {
        assertSame(data.returnCounter("catch", savedMap), 4);
    }

    @Test
    public void testReturnCounterReturnsNullForNonExistingKeyword() {
        assertNull(data.returnCounter("volitile", savedMap) );
    }

    @Test
    public void testSaveCollectKeywordsReturnsFalseForNonJavaFile() throws IOException {
        assertTrue(savedMap1.isEmpty());
    }

    @Test
    public void testSaveParsedKeywordsReturnsFalseForNonJavaFile() throws IOException {
        assertFalse(data1.saveParsedKeywords("C:\\GIT\\RRalys\\homework2\\part2\\src\\homework2\\part2\\testFile_02.txt", savedMap1));
    }

}
