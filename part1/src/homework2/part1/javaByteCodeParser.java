package homework2.part1;
import java.io.*;
import java.util.*;

public class javaByteCodeParser {
    private static final String[] keywords = new String[]{"abstract", "continue", "for", "new", "switch", "assert", "default",
            "goto", "package", "synchronized", "boolean", "do", "if", "private", "this", "break", "double",
            "implements", "protected", "throw", "byte", "else", "import", "public", "throws", "case", "enum",
            "instanceof", "return", "transient", "catch", "extends", "int", "short", "try", "char", "final",
            "interface", "static", "void", "class", "finally", "long", "strictfp", "volatile", "const", "float", "native", "super", "while"};

    private static final String[] separators = new String[] {"{", "}", "(", ")", "<", ">", " ", ";", ":", ",", "=", "\r\n", "\n"};

    private static Map<String, Integer> parsedKeywords;

    public javaByteCodeParser() {
        parsedKeywords = new HashMap<String, Integer>();
    }

    public static boolean isKeyword(String str) {
        boolean res = false;

        for (String keyword : keywords) {
            if (str.equals(keyword)) {
                res = true;
                break;
            }
        }

        return res;

    }

    public static boolean isSeparator(String str) {
        boolean res = false;

        for (String sep : separators) {
            if (str.equals(sep)) {
                res = true;
                break;
            }
        }

        return res;
    }

    public static boolean collectKeywords(String inFile) throws IOException {
        boolean res = false;
        FileInputStream in = null;

        try {

            in = new FileInputStream(inFile);
            int c;
            char ch;
            String curCh = "";
            String word = "";

            while ((c = in.read()) != -1) {
                ch = (char) c;
                curCh = String.valueOf(ch);
                if (!isSeparator(curCh)) {
                    word = word.concat(curCh);
                } else {
                    if (isKeyword(word) && parsedKeywords.containsKey(word)) {
                        Integer curCount = parsedKeywords.get(word);
                        curCount++;
                        parsedKeywords.put(word, curCount);
                    } else if (isKeyword(word) && !parsedKeywords.containsKey(word)) {
                        parsedKeywords.put(word, 1);
                    }

                    res = true;
                    word = "";
                }
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        finally {
            if (in != null) {
                in.close();
            }
        }

        return res;
    }

    public static boolean saveParsedKeywords(String outName) throws IOException {
        boolean res = false;
        FileOutputStream out = null;

        if (parsedKeywords.isEmpty()) {
            System.out.println("No java keywords are detected.");
            return false;
        }

        try {
            out = new FileOutputStream(outName);

            for (String keyword : keywords) {
                Integer counter = parsedKeywords.get(keyword);
                if (counter == null) {
                    continue;
                }
                if (counter > 0) {
                    String keywordCount = toString(keyword, counter);
                    byte[] keywordCountArray = keywordCount.getBytes();
                    out.write(keywordCountArray);
                    res = true;
                }
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        } finally {
            if (out != null) {
                out.close();
            }
        }

        return res;

    }

    public static String toString(String str, Integer count) {
        String res;
        res = String.format("%s %s\r\n", str, count.toString());
        return res;
    }

    public static Integer returnCounter(String keyword) {
        return parsedKeywords.get(keyword);
    }
}
