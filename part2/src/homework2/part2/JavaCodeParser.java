package homework2.part2;

import homework2.common.GeneralParserClass;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class JavaCodeParser {

    public static Map<String, Integer> collectKeywords(String inFile) throws IOException {
        Map<String, Integer> resMap = new HashMap<String, Integer>();
        FileReader in = null;

        try {

            in = new FileReader(inFile);
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
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } finally {
            if (in != null) {
                in.close();
            }
        }

        return resMap;
    }

    public static boolean saveParsedKeywords(String outName, Map<String, Integer> mapToSave) throws IOException {
        boolean res = false;
        FileWriter out = null;

        if (mapToSave.isEmpty()) {
            System.out.println("No java keywords are detected.");
            return false;
        }

        try {
            out = new FileWriter(outName);

            for (String keyword : mapToSave.keySet()) {
                Integer counter = mapToSave.get(keyword);
                String keywordCount = toString(keyword, counter);
                char[] keywordCountArray = new char[keywordCount.length()];
                keywordCount.getChars(0, keywordCount.length() - 1, keywordCountArray, 0);
                out.write(keywordCountArray);
                res = true;
            }

        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
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
        String res = String.format("%s %s\r\n", str, count.toString());
        return res;
    }

    public static Integer returnCounter(String keyword, Map<String, Integer> mapWithKeywords) {
        return mapWithKeywords.get(keyword);
    }

}
