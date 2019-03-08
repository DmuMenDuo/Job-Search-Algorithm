package me.menduo.jzoffer;

import java.util.Arrays;

/**
 * @program: Job-Search-Algorithm
 * @mail: menduo96@gmail.com
 * @author: menduo
 * @create: 2019-03-08 17:00
 **/
public class IsContinuous {
    public boolean isContinuous(int [] numbers) {
        if(numbers.length<5) return false;
        Arrays.sort(numbers);
        int start =0;
        int zeroN = 0;
        while (start<numbers.length){
            if(numbers[start]==0) zeroN++;
            else {
                break;
            }
            start++;
        }
        int slotN = 0;
        while (start<numbers.length-1){
            if (numbers[start]==numbers[start+1]) return false;
            if(numbers[start]<numbers[start+1]) {
                slotN += numbers[start+1] - numbers[start]-1;
            }
            start++;
        }

        if(slotN>zeroN) return false;
        else return true;
    }

    public static void main(String[] args) {
        IsContinuous isContinuous =new IsContinuous();
        System.out.println(isContinuous.isContinuous(new int[]{0,1,2,4,6}));
    }
}
