package homework2.part1;

import homework2.common.GeneralParserClass;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;

public class JavaByteCodeParser {

    public JavaByteCodeParser() {

    }

    public static HashMap<String, Integer> collectKeywords(String inFile) throws IOException {
        HashMap<String, Integer> resMap = new HashMap<String, Integer>();
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
                if (!GeneralParserClass.isSeparator(curCh)) {
                    word = word.concat(curCh);
                } else {
                    if (GeneralParserClass.isKeyword(word) && resMap.containsKey(word)) {
                        Integer curCount = resMap.get(word);
                        curCount++;
                        resMap.put(word, curCount);
                    } else if (GeneralParserClass.isKeyword(word) && !resMap.containsKey(word)) {
                        resMap.put(word, 1);
                    }

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

        return resMap;

    }

    public static boolean saveParsedKeywords(String outName, HashMap<String, Integer> mapToSave) throws IOException {
        boolean res = false;
        FileOutputStream out = null;

        if (mapToSave.isEmpty()) {
            System.out.println("No java keywords are detected.");
            return false;
        }

        try {
            out = new FileOutputStream(outName);

            for (String keyword : GeneralParserClass.keywords) {
                Integer counter = mapToSave.get(keyword);
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

    public static Integer returnCounter(String keyword, HashMap<String, Integer> mapWithKeywords) {
        return mapWithKeywords.get(keyword);
        
    }
}
