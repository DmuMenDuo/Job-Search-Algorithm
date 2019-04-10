package me.menduo.leetcode;

/**
 * @program: Job-Search-Algorithm
 * @mail: menduo96@gmail.com
 * @author: menduo
 * @create: 2019-04-09 14:33
 **/
public class NO289 {

        public void gameOfLife(int[][] board) {
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    check(board,i,j);
                }
            }
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    System.out.print(board[i][j] + " ");
                }
                System.out.println();
            }
            nextArray(board);
        }
        // 3 代表发生了变更 live -> dead 2代表 dead -> live
        private void check(int[][] array,int x, int y) {
            // array[x][y] == 1   1,3的数量<2--> 3
            // array[x][y] == 1   1,3的数量==2 or 3 --> 1
            // array[x][y] == 1   1,3的数量>3 --> 3
            // array[x][y] == 0   1,3的数量==3 --> 2
            int oneAndThree = 0;
            for(int i = x-1; i<= x+1;i++){
                for(int j = y-1; j<= y+1; j++) {
                    if (i>=0 && i < array.length && j>=0 && j < array[0].length && !(i == x && j == y) && (array[i][j] == 1 || array[i][j] == 3)) {
                        oneAndThree++;
                    }
                }
            }
            System.out.println(oneAndThree);

            if((array[x][y] == 0 || array[x][y] == 3) && oneAndThree == 3) {
                array[x][y] = 2;
                return;
            }
            if(array[x][y] == 1 || array[x][y] == 2)
                if (oneAndThree<2 || oneAndThree>3) {
                    array[x][y] = 3;
                } else
                    array[x][y] = 1;
        }

        private void nextArray(int[][] array) {
            for (int i=0; i < array.length; i++) {
                for (int j = 0; j < array[i].length; j++) {
                    if (array[i][j] == 3) array[i][j] = 0;
                    if (array[i][j] == 2) array[i][j] = 1;
                }
            }
        }

    public static void main(String[] args) {
        NO289 no289 =new NO289();
        no289.gameOfLife(new int[][]{{0,1,0},{0,0,1},{1,1,1},{0,0,0}});
    }
}
