package me.menduo.top100;

public class NO125ValidPalindrome {
    public boolean isPalindrome(String s) {
        if("".equals(s)) return true;
        int head = 0;
        int tail = s.length() - 1;
        while(head <= tail) {
            int m = check(s.charAt(head));
            int n = check(s.charAt(tail));
            if(m==-1){
                head++;
                continue;
            }
            if(n==-1){
                tail--;
                continue;
            }
            if(m != n) return false;
            head ++;
            tail --;
        }
        return true;
    }
    public int check(char x){
        int m = x - 'a';
        if(m>=0 && m <=26) return x;
        m = x - 'A';
        if(m>=0 && m <=26) return x+32;
        m = x - '0';
        if(m>=0 && m <=9) return x;

        return -1;
    }

    public static void main(String[] args) {
        NO125ValidPalindrome no125ValidPalindrome = new NO125ValidPalindrome();
        System.out.println(no125ValidPalindrome.isPalindrome("aA"));
    }
}
