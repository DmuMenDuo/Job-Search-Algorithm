package me.menduo.jzoffer;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: Job-Search-Algorithm
 * @mail: menduo96@gmail.com
 * @author: menduo
 * @create: 2019-03-07 22:50
 **/
public class FindNumsAppearOnce {
    //num1,num2分别为长度为1的数组。传出参数
    //将num1[0],num2[0]设置为返回结果
    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        int tmp = array[0];
        for (int i = 1; i < array.length ; i++) {
            tmp ^= array[i];
        }

        int flag = 1;
        while(flag!=0){
            if((tmp & flag) !=flag){
                flag = flag<<1;
            }else{
                break;
            }
        }
        List<Integer> a = new ArrayList<>();
        List<Integer> b = new ArrayList<>();
        for (int i = 0; i <array.length ; i++) {
            if((array[i]&flag)==0) a.add(array[i]);
            else b.add(array[i]);
        }
        tmp = a.get(0);
        for (int i = 1; i <a.size() ; i++) {
            tmp^=a.get(i);
        }
        num1[0] = tmp;

        tmp = b.get(0);
        for (int i = 1; i <b.size() ; i++) {
            tmp^=b.get(i);
        }
        num2[0] = tmp;
    }

    public static void main(String[] args) {
        FindNumsAppearOnce findNumsAppearOnce =new FindNumsAppearOnce();
        int[] num1 = new int[1];
        int[] num2 = new int[1];
        int[] array = new int[]{2,4,3,6,3,2,5,5};
        findNumsAppearOnce.FindNumsAppearOnce(array,num1,num2);
    }
}
