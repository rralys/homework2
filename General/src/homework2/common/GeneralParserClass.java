package homework2.common;

public class GeneralParserClass {
    public static final String[] keywords = new String[]{"abstract", "continue", "for", "new", "switch", "assert", "default",
            "goto", "package", "synchronized", "boolean", "do", "if", "private", "this", "break", "double",
            "implements", "protected", "throw", "byte", "else", "import", "public", "throws", "case", "enum",
            "instanceof", "return", "transient", "catch", "extends", "int", "short", "try", "char", "final",
            "interface", "static", "void", "class", "finally", "long", "strictfp", "volatile", "const", "float", "native", "super", "while"};

    private static final String[] separators = new String[] {"{", "}", "(", ")", "<", ">", " ", ";", ":", ",", "=", "\r\n", "\n"};

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
}
