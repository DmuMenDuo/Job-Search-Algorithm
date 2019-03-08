package me.menduo.jzoffer;

/**
 * @program: Job-Search-Algorithm
 * @mail: menduo96@gmail.com
 * @author: menduo
 * @create: 2019-03-08 12:21
 **/
public class Add {
    public int Add(int num1,int num2) {
        int sum =num1;
        int carry;
        while (num2!=0){
            sum = num1^num2;
            carry = (num1 & num2) <<1;
            num1 =sum;
            num2 = carry;
        }
        return sum;
    }
}
