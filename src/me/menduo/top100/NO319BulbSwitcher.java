package me.menduo.top100;

public class NO319BulbSwitcher {
    public int bulbSwitch(int n) {
        if (n <= 0) return 0;
        return (int) Math.sqrt(n);
    }

    public static void main(String[] args) {
        /**
         * 找规律题，命中第奇数轮次会变成ON,命中第偶数轮次会变成OFF
         * eg: 4  第1轮：  命中为ON
         *        第2轮：  命中为OFF
         *        第3轮：  未命中
         *        第4轮：  命中为ON
         *
         * 所以只有平方数的命中轮次为奇数，所以找n内的平方数个数就可以了。
         * 25以内的平方数：1 4 9 16 25,所以开平方就可以了。
         */
    }
}
