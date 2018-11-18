package me.menduo.leetcode;

/**
 * @program: LeetCode
 * @mail: menduo96@gmail.com
 * @author: menduo
 * @create: 2018-10-08 19:36
 **/
public class NO464CanIWin {

    private byte[] store;

    public boolean canIWin(int maxChoosableInteger, int desiredTotal) {
        int sum = maxChoosableInteger * (maxChoosableInteger+1)/2;
        if(sum<desiredTotal) return false;
        if(desiredTotal<=0) return true;
        store = new byte[1<<maxChoosableInteger];

        return canIWin(maxChoosableInteger,desiredTotal,0);
    }
    private  boolean canIWin(int max,int des,int state) {
        if(des<=0) return false;
        if(store[state]!=0) return  store[state] == 1;
        for (int i = 0; i < max ; i++) {
            if((state & (1<<i))>0) continue;
            if(!canIWin(max,des - (i+1),state | (1<<i))){
                store[state] = 1;
                return true;
            }

        }
        store[state] = -1;
        return false;
    }
    public static void main(String[] args) {
        NO464CanIWin no464CanIWin = new NO464CanIWin();
        System.out.println(no464CanIWin.canIWin(10,11));
    }
}
