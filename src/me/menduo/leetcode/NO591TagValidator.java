package me.menduo.leetcode;

public class NO591TagValidator {
    /**
     * 正则太TM强了
     * 格式： <![CDATA[]]> 替换为c  对应正则为“<!\\[CDATA\\[.*?\\]\\]>”
     * 其中java 对于匹配[] 这些字符 需要转义加\\
     * .*?  惰性匹配 只匹配到第一个 这里只匹配到第一个]]>
     * <p>
     * （）表示子正则表达式
     * [A-Z]{1,9} 匹配 大写字母 1<=长度<=9 所以{1,9}
     * \\1  表示必须为第一个（）中的值
     * [^<]* 非<的任意值，当遇到<时 去匹配</\\1> 防止了错位嵌套的发生
     * 最终映射<TAG>*</TAG>
     *
     * @param code
     * @return
     */
    public boolean isValid(String code) {
        if (code.equals("t")) return false;
        code = code.replaceAll("<!\\[CDATA\\[.*?\\]\\]>", "c");
        String pre = "";
        while (!code.equals(pre)) {
            pre = code;
            code = code.replaceAll("<([A-Z]{1,9})>[^<]*</\\1>", "t");
        }
        return code.equals("t");
    }

    public static void main(String[] args) {
        NO591TagValidator no591TagValidator = new NO591TagValidator();
        System.out.println(no591TagValidator.isValid("<DIV>This is the first line <![CDATA[<div>]]></DIV>"));
        System.out.println(no591TagValidator.isValid("<DIV>>>  ![cdata[]] <![CDATA[<div>]>]]>]]>>]</DIV>"));
        System.out.println(no591TagValidator.isValid("<A>  <B> </A>   </B>"));
    }
}
