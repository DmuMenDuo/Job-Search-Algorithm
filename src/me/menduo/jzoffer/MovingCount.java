package me.menduo.jzoffer;

/**
 * @program: Job-Search-Algorithm
 * @mail: menduo96@gmail.com
 * @author: menduo
 * @create: 2019-03-08 11:28
 **/
public class MovingCount {

    public int movingCount(int threshold, int rows, int cols) {
        boolean[][] visted = new boolean[rows][cols];
        return can_move(threshold,rows,cols,0,0,visted);

    }

    private int can_move(int threshold,int rows, int cols,int x,int y,boolean[][] visted){
        int count = 0;
        if(check(threshold,rows,cols,x,y,visted)){
            visted[x][y] = true;
            count = 1 + can_move(threshold,rows,cols,x-1,y,visted)
                    + can_move(threshold,rows,cols,x,y-1,visted)
                    + can_move(threshold,rows,cols,x+1,y,visted)
                    + can_move(threshold,rows,cols,x,y+1,visted);
        }
        return count;
    }

    private boolean check(int threshold,int rows, int cols,int x,int y,boolean[][] visted){
        if(x>=0 && x<rows &&
                y>=0 && y<cols &&
                getSum(x)+getSum(y)<=threshold &&
                !visted[x][y])
            return true;

        return false;
    }

    private int getSum(int x){
        int sum = 0;
        while (x>0){
            sum+=x%10;
            x/=10;
        }
        return sum;
    }

}
