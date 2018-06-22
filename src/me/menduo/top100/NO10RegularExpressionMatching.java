package me.menduo.top100;

public class NO10RegularExpressionMatching {
    /**
     * 递归的方法，每次比较第一个字符之后去掉第一个字符，再比较
     *
     * @param s 字符串
     * @param p 模式串
     * @return 匹配 or 不匹配
     */
    public boolean isMatch(String s, String p) {
        if (p.isEmpty()) return s.isEmpty();
        boolean firstMatch = (!s.isEmpty() && (s.charAt(0) == p.charAt(0) || p.charAt(0) == '.'));
        if (p.length() >= 2 && p.charAt(1) == '*') {
            return (isMatch(s, p.substring(2)) || (firstMatch && isMatch(s.substring(1), p)));
        } else {
            return firstMatch && isMatch(s.substring(1), p.substring(1));
        }

    }

    /**
     * dp写法
     *
     * @param s
     * @param p
     * @return
     */
    public boolean isMatch2(String s, String p) {
        return false;
    }

    public static void main(String[] args) {
        NO10RegularExpressionMatching no10RegularExpressionMatching = new NO10RegularExpressionMatching();
        System.out.println(no10RegularExpressionMatching.isMatch("aa", "a"));
        System.out.println(no10RegularExpressionMatching.isMatch("aa", "a*"));
        System.out.println(no10RegularExpressionMatching.isMatch("ab", ".*"));
        System.out.println(no10RegularExpressionMatching.isMatch("aab", "c*a*b"));
        System.out.println(no10RegularExpressionMatching.isMatch("mississippi", "mis*is*p*."));
    }
}
