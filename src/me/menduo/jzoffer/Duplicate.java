package me.menduo.jzoffer;

/**
 * @program: Job-Search-Algorithm
 * @mail: menduo96@gmail.com
 * @author: menduo
 * @create: 2019-03-05 11:30
 **/
public class Duplicate {
    public boolean duplicate(int numbers[],int length,int [] duplication) {
        if(length==0) return false;
        for (int i = 0; i <length ; i++) {
            while(numbers[i]!=i){
                if(numbers[i]==numbers[numbers[i]]) {
                    duplication[0] = numbers[i];
                    return true;
                }
                int tmp = numbers[i];
                numbers[i] = numbers[tmp];
                numbers[tmp] = tmp;
            }

        }
        return false;
    }

    public static void main(String[] args) {
        Duplicate duplicate = new Duplicate();
        int[] duplication = new int[2];
        duplicate.duplicate(new int[]{2,3,1,0,2,5,3},7,duplication);
        System.out.println(duplication[0]);
    }
}
