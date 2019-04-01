package me.menduo.huawei;

/**
 * @program: Job-Search-Algorithm
 * @mail: menduo96@gmail.com
 * @author: menduo
 * @create: 2019-03-27 18:30
 **/
public class Main {
    static class Transfer {
        int cur;
        int next;
        int value;
        int to;
        boolean hasTransfer;

        public Transfer(int cur, int next, int value,int to) {
            this.cur = cur;
            this.next = next;
            this.value = value;
            this.to = to;
        }

        private void update() {
            value -=to;
            hasTransfer = true;

        }
    }
    public static void main(String[] args) {
        Transfer[] transfers = new Transfer[4];
        build(transfers);
    }

    private static void build(Transfer[] transfers) {
        transfers[0] = new Transfer(0,1,50,50);
        transfers[1] = new Transfer(1,2,0,50);
        transfers[2] = new Transfer(2,3,0,30);
        transfers[3] = new Transfer(3,-1,0,-1);
    }
}
