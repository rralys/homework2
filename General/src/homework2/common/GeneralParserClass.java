package homework2.common;

import java.util.ArrayList;
import java.util.List;

public class GeneralParserClass {

    private static final List<String> keywordsList;
    private static final List<String> separatorsList;

    static {
        keywordsList = new ArrayList<>() {
            {
                add("abstract");
                add("continue");
                add("for");
                add("new");
                add("switch");
                add("assert");
                add("default");
                add("goto");
                add("package");
                add("synchronized");
                add("boolean");
                add("do");
                add("if");
                add("private");
                add("this");
                add("break");
                add("double");
                add("implements");
                add("protected");
                add("throw");
                add("byte");
                add("else");
                add("import");
                add("public");
                add("throws");
                add("case");
                add("enum");
                add("instanceof");
                add("return");
                add("transient");
                add("catch");
                add("extends");
                add("int");
                add("short");
                add("try");
                add("char");
                add("final");
                add("interface");
                add("static");
                add("void");
                add("class");
                add("finally");
                add("long");
                add("strictfp");
                add("volatile");
                add("const");
                add("float");
                add("native");
                add("super");
                add("while");
            }
        };

        separatorsList = new ArrayList<>() {
            {
                add("}");
                add("(");
                add(")");
                add("<");
                add(">");
                add(" ");
                add(";");
                add(":");
                add(",");
                add("=");
                add("\r\n");
                add("\n");
            }
        };
    }

    public static boolean isKeyword(String str) {
        return keywordsList.contains(str);
    }

    public static boolean isSeparator(String str) {
        return separatorsList.contains(str);
    }

}
