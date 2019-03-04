package me.menduo.jzoffer;

/**
 * @program: Job-Search-Algorithm
 * @mail: menduo96@gmail.com
 * @author: menduo
 * @create: 2019-03-04 14:29
 **/
public class GetUglyNumber_Solution {
    public int GetUglyNumber_Solution(int index) {
        int[] array = new int[index];
        array[0] = 1;
        int next = 1;
        int two_index =0;
        int three_index=0;
        int five_index=0;
        while(next<index) {
            array[next] = min(array[two_index]*2, array[three_index]*3, array[five_index]*5);
            while (array[two_index]*2 <= array[next]) two_index++;
            while (array[three_index]*3 <= array[next]) three_index++;
            while (array[five_index]*5 <= array[next]) five_index++;
            next++;
        }
        return array[next-1];
    }
    private int min(int two,int three,int five){
        return Math.min(Math.min(two,three),five);
    }

    public static void main(String[] args) {
        System.out.println(new GetUglyNumber_Solution().GetUglyNumber_Solution(6));
    }
}
