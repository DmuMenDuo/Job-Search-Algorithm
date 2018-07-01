package me.menduo.top100;

/**
 * User: menduo email:demon9607@163.com
 * Date: 2018-07-01
 * Time: 12:16
 */
public class NO9PalindromeNumber {
    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        int copy = x;
        int tmp = 0;
        int yu;
        while (x != 0) {
            yu = x % 10;
            x = x / 10;
            tmp = tmp * 10 + yu;
        }
        if (tmp != copy) return false;

        return true;
    }

    public static void main(String[] args) {
        NO9PalindromeNumber no9PalindromeNumber = new NO9PalindromeNumber();
        System.out.println(no9PalindromeNumber.isPalindrome(121));
        System.out.println(no9PalindromeNumber.isPalindrome(-121));
        System.out.println(no9PalindromeNumber.isPalindrome(10));
    }
}
