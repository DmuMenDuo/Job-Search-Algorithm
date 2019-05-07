package me.menduo.leetcode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * @program: Job-Search-Algorithm
 * @mail: menduo96@gmail.com
 * @author: menduo
 * @create: 2019-04-25 12:55
 **/
public class NO773 {
    public static void main(String[] args) {
        NO773 no773 = new NO773();
        no773.slidingPuzzle(new int[][]{{1,2,3},{4,0,5}});
    }
        class State {
            int[][] board;
            int x;
            int y;
            int stepCount;
            public State(int[][] board, int x, int y,int stepCount) {
                this.board = board;
                this.x = x;
                this.y = y;
                this.stepCount = stepCount;
            }

            private String b2String() {
                StringBuilder sb = new StringBuilder();
                for (int i = 0; i < board.length; i++) {
                    for (int j = 0; j < board[i].length; j++) {
                        sb.append(board[i][j]);
                    }
                }
                return sb.toString();
            }

            private void swap(int x,int y,int a_x,int a_y) {
                int tmp = board[x][y];
                board[x][y] = board[a_x][a_y];
                board[a_x][a_y] = tmp;
            }
        }

        public int slidingPuzzle(int[][] board) {
            Map<String,Integer> map = new HashMap();
            State state = null;
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[i].length; j++) {
                    if (board[i][j] == 0) state = new State(board.clone(),i,j,0);
                }
            }

            bfs(map, state);
            return map.getOrDefault("123450",-1);
            //{{1,2,3},{4,0,5}}
            // map存储所有可能得序列的最小值 String , Integer , 所以要有个board2String
            // bfs 每次生成一个新的state 步数+1存入map
            // 停止条件，步数比原来的要少，或者这个次序的String还没有出现

        }

        private void bfs(Map<String, Integer> map, State state) {
            if(state.b2String().equals("123450")) {
                map.put("123450",0);
                return;
            }

            int[][] steps = new int[][]{{0, -1},{0, 1},{-1, 0},{1, 0}};
            Queue<State> queue = new LinkedList();
            queue.offer(state);
            while (!queue.isEmpty()) {
                State tmp = queue.poll();
                for(int[] step: steps) {
                    int[][] new_board = new int[tmp.board.length][tmp.board[0].length];
                    for (int i = 0; i < new_board.length; i++)
                        for (int j = 0; j < new_board[i].length; j++)
                            new_board[i][j] = tmp.board[i][j];

                    if(tmp.x + step[0] < 0 || tmp.y  + step[1] < 0 || tmp.x + step[0] >= new_board.length || tmp.y + step[1] >= new_board[0].length) continue;

                    State new_state = new State(new_board,tmp.x+step[0],tmp.y+step[1],tmp.stepCount+1);
                    new_state.swap(tmp.x,tmp.y,new_state.x,new_state.y);
                    String b2s = new_state.b2String();
                    if(map.get(b2s) == null || map.get(b2s) > new_state.stepCount) {
                        map.put(b2s, new_state.stepCount);
                        queue.offer(new_state);
                    }
                }
            }
        }

}
