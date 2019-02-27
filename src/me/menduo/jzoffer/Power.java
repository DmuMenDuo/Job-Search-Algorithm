package me.menduo.jzoffer;

/**
 * @program: Job-Search-Algorithm
 * @mail: menduo96@gmail.com
 * @author: menduo
 * @create: 2019-02-27 12:08
 **/
public class Power {
    public double Power(double base, int exponent) {
        if(exponent==0) return 1;
        if(exponent==1) return base;
        boolean isN = false;
        if(exponent<0) {
            isN = true;
            exponent=0-exponent;
        }

        double result = Power(base*base,exponent/2);
        if(exponent%2!=0)
            result*=base;
        return isN?1/result:result;
    }
}
