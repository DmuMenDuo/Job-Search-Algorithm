package me.menduo.jzoffer;

/**
 * @program: Job-Search-Algorithm
 * @mail: menduo96@gmail.com
 * @author: menduo
 * @create: 2019-02-26 21:52
 **/
public class Find {
    public boolean Find(int target, int [][] array) {
        if(array==null||array.length==0) return false;

        int x = 0;
        int y = array.length-1;
        while(x<array[0].length&&y>=0){
            if(array[x][y]>target) y--;
            else if (array[x][y]<target) x++;
            else return true;
        }
        return false;
    }
}
