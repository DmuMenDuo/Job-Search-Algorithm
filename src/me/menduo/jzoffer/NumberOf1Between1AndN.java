package me.menduo.jzoffer;

/**
 * @program: Job-Search-Algorithm
 * @mail: menduo96@gmail.com
 * @author: menduo
 * @create: 2019-02-20 10:57
 **/
public class NumberOf1Between1AndN {
    public int NumberOf1Between1AndN_Solution(int n) {
        int count=0;
        for(int i=1;i<=n;i*=10)
        {
            int a = n/i;
            int b = n%i;
            count=count+(a+8)/10*i+((a%10==1)?1:0)*(b+1);
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new NumberOf1Between1AndN().NumberOf1Between1AndN_Solution(12));
    }


}
