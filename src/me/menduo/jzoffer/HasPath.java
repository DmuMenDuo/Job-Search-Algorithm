package me.menduo.jzoffer;

/**
 * @program: Job-Search-Algorithm
 * @mail: menduo96@gmail.com
 * @author: menduo
 * @create: 2019-03-08 11:40
 **/
public class HasPath {
    public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
        boolean[][] visted = new boolean[rows][cols];
        for (int i = 0; i < rows ; i++) {
            for (int j = 0; j < cols ; j++) {
                if(helper(matrix,rows,cols,i,j,str,0,visted)){
                    return true;
                }
            }
        }
        return false;
    }
    private boolean helper(char[] matrix,int rows,int cols,int x,int y,char[] str,int index,boolean[][] visted){
        if(index >=str.length) return true;
        boolean hasPath = false;
        if(x>=0 && x<rows &&
                y>=0 && y<cols &&
                !visted[x][y] &&
                matrix[x*cols+y] == str[index]){
            index++;
            visted[x][y] =true;
            hasPath = helper(matrix,rows,cols,x-1,y,str,index,visted) ||
                    helper(matrix,rows,cols,x+1,y,str,index,visted) ||
                    helper(matrix,rows,cols,x,y-1,str,index,visted) ||
                    helper(matrix,rows,cols,x,y+1,str,index,visted);

            if(!hasPath){
                index--;
                visted[x][y] = false;
            }

        }
        return hasPath;

    }

    public static void main(String[] args) {
        HasPath hasPath =new HasPath();
        System.out.println(hasPath.hasPath("ABCESFCSADEE".toCharArray(),3,4,"ABCCED".toCharArray()));
    }
}
