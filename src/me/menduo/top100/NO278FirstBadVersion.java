package me.menduo.top100;

public class NO278FirstBadVersion {
    public int firstBadVersion(int n) {
        int head = 1;
        int tail = n;
        while (head < tail) {
            int mid = head + (tail - head) / 2;
            if (isBadVersion(mid)) {
                tail = mid;
            } else {
                head = mid + 1;
            }
        }
        return head;
    }

    public boolean isBadVersion(int x) {
        return true;
    }

    public static void main(String[] args) {

    }
}
